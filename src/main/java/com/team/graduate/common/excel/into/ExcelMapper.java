package com.team.graduate.common.excel.into;


import org.apache.poi.hssf.usermodel.HSSFRow;


public interface ExcelMapper<T> {
	String[] mapExcel(HSSFRow row);
	T mapStringArray(HSSFRow row);
}

