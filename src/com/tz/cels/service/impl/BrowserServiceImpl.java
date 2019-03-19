package com.tz.cels.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.service.IBrowserService;
import com.tz.cels.util.PageBean;

public class BrowserServiceImpl implements IBrowserService {

	IBaseTermDao dao = new BaseTermDaoImpl();
	Scanner sc = new Scanner(System.in);

	@Override
	public Map<Character, Set<Word>> getFirstMap() {
		Set<Word> words = dao.getAllWords();// 获取所有单词
		Map<Character, Set<Word>> map = new HashMap<>();
		for (Word w : words) {
			Set<Word> set = map.get(w.getFirst());
			if (set == null) {
				set = new HashSet<>();
			}
			set.add(w);
			map.put(w.getFirst(), set);
		}
		return map;
	}

	@Override
	public PageBean<Word> getPageWords() {
		// 获取到所有单词
		System.out.println("请输入想要查看的首字母【A～Z】：");
		String choice1 = sc.next();
		IBrowserService bservice = new BrowserServiceImpl();
		Map<Character, Set<Word>> map = bservice.getFirstMap();
		// 把Map集合转成List集合
		List<Word> list = new ArrayList<Word>(map.get(choice1.trim().toUpperCase().charAt(0)));
		// System.out.println(list);
		PageBean<Word> pb = new PageBean<>();
		pb.setList(list.subList(0, PAGE_SIZE));
		pb.getList().forEach(System.out::println);
		boolean flag = true;
		while (flag) {
			System.out.println("请选择是否要看下一页，y/n:");
			String choice = sc.next();
				if (choice.equals("n")) {
					flag = false;
				} else if (choice.equals("y")) {
					int page = 1;
					int totalCount = list.size() % PAGE_SIZE == 0 ? (list.size() / PAGE_SIZE)
							: (list.size() / PAGE_SIZE + 1);
					pb.setList((list.subList(page * PAGE_SIZE, (page + 1) * PAGE_SIZE + 1)));
					pb.setLimit(PAGE_SIZE);
					pb.setTotalCount(totalCount);
					pb.getList().forEach(System.out::println);
					page++;
				} else {
					flag = true;
				}
			
		}
		return pb;
	}

	@Override
	public PageBean<Vocabulary> getPageVocabularies() {
		IBaseTermDao dao = new BaseTermDaoImpl();
		// 获取到所有词汇
		Set<Vocabulary> set = dao.getAllvocabularies();
		// 把Set集合转成List集合
		List<Vocabulary> list = new ArrayList<Vocabulary>(set);
		PageBean<Vocabulary> pb = new PageBean<>();
		int totalCount = list.size() % PAGE_SIZE == 0 ? (list.size() / PAGE_SIZE) : (list.size() / PAGE_SIZE + 1);
		boolean flag = true;
		while (flag) {
			StringBuilder builder = new StringBuilder();
			builder.append("每页").append(PAGE_SIZE).append("行, 共计").append(totalCount).append("页, 词汇量总数：【")
					.append(list.size()).append("】, 返回上一级 0  \n").append("|1|2|3|4|...|").append(totalCount).append("|");
			System.out.println(builder.toString());
			System.out.println("请输入要查看的页码, 返回上一级请按0:");
			int page = sc.nextInt();
			if (page <= 0) {
				flag = false;
			} else {
				page = page >= totalCount ? totalCount : page;
				int begin = (page - 1) * PAGE_SIZE;
				int end = page >= totalCount ? list.size() - 1 : page * PAGE_SIZE - 1;
				pb.setLimit(PAGE_SIZE);
				pb.setPage(page);
				pb.setTotalCount(totalCount);
				pb.setList(list.subList(begin, end + 1));
				pb.getList().forEach(System.out::println);
			}
		}
		return pb;
	}

}
