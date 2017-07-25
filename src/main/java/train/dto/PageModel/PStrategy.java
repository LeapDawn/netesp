package train.dto.PageModel;

import lombok.Data;
import train.model.Strategy;
import train.model.StrategyId;

import java.util.List;

/**
 * Created by cody on 2017/7/21.
 */
@Data
public class PStrategy {
    /* 策略属性 */
    private Long strategyId;
    private String name;   // 策略名称
    private Integer fullScore; // 满分
    private Integer passScore;  // 及格分
    private String purpose;   // 用途

    private List<Type> strategy_type;  // 当前策略包含的题目类型

    @Data
    public class Type {
        /* 试题类型属性 */
        private String type;   // 题目类型
        private Integer lowerlimitDifficultyId;  // 难度下限
        private Integer toplimitDifficultyId;    // 难度上限
        private Integer perquestioncatPerquestiontypeOrder; // 顺序
        private Integer perquestioncatPerquestiontypeScore; // 某题型的分数

        private List<Category> type_category; // 当前题目类型下的题目分类及其题目数量
        @Data
        public class Category{
            /** 题目分类属性 */
            private Long categoryId;   // 题目分类ID
            private Integer perquestioncatPerquestiontypeQuantity;  // 某题目分类下某题型的题目数量
        }
    }

}
