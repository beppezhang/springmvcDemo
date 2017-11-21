package bz.beppe.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bz.beppe.entity.Country;
import bz.beppe.entity.User;
import bz.beppe.iservice.UserService;
import bz.beppe.util.UUIDUtil;

/**
 * Created by zhangshangliang on 2017/9/25.
 */
@Controller
@RequestMapping("user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="save",method=RequestMethod.POST)
    @ResponseBody
    public void saveUser(){
    	Country country=new Country();
    	country.setId(UUIDUtil.getOrigUUID());
    	country.setName("china");
    	User user=new User();
    	user.setId(UUIDUtil.getOrigUUID());
        user.setCode("123456");
    	user.setName("zhang");
    	userService.saveUser(country, user);
    }
	
	
	@RequestMapping(value="date",method=RequestMethod.POST)
    @ResponseBody
    public Map showDate(){
		Date d=new Date();
		String aa="aaa";
		Map m=new HashMap<>();
		m.put("now", d);
		m.put("data", aa);
		return m;
    }
	
	@RequestMapping(value="selectUser",method=RequestMethod.POST)
    @ResponseBody
    public User selectUser(){
		return userService.getUser("aaa");
    }
	
	@RequestMapping(value="selectUserList",method=RequestMethod.POST)
    @ResponseBody
    public List<User> selectUserList(){
		return userService.getUserList("aaa");
    }
	
	@RequestMapping(value="insertUser",method=RequestMethod.POST)
    @ResponseBody
    public int insertUser(){
		User user=new User();
		user.setId(UUIDUtil.getOrigUUID());
		user.setCode("aaa");
		user.setName("beppe");
		return userService.insertUser(user);
    }
    
    
    
}
