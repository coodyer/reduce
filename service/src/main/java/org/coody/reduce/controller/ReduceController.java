package org.coody.reduce.controller;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.StringUtil;
import org.coody.framework.minicat.http.iface.MinicatServletResponse;
import org.coody.framework.minicat.web.annotation.PathBinding;
import org.coody.framework.minicat.web.annotation.TextOut;
import org.coody.reduce.common.util.PECode;
import org.coody.reduce.controller.base.BaseController;
import org.coody.reduce.domain.ShortInfo;
import org.coody.reduce.service.ShortService;
import org.coody.reduce.service.UserService;

@PathBinding("/")
public class ReduceController extends BaseController{

	@AutoBuild
	UserService userService;
	@AutoBuild
	ShortService shortService;

	@PathBinding("/{code}")
	public void trigger(String code) {
		if (StringUtil.isNullOrEmpty(code)) {
			return;
		}
		Long id = PECode.decode(code);
		if (id == null) {
			return;
		}
		ShortInfo info = shortService.getShortInfo(id);
		if (info == null) {
			return;
		}
		response.sendRedirect(info.getUrl());
	}

	@PathBinding("/index.do")
	@TextOut
	public String index(String code, MinicatServletResponse response) {
		return "Welcome to Short Web Site Service Platform.";
	}
}
