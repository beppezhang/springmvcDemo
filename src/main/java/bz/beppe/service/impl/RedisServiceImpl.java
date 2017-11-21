package bz.beppe.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//@Service("redisService")
public class RedisServiceImpl {

	@Cacheable("activity")
	public String getDate(String phoneNum){
		System.out.println("进入了redis方法");
		return "beppe"+phoneNum;
	}
	
	@Cacheable("name")
	public String getName(String phoneNum){
		System.out.println("进入了redis方法");
		return "onida"+phoneNum;
	}
}
