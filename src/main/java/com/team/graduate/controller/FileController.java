package com.team.graduate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.graduate.common.excel.ExcelToEntityUtil;
import com.team.graduate.common.excel.StuGraduateInfoExcelMapper;
import com.team.graduate.common.file.FileDownload;
import com.team.graduate.common.file.FileUpload;
import com.team.graduate.common.file.ReadFile;
import com.team.graduate.model.StuGraduateInfo;
import com.team.graduate.service.FileService;


@Controller
@RequestMapping("/admin")
public class FileController {
	@Autowired
	private FileService service;
	
	@RequestMapping(value = "/fileDown")
	public ModelAndView fileDownload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FileDownload.download(request, response);
		return null;
	}
	
	@RequestMapping(value = "/fileUp")
	public ModelAndView fileUpload(HttpServletRequest request, HttpServletResponse response) {
		String fileName = FileUpload.upload(request, "dataFile");
		
		ExcelToEntityUtil<StuGraduateInfo> util = new ExcelToEntityUtil<StuGraduateInfo>();
		List<StuGraduateInfo> list = util.readFromExcel(ReadFile.getFile(request, fileName), 1, new StuGraduateInfoExcelMapper());
		
		service.importExcel(list);
		
		return new ModelAndView();
	}
	
}

