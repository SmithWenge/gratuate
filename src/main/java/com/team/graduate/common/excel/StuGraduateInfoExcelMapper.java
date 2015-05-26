package com.team.graduate.common.excel;

import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.team.graduate.common.DataConvUtil;
import com.team.graduate.model.StuGraduateInfo;

public class StuGraduateInfoExcelMapper implements ExcelMapper<StuGraduateInfo> {
	private static String[] strings = null;
	
	//把excel表格中的一行数据读出来,放到一个<code>java.lang.String</code>数据中
	public String[] mapExcel(HSSFRow row) {
		strings = new String[row.getLastCellNum()];
		
		for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
			HSSFCell cell = row.getCell(cellIndex);
			
			if (null != cell) {
				strings[cellIndex] = ExcelToEntityUtil.getTypeValue(cell);
			}
		}
		
		return strings;
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
		graduateInfo.setStuDoubleMajorDegree(strings[15]);
		graduateInfo.setStuDoubleMajorDegreeNum(strings[16]);
		graduateInfo.setStuMinorDegree(strings[17]);
		graduateInfo.setStuMinorDegreeNum(strings[18]);
		graduateInfo.setStuIdentificationNum(strings[19]);
		graduateInfo.setStuPostgraduateNum(DataConvUtil.dataNullToString(strings[20]));
		graduateInfo.setStuCompletionNum(DataConvUtil.dataNullToString(strings[21]));
		graduateInfo.setStuLeaveType(DataConvUtil.dataNullToString(strings[22]));
		graduateInfo.setStuPublicationDate(DataConvUtil.dataFromStringToDate(strings[23]));
		graduateInfo.setId(UUID.randomUUID().toString());
		
		return graduateInfo;
	}

}