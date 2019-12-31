package org.coody.reduce.common.enm;

import org.coody.reduce.common.entity.MsgEntity;

/**
 * 全局交易编码枚举
 * 
 * @author Coody
 * @date 2018年10月31日
 */
public enum ResultCode {

	// 编码
	E_1009_USER_FROZEN(1009, "用户不可用"),
	// 编码
	E_1008_USER_UNAVABLE(1008, "用户审核中"),
	// 编码
	E_1007_SEND_TOO_BUSY(1007, "验证码发送过于频繁"),
	// 编码
	E_1006_PASS_ERROR(1006, "密码不正确"),
	// 编码
	E_1005_USER_NOT_EXISTS(1005, "用户不存在"),
	// 编码
	E_1004_MAIL_EXISTS(1004, "邮箱已使用"),
	// 编码
	E_1003_CODE_ERROR(1003, "验证码不正确"),
	// 编码
	E_1002_APP_UNAVAILABLE(1002, "APP不可用"),
	// 编码
	E_1001_APP_EXISTS(1001, "APP不存在"),

	
	// 编码
	E_403_NOT_EXISTS(403, "数据不存在"),
	// 编码
	E_404_NOT_DATAS(404, "暂无数据"),
	// 编码
	E_405_TIME_OUT(405, "登录超时"),
	// 编码
	E_500_SYS_BUSY(500, "系统繁忙"),
	// 编码
	E_200_SUCCESS(200, "成功"),;

	private int code;
	private String msg;

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgEntity toMsgEntity() {
		return new MsgEntity(this.code, this.msg);
	}

	public MsgEntity toMsgEntity(Object data) {
		return new MsgEntity(this.code, this.msg, data);
	}
}
