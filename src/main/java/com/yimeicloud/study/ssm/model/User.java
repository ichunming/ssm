package com.yimeicloud.study.ssm.model;

import java.util.Date;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.username
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.password
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.salt
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private String salt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.locked
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Boolean locked;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Date updateDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.id
	 * @return  the value of users.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.id
	 * @param id  the value for users.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.username
	 * @return  the value of users.username
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.username
	 * @param username  the value for users.username
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.password
	 * @return  the value of users.password
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.password
	 * @param password  the value for users.password
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.salt
	 * @return  the value of users.salt
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.salt
	 * @param salt  the value for users.salt
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.locked
	 * @return  the value of users.locked
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.locked
	 * @param locked  the value for users.locked
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.create_date
	 * @return  the value of users.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.create_date
	 * @param createDate  the value for users.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.update_date
	 * @return  the value of users.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.update_date
	 * @param updateDate  the value for users.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public User(){}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}