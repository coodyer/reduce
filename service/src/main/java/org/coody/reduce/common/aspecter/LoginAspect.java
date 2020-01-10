package org.coody.reduce.common.aspecter;

import java.util.Date;

import org.coody.framework.cache.instance.LocalCache;
import org.coody.framework.core.annotation.Around;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.model.AspectPoint;
import org.coody.framework.core.util.CommonUtil;
import org.coody.framework.minicat.http.iface.MinicatServletRequest;
import org.coody.reduce.common.annotation.LoginCheck;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.common.enm.ResultCode;
import org.coody.reduce.common.entity.LoginEntity;

@AutoBuild
public class LoginAspect {

	@AutoBuild
	MinicatServletRequest request;

	@AutoBuild
	LocalCache localCache;

	@Around(annotationClass = LoginCheck.class)
	public Object loginCheck(AspectPoint point) throws Throwable {
		String token = request.getCookie("token");
		if (CommonUtil.isNullOrEmpty(token)) {
			return ResultCode.E_405_TIME_OUT.toMsgEntity();
		}
		LoginEntity wrapper = localCache.getCache(CacheConstant.USER_TOKEN + token);
		if (wrapper == null) {
			return ResultCode.E_405_TIME_OUT.toMsgEntity();
		}
		if (wrapper.getActivityTime().getTime() < System.currentTimeMillis() - 1000 * 60 * 10) {
			wrapper.setActivityTime(new Date());
			localCache.setCache(CacheConstant.USER_TOKEN + token, wrapper, 60 * 30);
		}
		return point.invoke();
	}
}
