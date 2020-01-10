package org.coody.reduce.service;

import org.coody.framework.cache.annotation.CacheWipe;
import org.coody.framework.cache.annotation.CacheWrite;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.reflex.PropertUtil;
import org.coody.framework.jdbc.JdbcProcessor;
import org.coody.framework.jdbc.util.JdbcUtil;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.domain.UserInfo;

@AutoBuild
public class UserService {

	@AutoBuild
	JdbcProcessor jdbcProcessor;

	public Long addUserInfo(UserInfo user) {
		return jdbcProcessor.insert(user);
	}

	@CacheWipe(key = CacheConstant.USER_INFO, fields = "user.email")
	@CacheWipe(key = CacheConstant.USER_INFO, fields = "user.id")
	public Long modifyUserInfo(UserInfo user, String field) {
		String sql = String.format("update %s set %s=? where email=? limit 1", JdbcUtil.getTableName(user.getClass()),
				field);
		String value = PropertUtil.getFieldValue(user, field);
		return jdbcProcessor.update(sql, value, user.getEmail());
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
