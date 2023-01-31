package com.ECW.helper;

import java.util.Random;
import java.util.UUID;

public class RandomIdGenerator {
	public static int newIdGenrator() {
		return new Random().nextInt(10000);
	}

	public static String generateUUID() {
		String strUUID = new String();
		UUID uuid = UUID.randomUUID();
		strUUID = uuid.toString();
		return strUUID;
	}
}
