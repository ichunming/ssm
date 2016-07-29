/**
 * 自定义CredentialsMatcher
 * ming 2016/07/27
 */
package com.yimeicloud.study.ssm.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yimeicloud.study.ssm.helper.PasswordHelper;
import com.yimeicloud.study.ssm.util.AppConst;

public class MyCredentialsMatcher implements CredentialsMatcher {

	private Logger logger = LoggerFactory.getLogger(MyCredentialsMatcher.class);
	
	private Cache<String, AtomicInteger> passwordRetryCache;
	
	public MyCredentialsMatcher() {
	}
	
	public MyCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		String username = (String)token.getPrincipal();
		ByteSource salt = null;
		Object orgPassword = null;
		String password = null;
		
        // 重复登入次数取得
		logger.debug("重复登入次数取得");
        AtomicInteger retryCount = passwordRetryCache.get(username);
        
        if(retryCount == null) {
        	// 第一次登入，初始化Cache
        	logger.debug("第一次登入，初始化Cache");
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        
        // 重复登入次数check
        logger.debug("重复登入次数check");
        if(retryCount.incrementAndGet() >= AppConst.MAX_RETRY_COUNT) {
            // 超过最大尝试次数
        	logger.debug("超过最大尝试次数");
            throw new ExcessiveAttemptsException();
        }
		
		if (info instanceof SaltedAuthenticationInfo) {
			// salt取得
			logger.debug("salt取得");
			salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
		} else {
			// 非SaltedAuthenticationInfo实例
			logger.debug("非SaltedAuthenticationInfo实例");
			return false;
		}

		orgPassword = token.getCredentials();
		password = (String)info.getCredentials();
		
		// 密码匹配
		if (PasswordHelper.match(ByteSource.Util.bytes(orgPassword), salt, password)) {
			// 密码匹配成功
			logger.debug("密码匹配成功");
			return true;
		}
		
		// 密码匹配不成功
		logger.debug("密码匹配不成功");
		return false;
	}

}
