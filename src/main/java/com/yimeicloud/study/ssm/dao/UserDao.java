package com.yimeicloud.study.ssm.dao;

import com.yimeicloud.study.ssm.model.User;

public interface UserDao {

	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	/**
	 * 通过用户名查找用户
	 * @param name
	 * @return
	 */
	public User selectByName(String name);
}