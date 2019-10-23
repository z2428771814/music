package com.yc.music.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.service.IAdminService;
import com.yc.music.service.ITypeChangeService;

@RestController
@RequestMapping("/TypeChange")
public class TypeChangeController {
	
	@Autowired
	private ITypeChangeService service;
	
	//添加应用场景类型
	@RequestMapping("/addApplicationType")
	public int addApplicationType(HttpSession session,ApplicationTypeInfo alt){
		
		if( this.findApplicationType(session).size()>10 ){
			return -2;
		}
		
		return service.addApplicationType(alt);
	}
	
	//查询所有的应用场景
	@RequestMapping("/findApplicationType")
	public List<ApplicationTypeInfo> findApplicationType(HttpSession session) {
		List<ApplicationTypeInfo> list=service.findApplicationType();
		session.setAttribute("findApplicationType", list);
		return list;
	}
	
	//获取我们存下来的应用的场景
	@RequestMapping("/obtainsApplicationType")
	public List<ApplicationTypeInfo> obtainsApplicationType(HttpSession session) {
		List<ApplicationTypeInfo> list= (List<ApplicationTypeInfo>) session.getAttribute("findApplicationType");
		if( list == null ){
			list=service.findApplicationType();
		}
		return list;
	}

	
	//删除应用场景  和应用场景下面所有的类型
	@RequestMapping("/deleteApplicationType")
	public int deleteApplicationType(ApplicationTypeInfo alt){
		int result=-1;
		result=service.deleteApplicationType(alt);
		service.deleteSongTypeInfo(alt);
		return result;
	}
	
	//添加类型
	@RequestMapping("/addSongType")
	public int addSongType(SongTypeInfo songTypeInfo){	
		if( service.findByAtidSongType(songTypeInfo.getAtid()).size()>10  ){
			return -1;
		}
		return service.addSongType(songTypeInfo.getAtid(), songTypeInfo.getStype());
	}
	
	//查询场景下面对应的类型
	@RequestMapping("/findByAtidSongType")
	public  List<SongTypeInfo> findByAtidSongType(int atid){
		return service.findByAtidSongType(atid);	
	}
	
	//删除类型
	@RequestMapping("/deleteSongType")
	public int deleteSongType(int sid){
		return service.deleteSongType(sid);
	}
	
}
