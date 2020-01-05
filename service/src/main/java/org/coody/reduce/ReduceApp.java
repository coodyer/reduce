package org.coody.reduce;

import org.apache.log4j.Logger;
import org.coody.framework.minicat.CoreApp;
import org.coody.reduce.common.servlet.ReduceServlet;

public class ReduceApp {

	static Logger logger = Logger.getLogger(ReduceApp.class);

	public static void main(String[] args) throws Exception {
		logger.info("测试");
		CoreApp.init(ReduceServlet.class);
	}
}
