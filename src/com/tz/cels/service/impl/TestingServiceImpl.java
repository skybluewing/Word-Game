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
		//����һ��list
		List<BaseTerm> list = new ArrayList<BaseTerm>();
		//�������е��ʴʻ�
		Set<Word> words = base.getAllWords();
		Set<Vocabulary> vocabularies = base.getAllvocabularies();
		//����list
		list.addAll(words);
		list.addAll(vocabularies);
		//��������list
		Collections.shuffle(list);
		//��ȡ��ʼλ��
		//����һ����Ҫ���صļ��ϣ������Ѵ���˳��ļ�����ȡ��ָ����Ŀ������
		list.subList(num, list.size()).clear();
		//����
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
				throw new NoTestRecordException("û����ʷ��¼");
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
		//�µĲ�������
		File file = new File(TEST_RECORD_FILE);
		if (!file.exists()) {
				try {
					file.createNewFile();
					System.out.println("�����һ�α���");
				} catch (IOException e) {
					e.printStackTrace();
				}
		} else{
			origin = test2.read(TEST_RECORD_FILE);
			//Ҫ��������ҪTestRecordʵ��Comparable�ӿ�
		}
		origin.add(record);
		Collections.sort(origin);
		Collections.reverse(origin);
		test2.write(origin, TEST_RECORD_FILE);
	}

}
