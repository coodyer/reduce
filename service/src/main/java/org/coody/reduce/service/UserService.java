package org.coody.reduce.service;

import org.coody.framework.cache.annotation.CacheWrite;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.jdbc.JdbcProcessor;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.domain.UserInfo;

@AutoBuild
public class UserService {

	@AutoBuild
	JdbcProcessor jdbcProcessor;

	public Long saveUserInfo(UserInfo user) {
		return jdbcProcessor.insert(user);
	}

	@CacheWrite(key = CacheConstant.USER_INFO, fields = "email", time = 72000)
	public UserInfo getUserInfo(String email) {
		return jdbcProcessor.findBeanFirst(UserInfo.class, "email", email);
	}

	@CacheWrite(key = CacheConstant.USER_INFO, fields = "id", time = 72000)
	public UserInfo getUserInfo(Integer id) {
		return jdbcProcessor.findBeanFirst(UserInfo.class, "id", id);
	}
}
