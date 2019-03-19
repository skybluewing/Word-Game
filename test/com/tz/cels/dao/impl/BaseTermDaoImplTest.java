package com.tz.cels.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.tz.cels.dao.IBaseTermDao;

public class BaseTermDaoImplTest {

	IBaseTermDao dao = new BaseTermDaoImpl();
	@Test
	public void testGetAllWords() {
		System.out.println(dao.getAllWords());
	}

	@Test
	public void testGetAllvocabularies() {
		System.out.println(dao.getAllvocabularies());
	}

	@Test
	public void testWriteToFile() {
		Map<String, String> map = new HashMap<>();
		map.put("1","hi");
		map.put("2","hii");
		map.put("3","hii");
		System.out.println(map);
		dao.writeToFile(map, "abdsd");
	}

	@Test
	public void testReadFromFile() {
		Map<String, String> map = new HashMap<>();
		map = dao.readFromFile("abdsd");
		System.out.println(map);
	}
}
