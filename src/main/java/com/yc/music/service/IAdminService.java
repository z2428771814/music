package com.yc.music.service;

import java.util.List;

import com.yc.music.bean.AdminInfo;

public interface IAdminService {
	//后台登陆
	public AdminInfo login(AdminInfo af);
	
	//添加都统
	public int add(AdminInfo a);
	
	//查询帐下所有的都统
	public List<AdminInfo> findAll();
	
	//都统阵亡
	public int deleAid(AdminInfo af);
	
}
