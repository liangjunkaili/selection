package com.course.selection.util;

import java.util.UUID;

public class StringUtil {
	public static final String COMMA = ",";
	public static final String LOGIN_TOKEN = "token";
	public static final String EMPTY = "";
	public static final String UTF8 = "UTF-8";
	public static final String UNDEFINED = "undefined";
	public static final String BLANK_TEXT = " ";
	public static final String PLUS = "+";
	public static String getGlobalId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static Boolean isNullOrEmpty(String string) {
		return string == null || string.length() == 0;
	}
}
