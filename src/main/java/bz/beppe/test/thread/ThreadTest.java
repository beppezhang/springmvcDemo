package bz.beppe.test.thread;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bz.beppe.entity.User;
import bz.beppe.iservice.UserService;
import bz.beppe.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext-mybatis.xml"})  
public class ThreadTest {
	
	@Autowired
	private UserService userService;
	
	
	
	@Test
	public void userTest() throws InterruptedException{

		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				User user1 = new User();
				user1.setId(UUIDUtil.getOrigUUID());
				user1.setCode("aaa");
				user1.setName("aaa");
				userService.insertUser(user1);
				System.out.println("=====aaa线程开启了===");
				
			}
		};
		
		Runnable runnable1 = new Runnable() {
			
			@Override
			public void run() {
				
				User user2 = new User();
				user2.setId(UUIDUtil.getOrigUUID());
				user2.setCode("bbb");
				user2.setName("bbb");
				userService.insertUser(user2);
				System.out.println("=====bbb线程开启了===");
			}
		};
		for(int i=0;i<10;i++){
			
			Thread t=new Thread(runnable);
			Thread t1=new Thread(runnable1);
			t.start();
			t1.start();
		
			
		}
		Thread.sleep(1000);
	}

	@Test
	public void stationTest() throws InterruptedException{
//		Station station1 = new Station("线程1");
//		Station station2 = new Station("线程2");
//		Station station3 = new Station("线程3");
		Station s=new Station();
		
		Thread t1=new Thread(s,"thread1");
		Thread t2=new Thread(s,"thread2");
		Thread t3=new Thread(s,"thread3");
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(1000);
	}
	
	@Test
	public void bankTest() throws InterruptedException{
		Person p1=new Person(new Bank());
		p1.setMoney(100);
		Thread t1=new Thread(p1,"thread1");
		t1.start();
		Person p2=new Person(new Bank());
		p2.setMoney(200);
		Thread t2=new Thread(p2,"thread2");
		t2.start();
		Thread.sleep(100000);
	}
	
	
	@Test
	public void strTest1() throws InterruptedException{
		
//		MyRunnable myRunnable = new MyRunnable(new StringThread());
//		for(int i=0;i<10;i++){
//			Thread t=new Thread(myRunnable,"线程"+i);
//			t.start();
//		}
//		Thread.sleep(1000);
		
		Runnable stringThread = new StringThread("sb");
		for(int i=0;i<10;i++){
			Thread t=new Thread(stringThread,"线程"+i);
			t.start();
		}
		Thread.sleep(1000);
	}
	
	
	@Test
	public void strTest2() throws InterruptedException{
		
		Runnable r=new MyRunnable(new StringThread("sb"));
		for(int i=0;i<10;i++){
			Thread thread = new Thread(r,"线程："+i);
			thread.start();
		}
		Thread.sleep(1000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
