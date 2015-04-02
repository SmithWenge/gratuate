package com.team.graduate.common.file;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class ReadFile {
	public static File getFile(HttpServletRequest request, String name) {
		String fullName = "/WEB-INF/data/real/" + name;
		String path = request.getSession().getServletContext().getRealPath(fullName);
		
		return new File(path);
	}
}

