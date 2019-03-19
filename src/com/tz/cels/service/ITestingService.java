package com.tz.cels.service;

import java.util.List;

import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.exceptions.NoTestRecordException;

public interface ITestingService {
	//������ҵ��ӿڣ�Ϊ����ɲ����Լ���ˮƽ�������ҵ��ӿ�
	//�����Ų��Լ�¼��Ŀ¼·��
	String TESTRECORD_DIR = "data/testing";
	//�����Ų��Լ�¼���ļ�·��
	String TEST_RECORD_FILE = "data/testing/records.rec";
	/*
	 *��ȡ�������ݣ�������Դ���Ǵ�ԭʼ�����������ȡ��ָ������������ 
	 */
	List<BaseTerm> getTestingData(int num);
	/*
	 *�˷������ļ��ж�ȡ������Ĳ��Լ�¼������������Դֻ����֮ǰ���������ļ�¼�ļ���
	 *�˷�����ʵ�֣�����ί��ITestRecordDao��read����
	 */
	List<TestRecord> reviewTestRecord() throws NoTestRecordException;
	
	/*
	 * �־û����Ե����ݵ��ļ�
	 */
	void saveTestRecord(TestRecord record);
}
