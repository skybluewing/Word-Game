package com.tz.cels.service;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.util.PageBean;

public interface IBrowserService {
	//第一个业务接口，此接口负责定义浏览单词和词汇的业务操作
	//定义每页显示的行数
	int PAGE_SIZE = 15;
	//从所有的单词中，加载出所有首字母相同的单词，并且以首字母
	Map<Character, Set<Word>> getFirstMap();
	//以分页的方式显示所有的单词
	PageBean<Word>  getPageWords();
	//以分页的方式显示所有的词汇
	PageBean<Vocabulary>  getPageVocabularies();
}
