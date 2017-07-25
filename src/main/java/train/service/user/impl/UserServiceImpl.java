package train.service.user.impl;

import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.commons.exception.DataViolationException;
import train.dao.BaseDao;
import train.dto.PageModel.PUser;
import train.model.Department;
import train.model.Permission;
import train.model.User;
import train.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Setter
    @Autowired
    private BaseDao<User> userdao;

    @Setter
    @Autowired
    private BaseDao<Permission> permissiondao;

    @Override
    public PUser login(PUser puser) {
        User user = this.validateUser(puser.getUserId());
        if(!user.getPassword().equals(puser.getPassword())) {
            throw new DataViolationException("密码错误");
        } else {
            PUser result = new PUser();
            BeanUtils.copyProperties(user, result);
            result.setDepartentId(user.getDepartment().getDepartmentId());
            result.setDepartmentName(user.getDepartment().getName());
            result.setPermissionId(user.getPermissionId());
            Permission permission = permissiondao.get(Permission.class, user.getPermissionId());
            if (permission != null) {
                result.setPermissionName(permission.getName());
            }
            return result;
        }
    }

    @Override
    public User validateUser(String userId) {
        User user = null;
        if (userId == null || userId.trim().equals("") || (user = userdao.get(User.class, userId)) == null) {
            throw new DataViolationException("用户不存在");
        }
        return user;
    }
}
