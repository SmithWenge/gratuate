package com.team.graduate.common.excel.output.mapper;

import com.team.graduate.common.excel.output.ExcelMapper;
import com.team.graduate.model.LogMessage;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class LogMessageExcelMapper implements ExcelMapper<LogMessage> {

	public void mapToExcel(WritableSheet sheet, LogMessage message, WritableCellFormat wcf, int rowNum) {
		try {
			sheet.addCell(new Label(0, rowNum, message.getIPAddress()));
			sheet.addCell(new Label(1, rowNum, message.getQueryStuName()));
			sheet.addCell(new Label(2, rowNum, defaultNullValue(message.getQueryStuId())));
			sheet.addCell(new Label(3, rowNum, defaultNullValue(message.getQueryStuDegree())));
			sheet.addCell(new Label(4, rowNum, defaultNullValue(message.getQueryStuDate())));
			sheet.addCell(new Label(5, rowNum, message.getOkOrNot()));
			sheet.addCell(new Label(6, rowNum, message.getTime().toString()));
			sheet.addCell(new Label(7, rowNum, message.getTag()));
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String defaultNullValue(Object value) {
		return null == value ? "" : value.toString();
	}
}
