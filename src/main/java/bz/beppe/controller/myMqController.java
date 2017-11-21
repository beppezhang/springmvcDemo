package bz.beppe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bz.beppe.common.QueueSend;
@Controller
public class myMqController {

	 	@Autowired
	    private QueueSend sender;
	    
	    @RequestMapping("/mqtest")
	    @ResponseBody
	    public String Test() {
	        
	        sender.send("messages", "你好，这是我的第一条消息！");
	        return "Hello world";
	    }
}
