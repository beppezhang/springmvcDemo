package bz.beppe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bz.beppe.common.CacheUtil;
import bz.beppe.service.impl.RedisServiceImpl;

@Controller
@RequestMapping("filter/customer/")
public class CustomerController {

//	@Autowired
//	private RedisServiceImpl redisService;
	 
	@RequestMapping("token")
	@ResponseBody
	public Map  getData(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("name", "beppe");
		return map;
	}
	
//	操作接口带上token验证
	@RequestMapping(value="add",method=RequestMethod.GET)
	@ResponseBody
	public String save(String name,String token){
		System.out.println(name+token);
		if(token.equals(CacheUtil.getValue(name+"_token"))){
			System.out.println("新增记录成功！！");
			return "保存成功";
		}
		return "token失效";
	}
	
//	@RequestMapping("getRedisData")
//	@ResponseBody
//	public String  getRedisData(){
//		String date = redisService.getName("123456");
//		return date;
//	}
}
