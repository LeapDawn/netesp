package train.service.questions;

import train.model.Questiondifficulty;

import java.util.List;

/**
 * 试题难度业务
 */
public interface QuestionsDifficultyService {

    /**
     * 保存新的试题难度
     * @param difficulty
     */
    public void save(Questiondifficulty difficulty);

    /**
     * 更新试题难度信息
     * @param difficulty
     */
    public void update(Questiondifficulty difficulty);

    /**
     * 删除试题难度
     * @param difficultyID
     */
    public void delete(Long difficultyID);

    /**
     * 获取所有试题难度
     * @return
     */
    public List<Questiondifficulty> getAll();
}
