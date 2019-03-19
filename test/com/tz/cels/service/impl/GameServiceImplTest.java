package com.tz.cels.service.impl;

import java.util.Map;
import org.junit.Test;
import com.tz.cels.exceptions.NoHistoryException;
import com.tz.cels.service.IGameService;

public class GameServiceImplTest {

	IGameService game = new GameServiceImpl();

	@Test
	public void testEn2cn() {
		// 不继续上次的游戏
				try {
					game.en2cn(true);
				} catch (NoHistoryException e) {
					e.printStackTrace();
				}
	}

	@Test
	public void testCn2en() {
		// 不继续上次的游戏
		try {
			game.cn2en(true);
		} catch (NoHistoryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveGameHistory() throws NoHistoryException {
		Map<String, String> mapEn2Cn = game.en2cn(false); //继续上次游戏
		game.saveGameHistory(mapEn2Cn, true); //保存记录
	}
	
}
