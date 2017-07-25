package train.dto.PageModel;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PLearningTask {
    private Long learningTaskId;
    private String name;
    private String content;
    private Date startDate;
    private Date endDate;
    private List<String> userIds;
    private List<Long> CoursewareIds;
}
