package com.yc.music.service.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.AdminInfo;
import com.yc.music.mapper.IAdmininfoMapper;
import com.yc.music.service.IAdminService;
import com.yc.music.util.StringUtil;



@Service
public class AdminServiceImpl  implements IAdminService {
	
	@Autowired
	private IAdmininfoMapper mapper;

	
	public AdminInfo login(AdminInfo af) {
		
		if( StringUtil.checkNull(af.getAname(),af.getPwd()) ){
			return null;
		}
		AdminInfo adminInfo=mapper.login(af);
		
		return adminInfo;
	}


	@Override
	public int add(AdminInfo a) {
		if( StringUtil.checkNull( a.getAname(),a.getPwd(),a.getEmail() ) ){
			return -1;
		}
		
		
		
		return mapper.add(a);
	}


	@Override
	public List<AdminInfo> findAll() {
		
		return mapper.findAll();
	}


	@Override
	public int deleAid(AdminInfo af) {
		
		return mapper.deleAid(af);
	}


	@Override
	public List<AdminInfo> paging(Map<String, Integer> map) {
		return mapper.paging(map);
	}

}
