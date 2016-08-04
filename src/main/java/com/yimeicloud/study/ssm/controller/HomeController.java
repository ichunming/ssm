package com.yimeicloud.study.ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String login(Model model) {
		
		// 登入页面跳转
		logger.debug("Home页面跳转");
		Subject currentUser = SecurityUtils.getSubject();

		model.addAttribute("uInfo", currentUser);
		return "home";
	}
}