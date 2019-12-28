package org.coody.reduce.service;

import java.util.Date;
import java.util.List;

import org.coody.framework.cache.instance.LocalCache;
import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.model.BaseModel;
import org.coody.framework.core.util.DateUtils;
import org.coody.framework.core.util.EncryptUtil;
import org.coody.framework.core.util.StringUtil;
import org.coody.framework.jdbc.JdbcProcessor;
import org.coody.framework.jdbc.annotation.Transacted;
import org.coody.framework.jdbc.entity.Pager;
import org.coody.framework.jdbc.entity.Where;
import org.coody.framework.mail.entity.EmailSendConfig;
import org.coody.framework.mail.sender.EmailSender;
import org.coody.reduce.common.constants.CacheConstant;
import org.coody.reduce.domain.EmailQueue;

@AutoBuild
public class EmailService {

	@AutoBuild
	JdbcProcessor jdbcProcessor;
	@AutoBuild
	LocalCache localCache;
	@AutoBuild
	EmailSendConfig emailConfig;

	@Transacted
	public boolean sendEmail(EmailQueue queue) {

		String sql = "update email_queue set status=1 where id=? limit 1";
		Long code = jdbcProcessor.update(sql, queue.getId());
		if (code < 1) {
			return false;
		}
		EmailSender sender = new EmailSender(emailConfig);
		sender.send(queue.getTargeEmail(), queue.getTitle(), queue.getContext());

		return true;
	}

	public String createCode(String email) {
		Integer code = StringUtil.getRanDom(1000, 9999);
		String key = CacheConstant.EMAIL_CODE + email;

		CodeWrapper wrapper = new CodeWrapper();
		wrapper.setCode(code.toString());
		wrapper.setErrors(0);
		localCache.setCache(key, wrapper, 60 * 5);
		return code.toString();
	}

	public boolean checkCode(String email, String code) {
		String key = CacheConstant.EMAIL_CODE + email;
		CodeWrapper wrapper = localCache.getCache(key);
		if (wrapper == null) {
			return false;
		}
		if (!wrapper.getCode().equals(code)) {
			wrapper.setErrors(wrapper.getErrors() + 1);
			localCache.setCache(key, wrapper, 60 * 5);
			return false;
		}
		return true;
	}

	public CodeWrapper getCode(String email) {
		String key = CacheConstant.EMAIL_CODE + email;
		return localCache.getCache(key);
	}

	/**
	 * 发送验证码
	 */
	public boolean sendEmail(String targe, String code) {
		EmailQueue queue = new EmailQueue();
		queue.setTitle("Reduce 验证邮件");
		queue.setContext("您的验证码是：" + code);
		queue.setTargeEmail(targe);
		queue.setUnionId(EncryptUtil.md5Code(queue.getTitle() + "_" + queue.getContext() + "_" + queue.getTargeEmail()
				+ "_" + DateUtils.getDateString()));
		Long result = jdbcProcessor.insert(queue);
		if (result < 1) {
			return false;
		}
		return true;
	}

	public List<EmailQueue> getEmailQueues() {
		Where where = new Where();
		where.set("status", 0);
		where.set("millisecond", ">", System.currentTimeMillis() - (1000 * 60 * 1));
		Pager pager = new Pager();
		pager.setSize(100);
		List<EmailQueue> queues = jdbcProcessor.findBean(EmailQueue.class, where, pager);
		return queues;
	}

	@SuppressWarnings("serial")
	public static class CodeWrapper extends BaseModel {

		private String code;

		private Integer errors;

		private Date createTime;

		public CodeWrapper() {
			createTime = new Date();
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Integer getErrors() {
			return errors;
		}

		public void setErrors(Integer errors) {
			this.errors = errors;
		}

	}

}
