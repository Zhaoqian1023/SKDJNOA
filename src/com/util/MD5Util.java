package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	private static final char[] hex="abcdef0123456789".toCharArray();
	public static String getMD5(String upwd){
		MessageDigest md = null;
		String MD5=null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(upwd.getBytes());
		byte[] b = md.digest();
		char[] rc = new char[b.length*2];
		int k = 0;
		for(int i=0;i<b.length;i++){
			rc[k++] = hex[b[i]>>>4&0xf];
			rc[k++] = hex[b[i]&0xf];
		}
		MD5 = new String(rc);
		return MD5;
	}
	public static void main(String[] args) {
		System.out.println(getMD5("123456"));
		System.out.println(getMD5("123456"));
		System.out.println(getMD5("zhhHhsw./-=6548&^%$#@!`"));
	}

}
