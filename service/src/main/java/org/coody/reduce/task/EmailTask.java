package org.coody.reduce.task;

import java.util.List;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.annotation.LogFlag;
import org.coody.framework.core.threadpool.ThreadBlockPool;
import org.coody.framework.core.util.LogUtil;
import org.coody.framework.task.annotation.CronTask;
import org.coody.reduce.domain.EmailQueue;
import org.coody.reduce.service.EmailService;

@AutoBuild
public class EmailTask {

	@AutoBuild
	EmailService emailService;

	@LogFlag("发送邮件任务")
	@CronTask(value = "0/1 * * * * ? ")
	public void trigger() throws InterruptedException {
		LogUtil.log.info("发送邮件任务执行中");
		List<EmailQueue> queues = emailService.getEmailQueues();
		if (queues == null) {
			return;
		}
		ThreadBlockPool handle = new ThreadBlockPool();
		for (EmailQueue queue : queues) {
			try {
				Runnable runn = new Runnable() {
					@Override
					public void run() {
						emailService.sendEmail(queue);
					}
				};
				handle.pushTask(runn);
			} catch (Exception e) {
			}
		}
		handle.execute();
	}
}
