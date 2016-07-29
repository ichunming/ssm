/**
 * 自定义Realm
 * ming 2016/07/22
 */
package com.yimeicloud.study.ssm.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yimeicloud.study.ssm.model.User;
import com.yimeicloud.study.ssm.service.PermissionService;
import com.yimeicloud.study.ssm.service.RoleService;
import com.yimeicloud.study.ssm.service.UserService;

public class MyRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 用户名
        String username = (String)principals.getPrimaryPrincipal();
        
        // 角色权限信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        // 角色，权限设置


        logger.debug("角色，权限设置");
        
        Set<String> roles = roleService.findRolesByName(username);
        Set<String> permission = permissionService.findPermissionsByName(username);
        
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permission);
        
        //authorizationInfo.setRoles(roleService.findRolesByName(username));
        //authorizationInfo.setStringPermissions(permissionService.findPermissionsByName(username));
        return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 用户信息
		String username = (String)token.getPrincipal();
		
		// 通过用户名获取用户信息
		logger.debug("通过用户名获取用户信息...");
        User user = userService.findUserByName(username);
        
        if(user == null) {
        	// 用户不存在
        	logger.debug("用户不存在");
            throw new UnknownAccountException();
        }
        
        if(Boolean.TRUE.equals(user.getLocked())) {
        	// 用户被锁定
        	logger.debug("用户被锁定");
            throw new LockedAccountException();
        }
        
        // 封装认证信息
        logger.debug("封装认证信息");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(  
                user.getUsername(), //用户名
                user.getPassword(), //密码 
                ByteSource.Util.bytes(user.getUsername() + user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        
        // 密码匹配
        logger.debug("密码匹配");
        assertCredentialsMatch(token, info);
        
        return info;
	}

}
