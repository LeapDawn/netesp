package train.service.knowledgeBase;

import train.dto.PageModel.PRepositorycategory;
import train.model.Repositorycategory;

import java.util.List;

/**
 * 知识库分类业务
 */
public interface RepositorycategoryService {

    /**
     * 保存新的知识库分类
     * @param prc
     */
    void save(PRepositorycategory prc);

    /**
     * 更新知识库分类信息
     * @param prc
     */
    void update(PRepositorycategory prc);

    /**
     * 审批知识库分类信息
     * @param prc
     */
    void check(PRepositorycategory prc);

    /**
     * 删除知识库分类信息
     * //TODO
     * (知识库分类被引用则无法删除/级联删除?)
     * @param prcID 待删除知识库分类
     */
    void delete(Long prcID);

    /**
     * 获取已经审批和待审批(所有)知识库分类信息
     * @return
     */
    List<PRepositorycategory> getAll();

    /**
     * 获取已经审批的分类信息
     * // TODO
     * (这里可能需要构建知识库分类树,具体前端或者后端分待定)
     * @return
     */
    List<PRepositorycategory> getPass();
}
