package train.service.knowledgeBase.impl;

import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.commons.exception.DataViolationException;
import train.commons.util.IDGenerator;
import train.dao.BaseDao;
import train.dto.PageModel.PRepositorycategory;
import train.model.Repositorycategory;
import train.model.User;
import train.service.knowledgeBase.RepositorycategoryService;
import train.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("repositoryService")
public class RepositorycategoryServiceImpl implements RepositorycategoryService{

    @Autowired
    @Setter
    private BaseDao<Repositorycategory> rcdao;
    @Autowired
    @Setter
    private UserService userService;

    @Override
    public void save(PRepositorycategory prc) {
        // 数据验证(对引用进行验证)
        // 用户ID验证
        User user = userService.validateUser(prc.getUserId());
        // 上级知识库验证
        this.validateRepositoryCategory(prc.getParentId());

        // 从dto-->entity复制属性
        Repositorycategory rc = new Repositorycategory();
        BeanUtils.copyProperties(prc, rc);
        // 对用户引用赋值
        rc.setUser(user);
        // 生成新的知识库ID
        Long pcId = IDGenerator.generatorUniqueLongId();

        rc.setCategoryId(pcId);
        rc.setIsReview(false);   // 未审核
        // 保存新的数据库信息
        System.out.print(rc);
        rcdao.save(rc);
    }

    @Override
    public void update(PRepositorycategory prc) {
        Long rcId = prc.getCategoryId();
        Repositorycategory rc = null;
        if (rcId == null || rcId == 0L || (rc = rcdao.get(Repositorycategory.class, rcId)) == null) {
            throw new DataViolationException("该知识库不存在");
        }
        Long parentId = prc.getParentId();
        // 验证上级知识库是否更改
        this.validateRepositoryCategory(parentId);

        rc.setParentId(parentId);
        rc.setDisplayOrder(prc.getDisplayOrder());
        rc.setName(prc.getName());
        rc.setNote(prc.getNote());
        rcdao.update(rc);
    }

    @Override
    public void check(PRepositorycategory prc) {
        Long rcId = prc.getCategoryId();
        Repositorycategory rc = this.validateRepositoryCategory(rcId);
        userService.validateUser(prc.getReviewer());
        // 更新审批人和审批结果
        rc.setIsReview(true);
        rc.setReviewer(prc.getReviewer());
        rc.setReviewResult(prc.getReviewResult());
        rcdao.update(rc);
    }

    @Override
    public void delete(Long prcID) {
        // 需要删除的ID记录列表
        List<Repositorycategory> delete_list = new ArrayList<>();
        Repositorycategory rc = new Repositorycategory();
        rc.setCategoryId(prcID);
        delete_list.add(rc);
        // 需要查询的记录列表
        List<Repositorycategory> need_query_list = new ArrayList<>(delete_list);
        // 每次查询结果
        List<Repositorycategory> result_list = null;

        // 循环查找待删除ID
        StringBuffer sb = null;
        while(need_query_list.size() > 0) {
            sb = new StringBuffer("from Repositorycategory where parentId in (");
            for(Repositorycategory tmp : need_query_list) {
                sb.append(tmp.getCategoryId());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            result_list = rcdao.find(sb.toString());
            delete_list.addAll(result_list);
            need_query_list = result_list;
        }

        // 拼接删除hql
        sb = new StringBuffer("delete from Repositorycategory where categoryId in (");
        for(Repositorycategory tmp : delete_list) {
            sb.append(tmp.getCategoryId());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        // 执行hql语句删除记录,若记录被引用,则执行失败,抛出DataIntegrityViolationException,Controller层注意捕获处理
        rcdao.executeHql(sb.toString());
    }

    @Override
    public List<PRepositorycategory> getAll() {
        String hql = "from Repositorycategory";
        List<Repositorycategory> list = rcdao.find(hql);
        return this.transferToPage(list);
    }

    @Override
    public List<PRepositorycategory> getPass() {
        String hql = "from Repositorycategory where reviewResult = '审核通过'";
        List<Repositorycategory> list = rcdao.find(hql);
        return this.transferToPage(list);
    }

    /**
     * 验证知识库
     * @param rcId
     * @return
     */
    private Repositorycategory validateRepositoryCategory(Long rcId) {
        Repositorycategory rc = null;
        if (rcId != null && rcId != 0L && (rc = rcdao.get(Repositorycategory.class, rcId)) == null) {
            throw new DataViolationException("该知识库不存在");
        }
        return rc;
    }

    /**
     * 将知识库查询实体结果转为页面对象
     * @param list
     * @return
     */
    private List<PRepositorycategory> transferToPage(List<Repositorycategory> list) {
        List<PRepositorycategory> result = new ArrayList<>();
        PRepositorycategory prc = null;
        for(Repositorycategory rc : list){
            prc = new PRepositorycategory();
            BeanUtils.copyProperties(rc, prc);
            prc.setUserId(rc.getUser().getUserId());
            prc.setUsername(rc.getUser().getName());
            result.add(prc);
        }
        return result;
    }
}
