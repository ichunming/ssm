/**
 * Role Service Interface
 * ming 2016/07/20
 */
package com.yimeicloud.study.ssm.service;

import java.util.Set;

import com.yimeicloud.study.ssm.model.Role;

public interface RoleService {

	/**
	 * 创建角色
	 * @param role
	 */
	public void createRole(Role role);
	
	/**
	 * 角色无效化
	 * @param roleId
	 */
	public void disableRole(Long roleId);
	
	/**
	 * 角色有效化
	 * @param roleId
	 */
	public void enableRole(Long roleId);

	/**
	 * 添加权-限角色关系
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(Long roleId, Long... permissionIds);
	
	/**
	 * 移除权限-角色关系
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);
	
	/**
	 * 根据用户名查找角色
	 * @param name
	 * @return
	 */
	public Set<String> findRolesByName(String name);
}
