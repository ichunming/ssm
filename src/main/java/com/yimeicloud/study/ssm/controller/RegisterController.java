/**
 * Register Controller
 * ming 2016/07/22
 */
package com.yimeicloud.study.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.yimeicloud.study.ssm.model.User;
import com.yimeicloud.study.ssm.service.UserService;

@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		// 跳转注册页
		logger.debug("跳转注册页");
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username")String username, @RequestParam("password")String password, Model model) {
		String eMsg = "";
		
		// 用户名check
		logger.debug("用户名check...");
		if(userService.nameExist(username)) {
			// 用户名已存在
			logger.debug("用户名已存在");
			eMsg = "用户名已存在";
			model.addAttribute("eMsg", eMsg);
			
			return "register";
		}
		
		// 封装用户信息
		logger.debug("封装用户信息...");
		User user = new User(username, password);
		
		// 创建用户
		logger.debug("创建用户...");
		userService.createUser(user);
		
		// 返回登入页
		logger.debug("用户创建成功");
		return "login";
	}
}
