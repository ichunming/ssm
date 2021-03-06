package com.yimeicloud.study.ssm.model;

import java.util.Date;

public class Permission {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.permission
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private String permission;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.description
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.available
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Boolean available;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permissions.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	private Date updateDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.id
	 * @return  the value of permissions.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.id
	 * @param id  the value for permissions.id
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.permission
	 * @return  the value of permissions.permission
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.permission
	 * @param permission  the value for permissions.permission
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setPermission(String permission) {
		this.permission = permission == null ? null : permission.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.description
	 * @return  the value of permissions.description
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.description
	 * @param description  the value for permissions.description
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.available
	 * @return  the value of permissions.available
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.available
	 * @param available  the value for permissions.available
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.create_date
	 * @return  the value of permissions.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.create_date
	 * @param createDate  the value for permissions.create_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permissions.update_date
	 * @return  the value of permissions.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permissions.update_date
	 * @param updateDate  the value for permissions.update_date
	 * @mbggenerated  Wed Jul 27 15:46:49 CST 2016
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}