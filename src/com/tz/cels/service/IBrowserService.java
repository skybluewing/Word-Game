package com.tz.cels.service;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.util.PageBean;

public interface IBrowserService {
	//��һ��ҵ��ӿڣ��˽ӿڸ�����������ʺʹʻ��ҵ�����
	//����ÿҳ��ʾ������
	int PAGE_SIZE = 15;
	//�����еĵ����У����س���������ĸ��ͬ�ĵ��ʣ�����������ĸ
	Map<Character, Set<Word>> getFirstMap();
	//�Է�ҳ�ķ�ʽ��ʾ���еĵ���
	PageBean<Word>  getPageWords();
	//�Է�ҳ�ķ�ʽ��ʾ���еĴʻ�
	PageBean<Vocabulary>  getPageVocabularies();
}
