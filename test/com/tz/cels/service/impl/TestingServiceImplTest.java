package com.tz.cels.service.impl;


import java.util.List;
import org.junit.Test;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.ITestingService;

public class TestingServiceImplTest {
	
	ITestingService test = new TestingServiceImpl();

	@Test
	public void testGetTestingData() {
		test.getTestingData(10);
	}

	@Test
	public void testReviewTestRecord() throws NoTestRecordException {
		List<TestRecord> list = test.reviewTestRecord();
		System.out.println(list);
	}

	@Test
	public void testSaveTestRecord() {
		List<BaseTerm> list = test.getTestingData(10);
		TestRecord record = new TestRecord();
		record.setList(list);
		System.out.println(record);
		test.saveTestRecord(record);
	}

}
