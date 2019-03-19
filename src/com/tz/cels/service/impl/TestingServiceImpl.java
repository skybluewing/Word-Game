package com.tz.cels.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.dao.impl.TestRecordDaoImpl;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.ITestingService;

public class TestingServiceImpl implements ITestingService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2874603560516007070L;
	
	IBaseTermDao base = new BaseTermDaoImpl();

	@Override
	public List<BaseTerm> getTestingData(int num) {
		//创建一个list
		List<BaseTerm> list = new ArrayList<BaseTerm>();
		//加载所有单词词汇
		Set<Word> words = base.getAllWords();
		Set<Vocabulary> vocabularies = base.getAllvocabularies();
		//放入list
		list.addAll(words);
		list.addAll(vocabularies);
		//打乱整个list
		Collections.shuffle(list);
		//获取起始位置
		//创建一个需要返回的集合，并从已打乱顺序的集合中取出指定数目的数据
		list.subList(num, list.size()).clear();
		//返回
		return list;
	}

	@Override
	public List<TestRecord> reviewTestRecord() throws NoTestRecordException {
		ITestRecordDao test1 = new TestRecordDaoImpl();
		List<TestRecord> list = new ArrayList<>();
		File dir = new File(TESTRECORD_DIR);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File file = new File(TEST_RECORD_FILE);
		if (!file.exists()) {
				throw new NoTestRecordException("没有历史记录");
		} else {
		list = test1.read(TEST_RECORD_FILE);
		System.out.println(list);
		}
		return list;
	}

	@Override
	public void saveTestRecord(TestRecord record) {
		ITestRecordDao test2 = new TestRecordDaoImpl();
		List<TestRecord> origin = new ArrayList<>();
		File dir = new File(TESTRECORD_DIR);
		if (!dir.exists()) {
			dir.mkdir();
		}
		//新的测试数据
		File file = new File(TEST_RECORD_FILE);
		if (!file.exists()) {
				try {
					file.createNewFile();
					System.out.println("这个第一次保存");
				} catch (IOException e) {
					e.printStackTrace();
				}
		} else{
			origin = test2.read(TEST_RECORD_FILE);
			//要求排序，需要TestRecord实现Comparable接口
		}
		origin.add(record);
		Collections.sort(origin);
		Collections.reverse(origin);
		test2.write(origin, TEST_RECORD_FILE);
	}

}
