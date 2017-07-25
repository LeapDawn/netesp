package train.service.knowledgeBase;

import train.dto.PageModel.PKnowledge;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Knowledge;

/**
 * 知识管理业务
 */
public interface KnowledgeService {

    /**
     * 新增知识信息
     * @param pk
     */
    void save(PKnowledge pk);

    /**
     * 更新知识信息
     * @param pk
     */
    void update(PKnowledge pk);

    /**
     * 审批
     * @param pk
     */
    void check(PKnowledge pk);

    /**
     * 删除知识
     * (可能被评论引用,先删除相关评论)
     * @param knowledegID 待删除知识ID
     */
    void delete(Long knowledegID);

    /**
     * 分页获取知识
     * @param rl
     */
    ResultModel<PKnowledge> list(RequestList<PKnowledge> rl);
}
