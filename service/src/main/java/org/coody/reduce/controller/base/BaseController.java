package org.coody.reduce.controller.base;

import org.coody.framework.cache.instance.LocalCache;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.minicat.http.iface.MinicatServletRequest;
import org.coody.framework.minicat.http.iface.MinicatServletResponse;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.common.entity.LoginEntity;

public class BaseController {

	@AutoBuild
	protected MinicatServletRequest request;

	@AutoBuild
	protected MinicatServletResponse response;

	@AutoBuild
	protected LocalCache localCache;

	protected Integer getCurrentUserId() {
		String token = request.getCookie("token");
		LoginEntity wrapper = localCache.getCache(CacheConstant.USER_TOKEN + token);
		if (wrapper == null) {
			return null;
		}
		return wrapper.getUserId();

	}
}
