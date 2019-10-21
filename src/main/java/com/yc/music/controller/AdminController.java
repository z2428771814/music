package com.yc.music.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.AdminInfo;
import com.yc.music.service.IAdminService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@Autowired
	private IAdminService iadminService;
	
	@RequestMapping("/login")
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
	public AdminInfo obtain(HttpSession session){	
		
		return (AdminInfo) session.getAttribute("currentLoginAdmin");

	}
	
	/**
	 * 添加都统
	 * @param af
	 * @return
	 */
	@RequestMapping("/add")
	public int add(AdminInfo af){
		return iadminService.add(af);
	}
	
	@RequestMapping("/findAll")
	public List<AdminInfo> findAll(){
		return iadminService.findAll();
	}
	
	@RequestMapping("/deleAid")
	public int deleAid(AdminInfo af){
		return iadminService.deleAid(af);
	}
	
	//分页查询
	@RequestMapping("/paging")
	public Map<String, Object> paging(Integer pageNo,Integer pageSize){
		Map<String, Object> pmap=new HashMap<String, Object>();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("pageNo", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		//获取分页查询的内容
		pmap.put("paging", iadminService.paging(map));
		//计算总页数
		pmap.put("total", iadminService.findAll().size());
		
		
		
		return pmap;
		
	
	}
	
}
