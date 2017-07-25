package train.controller.user;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;
import train.commons.exception.DataViolationException;
import train.controller.BaseAction;
import train.dto.AjaxResult;
import train.dto.PageModel.PUser;
import train.model.Exam;
import train.model.User;
import train.service.user.UserService;

import javax.servlet.http.HttpSession;

@Controller("userAction")
@RequestMapping("/user")
public class UserAction extends BaseAction {

    @Autowired
    @Setter
    private UserService userService;

    @RequestMapping(value = "/login", method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(@RequestBody PUser puser, HttpSession httpSession){

        try {
            PUser user = userService.login(puser);
            httpSession.setAttribute("user", user);
            result = new AjaxResult(true, "");
        } catch (DataViolationException e) {
            e.printStackTrace();
            result = new AjaxResult(false, e.getMessage());
        } catch (CannotCreateTransactionException | DataAccessResourceFailureException e) {
            e.printStackTrace();
            result = new AjaxResult(false, "数据库服务异常,请重新获取");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public AjaxResult logout(HttpSession httpSession){
        String errorMsg = "";
        try {
            httpSession.removeAttribute("user");
            result = new AjaxResult(true, "");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "退出登录失败");
        }
        return result;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public AjaxResult detail(HttpSession httpSession){
        String errorMsg = "";
        try {
            Object obj = httpSession.getAttribute("user");
            if (obj != null && obj instanceof PUser) {
                PUser puser = (PUser)obj;
                puser.setPassword("");
                result = new AjaxResult(true, puser);
            } else {
                result = new AjaxResult(false, "获取用户详细信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "获取用户详细信息失败");
        }
        return result;
    }
}
