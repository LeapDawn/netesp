package train.service.questions;

import train.model.Questioncategory;

/**
 * 试题分类业务逻辑
 */
public interface QuestionsCategoryService {

    /**
     * 新增试题分类
     * @param category
     */
    public void save(Questioncategory category);
}
