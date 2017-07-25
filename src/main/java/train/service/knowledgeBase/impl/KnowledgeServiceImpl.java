package train.service.knowledgeBase.impl;

import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.commons.exception.DataViolationException;
import train.commons.util.IDGenerator;
import train.dao.BaseDao;
import train.dto.PageModel.PKnowledge;
import train.dto.PageModel.PRepositorycategory;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Knowledge;
import train.model.Knowledgecomment;
import train.model.Repositorycategory;
import train.model.User;
import train.service.knowledgeBase.KnowledgeService;
import train.service.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("knowledegService")
public class KnowledgeServiceImpl implements KnowledgeService {

    @Setter
    @Autowired
    private BaseDao<Knowledge> knowledgedao;

    @Setter
    @Autowired
    private BaseDao<Repositorycategory> rcdao;

    @Setter
    @Autowired
    private BaseDao<Knowledgecomment> kcdao;

    @Setter
    @Autowired
    private UserService userService;

    @Override
    public void save(PKnowledge pk) {
        Knowledge knowledge = new Knowledge();
        BeanUtils.copyProperties(pk, knowledge);
        User user = userService.validateUser(pk.getUserId());
        knowledge.setUser(user);
        Repositorycategory rc = rcdao.get(Repositorycategory.class, pk.getRepositorycategoryId());
        if (rc == null) {
            throw new DataViolationException("该知识库不存在");
        }
        knowledge.setRepositorycategory(rc);

        knowledge.setKnowledgeId(IDGenerator.generatorUniqueLongId());
        knowledge.setIsReview(false);
        knowledgedao.save(knowledge);
    }

    @Override
    public void update(PKnowledge pk) {
        Knowledge knowledge = knowledgedao.get(Knowledge.class, pk.getKnowledgeId());
        knowledge.setName(pk.getName());
        knowledge.setRelativeData(pk.getRelativeData());
        Repositorycategory rc = rcdao.get(Repositorycategory.class, pk.getRepositorycategoryId());
        if (rc == null) {
            throw new DataViolationException("该知识库不存在");
        }
        knowledge.setRepositorycategory(rc);
        knowledgedao.update(knowledge);
    }

    @Override
    public void check(PKnowledge pk) {
        Knowledge knowledge = knowledgedao.get(Knowledge.class, pk.getKnowledgeId());
        knowledge.setIsReview(true);
        knowledge.setReviewer(pk.getReviewer());
        knowledge.setReviewResult(pk.getReviewResult());
        knowledgedao.update(knowledge);
    }

    @Override
    public void delete(Long knowledegID) {
        if (knowledegID == null || knowledegID == 0L) {
            throw new DataViolationException("没有指定要删除的知识");
        }

        // 删除知识的评论
        String hql = " delete from Knowledgecomment where knowledge.knowledgeId = '" + knowledegID + "'";
        kcdao.executeHql(hql);

        // 删除知识
        Knowledge knowledge = knowledgedao.get(Knowledge.class, knowledegID);
        knowledgedao.delete(knowledge);
    }

    @Override
    public ResultModel<PKnowledge> list(RequestList<PKnowledge> rl) {
        // 拼接hql
        StringBuffer hql = new StringBuffer("from Knowledge k left join k.user user " +
                "left join k.repositorycategory rc where 1 = 1 ");
        Map<String, Object> paramsMap = new HashMap<>();
        PKnowledge pk = rl.getKey();
        if (pk.getName() != null && !pk.getName().equals("")) {
            hql.append(" and k.name like :name");
            paramsMap.put("name", "%" + pk.getName() + "%");
        }
        if (pk.getReviewResult() != null && !"".equals(pk.getReviewResult())) {
            hql.append(" and k.reviewResult = :reviewResult");
            paramsMap.put("reviewResult", pk.getReviewResult());
        }
        if (pk.getUserName() != null && !pk.getUserName().equals("")) {
            hql.append(" and user.name like :username");
            paramsMap.put("username", "%" + pk.getUserName() + "%");
        }
        if (pk.getRepositorycategoryName() != null && !"".equals(pk.getRepositorycategoryName())) {
            hql.append(" and rc.name like :rcname");
            paramsMap.put("rcname", "%" + pk.getRepositorycategoryName() + "%");
        }
        if (pk.getRepositorycategoryId() != null && !"".equals(pk.getRepositorycategoryId())) {
            hql.append(" and rc.categoryId = :rcid");
            paramsMap.put("rcid", pk.getRepositorycategoryId());
        }
        String hqlStr = hql.toString();

        // 获取数据总数
        long total = knowledgedao.count("select count(*) " + hqlStr, paramsMap);
        // 初始化对象
        ResultModel<PKnowledge> result = new ResultModel<>((int)total, rl.getRows(), rl.getPage());
        // 查询指定页码数据
        String h = "select k.knowledgeId,user.userId,user.name,rc.categoryId,rc.name,k.relativeData,k.isReview,k.reviewer," +
                "k.reviewResult,k.name";
        List list = knowledgedao.find(h+hqlStr, paramsMap, result.getCurrentPage(), result.getRows());

        // 转化数据为页面对象
        List<PKnowledge> plist = new ArrayList<>();
        PKnowledge pknowledge = null;
        for(int i = 0; i < list.size(); i++) {
            Object[] array = (Object[]) list.get(i);
            pknowledge = new PKnowledge();
            pknowledge.setKnowledgeId((Long)array[0]);
            pknowledge.setUserId((String)array[1]);
            pknowledge.setUserName((String) array[2]);
            pknowledge.setRepositorycategoryId((Long)array[3]);
            pknowledge.setRepositorycategoryName((String)array[4]);
            pknowledge.setRelativeData((String)array[5]);
            pknowledge.setIsReview((Boolean)array[6]);
            pknowledge.setReviewer((String)array[7]);
            pknowledge.setReviewResult((String)array[8]);
            pknowledge.setName((String)array[9]);
            plist.add(pknowledge);
        }
        result.setData(plist);
        return result;
    }
}
