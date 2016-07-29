/**
 * 自定义role filter
 * ming 2016/07/29
 */
package com.yimeicloud.study.ssm.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRolesAuthorizationFilter extends AuthorizationFilter {

	private Logger logger = LoggerFactory.getLogger(MyRolesAuthorizationFilter.class);
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// role check
		logger.debug("role check...");
		Subject subject = getSubject(request, response);
		String[] rolesArray = (String[]) mappedValue;

		if (rolesArray == null || rolesArray.length == 0) {
			// no roles
			logger.debug("no roles");
			return false;
		}

		List<String> roles = CollectionUtils.asList(rolesArray);
		boolean[] hasRoles = subject.hasRoles(roles);
		for (boolean hasRole : hasRoles) {
			if (hasRole) {
				return true;
			}
		}
		return false;
	}

}
