package train.service.studyOnline;

import train.model.Coursewarecategory;

import java.util.List;
import java.util.Locale;

/**
 * 课件分类业务
 */
public interface CoursewarecategoryService {

    /**
     * 新增课件分类
     * @param category
     */
    void save(Coursewarecategory category);

    /**
     * 更新课件分类
     * @param category
     */
    void update(Coursewarecategory category);

    /**
     * 删除课件分类
     * (被引用则删除失败)
     * @param categoryId 待删除ID
     */
    void delete(Long categoryId);

    /**
     * 获取所有课件分类
     * @return
     */
    List<Locale.Category> getAll();
}
