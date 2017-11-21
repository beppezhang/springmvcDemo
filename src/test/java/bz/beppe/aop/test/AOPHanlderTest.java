package bz.beppe.aop.test;

import bz.beppe.test.AOP.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangshangliang on 2017/10/23.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:aop.xml")
public class AOPHanlderTest {

    @Test
    public void aopTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop.xml");

        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorldImpl");
        helloWorld.doPrint();
        helloWorld.printHelloWorld();

    }

}

