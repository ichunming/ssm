package com.yimeicloud.study.ssm.controller;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private String rememberMeParam = "rememberMe";
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		// 获取当前用户
		logger.debug("获取当前用户...");
		Subject currentUser = SecurityUtils.getSubject();

		// 用户登入状态判断
		if (currentUser.isRemembered() || currentUser.isAuthenticated()) {
			// 用户已登入
			logger.debug("用户已登入");
			return "redirect:/home";
		}

		// 登入页面跳转
		logger.debug("登入页面跳转");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		// 登出处理
		logger.debug("登出处理...");
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();

		// 登入页面跳转
		logger.debug("登入页面跳转");
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ServletRequest request, Model model) {
		String eMsg = "";

		// 用户名，密码非空check TODO
		if ("".equals(username) || "".equals(password)) {
			eMsg = "用户名/密码不能为空";
			model.addAttribute("eMsg", eMsg);
			return "login";
		}

		// 获取当前用户
		logger.debug("获取当前用户...");
		Subject currentUser = SecurityUtils.getSubject();

		// 创建用户登录凭证
		logger.debug("创建用户登入凭证...");
		boolean rememberMe = WebUtils.isTrue(request, rememberMeParam);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		
		// 登入
		try {
			logger.debug("登入...");
			currentUser.login(token);
		} catch (UnknownAccountException e) {
			// 用户名错误
			logger.debug("用户名错误");
			eMsg = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			// 密码错误
			logger.debug("密码错误");
			eMsg = "用户名/密码错误";
		} catch (LockedAccountException e) {
			// 帐号被锁
			logger.debug("帐号被锁");
			eMsg = "帐号被锁";
		} catch (ExcessiveAttemptsException e) {
			// 重复登入次数超过规定次数
			logger.debug("重复登入次数超过规定次数");
			eMsg = "频繁登入，请10分钟后再尝试";
		} catch (AuthenticationException e) {
			// 认证异常
			logger.debug("认证异常");
			eMsg = "认证异常";
		}

		// 认证
		if (currentUser.isAuthenticated()) {
			logger.debug("认证通过...");
		} else {
			logger.debug("认证未通过...");

			// 添加提示信息，跳转登入页
			logger.debug("跳转登入页");
			model.addAttribute("eMsg", eMsg);
			return "login";
		}

		// 跳转首页
		logger.debug("跳转首页");
		return "redirect:/home";
	}
}
