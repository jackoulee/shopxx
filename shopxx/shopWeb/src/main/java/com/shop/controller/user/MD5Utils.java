package com.shop.controller.user;

import java.security.MessageDigest;

public class MD5Utils {

	public final static String md5(String s){
		MessageDigest mdTemp = null;
		// 用来将字节转换成 16 进制表示的字符  
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','q','w','e','r','d','f'};
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			// MD5 的计算结果是一个 128 位的长整数， 用字节表示就是 16 个字节
			byte[] md = mdTemp.digest();
			int j = md.length;
			// 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
			char str[] = new char[j * 2];
			 // 表示转换结果中对应的字符位置
			int k = 0;
			 // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
			for(int i = 0; i < j; i++){
				//  取第 i 个字节
				byte b = md[i];
				// 取字节中高 4 位的数字转换，>> 为逻辑右移，将符号位一起右移  
				str[k++] = hexDigits[b >> 4 & 0xf];
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[b & 0xf];
			}
			// 换后的结果转换为字符串  
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("ce48fd56972df026878abd99f5d70d18");
		System.out.println(MD5Utils.md5("都可以")); 
		byte b = (byte) 0xf1;
		System.err.println(0xf1);
	}
	
}
