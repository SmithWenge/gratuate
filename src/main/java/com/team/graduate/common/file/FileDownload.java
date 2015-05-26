package com.team.graduate.common.file;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 通过response相应流下载数据录入Template
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		download(request, response);
//	}
	
	/**
	 * 下载数据录入模板功能
	 */
	public static HttpServletResponse download(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/data/template/Template.xls");
			File file = new File(path);
			String fileName = file.getName();
			
			InputStream fis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream fos = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel; charset=utf-8");
			fos.write(buffer);
			
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
