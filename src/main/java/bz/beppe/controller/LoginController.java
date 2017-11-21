package bz.beppe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bz.beppe.common.CacheUtil;
import bz.beppe.util.UUIDUtil;

@Controller
@RequestMapping("/web/")
public class LoginController {
	
	/**
	 * 登录成功返回token
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public String login(){
		String name="beppe";
		System.out.println("登录成功！！");
		String token = UUIDUtil.getOrigUUID();
		CacheUtil.setCache(name+"_token", token);
		
		return token;
	}

}
