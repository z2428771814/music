package com.yc.music.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.UserInfo;
import com.yc.music.service.IUserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private IUserInfoService userInfoService;

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

}
