package train.service.practiceOnline;

import train.dto.PageModel.PStrategy;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Strategy;

/**
 * 策略相关业务
 */
public interface StrategyService {

    /**
     * 制定新的策略
     * @param ps
     */
    void save(PStrategy ps);

    /**
     * 删除策略
     * @param StrategyId
     */
    void delete(Long StrategyId);

    /**
     * 分页查询策略列表(基础信息)
     * @param rl
     * @return
     */
    ResultModel <PStrategy> list(RequestList rl);
}
