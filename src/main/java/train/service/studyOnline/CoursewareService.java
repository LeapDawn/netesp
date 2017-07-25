package train.service.studyOnline;

import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Courseware;

import javax.xml.transform.Result;

/**
 * 课件管理业务
 */
public interface CoursewareService {

    /**
     * 新增课件
     * @param courseware
     */
    void save(Courseware courseware);

    /**
     * 更新课件
     * @param courseware
     */
    void update(Courseware courseware);

    /**
     * 删除课件
     * @param CoursewareId
     */
    void delete(Long CoursewareId);

    /**
     * 分页查询课件列表
     * @param rl
     * @return
     */
    ResultModel<Courseware> list(RequestList rl);
}
