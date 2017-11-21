package bz.beppe.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by zhangshangliang on 2017/11/21.
 */
public class MyRedisListener implements MessageListener{

    @Resource
    private RedisTemplate redisTemplate;



    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
//        redisTemplate.convertAndSend("push:myredis","this is the redis subscribe!!");
        String channelStr = new String(channel);
        String bodyStr = new String(body);
        System.out.println("渠道为："+channelStr+"消息为："+bodyStr);
    }
}
