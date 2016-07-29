/**
 * Permission Service Implement
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

import com.yimeicloud.study.ssm.dao.PermissionDao;
import com.yimeicloud.study.ssm.model.Permission;
import com.yimeicloud.study.ssm.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public void createPermission(Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePermission(Long permissionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enablePermission(Long permissionId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据用户名查找权限
	 * @param name
	 * @return
	 */
	@Override
	public Set<String> findPermissionsByName(String name) {
		// 权限取得
		logger.debug("权限取得");
		List<String> permissions = permissionDao.selectByName(name);
		return new HashSet<String>(permissions);
	}
}
