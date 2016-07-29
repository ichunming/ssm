/**
 * Role Service Implement
 * ming 2016/07/22
 */
package com.yimeicloud.study.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimeicloud.study.ssm.dao.RoleDao;
import com.yimeicloud.study.ssm.model.Role;
import com.yimeicloud.study.ssm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void createRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableRole(Long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableRole(Long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 根据用户名查找角色
	 * @param name
	 * @return
	 */
	@Override
	public Set<String> findRolesByName(String name) {
		// 查询角色信息
		logger.debug("查询角色信息");
		List<String> result = roleDao.selectByName(name);
		return new HashSet<String>(result);
	}
}
