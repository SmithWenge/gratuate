package com.team.graduate.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AuthCodeGenerator {
	public static final String AUTHENTICATION_CODE = "authCode";
	
	private static int WIDTH = 80;
	private static int HEIGHT = 25;
	private  StringBuffer buffer;

	public  BufferedImage getAuthCodeImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics img = image.getGraphics();

		setBackground(img);
		setBorder(img);
		drawRandomNumber((Graphics2D) img);
		drawRandomLine(img);

		return image;
	}

	public  void setBackground(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	public  void setBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	public  void drawRandomNumber(Graphics2D g) {
		buffer = new StringBuffer();
		g.setColor(Color.RED);
		Font font = new Font("consolas", Font.BOLD, 22);
		g.setFont(font);

		String string = "abcdefghijklmnopqrstuvwxyz";

		int x = 5;
		for (int i = 0; i < 4; i++) {
			int ran = new Random().nextInt(string.length());
			int degree = new Random().nextInt(30);
			String str = string.charAt(ran) + "";
			buffer.append(str);
			g.rotate(degree * Math.PI / 180, x, 20);
			g.drawString(str, x, 20);
			g.rotate(-degree * Math.PI / 180, x, 20);

			x += 15;
		}
	}

	public  void drawRandomLine(Graphics g) {
		g.setColor(Color.GRAY);
		for (int i = 0; i < 4; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);

			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);

			g.drawLine(x1, y1, x2, y2);
		}
	}

	public  String getString() {
		return buffer.toString();
	}
}
