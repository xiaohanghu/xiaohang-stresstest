package com.xiaohang.stresstest;


import org.junit.Test;

/**
 * @author xiaohanghu
 */
public class MainTest {

    @Test
    public void test() {
        StressTestUtils.testAndPrint(100, 1000, new StressTask() {

            @Override
            public Object doTask() throws Exception {
                System.out.println("Do my task.");
                return null;
            }
        }, "Demo");
    }

}
