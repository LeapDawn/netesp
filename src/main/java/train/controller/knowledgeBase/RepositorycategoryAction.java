package train.controller.knowledgeBase;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;
import train.commons.exception.DataViolationException;
import train.controller.BaseAction;
import train.dto.AjaxResult;
import train.dto.PageModel.PRepositorycategory;
import train.model.Repositorycategory;
import train.service.knowledgeBase.RepositorycategoryService;

import java.util.List;

/**
 * 知识库Controller.
 */
@Controller
@RequestMapping("/repository")
public class RepositorycategoryAction extends BaseAction{

    @Autowired
    @Setter
    private RepositorycategoryService repositorycategoryService;

    @RequestMapping(value = "/addition", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResult addition(@RequestBody PRepositorycategory prc){
        prc.setUserId(user.getUserId());
        try {
            repositorycategoryService.save(prc);
            result = new AjaxResult(true, "新增知识库成功");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据不合法");
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResult update(@RequestBody PRepositorycategory prc){
        prc.setUserId(user.getUserId());
        try {
            repositorycategoryService.update(prc);
            result = new AjaxResult(true, "修改知识库成功");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据不合法");
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/check", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResult check(@RequestBody PRepositorycategory prc){
        prc.setReviewer(user.getUserId());
        try {
            repositorycategoryService.check(prc);
            result = new AjaxResult(true, "审批知识库成功");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据不合法");
        }  catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/deletion/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            repositorycategoryService.delete(id);
            result = new AjaxResult(true, "删除知识库成功");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "该知识库包含知识,无法被删除");
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/get/all", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult getAll(){
        try {
            List<PRepositorycategory> list = repositorycategoryService.getAll();
            result = new AjaxResult(true, list);
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/get/pass", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult getPass(){
        try {
            List<PRepositorycategory> list = repositorycategoryService.getPass();
            result = new AjaxResult(true, list);
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }
}
