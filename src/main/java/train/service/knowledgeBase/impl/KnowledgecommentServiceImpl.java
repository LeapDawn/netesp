package train.service.knowledgeBase.impl;

import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.Request;
import train.commons.exception.DataViolationException;
import train.dao.BaseDao;
import train.dto.PageModel.PKnowledge;
import train.dto.PageModel.PKnowledgecomment;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Knowledge;
import train.model.Knowledgecomment;
import train.model.User;
import train.service.knowledgeBase.KnowledgecommentService;
import train.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

public class KnowledgecommentServiceImpl implements KnowledgecommentService{

    @Autowired
    @Setter
    private BaseDao<Knowledgecomment> kcdao;
    @Autowired
    @Setter
    private BaseDao<Knowledge> knowledgedao;

    @Autowired
    @Setter
    private UserService userService;

    @Override
    public void save(PKnowledgecomment pkc) {
        Knowledgecomment kc = new Knowledgecomment();
        BeanUtils.copyProperties(pkc, kc);
        User user = userService.validateUser(pkc.getUserId());
        kc.setUser(user);
        Knowledge knowledge = knowledgedao.get(Knowledge.class, pkc.getKnowledgeId());
        if (knowledge == null) {
            throw new DataViolationException("该知识不存在");
        }

        kc.setKnowledge(knowledge);
        kc.setIsReview(false);
        kcdao.save(kc);
    }

    @Override
    public void check(PKnowledgecomment pkc) {
        Knowledgecomment kc = kcdao.get(Knowledgecomment.class, pkc.getCommentId());
        kc.setIsReview(true);
        kc.setReviewer(pkc.getReviewer());
        kc.setReviewResult(pkc.getReviewResult());
        kcdao.update(kc);
    }

    @Override
    public ResultModel<PKnowledgecomment> listPass(RequestList<Long> rl) {
        String hql = "from Knowledgecomment kc where isReview = true reviewResult = '通过审核'";
        return this.list(rl, hql);
    }

    @Override
    public ResultModel<PKnowledgecomment> listCheck(RequestList<Long> rl) {
        String hql = "from Knowledgecomment kc where isReview = false";
        return this.list(rl, hql);
    }


    private ResultModel<PKnowledgecomment> list(RequestList<Long> rl, String hql) {
        Long commentId = rl.getKey();
        if (commentId != null) {
            hql += " and commentId = " + commentId + "";
        }

        long total = kcdao.count(hql);
        ResultModel<PKnowledgecomment> result
                = new ResultModel<>((int)total, rl.getRows(), rl.getPage());
        List<Knowledgecomment> list = kcdao.find(hql, result.getPages(), result.getRows());
        List<PKnowledgecomment> plist = new ArrayList<>();
        for (Knowledgecomment kc : list) {
            plist.add(this.transferToPage(kc));
        }
        result.setData(plist);
        return result;
    }

    private PKnowledgecomment transferToPage(Knowledgecomment kc){
        PKnowledgecomment pkc = new PKnowledgecomment();
        BeanUtils.copyProperties(kc, pkc);
        pkc.setUserId(kc.getUser().getUserId());
        pkc.setUsername(kc.getUser().getName());
        return pkc;
    }
}
