package train.dto.PageModel;

import lombok.Data;

/**
 * Created by cody on 2017/7/20.
 */
@Data
public class PQuestion {
    private Long questionId;
    private Long questiondifficultyId;
    private Long questioncategoryId;
    private String type;
    private String pattern;
    private String content;
    private String answer;
    private Boolean isReview;
    private String reviewer;
    private String reviewContent;
}
