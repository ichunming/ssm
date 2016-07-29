/**
 * User Service Implement
 * ming 2016/07/20
 */
package com.yimeicloud.study.ssm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimeicloud.study.ssm.dao.UserDao;
import com.yimeicloud.study.ssm.helper.PasswordHelper;
import com.yimeicloud.study.ssm.model.User;
import com.yimeicloud.study.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 创建帐户
	 * @param user
	 */
	@Override
	public void createUser(User user) {
		logger.debug("创建帐户...");
		
		// 加密处理
		logger.debug("密码加密...");
		PasswordHelper.encrypPassword(user);

		// 用户插入数据库
		logger.debug("帐户信息插入数据库...");
		userDao.insert(user);
		
		logger.debug("帐户创建成功");
	}

	@Override
	public void changePassword(Long uid, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void correlationRoles(Long uid, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncorrelationiRoles(Long uid, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	@Override
	public User findUserByName(String name) {
		// 查找用户
		return userDao.selectByName(name);
	}

	@Override
	public void lockUser(Long uid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlockUser(Long uid) {
		// TODO Auto-generated method stub

	}

	/**
	 * 用户名check
	 * @param name
	 * @return
	 */
	@Override
	public boolean nameExist(String name) {
		// 通过用户名查找用户信息
		logger.debug("通过用户名查找用户信息");
		User user = this.findUserByName(name);
		
		// 查询结果check
		logger.debug("查询结果check");
		if(null != user) {
			// 查找到用户
			logger.debug("查找到用户");
			return true;
		}
		
		// 未查找到用户
		logger.debug("未查找到用户");
		return false;
	}
}