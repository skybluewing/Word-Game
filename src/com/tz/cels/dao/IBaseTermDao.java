package com.tz.cels.dao;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public interface IBaseTermDao {
	
	// ��ŵ��ʵ��ļ�
	String WORD_FILE = "data/dic/w.dic";
	// ��Ŵʻ���ļ�
	String VOCABULARY_FILE = "data/dic/v.dic";
	//���ص��������ļ�����ȡ���еĵ������ݣ���ʹ��Set�洢������
	Set<Word> getAllWords();
	//���شʻ������ļ�����ȡ���еĴʻ����ݣ���ʹ��Set�洢������
	Set<Vocabulary> getAllvocabularies();
	//�˷�����Ϊ֧�ֵڶ���ҵ������Ϸѧϰ���ʺʹʻ�ҵ�񡿶�׼����
	void writeToFile(Map<String, String> map, String filename);
	//��ָ���ļ��ж���֮ǰ���־û������ݣ��Ա�����ϴ�û�д���ļ���
	Map<String, String> readFromFile(String filename);
	
}
