package com.yimeicloud.study.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/article")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view() {
		logger.info("ArticleController: /article/view...");
		return "view";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete() {
		logger.info("ArticleController: /article/delete...");
		return "delete";
	}
}
