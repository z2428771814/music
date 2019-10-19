package com.yc.music.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMailUtil {
	private String sendEmail;	//发件箱
	private String pwd;			//发件箱授权密码

	public void setSendEmail(String sendEmail) {
		this.sendEmail = sendEmail;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 发送html格式的文件
	 * @param receiveEmail	接受者邮箱
	 * @param name			昵称
	 * @param code			验证码
	 * @return
	 */
	public boolean sendHtmlMail(String receiveEmail,String name,String code){
		//为空判断
		if( StringUtil.checkNull(receiveEmail,name,code) ){
			return false;
		}

		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		senderImpl.setHost("smtp.163.com");//邮箱主机，如果是qq的就是smtp.qq.com
		senderImpl.setDefaultEncoding("utf-8");//设置默认编码集

		//建立邮件的信息,我们需要发送的是html格式的邮件
		MimeMessage  mimeMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

		try {
			//设置收件人，寄件人
			messageHelper.setTo(receiveEmail);
			messageHelper.setFrom(sendEmail);
			messageHelper.setSubject("天天注册中心");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String str="<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>"
					+ "<p style='font-size:20px;font-weight:bold;'>尊敬的:"+name+",你好！"
					+ "</p><p style='text-indent:2em;font-size:20px'>"
					+ "欢迎注册天天生鲜网，你本次的注册码是<span style='font-size:30px;font-weight:bold;color:red'>"
					+ code+"</span>,3分钟之类有效，请尽快使用！</p><p style='font-size:18px'>"
					+ "技术部顾问：周龙基</p><span style='font-size:18px;float:right;margin-right:60px;' >"
					+ sdf.format(new Date())+"</span></body></html>";
			//假如没有这个true就不是html形式发送，单纯的数字放松，有了这个就识别是网页内容发送解析
			messageHelper.setText(str, true);

			senderImpl.setUsername(sendEmail);//发件箱
			senderImpl.setPassword(pwd); //发件箱密码

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");//让服务器区认证用户名密码
			properties.put("mail.smtp.timeout", "2500");//链接超时时间

			senderImpl.setJavaMailProperties(properties);

			senderImpl.send(mimeMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
