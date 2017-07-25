package train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ajax请求返回结果
 */
@Data
@AllArgsConstructor
public class AjaxResult {
    private boolean state;   // 请求是否成功
    private Object value;    // 返回对象
}
