package com.team.graduate.common.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.common.file.FileUpload;
import com.team.graduate.common.file.ReadFile;

/**
 * Servlet implementation class DataInput
 */
public class DataInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 读取上传的文件,存储上传文件,读取上传文件中的数据,添加数据到数据库
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = FileUpload.upload(request, "dataFile");
		
		ExcelToEntityUtil<StuGraduateInfo> util = new ExcelToEntityUtil<StuGraduateInfo>();
		List<StuGraduateInfo> list = util.readFromExcel(ReadFile.getFile(request, fileName), 1, new StuGraduateInfoExcelMapper());
		
		ExcelInputDao.createByList(list);
	}

}