package org.coody.reduce.service;

import java.text.MessageFormat;

import org.coody.framework.cache.annotation.CacheWipe;
import org.coody.framework.cache.annotation.CacheWrite;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.jdbc.JdbcProcessor;
import org.coody.framework.jdbc.entity.Pager;
import org.coody.framework.jdbc.util.JdbcUtil;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.domain.ShortInfo;

@AutoBuild
public class ShortService {

	@AutoBuild
	JdbcProcessor jdbcProcessor;

	@CacheWrite(key = CacheConstant.SHORT_INFO, fields = "id", time = 72000)
	public ShortInfo getShortInfo(Long id) {
		return jdbcProcessor.findBeanFirst(ShortInfo.class, "id", id);
	}

	public Long addShortInfo(ShortInfo info) {
		return jdbcProcessor.insert(info);
	}

	@CacheWrite(key = CacheConstant.SHORT_PAGER, time = 5)
	public Pager getPager(Pager pager, ShortInfo shorter) {
		return jdbcProcessor.findPager(shorter, pager, "id", true);
	}

	@CacheWipe(key = CacheConstant.SHORT_INFO, fields = "id")
	public Long del(Long id) {
		String sql = MessageFormat.format("delete from {0} where id=? limit 1", JdbcUtil.getTableName(ShortInfo.class));
		return jdbcProcessor.update(sql, id);
	}
}
