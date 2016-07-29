/**
 * 密码服务Helper类
 * ming 2016/07/20
 */
package com.yimeicloud.study.ssm.helper;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yimeicloud.study.ssm.model.User;
import com.yimeicloud.study.ssm.util.AppConst;

@Component
public class PasswordHelper {

	private static final Logger logger = LoggerFactory.getLogger(PasswordHelper.class);
	
	private static DefaultHashService hashService = new DefaultHashService();
	
	/**
	 * 密码加密
	 * @param user
	 */
	public static void encrypPassword(User user) {
		logger.debug("加密开始...");
		
		// 构造随机数作为salt
		logger.debug("构造随机数作为salt...");
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        
        // 计算password
        logger.debug("计算password...");;
        String password = computeHash(user.getPassword(), user.getUsername() + salt);
        
        // salt,password设定
        logger.debug("salt,password设定...");
        user.setSalt(salt);
        user.setPassword(password);
        
        logger.debug("加密成功");
	}
	
	/**
	 * 密码匹配
	 * @param user
	 * @param password
	 * @return
	 */
	public static boolean match(Object orgPassword, Object salt, String password) {
		logger.debug("密码匹配开始...");
		
		// 计算password
		logger.debug("计算password...");
		String computePassword = computeHash(orgPassword, salt);
		
		logger.debug("匹配结果：" + computePassword.equals(password));
		
		// 比较传入与实际password
		return computePassword.equals(password);
	}
	
	/**
	 * 密文计算
	 * @param password
	 * @param salt
	 * @return
	 */
	private static String computeHash(Object password, Object salt) {
		logger.debug("密文计算...");
        // 构造HashRequest
        HashRequest request = new HashRequest.Builder()
        		.setAlgorithmName(AppConst.ALGORITHM_NAME)
        		.setSource(ByteSource.Util.bytes(password))
        		.setSalt(ByteSource.Util.bytes(salt))
        		.setIterations(AppConst.HASH_ITERATIONS)
        		.build();
        
        // 计算password
        return hashService.computeHash(request).toString();
	}
}
