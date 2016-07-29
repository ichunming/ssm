/**
 * Permission Service Interface
 * ming 2016/07/20
 */
package com.yimeicloud.study.ssm.service;

import java.util.Set;

import com.yimeicloud.study.ssm.model.Permission;

public interface PermissionService {

	/**
	 * 创建权限
	 * @param permission
	 */
	public void createPermission(Permission permission);
	
	/**
	 * 权限无效化
	 * @param permissionId
	 */
	public void disablePermission(Long permissionId);
	
	/**
	 * 权限有效化
	 * @param permissionId
	 */
	public void enablePermission(Long permissionId);
	
	/**
	 * 根据用户名查找权限
	 * @param name
	 * @return
	 */
	public Set<String> findPermissionsByName(String name);
}
