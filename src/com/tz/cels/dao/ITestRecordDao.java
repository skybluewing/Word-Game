package com.tz.cels.dao;

import java.util.List;

import com.tz.cels.entity.TestRecord;

public interface ITestRecordDao {
	//测试记录的数据访问对象，为支持第三个业务【测试业务】而设计的数据
	void write(List<TestRecord> records, String fileName);
	
	/*
	 * 加载所有的已保存的测试记录，并返回整个List
	 */
	List<TestRecord> read(String fileName);
}
