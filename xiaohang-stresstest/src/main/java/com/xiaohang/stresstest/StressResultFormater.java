package com.xiaohang.stresstest;

import java.io.Writer;

/**
 * @author xiaohanghu
 * */
public interface StressResultFormater {

	void format(StressResult stressResult, Writer writer);

}
