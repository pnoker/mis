package com.noker.mis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noker.mis.auth.AuthPassport;

@Controller // 定义容器，MVC 中的 Ｃ
@RequestMapping("/") // 请求映射
public class MainController extends BaseController {
	static final Logger logger = LogManager.getLogger(MainController.class);// 日志

	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		return "/index";
	}

	@RequestMapping("/login")
	public String login(ModelMap modelMap) {
		return "/user/login";
	}
	
	@RequestMapping("/login_admin")
	public String loginAdmin(ModelMap modelMap) {
		return "/manger/login";
	}

	@RequestMapping("/regist")
	public String regist(ModelMap modelMap) {
		return "/user/regist";
	}

}