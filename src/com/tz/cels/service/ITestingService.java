package com.tz.cels.service;

import java.util.List;

import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.exceptions.NoTestRecordException;

public interface ITestingService {
	//第三个业务接口，为了完成测试自己的水平而定义的业务接口
	//定义存放测试记录的目录路径
	String TESTRECORD_DIR = "data/testing";
	//定义存放测试记录的文件路径
	String TEST_RECORD_FILE = "data/testing/records.rec";
	/*
	 *获取测试数据，它的来源都是从原始数据中随机抽取出指定数量的数据 
	 */
	List<BaseTerm> getTestingData(int num);
	/*
	 *此方法从文件中读取保存过的测试记录，它的数据来源只能是之前保存下来的记录文件。
	 *此方法的实现，就是委托ITestRecordDao的read方法
	 */
	List<TestRecord> reviewTestRecord() throws NoTestRecordException;
	
	/*
	 * 持久化测试的数据到文件
	 */
	void saveTestRecord(TestRecord record);
}
