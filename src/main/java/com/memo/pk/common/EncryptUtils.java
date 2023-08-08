package com.memo.pk.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	// 암호화 기능
	// 암호화할 문자열을 전달 받고, 암호화된 문자열을 리턴
	
	public static String md5(String message) {
		
		String resultString = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
			byte[] digest = md.digest();
			
			for(int i = 0;i<digest.length;i++) {
				resultString += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return resultString;
	}
	
}
