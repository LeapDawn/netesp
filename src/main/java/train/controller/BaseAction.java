package train.controller;


import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import train.dto.AjaxResult;
import train.dto.PageModel.PUser;

@CrossOrigin
public class BaseAction {

    @Setter
    protected AjaxResult result;
    @Setter
    // TODO User对象应该由登录拦截器注入
    protected PUser user = new PUser();


}
