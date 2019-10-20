package com.yc.music.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.AdminInfo;
import com.yc.music.service.IAdminService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@Autowired
	private IAdminService iadminService;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(HttpSession session,AdminInfo af){
		
		AdminInfo adminInfo=iadminService.login(af);
	
		if( adminInfo!=null ){
			session.setAttribute("currentLoginAdmin", adminInfo);
			return 1;
		}
		return 0;
		
	}
	
	@RequestMapping("/manager")
	public String manage(AdminInfo af){
		return "index";
	}
	
	
	/**
	 * 获取管理员登陆的信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/obtain")
	@ResponseBody
	public AdminInfo obtain(HttpSession session){	
		
		return (AdminInfo) session.getAttribute("currentLoginAdmin");

	}
	
	/**
	 * 添加都统
	 * @param af
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public int add(AdminInfo af){
		return iadminService.add(af);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<AdminInfo> findAll(){
		return iadminService.findAll();
	}
	
	@RequestMapping("/deleAid")
	@ResponseBody
	public int deleAid(AdminInfo af){
		return iadminService.deleAid(af);
	}
	
}
