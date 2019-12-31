package org.coody.reduce;

import org.coody.framework.minicat.CoreApp;
import org.coody.reduce.common.servlet.ReduceServlet;

public class ReduceApp {

	public static void main(String[] args) throws Exception {
		CoreApp.init(ReduceServlet.class);
	}
}
