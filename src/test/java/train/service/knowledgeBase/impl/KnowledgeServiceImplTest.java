package train.service.knowledgeBase.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import train.dto.PageModel.PKnowledge;
import train.dto.RequestList;
import train.dto.ResultModel;
import train.service.knowledgeBase.KnowledgeService;

import static org.junit.Assert.*;

/**
 * Created by cody on 2017/7/25.
 */
public class KnowledgeServiceImplTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
            "classpath:spring-web.xml", "classpath:spring-hibernate.xml" });

    @Test
    public void list() throws Exception {
        KnowledgeService knowledgeService = (KnowledgeService)ac.getBean("knowledegService");
        RequestList<PKnowledge> rl = new RequestList<>();
        rl.setPage(2);
        rl.setRows(2);
        PKnowledge pk = new PKnowledge();
        pk.setName("知识");
        pk.setReviewResult("审核通过");
        pk.setUserName("测试");
        pk.setRepositorycategoryName("知识库");
        pk.setRepositorycategoryId(1500967584834L);
        rl.setKey(pk);
        ResultModel<PKnowledge> result = knowledgeService.list(rl);
        System.out.println(result);
    }

}