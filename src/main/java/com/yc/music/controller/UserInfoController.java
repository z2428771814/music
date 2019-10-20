package com.yc.music.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yc.music.bean.UserInfo;
import com.yc.music.service.IUserInfoService;
import com.yc.music.util.SendMailUtil;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	private SendMailUtil sendMailUtil;

	@Autowired
	private IUserInfoService userInfoService;
	
	/**
	 * 发送邮箱验证
	 * @param receiveEmail	发送邮箱的地址
	 * @param name			账号名字
	 * @param session
	 * @return
	 */
	@RequestMapping("/code")
	public int code(String receiveEmail,String name,HttpSession session){
		String code="";
		Random random=new Random();
		while( code.length()<6 ){
			code+=random.nextInt(10);
		}
		System.out.println( "我们邮箱验证码为"+code );
		if( sendMailUtil.sendHtmlMail(receiveEmail, name, code) ){
			session.setAttribute("code", code);

			TimerTask task = new TimerTask(){
				public void run() {
					session.removeAttribute("code");//清空验证码
				}

			};
			Timer timer = new Timer();//实例化一个定时器
			timer.schedule(task, 180000);//3分钟执行任务task一次
			
			return 1;
		}

		return 0;
	}
	
	/**
	 * 登陆
	 * @param session
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/login")
	public int login(HttpSession session, UserInfo userInfo) {
		String gn=userInfo.getRealName();
		String code=(String) session.getAttribute("code");
		if( !code.equalsIgnoreCase(gn) ){
			return -1;
		}
		System.out.println( userInfo );
		UserInfo user = userInfoService.login(userInfo);
		if (user != null) {
			// 假如登陆的话，就把我们的用户存起来
			session.setAttribute("loginUser", user);
			return 1;
		}
		System.out.println( user );
		return 0;

	}
	
	/**
	 * 注册
	 * @param session
	 * @param mf
	 * @return
	 */
	@RequestMapping("/reg")
	public int reg(HttpSession session,UserInfo mf){
		Object obj = session.getAttribute("code");
		System.out.println( mf.toString() );
		if( obj == null ){//说明验证码已经过期
			return -2;
		}
		System.out.println( "我们的验证码为"+obj );
		String code=(String)obj;
		if( !code.equals( mf.getRealName() ) ){
			return -1;	//说明验证码错误
		}
		return userInfoService.add(mf);
	}
	
	
	/**
	 * 检验用户有没有登陆
	 * @param session
	 * @return
	 */
	@RequestMapping("/check")
	public UserInfo checkLogin(HttpSession session){
		Object object=session.getAttribute("loginUser");
		if( object==null ){
			return new UserInfo();
		}
		return (UserInfo)object;
	}
	

}
