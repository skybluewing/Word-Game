package com.tz.cels.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.entity.TestRecord;

public class TestRecordDaoImplTest {

	ITestRecordDao test = new TestRecordDaoImpl();
	
	@Test
	public void testWrite() {
		List<TestRecord> records = new ArrayList<>();
		TestRecord element = new TestRecord();
		element.setMinute(8);
		records.add(element);
		test.write(records, "data/history/en2cn.his");
	}

	@Test
	public void testRead() {
		List<TestRecord> records = new ArrayList<>();
		records = test.read("data/history/en2cn.his");
		records.forEach(System.out::println);
	}

}
