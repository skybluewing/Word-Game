package com.tz.cels.service;

import java.util.Map;

import com.tz.cels.exceptions.NoHistoryException;

public interface IGameService {
	//第二个业务接口，定义了以游戏方式学习计算机英语单词和词汇的业务，主要是中英文互答的操作
	//定义保存英文到中文没有完成的数据的存储文件
	String EN_TO_CN_FILE = "en2cn.his";
	//定义保存中文到英文没有完成的数据的存储文件
	String CN_TO_EN_FILE = "cn2en.his";
	Map<String, String> en2cn(boolean isNew) throws NoHistoryException;
	Map<String, String> cn2en(boolean isNew) throws NoHistoryException;
	void saveGameHistory(Map<String, String> map, boolean en2cn);
}
