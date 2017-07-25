package train.dto.PageModel;

import lombok.Data;

import java.util.Date;

/**
 * Created by cody on 2017/7/20.
 */
@Data
public class PKnowledgecomment {

    private Long commentId;
    private Long knowledgeId;
    private String userId;
    private String username;
    private String content;
    private Date createDate;
    private Boolean isReview;
    private String reviewer;
    private String reviewResult;
}
