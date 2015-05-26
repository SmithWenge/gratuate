package com.team.graduate.common.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Component;

@Component
public class ExcelToEntityUtil <T>{
	public List<T> readFromExcel(File file, int ignoreRow, ExcelMapper<T> mapper) {
		List<T> list = null;
		BufferedInputStream bis = null;
		try {
			list = new ArrayList<T>();
			bis = new BufferedInputStream(new FileInputStream(file));
			//通过文件流获取文件
			POIFSFileSystem fs = new POIFSFileSystem(bis);
			//获取该excel中的sheets
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
				//获得excel中的一个sheet
				HSSFSheet sheet = wb.getSheetAt(sheetIndex);
				
				for (int rowIndex = ignoreRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					//获得sheet中的每一行
					HSSFRow row = sheet.getRow(rowIndex);
					
					if (null == row) 
						continue;
					
					list.add(mapper.mapStringArray(row));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public static  String getTypeValue(HSSFCell cell) {
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case HSSFCell.CELL_TYPE_BLANK:
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			//判断是够是日期类型
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				return  cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		default:
			return "";
		}
		
		return "";
	}
}
