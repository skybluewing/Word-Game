package com.tz.cels.service;

import java.util.Map;

import com.tz.cels.exceptions.NoHistoryException;

public interface IGameService {
	//�ڶ���ҵ��ӿڣ�����������Ϸ��ʽѧϰ�����Ӣ�ﵥ�ʺʹʻ��ҵ����Ҫ����Ӣ�Ļ���Ĳ���
	//���屣��Ӣ�ĵ�����û����ɵ����ݵĴ洢�ļ�
	String EN_TO_CN_FILE = "en2cn.his";
	//���屣�����ĵ�Ӣ��û����ɵ����ݵĴ洢�ļ�
	String CN_TO_EN_FILE = "cn2en.his";
	Map<String, String> en2cn(boolean isNew) throws NoHistoryException;
	Map<String, String> cn2en(boolean isNew) throws NoHistoryException;
	void saveGameHistory(Map<String, String> map, boolean en2cn);
}
