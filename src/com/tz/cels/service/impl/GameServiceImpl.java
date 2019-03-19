package com.tz.cels.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoHistoryException;
import com.tz.cels.service.IGameService;

public class GameServiceImpl implements IGameService {

	IBaseTermDao dao = new BaseTermDaoImpl();

	@Override
	public Map<String, String> en2cn(boolean isNew) throws NoHistoryException {
		Map<String, String> map = new HashMap<>();
		if (isNew) { //不继续上次的游戏
			Set<Word> words = dao.getAllWords();
			//通过迭代的方法把单词词汇全部放入map集合
			Iterator<Word> iter1 = words.iterator();
			while (iter1.hasNext()) {
				Word word = iter1.next();
				map.put(word.getEn(), word.getCn());
			}
			Set<Vocabulary> vocabularies = dao.getAllvocabularies();
			Iterator<Vocabulary> iter2 = vocabularies.iterator();
			while (iter2.hasNext()) {
				Vocabulary Vocabularies = iter2.next();
				map.put(Vocabularies.getEn(), Vocabularies.getCn());
			}
		} else {
			String HISTORY_DIR = "data/history";
			File file = new File(HISTORY_DIR, EN_TO_CN_FILE);
				if (! file.exists()) {
					throw new NoHistoryException("没有历史记录");
				} else {
					map = dao.readFromFile(EN_TO_CN_FILE);//继续上次的游戏
				}
			}
		return map;
	}


	@Override
	public Map<String, String> cn2en(boolean isNew) throws NoHistoryException {
		Map<String, String> map = new HashMap<>();
		if (isNew) {
			Set<Word> words = dao.getAllWords();
			Iterator<Word> iter1 = words.iterator();
			while (iter1.hasNext()) {
				Word word = iter1.next();
				map.put(word.getCn(), word.getEn());
			}
			Set<Vocabulary> vocabularies = dao.getAllvocabularies();
			Iterator<Vocabulary> iter2 = vocabularies.iterator();
			while (iter2.hasNext()) {
				Vocabulary Vocabularies = iter2.next();
				map.put(Vocabularies.getCn(), Vocabularies.getEn());
			}
		} else {
			String HISTORY_DIR = "data/history";
			File file = new File(HISTORY_DIR, CN_TO_EN_FILE);
				if (! file.exists()) {
					throw new NoHistoryException("没有历史记录");
				} else {
					map = dao.readFromFile(CN_TO_EN_FILE);//继续上次的游戏
				}
			}
		return map;
	}

	@Override
	public void saveGameHistory(Map<String, String> map, boolean en2cn) {
		if (en2cn) {
			dao.writeToFile(map, EN_TO_CN_FILE);
		} else {
			dao.writeToFile(map, CN_TO_EN_FILE);
		}
	}

}
