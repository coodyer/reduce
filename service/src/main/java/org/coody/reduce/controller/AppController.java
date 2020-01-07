package org.coody.reduce.controller;

import java.util.List;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.JUUIDUtil;
import org.coody.framework.core.util.StringUtil;
import org.coody.framework.minicat.web.adapter.JsonMealAdapter;
import org.coody.framework.minicat.web.annotation.JsonOut;
import org.coody.framework.minicat.web.annotation.ParamsAdapt;
import org.coody.framework.minicat.web.annotation.PathBinding;
import org.coody.reduce.common.annotation.LoginCheck;
import org.coody.reduce.common.enm.ResultCode;
import org.coody.reduce.controller.base.BaseController;
import org.coody.reduce.domain.AppInfo;
import org.coody.reduce.service.AppService;
import org.coody.reduce.vo.AppCreateVO;

@PathBinding("/app")
@JsonOut
public class AppController extends BaseController {

	@AutoBuild
	AppService appService;

	@LoginCheck
	@PathBinding("/save")
	@ParamsAdapt(JsonMealAdapter.class)
	public Object save(AppCreateVO vo) {
		if (!StringUtil.isNullOrEmpty(vo.getId())) {
			AppInfo app = appService.getAppInfo(vo.getId());
			Integer userId = getCurrentUserId();
			if (app == null || userId != app.getUserId().intValue()) {
				return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
			}
		}
		AppInfo app = new AppInfo();
		app.setId(vo.getId());
		app.setName(vo.getName());	
		app.setStatus(0);
		app.setUnionId(JUUIDUtil.createUuid());
		app.setUserId(getCurrentUserId());
		Long code = appService.saveAppInfo(app);
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity();
	}

	@LoginCheck
	@PathBinding("/info")
	public Object info(Integer id) {
		AppInfo app = appService.getAppInfo(id);
		Integer userId = getCurrentUserId();
		if (app == null || userId != app.getUserId().intValue()) {
			return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity(app);
	}

	@LoginCheck
	@PathBinding("/list")
	public Object list() {
		List<AppInfo> apps = appService.getAppInfos(getCurrentUserId());
		if (StringUtil.isNullOrEmpty(apps)) {
			return ResultCode.E_404_NOT_DATAS.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity(apps);
	}

	@LoginCheck
	@PathBinding("/del")
	public Object del(Integer id) {
		AppInfo app = appService.getAppInfo(id);
		Integer userId = getCurrentUserId();
		if (app == null || userId != app.getUserId().intValue()) {
			return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
		}
		Long code = appService.delAppInfo(app);
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity();
	}
}
