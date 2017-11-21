package bz.beppe.test.AOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration({"classpath:aop.xml"})  
public class AOPTest {
	
//	@Autowired
//	private HelloWorldImpl helloWorldImpl;

	@Test
	public void helloWorldTest(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop.xml"); 
		HelloWorldImpl helloWorldImpl=(HelloWorldImpl)applicationContext.getBean("helloWorldImpl");
		helloWorldImpl.doPrint();
	}
}
