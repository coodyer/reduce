package org.coody.reduce.initer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.bean.InitBeanFace;
import org.coody.framework.core.util.CommonUtil;
import org.coody.framework.core.util.log.LogUtil;
import org.coody.framework.jdbc.JdbcProcessor;

//@AutoBuild
public class ImportDatabase implements InitBeanFace {

	@AutoBuild
	JdbcProcessor jdbcProcessor;

	public static AtomicLong input = new AtomicLong(0l);

	@SuppressWarnings("serial")
	static final Map<String, String> INIT_DATABASE = new HashMap<String, String>() {
		{

			put("email_queue", "CREATE TABLE `email_queue` (\r\n" + "  `id` bigint(32) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `unionId` varchar(32) DEFAULT NULL,\r\n" + "  `title` varchar(128) DEFAULT NULL,\r\n"
					+ "  `context` varchar(256) DEFAULT NULL,\r\n" + "  `targeEmail` varchar(32) DEFAULT NULL,\r\n"
					+ "  `status` int(2) DEFAULT '0',\r\n" + "  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,\r\n"
					+ "  `millisecond` bigint(32) DEFAULT NULL,\r\n"
					+ "  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,\r\n" + "  PRIMARY KEY (`id`)\r\n" + ")");
			put("app_info", "CREATE TABLE `app_info` (\r\n" + "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `name` varchar(32)  DEFAULT NULL,\r\n" + "  `userId` int(11) DEFAULT NULL,\r\n"
					+ "  `unionId` varchar(32) DEFAULT NULL,\r\n"
					+ "  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,\r\n" + "  `status` int(2) DEFAULT '0',\r\n"
					+ "  PRIMARY KEY (`id`) ,\r\n" + "  UNIQUE KEY `app_uk` (`unionId`)  USING BTREE\r\n" + ") ;");
			put("short_info", "CREATE TABLE `short_info` (\r\n" + "  `id` bigint(32) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `frequency` bigint(32) NOT NULL DEFAULT 0,\r\n" + "  `status` tinyint(4) DEFAULT '1',\r\n"
					+ "  `appId` int(11) DEFAULT NULL,\r\n" + "  `userId` int(11) DEFAULT NULL,\r\n"
					+ "  `url` varchar(255) DEFAULT NULL,\r\n"
					+ "  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,\r\n" + "  PRIMARY KEY (`id`) \r\n" + ");");
			put("user_info",
					"CREATE TABLE `user_info` (\r\n" + "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
							+ "  `email` varchar(32) DEFAULT NULL,\r\n" + "  `password` varchar(40) DEFAULT NULL,\r\n"
							+ "  `status` tinyint(4) DEFAULT '1',\r\n"
							+ "  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,\r\n" + "  PRIMARY KEY (`id`) ,\r\n"
							+ "  UNIQUE KEY `email_uk` (`email`) USING BTREE\r\n" + ") ;");
		}
	};

	@Override
	public void init() throws Exception {
		List<Map<String, Object>> results = jdbcProcessor.query("show tables");
		List<String> tables = new ArrayList<String>();
		if (!CommonUtil.isNullOrEmpty(results)) {
			for (Map<String, Object> map : results) {
				tables.add(map.get("table_name").toString().toLowerCase());
			}
		}
		for (String table : INIT_DATABASE.keySet()) {
			if (tables.contains(table)) {
				continue;
			}
			LogUtil.log.info("初始化数据表>>" + table);
			jdbcProcessor.update(INIT_DATABASE.get(table));
		}

	}

}
