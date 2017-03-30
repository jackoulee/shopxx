/** 
 * <pre>项目名称:yt_oa 
 * 文件名称:ImportExcelUtil.java 
 * 包名:com.jk.util 
 * 创建日期:2017-1-17上午11:34:29 
 * Copyright (c) 2017, myangsh@sina.com All Rights Reserved.</pre> 
 */  
package com.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

/** 
 * <pre>项目名称：yt_oa    
 * 类名称：ImportExcelUtil    
 * 类描述：    
 * 创建人：Yangshy myangsh@sina.com    
 * 创建时间：2017-1-17 上午11:34:29    
 * 修改人：Yangshy myangsh@sina.com     
 * 修改时间：2017-1-17 上午11:34:29    
 * 修改备注：       
 * @version </pre>    
 */
public class ImportExcelUtil {
	/**
	 * <pre>readExcelInfo(读取Excel信息)   
	 * 创建人：Yangshy myangsh@sina.com    
	 * 创建时间：2017-1-17 上午11:35:37    
	 * 修改人：Yangshy myangsh@sina.com     
	 * 修改时间：2017-1-17 上午11:35:37    
	 * 修改备注： 
	 * @param excelFile 需要读取的对应Excel文件
	 * </pre>
	 */
   public static List<Map<String,Object>> readExcelInfo(InputStream excelFile){
   	//把文件流提try代码块外 方便关流时使用
   	XSSFWorkbook workbook = null;
   	Date time = new Date();
   	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
   	String proTime = sdf.format(time);
   	List<Map<String,Object>> listStore = new ArrayList<Map<String,Object>>();
   	try {
		
			 //根据文件对象 创建excel对象
			 workbook = new XSSFWorkbook(excelFile);
			 //获取到第一个sheet页
			 XSSFSheet sheet1 = workbook.getSheetAt(0);
			 //循环所有有内容的行
           	 for (int i = 1; i <sheet1.getLastRowNum()+1 ; i++) {
           		 Map<String,Object> param = new HashMap<String,Object>();
           		 String proId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
				param.put("pro_name", sheet1.getRow(i).getCell(0).getStringCellValue());
				param.put("pro_totalno", sheet1.getRow(i).getCell(1).getNumericCellValue());
				param.put("pro_dis", sheet1.getRow(i).getCell(2).getStringCellValue());
				param.put("pro_id", proId);
				param.put("pro_time", proTime);
				param.put("pro_no", OrderNumberRandom.queryOrderNumber());
				listStore.add(param);
			   }
           
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return listStore;
   }
}
