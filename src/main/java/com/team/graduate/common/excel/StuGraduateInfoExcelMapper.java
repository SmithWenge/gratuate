package com.team.graduate.common.excel;

import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.team.graduate.common.DataConvUtil;
import com.team.graduate.model.StuGraduateInfo;

public class StuGraduateInfoExcelMapper implements ExcelMapper<StuGraduateInfo> {
	private static String[] strings = null;
	
	//把excel表格中的一行数据读出来,放到一个<code>java.lang.String[]</code>数据中
	public String[] mapExcel(HSSFRow row) {
		strings = new String[row.getLastCellNum()];
		
		for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
			HSSFCell cell = row.getCell(cellIndex);
			
			if (null != cell) {
				strings[cellIndex] = getTypeValue(cell);
			}
		}
		
		return strings;
	}

	private  String getTypeValue(HSSFCell cell) {
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

	public StuGraduateInfo mapStringArray(HSSFRow row) {
		this.mapExcel(row);
		
		StuGraduateInfo graduateInfo = new StuGraduateInfo();
		
		graduateInfo.setStuName(strings[0]);
		graduateInfo.setStuEnName(DataConvUtil.dataNullToString(strings[1]));
		graduateInfo.setStuNumber(strings[2]);
		graduateInfo.setStuGender(strings[3]);
		graduateInfo.setStuBrithday(DataConvUtil.dataFromStringToDate(strings[4]));
		graduateInfo.setStuEnrollment(DataConvUtil.dataFromStringToDate(strings[5]));
		graduateInfo.setStuGraduation(DataConvUtil.dataFromStringToDate(strings[6]));
		graduateInfo.setStuAcademy(strings[7]);
		graduateInfo.setStuSpecialty(strings[8]);
		graduateInfo.setStuSpecialtyMajor(strings[9]);
		graduateInfo.setStuClass(strings[10]);
		graduateInfo.setStuPicture(DataConvUtil.dataNullToString(strings[11]));
		graduateInfo.setStuGraduationCardNum(strings[12]);
		graduateInfo.setStuMajorDegreeCertNum(strings[13]);
		graduateInfo.setStuMajorDegree(strings[14]);
		graduateInfo.setStuDoubleMajorDegree(DataConvUtil.dataNullToString(strings[15]));
		graduateInfo.setStuDoubleMajorDegreeNum(DataConvUtil.dataNullToString(strings[16]));
		graduateInfo.setStuMinorDegree(DataConvUtil.dataNullToString(strings[17]));
		graduateInfo.setStuMinorDegreeNum(DataConvUtil.dataNullToString(strings[18]));
		graduateInfo.setStuIdentificationNum(strings[19]);
		graduateInfo.setStuPostgraduateNum(DataConvUtil.dataNullToString(strings[20]));
		graduateInfo.setStuCompletionNum(DataConvUtil.dataNullToString(strings[21]));
		graduateInfo.setStuLeaveType(DataConvUtil.dataNullToString(strings[22]));
		graduateInfo.setStuPublicationDate(DataConvUtil.dataFromStringToDate(strings[23]));
		graduateInfo.setId(UUID.randomUUID().toString());

		strings = null;
		
		return graduateInfo;
	}

}