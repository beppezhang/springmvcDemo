package bz.beppe.configration;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSend {

	public static void main(String[] args) throws InterruptedException {  
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisCacheConfig.class);  
  
        RedisTemplate template = ctx.getBean(RedisTemplate.class);  
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);  
  
        System.out.println("Sending message...");  
        template.convertAndSend("beppezhang", "this is the Hello from Redis!");  
  
        latch.await();  
        System.exit(0);  
  
    }  
}
