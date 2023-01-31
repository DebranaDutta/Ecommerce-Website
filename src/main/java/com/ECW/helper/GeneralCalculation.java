package com.ECW.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralCalculation {
	public static List<Integer> ConvertStringToArrayList(String cartIds) {
		List<Integer> cartIdsIntegerList = new ArrayList<Integer>();
		String replaceCartIds = cartIds.replace("[", "");
		String replaceCartIds2 = replaceCartIds.replace("]", "");
		try {
			List<String> cartIdsStringList = new ArrayList<String>(Arrays.asList(replaceCartIds2.split(",")));
			for (String s : cartIdsStringList) {
				cartIdsIntegerList.add(Integer.parseInt(s.trim()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartIdsIntegerList;
	}

	/*
	 * String replace = cartIds.replace("[", ""); String replace1 =
	 * replace.replace("]", ""); List<String> arrayList = new
	 * ArrayList<String>(Arrays.asList(replace1.split(","))); List<Integer> favList
	 * = new ArrayList<Integer>(); for (String fav : arrayList) {
	 * favList.add(Integer.parseInt(fav.trim())); }
	 * 
	 */
}
