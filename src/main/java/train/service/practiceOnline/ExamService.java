package train.service.practiceOnline;

import train.model.Exam;

/**
 * 试卷管理业务
 */
public interface ExamService {


    /**
     * 新增试卷
     * @param exam
     */
    void save(Exam exam);

}
