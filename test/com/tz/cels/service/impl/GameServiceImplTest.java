package com.tz.cels.service.impl;

import java.util.Map;
import org.junit.Test;
import com.tz.cels.exceptions.NoHistoryException;
import com.tz.cels.service.IGameService;

public class GameServiceImplTest {

	IGameService game = new GameServiceImpl();

	@Test
	public void testEn2cn() {
		// �������ϴε���Ϸ
				try {
					game.en2cn(true);
				} catch (NoHistoryException e) {
					e.printStackTrace();
				}
	}

	@Test
	public void testCn2en() {
		// �������ϴε���Ϸ
		try {
			game.cn2en(true);
		} catch (NoHistoryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveGameHistory() throws NoHistoryException {
		Map<String, String> mapEn2Cn = game.en2cn(false); //�����ϴ���Ϸ
		game.saveGameHistory(mapEn2Cn, true); //�����¼
	}
	
}
