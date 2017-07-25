package train.service.questions;

import train.dto.PageModel.PQuestion;
import train.dto.RequestList;
import train.dto.ResultModel;

/**
 * 试题业务
 */
public interface QuestionsService {

    /**
     * 录入试题
     * @param pquestion
     */
    public void save(PQuestion pquestion);

    /**
     * 删除试题
     * @param questionId
     */
    public void delete(Long questionId);

    /**
     * 取消试题(审核不通过的操作,打回重做)
     * @param questionId
     */
    public void cancel(Long questionId);

    /**
     * 审批试题
     * @param question
     */
    public void check(PQuestion question);

    /**
     * 根据分类显示试题
     * @param rl
     * @return 试题列表
     */
    public ResultModel<PQuestion> list(RequestList rl);
}
