/**
 * User Service Interface
 * ming 2016/07/20
 */
package com.yimeicloud.study.ssm.service;

import com.yimeicloud.study.ssm.model.User;

public interface UserService {
	
	/**
	 * 创建帐户
	 * @param user
	 */
	public void createUser(User user);
	
	/**
	 * 修改密码
	 * @param uid
	 * @param newPassword
	 */
	public void changePassword(Long uid, String newPassword);
	
	/**
	 * 添加用户-角色关系
	 * @param uid
	 * @param roleIds
	 */
	public void correlationRoles(Long uid, Long... roleIds);
	
	/**
	 * 移除用户-角色关系
	 * @param uid
	 * @param roleIds
	 */
	public void uncorrelationiRoles(Long uid, Long... roleIds);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByName(String name);

	/**
	 * 帐户锁定
	 * @param uid
	 */
	public void lockUser(Long uid);
	
	/**
	 * 帐户解锁
	 * @param uid
	 */
	public void unlockUser(Long uid);
	
	/**
	 * 用户名check
	 * @param name
	 * @return
	 */
	public boolean nameExist(String name);
}
