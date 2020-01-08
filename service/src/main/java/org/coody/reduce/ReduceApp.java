package org.coody.reduce;

import org.coody.framework.minicat.MinicatApp;
import org.coody.reduce.common.servlet.ReduceServlet;

public class ReduceApp {

	public static void main(String[] args) throws Exception {
		MinicatApp.init(ReduceServlet.class);
	}
}
