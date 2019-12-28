package org.coody.reduce.controller;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.minicat.web.adapter.JsonMealAdapter;
import org.coody.framework.minicat.web.annotation.JsonOut;
import org.coody.framework.minicat.web.annotation.ParamsAdapt;
import org.coody.framework.minicat.web.annotation.PathBinding;
import org.coody.reduce.common.enm.ResultCode;
import org.coody.reduce.controller.base.BaseController;
import org.coody.reduce.service.EmailService;
import org.coody.reduce.service.EmailService.CodeWrapper;
import org.coody.reduce.vo.SendCodeVO;

@PathBinding("verificat")
@ParamsAdapt(JsonMealAdapter.class)
@JsonOut
public class VerificatController extends BaseController {

	@AutoBuild
	EmailService emailService;

	
	@PathBinding("/sendCode")
	public Object sendCode(SendCodeVO vo) {

		CodeWrapper wrapper = emailService.getCode(vo.getEmail());
		if (wrapper != null) {
			if (System.currentTimeMillis() - wrapper.getCreateTime().getTime() < 1000 * 60) {
				return ResultCode.E_1007_SEND_TOO_BUSY.toMsgEntity();
			}
		}
		String code = emailService.createCode(vo.getEmail());
		boolean isSended = emailService.sendEmail(vo.getEmail(), code);
		if (!isSended) {
			return ResultCode.E_500_SYS_BUSY.toMsgEntity();
		}
		return ResultCode.E_200_SUCCESS.toMsgEntity();
	}

}
