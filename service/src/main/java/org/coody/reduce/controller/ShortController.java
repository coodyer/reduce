package org.coody.reduce.controller;

import java.util.Date;
import java.util.List;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.CommonUtil;
import org.coody.framework.core.util.reflex.PropertUtil;
import org.coody.framework.jdbc.entity.Pager;
import org.coody.framework.minicat.web.adapter.JsonMealAdapter;
import org.coody.framework.minicat.web.annotation.JsonOut;
import org.coody.framework.minicat.web.annotation.ParamsAdapt;
import org.coody.framework.minicat.web.annotation.PathBinding;
import org.coody.reduce.common.annotation.LoginCheck;
import org.coody.reduce.common.enm.ResultCode;
import org.coody.reduce.common.util.PECode;
import org.coody.reduce.controller.base.BaseController;
import org.coody.reduce.domain.AppInfo;
import org.coody.reduce.domain.ShortInfo;
import org.coody.reduce.dto.ShortInfoDTO;
import org.coody.reduce.service.AppService;
import org.coody.reduce.service.ShortService;

@PathBinding("/short")
@JsonOut
public class ShortController extends BaseController {

	@AutoBuild
	ShortService shortService;
	@AutoBuild
	AppService appService;

	@PathBinding("/create")
	public Object create(String unionId, String url) {
		AppInfo app = appService.getAppInfo(unionId);
		if (CommonUtil.isNullOrEmpty(app)) {
			return ResultCode.E_1001_APP_EXISTS.toMsgEntity();
		}
		if (app.getStatus() != 1) {
			return ResultCode.E_1002_APP_UNAVAILABLE.toMsgEntity();
		}
		ShortInfo info = new ShortInfo();
		info.setUrl(url);
		info.setCreateTime(new Date());
		info.setUserId(app.getUserId());
		info.setAppId(app.getId());
		Long id = shortService.addShortInfo(info);
		if (id < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		String shorter = request.getBasePath() + "/" + PECode.encode(id);
		return ResultCode.E_200_SUCCESS.toMsgEntity(shorter);
	}

	@LoginCheck
	@PathBinding("/info")
	public Object save(Long id) {
		ShortInfo shorter = shortService.getShortInfo(id);
		if (shorter == null) {
			return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity(shorter);
	}

	@LoginCheck
	@PathBinding("/save")
	@ParamsAdapt(JsonMealAdapter.class)
	public Object save(ShortInfo info) {
		info.setUserId(getCurrentUserId());
		Long code = shortService.saveShortInfo(info);
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity();
	}

	@PathBinding("/del")
	public Object del(Long id) {
		ShortInfo shorter = shortService.getShortInfo(id);
		if (CommonUtil.isNullOrEmpty(shorter) || shorter.getUserId() != getCurrentUserId().intValue()) {
			return ResultCode.E_403_NOT_EXISTS.toMsgEntity();
		}
		Long code = shortService.del(id);
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity();
	}

	@LoginCheck
	@PathBinding("/page")
	public Object page(Pager pager, ShortInfo shorter) {
		if (shorter == null) {
			shorter = new ShortInfo();
		}
		if (pager == null) {
			pager = new Pager();
		}
		shorter.setUserId(getCurrentUserId());
		pager = shortService.getPager(pager, shorter);
		if (!CommonUtil.isNullOrEmpty(pager.getData())) {
			List<ShortInfoDTO> dtos = PropertUtil.getNewList(pager.getData(), ShortInfoDTO.class);
			for (ShortInfoDTO dto : dtos) {
				String shortUrl = request.getBasePath() + "/" + PECode.encode(dto.getId());
				dto.setShortUrl(shortUrl);
				AppInfo app = appService.getAppInfo(dto.getAppId());
				dto.setAppName(app == null ? "" : app.getName());
			}
			pager.setData(dtos);
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity(pager);
	}
}
