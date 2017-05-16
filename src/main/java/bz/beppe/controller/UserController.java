package bz.beppe.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bz.beppe.common.Constant;
import bz.beppe.util.DateUtil;
import bz.sunlight.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;

//	问题：日期格式没有转化为前端需要的格式
	@RequestMapping("getUser")
	@ResponseBody
	public User getUser(){
//		Map map=new HashMap<String, Object>();
//		map.put("name", "beppe");
//		map.put("birthday", DateUtil.dateToString(new Date(), Constant.DATE_2_SECOND));
		User user=new User();
		user.setId("1111");
		user.setName("beppe");
		user.setBirthday(new Date());
		response.setContentType("application/json;charset=UTF-8");
		String contentType = response.getContentType();
		Cookie[] cookies = request.getCookies();
//		System.out.println("content-Type:"+contentType+"="+"cookie:"+cookies);
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName=headerNames.nextElement();
			System.out.println("headerNames:"+headerName+"=="+request.getHeader(headerName));
		}
		return user;
	}
	
//	问题：前台提交过来的字符串转为date
	@RequestMapping("dateConvert")
	public void dateConvert(Date date1){
		System.out.println(date1.toString());
	}
}
