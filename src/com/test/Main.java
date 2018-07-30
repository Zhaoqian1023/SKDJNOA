package com.test;

import com.util.MD5Util;


public class Main {

	public static void main(String[] args) {
		String s = "admin";
		String md5=MD5Util.getMD5(s);
		System.out.println(md5);
		
	}

}
