package com.yc.music.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class CreateCodeController {

	@RequestMapping("/getcode")
	public void createCode(HttpSession session, HttpServletResponse response) throws IOException {

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 生成一个四位数的随机数
		String code = getRandomCode();

		// 把我们生成的随机数存起来，方便后面做检查
		session.setAttribute("code", code);
		System.out.println("我们的随机数为" + code);
		// 创建验证码的图片
		BufferedImage image = getCodeImage(code, 70, 36);

		ImageIO.write(image, "JPEG", response.getOutputStream());

	}

	/**
	 * 绘制验证码图片
	 * 
	 * @param code
	 * @param i
	 * @param j
	 * @return
	 */
	private BufferedImage getCodeImage(String code, int width, int height) {
		// 创建图片对象 定义图片的宽和高，和我们的rgb格式
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

		// 绘制图片内容
		// 获取一个图片的绘制工具
		Graphics g = image.getGraphics();

		// 设置绘制的颜色
		g.setColor(this.getRandomColor(225, 30));

		// 绘制背景
		g.fillRect(0, 0, width, height);

		// 绘制干扰线
		Random random = new Random();
		int x1, y1, x2, y2;
		for (int i = 0; i < 50; i++) {
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);
			x2 = random.nextInt(width);
			y2 = random.nextInt(height);
			// 设置干扰线的颜色
			g.setColor(getRandomColor(140, 60));

			// 绘制干扰线
			g.drawLine(x1, y1, x2, y2);
		}
		// 设置验证码字体
		g.setFont(new Font("Courier new", Font.ITALIC, 22));

		// 绘制验证码
		char[] codes = code.toCharArray();
		for (int i = 0, len = codes.length; i < len; i++) {
			// 设置验证码的颜色
			g.setColor(this.getRandomColor(40, 70));

			// 绘制验证码的图形
			g.drawString(String.valueOf(codes[i]), 10 + 12 * i, 22);
		}
		g.dispose();

		return image;
	}

	/**
	 * 获取随机的颜色
	 * 
	 * @param start
	 *            颜色的开始值
	 * @param bound
	 *            颜色的范围
	 * @return
	 */
	private Color getRandomColor(int start, int bound) {
		Random random = new Random();
		int r = start + random.nextInt(bound);
		int g = start + random.nextInt(bound);
		int b = start + random.nextInt(bound);
		return new Color(r, g, b);
	}

	/**
	 * 生成随机验证码的方法
	 * 
	 * @return
	 */
	private String getRandomCode() {
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		int flag;
		for (int i = 0; i < 4; i++) {
			flag = random.nextInt(3);

			switch (flag) {
			case 0:
				stringBuffer.append(random.nextInt(10));
				break;
			case 1:
				stringBuffer.append((char) (random.nextInt(26) + 65));
				break;
			case 2:
				stringBuffer.append((char) (random.nextInt(26) + 97));
				break;
			}
		}
		return stringBuffer.toString();
	}
}
