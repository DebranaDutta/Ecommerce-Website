package com.ECW.helper;

public class gettingSecurityQuestionDetails {
	public static String question=null;
	public static String getSecurityQuestion(String questionId) {
		if(questionId.equalsIgnoreCase("1")) {
			return "What was your first Car?";
		}else if(questionId.equalsIgnoreCase("2")) {
			return "What was first school?";
		}else if (questionId.equalsIgnoreCase("3")) {
			return "What is your mother's maiden name?";
		}else {
			return "what was your first pet name?";
		}
	}
}
