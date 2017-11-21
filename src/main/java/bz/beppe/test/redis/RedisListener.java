package bz.beppe.test.redis;

import bz.beppe.configration.RedisCacheConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by zhangshangliang on 2017/11/21.
 */
public class RedisListener {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisCacheConfig.class);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);

        System.out.println("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");
    }
}
