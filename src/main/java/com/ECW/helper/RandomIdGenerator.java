package com.ECW.helper;

import java.util.Random;

public class RandomIdGenerator {
	public static int newIdGenrator() {
		return new Random().nextInt(10000);
	}
}
