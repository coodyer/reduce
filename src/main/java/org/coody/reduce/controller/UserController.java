package org.coody.reduce.controller;

import java.util.Date;

import org.coody.framework.cache.instance.LocalCache;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.util.reflex.PropertUtil;
import org.coody.framework.core.util.uuid.JUUIDUtil;
import org.coody.framework.minicat.web.adapter.JsonMealAdapter;
import org.coody.framework.minicat.web.annotation.JsonOut;
import org.coody.framework.minicat.web.annotation.ParamsAdapt;
import org.coody.framework.minicat.web.annotation.PathBinding;
import org.coody.reduce.common.annotation.LoginCheck;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.common.enm.ResultCode;
import org.coody.reduce.common.entity.LoginEntity;
import org.coody.reduce.controller.base.BaseController;
import org.coody.reduce.domain.UserInfo;
import org.coody.reduce.dto.UserInfoDTO;
import org.coody.reduce.service.EmailService;
import org.coody.reduce.service.UserService;
import org.coody.reduce.vo.UserCreateVO;
import org.coody.reduce.vo.UserLoginVO;

@PathBinding("user")
@ParamsAdapt(JsonMealAdapter.class)
@JsonOut
public class UserController extends BaseController {

	@AutoBuild
	UserService userService;
	@AutoBuild
	EmailService emailService;
	@AutoBuild
	LocalCache localCache;

	@PathBinding("/create")
	public Object create(UserCreateVO vo) {
		boolean isChecked = emailService.checkCode(vo.getEmail(), vo.getCode());
		if (!isChecked) {
			return ResultCode.E_1003_CODE_ERROR.toMsgEntity();
		}
		UserInfo user = userService.getUserInfo(vo.getEmail());
		if (user != null) {
			return ResultCode.E_1004_MAIL_EXISTS.toMsgEntity();
		}
		user = new UserInfo();
		user.setCreateTime(new Date());
		user.setEmail(vo.getEmail());
		user.setPassword(vo.getPassword());
		user.setStatus(1);
		Long code = userService.addUserInfo(user);
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		user.setId(code.intValue());
		String token = JUUIDUtil.createUuid();
		LoginEntity wrapper = new LoginEntity();
		wrapper.setUserId(user.getId());
		localCache.setCache(CacheConstant.USER_TOKEN + token, wrapper, 60 * 30);
		response.setCookie("token", token);
		return ResultCode.E_200_SUCCESS.toMsgEntity(token);
	}

	@PathBinding("/loginOut")
	public void loginOut() {
		String token = request.getCookie("token");
		localCache.delCache(CacheConstant.USER_TOKEN + token);
		response.sendRedirect("/html/login.html");
	}

	@PathBinding("/resetPwd")
	public Object resetPwd(UserCreateVO vo) {
		boolean isChecked = emailService.checkCode(vo.getEmail(), vo.getCode());
		if (!isChecked) {
			return ResultCode.E_1003_CODE_ERROR.toMsgEntity();
		}
		UserInfo user = userService.getUserInfo(vo.getEmail());
		if (user == null) {
			return ResultCode.E_1005_MAIL_NOT_EXISTS.toMsgEntity();
		}
		Long code = userService.modifyUserInfo(user, "password");
		if (code < 1) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		String token = JUUIDUtil.createUuid();
		LoginEntity wrapper = new LoginEntity();
		wrapper.setUserId(user.getId());
		localCache.setCache(CacheConstant.USER_TOKEN + token, wrapper, 60 * 30);
		response.setCookie("token", token);
		return ResultCode.E_200_SUCCESS.toMsgEntity(token);
	}

	@LoginCheck
	@PathBinding("/info")
	public Object info() {
		UserInfo user = userService.getUserInfo(getCurrentUserId());
		if (user == null) {
			return ResultCode.E_1005_MAIL_NOT_EXISTS.toMsgEntity();
		}
		UserInfoDTO dto = new UserInfoDTO();
		dto = PropertUtil.copyPropertys(user, dto);
		return ResultCode.E_200_SUCCESS.toMsgEntity(dto);
	}

	@PathBinding("/login")
	public Object login(UserLoginVO vo) {
		UserInfo user = userService.getUserInfo(vo.getEmail());
		if (user == null) {
			return ResultCode.E_1005_MAIL_NOT_EXISTS.toMsgEntity();
		}
		if (!vo.getPassword().equals(user.getPassword())) {
			return ResultCode.E_1006_PASS_ERROR.toMsgEntity();
		}
		if (user.getStatus() == 0) {
			return ResultCode.E_1008_USER_UNAVABLE.toMsgEntity();
		}
		if (user.getStatus() != 1) {
			return ResultCode.E_1009_USER_FROZEN.toMsgEntity();
		}
		String token = JUUIDUtil.createUuid();
		LoginEntity wrapper = new LoginEntity();
		wrapper.setUserId(user.getId());
		localCache.setCache(CacheConstant.USER_TOKEN + token, wrapper, 60 * 30);
		response.setCookie("token", token);
		return ResultCode.E_200_SUCCESS.toMsgEntity(token);
	}

}
