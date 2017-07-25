package train.controller.knowledgeBase;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;
import train.commons.exception.DataViolationException;
import train.controller.BaseAction;
import train.dto.AjaxResult;
import train.dto.PageModel.PKnowledge;
import train.dto.PageModel.PRepositorycategory;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.service.knowledgeBase.KnowledgeService;

import java.util.List;

/**
 * 知识库Action
 */
@Controller
@RequestMapping("/knowledge")
public class KnowledgeAction extends BaseAction {

    @Autowired
    @Setter
    private KnowledgeService knowledgeService;

    @RequestMapping(value = "/addition", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResult addition(@RequestBody PKnowledge pk){
        pk.setUserId(user.getUserId());
        try {
            knowledgeService.save(pk);
            result = new AjaxResult(true, "新增知识成功");
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
    public AjaxResult update(@RequestBody PKnowledge pk){
        pk.setUserId(user.getUserId());
        try {
            knowledgeService.update(pk);
            result = new AjaxResult(true, "修改知识成功");
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
    public AjaxResult check(@RequestBody PKnowledge pk){
        pk.setReviewer(user.getUserId());
        try {
            knowledgeService.check(pk);
            result = new AjaxResult(true, "审批知识成功");
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
            knowledgeService.delete(id);
            result = new AjaxResult(true, "删除知识成功");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "该知识已被使用,无法被删除");
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxResult list(@RequestBody RequestList<PKnowledge> rl){
        try {
            ResultModel<PKnowledge> resultModel = knowledgeService.list(rl);
            result = new AjaxResult(true, resultModel);
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
