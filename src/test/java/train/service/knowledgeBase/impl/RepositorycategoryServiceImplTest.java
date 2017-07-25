package train.service.knowledgeBase.impl;

import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by cody on 2017/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-*.xml" })
public class RepositorycategoryServiceImplTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-*.xml"});
    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void check() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getPass() throws Exception {
    }

}