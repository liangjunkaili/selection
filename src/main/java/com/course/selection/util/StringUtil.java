package com.course.selection.util;

import java.util.UUID;

public class StringUtil {

	public static String getGlobalId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
