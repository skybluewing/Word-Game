package com.tz.cels.service.impl;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.tz.cels.entity.Word;
import com.tz.cels.service.IBrowserService;

public class BrowserServiceImplTest {

	IBrowserService browser = new BrowserServiceImpl();

	@Test
	public void testGetFirstMap() {
		Map<Character, Set<Word>> map = browser.getFirstMap();
		Set<Map.Entry<Character, Set<Word>>> sets = map.entrySet();
		for (Map.Entry<Character, Set<Word>> entry : sets) {
			for (Word w : entry.getValue()) {
				System.out.println(entry.getKey() + "---->" + w);
			}
		}
	}

	@Test
	public void testGetPageWords() {
		browser.getPageWords();
	}

	@Test
	public void testGetPageVocabularies() {
		browser.getPageVocabularies();
	}

}
