package com.lqq.util.common;

import java.io.UnsupportedEncodingException;

public class HbrUtil {

	public static boolean isNotEmpty(String s) {

		return (s != null && !s.trim().equals("")) ? true : false;
	}
	
	public static boolean isNormalString(String s){
		return java.nio.charset.Charset.forName("GBK").newEncoder().canEncode(s);
	}
	public static String notNormalStringParse(String s){
		try {
			return new String(s.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
