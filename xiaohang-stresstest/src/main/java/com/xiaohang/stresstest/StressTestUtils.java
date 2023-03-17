package com.xiaohang.stresstest;

import java.io.StringWriter;


/**
 * @author xiaohanghu
 */
public class StressTestUtils {

	private static StressTester stressTester = new StressTester();
	private static SimpleResultFormater simpleResultFormater = new SimpleResultFormater();

	public static StressResult test(int concurrencyLevel, int totalTasks,
			StressTask stressTask) {
		return stressTester.test(concurrencyLevel, totalTasks, stressTask);
	}

	public static StressResult test(int concurrencyLevel, int totalTasks,
			StressTask stressTask, int warmUpTime) {
		return stressTester.test(concurrencyLevel, totalTasks, stressTask,
				warmUpTime);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks,
			StressTask stressTask) {
		testAndPrint(concurrencyLevel, totalTasks, stressTask, null);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks,
			StressTask stressTask, String testName) {
		StressResult stressResult = test(concurrencyLevel, totalTasks,
				stressTask);
		String str = format(stressResult);
		System.out.println(" " + testName + " test result:");
		System.out.println(str);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks,
			StressTask stressTask, int warmUpTime, String testName) {
		StressResult stressResult = test(concurrencyLevel, totalTasks,
				stressTask, warmUpTime);
		String str = format(stressResult);
		System.out.println(" " + testName + " test result:");
		System.out.println(str);
	}

	public static String format(StressResult stressResult) {
		return format(stressResult, simpleResultFormater);
	}

	public static String format(StressResult stressResult,
			StressResultFormater stressResultFormater) {
		StringWriter sw = new StringWriter();
		stressResultFormater.format(stressResult, sw);
		return sw.toString();
	}

}
