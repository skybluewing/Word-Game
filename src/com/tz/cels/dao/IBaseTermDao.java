package com.tz.cels.dao;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public interface IBaseTermDao {
	
	// 存放单词的文件
	String WORD_FILE = "data/dic/w.dic";
	// 存放词汇的文件
	String VOCABULARY_FILE = "data/dic/v.dic";
	//加载单词数据文件，获取所有的单词数据，并使用Set存储并返回
	Set<Word> getAllWords();
	//加载词汇数据文件，获取所有的词汇数据，并使用Set存储并返回
	Set<Vocabulary> getAllvocabularies();
	//此方法是为支持第二个业务【做游戏学习单词和词汇业务】而准备的
	void writeToFile(Map<String, String> map, String filename);
	//从指定文件中读出之前被持久化的数据，以便接着上次没有答完的继续
	Map<String, String> readFromFile(String filename);
	
}
