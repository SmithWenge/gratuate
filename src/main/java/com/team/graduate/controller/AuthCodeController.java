package com.team.graduate.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.graduate.common.AuthCodeGenerator;

@Controller
@RequestMapping("/code")
public class AuthCodeController {
	private AuthCodeGenerator generator = new AuthCodeGenerator();
	static final String IMAGE_FORMAT = "JPEG";
	
	@RequestMapping("")
	public void returnAuthCode(HttpServletResponse response, HttpServletRequest request) {
		BufferedImage image = generator.getAuthCodeImage();
		request.getSession().setAttribute(AuthCodeGenerator.AUTHENTICATION_CODE, null);
		request.getSession().setAttribute(AuthCodeGenerator.AUTHENTICATION_CODE, generator.getString());
		try {
			ImageIO.write(image, IMAGE_FORMAT, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
