package com.tz.cels.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.tz.cels.controller.Controller;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.exceptions.NoHistoryException;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.IBrowserService;
import com.tz.cels.service.IGameService;
import com.tz.cels.service.ITestingService;
import com.tz.cels.service.impl.BrowserServiceImpl;
import com.tz.cels.service.impl.GameServiceImpl;
import com.tz.cels.service.impl.TestingServiceImpl;
import com.tz.cels.util.Reader;
import com.tz.cels.view.ClientUI;

public class CelsController implements Controller {

	Reader input = new Reader();
	
	@Override
	public void action() {
		ClientUI.welcome();
		boolean flag = true;// 主控制
		while (flag) {
			ClientUI.mainMenu();
			boolean f = true;// 二级控制
			int key = input.readInt();
			switch (key) {
			case 1:
				while (f) {
					ClientUI client = new ClientUI();
					client.showBrowserSubMenu();
					IBrowserService browser = new BrowserServiceImpl();
					int key1 = input.readInt();
					switch (key1) {
					case 1:
						browser.getPageWords();
						break;
					case 2:
						browser.getPageVocabularies();
						break;
					case 0:
						f = false;
						break;
					default:
						System.out.println("输入有误，请重新输入");
					}
				}
				break;
			case 2:
				while (f) {
					ClientUI client = new ClientUI();
					client.showGameSubMenu();
					IGameService game = new GameServiceImpl();
					Map<String, String> map = new HashMap<>();
					int key1 = input.readInt();
					switch (key1) {
					case 1:
						Scanner sc2 = new Scanner(System.in);
						System.out.println("请选择是否继续上次的游戏，按y/n....");
						String choice = sc2.nextLine();
						if (choice.equals("n")) {
							try {
								map = game.en2cn(true);
							} catch (NoHistoryException e) {
								e.printStackTrace();
							}
						} else if (choice.equals("y")){
								try {
								map = game.en2cn(false);
								} catch (NoHistoryException e) {
									e.printStackTrace();
								}
						}
						Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry<String, String> entry = it.next();
							StringBuilder builder = new StringBuilder();
							System.out.print(builder.append("【退出：e or q】").append("[").append(entry.getKey()).append("]").append("的中文含义是："));
							String input1 = input.readString();
							if (input1.trim().equals("e") || input1.trim().equals("q")) {
								System.out.println("退出");
								break;
							} else if ((entry.getValue()).contains(input1.trim())) {
								StringBuilder builder1 = new StringBuilder();
								System.out.println(builder1.append("回答正确").append("   ").append(entry.getKey()
										).append("   ").append(entry.getValue()));
								it.remove();
							} else {
								StringBuilder builder1 = new StringBuilder();
								System.out.println(builder1.append("回答错误").append("   ").append(entry.getKey()
										).append("   ").append(entry.getValue()));
								it.remove();
							}
							game.saveGameHistory(map, true);
						}
						break;
					case 2:
						System.out.println("请选择是否继续上次的游戏，按y/n....");
						String choice2 = input.readString();
						if (choice2.equals("n")) {
							try {
								map = game.cn2en(true);
							} catch (NoHistoryException e) {
								e.printStackTrace();
							}
						} else if (choice2.equals("y")){
								try {
									map = game.cn2en(false);
								} catch (NoHistoryException e) {
									e.printStackTrace();
								}
						}
						Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
						while (it2.hasNext()) {
							Map.Entry<String, String> entry = it2.next();
							StringBuilder builder = new StringBuilder();
							System.out.print(builder.append("【退出：e or q】    ").append("[").append(entry.getKey()).append("]").append("的英文含义是："));
							String input2 = input.readString();
							if (input2.trim().equals("e") || input2.trim().equals("q")) {
								System.out.println("退出");
								break;
							} else if (input2.trim().equals(entry.getValue())) {
								StringBuilder builder1 = new StringBuilder();
								System.out.println(builder1.append("回答正确").append("   ").append(entry.getKey()
										).append("   ").append(entry.getValue()));
								it2.remove();
							} else {
								StringBuilder builder1 = new StringBuilder();
								System.out.println(builder1.append("回答错误").append("   ").append(entry.getKey()
										).append("   ").append(entry.getValue()));
								it2.remove();
							}
							game.saveGameHistory(map, false);
						}		
						break;
					case 0:
						f = false;
						break;
					default:
						System.out.println("输入有误，请重新输入");
					}
				}
				break;
			case 3:
				while (f) {
					ClientUI client = new ClientUI();
					client.showTestingSubMenu();
					int key1 = input.readInt();
					switch (key1) {
					case 1:
						ITestingService test1 = new TestingServiceImpl();
						System.out.println("请输入要测试的题目数量：【5～100】");
						int num = input.readInt();
						List<BaseTerm> list = test1.getTestingData(num);
						List<BaseTerm> gamelist = new ArrayList<>();
						int count = 0;
						int rightCount = 0;
						for (BaseTerm term : list) {
							StringBuilder builder = new StringBuilder();
							System.out.print(builder.append("【退出：e or q】    ").append("[").append(term.getEn()).append("]").append("的中文含义是："));
							long startTime = System.currentTimeMillis();
							String input3 = input.readString();
							StringBuilder builder3 = new StringBuilder();
							if (input3.trim().equals("e") || input3.trim().equals("q")) {
								System.out.println("退出");
								break;
							} else if ((term.getCn()).contains(input3.trim())) {
								System.out.println(builder3.append("回答正确").append("   ").append(term.getEn()
										).append("   ").append(term.getCn()));
								gamelist.add(term);
								rightCount++;
								count++;
							} else {
								System.out.println(builder3.append("回答错误").append("   ").append(term.getEn()
										).append("   ").append(term.getCn()));
								gamelist.add(term);
								count++;
							}
							long endTime = System.currentTimeMillis();
							long time = endTime - startTime;
							long minute = (time % (1000 * 60 * 60)) / (1000 * 60); 
							long second = (time % (1000 * 60)) / 1000;
							TestRecord record = new TestRecord();
							record.setMinute(minute);
							record.setSecond(second);
							record.setTotalNumber(num);
							record.setFinishedNumber(count);
							record.setCorrectCount(rightCount);
							record.setWrongCount(count-rightCount);
							record.setList(gamelist);
							test1.saveTestRecord(record);
						}
						break;
					case 2:
						ITestingService test2 = new TestingServiceImpl();
						try {
							test2.reviewTestRecord();
						} catch (NoTestRecordException e) {
							e.printStackTrace();
						}
						break;
					case 0:
						f = false;
						break;
					default:
						System.out.println("输入有误，请重新输入");
					}
				}
				break;
			case 0:
				flag = false;
				break;
			default: 
				System.out.println("输入有误，请重新输入");
			}
		}
	}
}


