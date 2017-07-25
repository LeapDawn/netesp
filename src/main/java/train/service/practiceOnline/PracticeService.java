package train.service.practiceOnline;

import train.dto.RequestList;
import train.dto.ResultModel;
import train.model.Userpractice;

/**
 * Created by cody on 2017/7/21.
 */
public interface PracticeService {

    /**
     * 分页查询用户的练习
     * (用户练习UserPractice,练习Practice)
     * @param rl
     * @return
     */
    ResultModel list(RequestList rl);


    /**
     * 更新用户答案
     * @param up
     */
    void updateUserPractice(Userpractice up);


    /**
     * 统计
     * //TODO  再说,先不管
     * @param o
     * @return
     */
    Object statistics(Object o);
}
