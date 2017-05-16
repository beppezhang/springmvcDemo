package bz.beppe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/filter/")
public class CustomerController {

	@RequestMapping("data")
	@ResponseBody
	public String  getData(){
		return "beppe";
	}
}
