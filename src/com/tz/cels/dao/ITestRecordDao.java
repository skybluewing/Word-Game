package com.tz.cels.dao;

import java.util.List;

import com.tz.cels.entity.TestRecord;

public interface ITestRecordDao {
	//���Լ�¼�����ݷ��ʶ���Ϊ֧�ֵ�����ҵ�񡾲���ҵ�񡿶���Ƶ�����
	void write(List<TestRecord> records, String fileName);
	
	/*
	 * �������е��ѱ���Ĳ��Լ�¼������������List
	 */
	List<TestRecord> read(String fileName);
}
