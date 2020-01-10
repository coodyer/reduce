package org.coody.reduce.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.coody.framework.core.annotation.AutoBuild;
import org.coody.framework.core.bean.InitBeanFace;
import org.coody.framework.core.threadpool.SysThreadPool;
import org.coody.reduce.service.ShortService;

@AutoBuild
public class FrequencyQueue implements InitBeanFace {

	private static final LinkedBlockingQueue<Long> FREQUENCY_QUEUE = new LinkedBlockingQueue<Long>();

	@AutoBuild
	private ShortService shortService;

	public void addFrequency(Long id) {
		FREQUENCY_QUEUE.offer(id);
	}

	private void consume() {
		while (true) {
			try {
				Long id = FREQUENCY_QUEUE.take();

				shortService.addFrequency(id);

			} catch (Exception e) {
				e.printStackTrace();
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (Exception e2) {
				}
			} finally {
				try {
					TimeUnit.MICROSECONDS.sleep(1);
				} catch (Exception e2) {
				}
			}

		}
	}

	@Override
	public void init() throws Exception {
		SysThreadPool.THREAD_POOL.execute(new Runnable() {
			@Override
			public void run() {
				consume();
			}
		});
	}

}
