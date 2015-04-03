package com.team.graduate.common;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataConvUtil {
	public static String dataNullToString(String string) {
		String reTmp = "";
		
		if (null != string)
			reTmp = string;
		
		return reTmp;
	}
	
	public static String dataFromDateToString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; 
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
		return year +"-" + month + "-" + day;
	}
	
	@SuppressWarnings("deprecation")
	public static Date dataFromDateToFormatDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; 
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
		return new Date(year, month, day);
	}
	
	public static Date dataFromStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return new Date(sdf.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}
