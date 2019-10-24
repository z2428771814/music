package com.yc.music.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.music.bean.SongTypeInfo;
import com.yc.music.bean.UserListInfo;
import com.yc.music.service.IUserListService;



@RestController
@RequestMapping("/songList")
public class UserListInfoController {
	
	@Autowired
	private IUserListService service;
	
	//歌单推荐类型
	@RequestMapping("/oodType")
	public List<SongTypeInfo> oodType() {
		return service.oodType();
	}
	
	//最新歌单
	@RequestMapping("/newOdd")
	public List<UserListInfo> newOdd() {
		return service.newOdd();
		
	}
}
