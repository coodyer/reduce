package org.coody.reduce.controller;

import java.util.List;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.CommonUtil;
import org.coody.framework.core.util.uuid.JUUIDUtil;
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
		AppInfo app = new AppInfo();
		app.setStatus(1);
		if (!CommonUtil.isNullOrEmpty(vo.getId())) {
			app = appService.getAppInfo(vo.getId());
			Integer userId = getCurrentUserId();
			if (app == null || userId != app.getUserId().intValue()) {
				return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
			}
			if (app.getStatus() > 0) {
				app.setStatus(vo.getStatus());
			}
		}
		app.setId(vo.getId());
		app.setName(vo.getName());
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
	@ParamsAdapt(JsonMealAdapter.class)
	public Object list(AppInfo app) {
		if (app == null) {
			app = new AppInfo();
		}
		app.setUserId(getCurrentUserId());
		List<AppInfo> apps = appService.getAppInfos(app);
		if (CommonUtil.isNullOrEmpty(apps)) {
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
