package train.dto.PageModel;

import lombok.Data;

/**
 * Created by cody on 2017/7/20.
 */
@Data
public class PRepositorycategory {

    private Long categoryId;
    private String userId;
    private String username;
    private String name;
    private Long parentId;
    private String displayOrder;
    private String note;
    private Boolean isReview;
    private String reviewer;
    private String reviewResult;
}
