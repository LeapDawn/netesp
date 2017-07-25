package train.dto.PageModel;

import lombok.Data;
import train.model.Department;

/**
 * Created by cody on 2017/7/24.
 */
@Data
public class PUser {
    private String userId;
    private Long departentId;
    private String departmentName;
    private String password;
    private String name;
    private Long permissionId;
    private String permissionName;
    public PUser() {
        userId = "test";
        departentId = 1L;
        String password = "test";
        name = "测试";
        permissionId = 1L;
        permissionName = "管理员";
    }
}
