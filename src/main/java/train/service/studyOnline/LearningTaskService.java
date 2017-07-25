package train.service.studyOnline;

import train.dto.PageModel.PLearningTask;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Learningtask;

/**
 * 学习任务业务
 * (制定学习任务拆分为3步.
 *  1.新增基本信息
 *  2.确定学员
 *  3.确定学习任务的课件
 * )
 */
public interface LearningTaskService {

    /**
     * 保存新的学习任务基本信息
     * @param plt
     * @return 新的学习任务的ID,供后续操作使用
     */
    Long save(PLearningTask plt);

    /**
     * 确定学习任务的学习人员
     * @param plt
     */
    void configStudents(PLearningTask plt);

    /**
     * 确定学习任务的课件
     * @param plt
     */
    void configCoursewares(PLearningTask plt);

    /**
     * 分页查询学习任务的基本信息
     * @param rl
     * @return  只包含基本信息
     */
    ResultModel<PLearningTask> list(RequestList rl);

    /**
     * 统计
     * //TODO  再说,先不管
     * @param o
     * @return
     */
    Object statistics(Object o);
}
