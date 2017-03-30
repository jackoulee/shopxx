package com.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNumberRandom {
   public static String queryOrderNumber(){
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	   Random ran = new Random();
	   int letter = ran.nextInt(26)+'a';
       return sdf.format(date)+(char)letter+(int)Math.round(Math.random()*100);
   }
  
}
