package bz.beppe.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by zhangshangliang on 2017/11/21.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-redis.xml"})
public class RedisTest {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Test
    public void redisSubTest() throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate =  (RedisTemplate) ctx.getBean("redisTemplate");
        redisTemplate.convertAndSend("push:myredis","this is the redis subscribe!!");
        Thread.sleep(5000);
    }

    @Test
    public void redisCacheTest() throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate =  (RedisTemplate) ctx.getBean("redisTemplate");
//        String 类型
//        ValueOperations vop = redisTemplate.opsForValue();
//        vop.set("name","beppe");
//        String name = (String)vop.get("name");
//        System.out.println(name);
//        Thread.sleep(5000);

//        List 类型
//        ListOperations listOps = redisTemplate.opsForList();
//        listOps.leftPush("list1","beppe1");
//        listOps.leftPush("list2","beppe2");
//        String list1 = (String) listOps.rightPop("list2");
//        System.out.println(list1);

//        hash 类型
//        HashOperations opHash = redisTemplate.opsForHash();
//        opHash.put("mykey1","city1","shanghai");
//        opHash.put("mykey2","city2","beijing");
////        String o = (String)opHash.get("mykey2", "city2");
////        System.out.println(o);
//        Map<String, String> map = new HashMap<>();
//        map.put("name1","beppe1");
//        map.put("name2","beppe2");
//        map.put("name3","beppe3");
//        opHash.putAll("mykey3",map);
//        Map.Entry<String,String> mykey3 = (Map.Entry<String,String>)opHash.entries("mykey3");


    }
}
