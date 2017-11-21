package bz.beppe.service.test;

import bz.beppe.entity.Country;
import bz.beppe.entity.User;
import bz.beppe.iservice.UserService;
import bz.beppe.util.UUIDUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-mybatis.xml")
public class userServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void userTest(){
//		Country country = userService.selectCountry("86204b86-b8a0-11e7-9e35-484d7ec6ae1f");
//		System.out.println(country.getName());
//		Country c=new Country();
//		c.setId(UUIDUtil.getOrigUUID());
//		c.setCode("aaa");
//		c.setName("ddd");
//		c.setScore(10);
//		userService.saveCountry(c);
//		User aa = userService.selectByName("aa");
//		System.out.println(aa.getName());
	}

	@Test
	public void countryTest() throws InterruptedException{
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
//				int saveCountry = userService.saveCountry("us");
//				if(saveCountry>0){
//					System.out.println("====插入了一个  country 对象====");
//				}
			}
				
			
		};
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Thread t=new Thread(runnable);
			t.start();

		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
		Thread.sleep(1000);
	}
	
//	多线程插入数据到表
	@Test
	public void threadTest() throws InterruptedException{
		
	}
	

}
