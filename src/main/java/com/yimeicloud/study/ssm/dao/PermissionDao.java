package com.yimeicloud.study.ssm.dao;

import java.util.List;

public interface PermissionDao {

	/**
	 * 根据用户名取得权限信息
	 * @param name
	 * @return
	 */
	public List<String> selectByName(String name);
}