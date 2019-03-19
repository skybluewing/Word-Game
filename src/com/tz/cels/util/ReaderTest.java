package com.tz.cels.util;

import org.junit.Test;

public class ReaderTest {

	@Test
	public void testReadString() {
		Reader reader = new Reader();
		System.out.println("input.....");
		int key = reader.readInt();
		System.out.println(key);
	}

	@Test
	public void testReadInt() {
		Reader reader = new Reader();
		System.out.println("input.....");
		String key = reader.readString();
		System.out.println(key);
	}

}
