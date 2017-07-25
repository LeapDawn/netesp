package train.dto.PageModel;

import lombok.Data;

/**
 * Created by cody on 2017/7/20.
 */
@Data
public class PKnowledge {
    private Long knowledgeId;
    private String userId;
    private String userName;
    private Long repositorycategoryId;
    private String repositorycategoryName;
    private String name;
    private String relativeData;
    private Boolean isReview;
    private String reviewer;
    private String reviewResult;
}
