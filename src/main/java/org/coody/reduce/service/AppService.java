package org.coody.reduce.service;

import java.text.MessageFormat;
import java.util.List;

import org.coody.framework.cache.annotation.CacheWipe;
import org.coody.framework.cache.annotation.CacheWrite;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.CommonUtil;
import org.coody.framework.jdbc.JdbcProcessor;
import org.coody.framework.jdbc.annotation.Transacted;
import org.coody.framework.jdbc.util.JdbcUtil;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.domain.AppInfo;

@AutoBuild
public class AppService {

	@AutoBuild
	JdbcProcessor jdbcProcessor;

	@CacheWrite(key = CacheConstant.APP_INFO, fields = "id", time = 72000)
	public AppInfo getAppInfo(Integer id) {

		return jdbcProcessor.findBeanFirst(AppInfo.class, "id", id);
	}

	@Transacted
	@CacheWipe(key = CacheConstant.APP_LIST, fields = "app.userId")
	@CacheWipe(key = CacheConstant.APP_INFO, fields = "app.id")
	public Long saveAppInfo(AppInfo app) {
		if (CommonUtil.isNullOrEmpty(app.getId())) {
			return jdbcProcessor.insert(app);
		}
		return jdbcProcessor.updateByPriKey(app, "id");
	}
	@Transacted
	@CacheWipe(key = CacheConstant.APP_LIST, fields = "app.userId")
	@CacheWipe(key = CacheConstant.APP_INFO, fields = "app.id")
	public Long delAppInfo(AppInfo app) {
		String sql = MessageFormat.format("delete from {0} where id=? limit 1", JdbcUtil.getTableName(AppInfo.class));
		return jdbcProcessor.update(sql, app.getId());
	}

	@CacheWrite(time = 3)
	public List<AppInfo> getAppInfos(AppInfo app) {
		return jdbcProcessor.findBean(app);
	}

	@CacheWrite(key = CacheConstant.APP_LIST, fields = "userId", time = 72000)
	public List<AppInfo> getAppInfos(Integer userId) {
		return jdbcProcessor.findBean(AppInfo.class, "userId", userId);
	}

	@CacheWrite(key = CacheConstant.APP_INFO, fields = "unionId", time = 72000)
	public AppInfo getAppInfo(String unionId) {
		return jdbcProcessor.findBeanFirst(AppInfo.class, "unionId", unionId);
	}
}
