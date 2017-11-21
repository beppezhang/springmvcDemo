package bz.beppe.test.redis;



import java.util.Calendar;
import java.util.Date;

import redis.clients.jedis.Jedis;

public class RedisDemo1 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
//		jedis.set("name", "beppe");
		jedis.expire("name", 2);
		String name = jedis.get("name");
		System.out.println(name);
//		int i = Calendar.getInstance().get(Calendar.SECOND);
//		long currentTimeMillis = System.currentTimeMillis();
//		System.out.println(seconds+":"+time);
//		long i=1000*60*60*24*365*24;
//		System.out.println(currentTimeMillis/i);
		

	}
	
	
}
