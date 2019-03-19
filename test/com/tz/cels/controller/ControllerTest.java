package com.tz.cels.controller;


import org.junit.Test;
import com.tz.cels.controller.impl.CelsController;
public class ControllerTest {

	@Test
	public void testAction() {
		CelsController controller = new CelsController();
		controller.action();
	}

}
