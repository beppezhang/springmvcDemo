package bz.beppe.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import bz.beppe.dao.CountryMapper;
import bz.beppe.dao.UserMapper;
import bz.beppe.entity.Country;
import bz.beppe.entity.User;
import bz.beppe.entity.UserExample;
import bz.beppe.iservice.UserService;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	@Resource
	private CountryMapper countryMapper;
	@Resource(name = "redisTemplate")
	private RedisTemplate redisTemplate;
	
	private static final String COUNTRY_REDIS_KEY="COUNTRY_REDIS_KEY";
	
	@Override
//	@Transactional
	public  int saveUser(Country country,User user) {
		int i=6/0;
		int insert2 = countryMapper.insert(country);
		int insert = userMapper.insert(user);
		return insert+insert2;
	}

	@Override

	public int insertUser(User user) {
		synchronized(user.getCode()){
			User user1 = getUser(user.getCode());
			if(user1!=null){
				return 0;
			}
			int insert = userMapper.insert(user);
			return insert;
		}
	}

	@Override
	public User getUser(String code) {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		User user = (User)opsForValue.get("user"+code);
		if(user==null){
			UserExample userExample = new UserExample();
			userExample.createCriteria().andCodeEqualTo(code);
			List<User> users = userMapper.selectByExample(userExample);
			if(users!=null&&users.size()>0){
				opsForValue.set("user"+code, users.get(0));
				return users.get(0);
			}
			return null;
		}
		return user;
	}
	
	
	@Override
	public List<User> getUserList(String code) {
		HashOperations hashOps= redisTemplate.opsForHash();
		hashOps.put("hashKey","name","beppezhang");
		hashOps.put("hashKey","city","shanghai");
		Map map = hashOps.entries("hashKey");
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry next = (Map.Entry)iterator.next();
			System.out.println(next.getKey()+":"+next.getValue());
		}
		System.out.println(map);
		return null;
//		BoundListOperations boundListOps = redisTemplate.boundListOps("userList"+code);
//		List<User> users= (List<User>)boundListOps.range(0, 1);
////		List<User> users = (List<User>)opsForValue.get("userList"+code);
//		if(users==null){
//			UserExample userExample = new UserExample();
//			userExample.createCriteria().andCodeEqualTo(code);
//			users = userMapper.selectByExample(userExample);
//			if(users!=null&&users.size()>0){
//				boundListOps.leftPush(users);
//				return users;
//			}
//			return null;
//		}
//		return users;
	}




	public static void main(String[] args) {
		System.out.println("a"+(2==2?"true":"false"));
	}

	
}
