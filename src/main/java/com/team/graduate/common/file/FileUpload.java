package com.team.graduate.common.file;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	public static String upload(HttpServletRequest request, String name) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		ServletContext context = request.getSession().getServletContext();
		List<FileItem> files = null;
		String dataFile = null;
		
		try {
			files = upload.parseRequest(request);
			for (FileItem item : files) {
				if (item.isFormField()) {
					
				} else {
					dataFile = item.getName();
					File uploadFile = new File(context.getRealPath("") + "/WEB-INF/data/real/" + dataFile);
					item.write(uploadFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFile;
	}
}
