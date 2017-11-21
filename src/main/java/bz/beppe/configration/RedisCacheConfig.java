package bz.beppe.configration;


import bz.beppe.common.Receiver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@Configuration
@EnableCaching  
public class RedisCacheConfig extends CachingConfigurerSupport{

    private static String topicName = "Topic:chat";

	@Bean  
    public JedisConnectionFactory redisConnectionFactory() {  
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
        redisConnectionFactory.setHostName("localhost");  
        redisConnectionFactory.setPort(6379);  
        return redisConnectionFactory;  
    }  
  
    @Bean  
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {  
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();  
        redisTemplate.setConnectionFactory(cf);  
        return redisTemplate;  
    }  
  
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
        // Number of seconds before expiration. Defaults to unlimited (0)  
        cacheManager.setDefaultExpiration(300); // Sets the default expire time (in seconds)  
        return cacheManager;  
    }  
    
//    配置发布订阅
    @Bean
    public Receiver receiver(String name) {
        return new Receiver(name);
    }
    @Bean
    public MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }


}
