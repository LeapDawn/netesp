package train.service.knowledgeBase;

import train.dto.PageModel.PKnowledge;
import train.dto.PageModel.PKnowledgecomment;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Knowledge;

/**
 * 知识评论业务
 */
public interface KnowledgecommentService {

    /**
     * 新增知识评论
     * @param pkc
     */
    void save(PKnowledgecomment pkc);

    /**
     * 审批知识评论
     * @param pkc
     */
    void check(PKnowledgecomment pkc);

    /**
     * 分页查询已审批的评论
     * @param rl
     * @return
     */
    ResultModel<PKnowledgecomment> listPass(RequestList<Long> rl);

    /**
     * 分页查询待审批的评论
     * @param rl
     * @return
     */
    ResultModel<PKnowledgecomment> listCheck(RequestList<Long> rl);
}
