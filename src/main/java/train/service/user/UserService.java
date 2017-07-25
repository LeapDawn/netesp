package train.service.user;

import train.dto.PageModel.PUser;
import train.model.User;

public interface UserService {

    /**
     * 登录业务
     * @param puser
     */
    PUser login(PUser puser);

    /**
     * 根据用户名获取用户信息
     * @param userId
     * @return
     */
    User validateUser(String userId);
}
