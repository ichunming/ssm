package com.yimeicloud.study.ssm.model;

public class UserRole {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users_roles.user_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users_roles.role_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Long roleId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users_roles.user_id
	 * @return  the value of users_roles.user_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users_roles.user_id
	 * @param userId  the value for users_roles.user_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users_roles.role_id
	 * @return  the value of users_roles.role_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users_roles.role_id
	 * @param roleId  the value for users_roles.role_id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}