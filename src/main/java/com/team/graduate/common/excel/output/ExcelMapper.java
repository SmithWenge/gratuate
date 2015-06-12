package com.team.graduate.common.excel.output;

import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;

public interface ExcelMapper<T> {
	void mapToExcel(WritableSheet sheet, T t, WritableCellFormat wcf, int rowNum);
}
