package com.xiaohang.stresstest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 测试工作线程
 * 
 * @author xiaohanghu
 * */
class StressThreadWorker implements Runnable {

	private StressTask service;
	private CyclicBarrier threadStartBarrier;
	private CountDownLatch threadEndLatch;
	private AtomicInteger failedCounter = null;
	private int count;
	private static Log log = LogFactory.getLog(StressThreadWorker.class);

	private List<Long> everyTimes;

	public StressThreadWorker(StressContext stressContext, int count) {
		super();
		this.threadStartBarrier = stressContext.getThreadStartBarrier();
		this.threadEndLatch = stressContext.getThreadEndLatch();
		this.failedCounter = stressContext.getFailedCounter();
		this.count = count;

		everyTimes = new ArrayList<Long>(count);

		this.service = stressContext.getTestService();
	}

	public List<Long> getEveryTimes() {
		return everyTimes;
	}

	@Override
	public void run() {
		try {
			threadStartBarrier.await();
			doRun();
		} catch (Exception e) {
			log.error("Test exception", e);
		}
	}

	protected void doRun() throws Exception {
		// 记录单次调用时间
		// 10000次测试工具耗时2ms
		for (int i = 0; i < count; i++) {
			long start = System.nanoTime();
			try {
				// Object result = service.test();
				service.doTask();
			} catch (Throwable e) {
				failedCounter.incrementAndGet();
				// throw e;
			} finally {
				long takes = System.nanoTime() - start;
				everyTimes.add(takes);
			}
		}
		threadEndLatch.countDown();
	}


}
