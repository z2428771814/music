package com.yc.music.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.music.bean.ApplicationTypeInfo;
import com.yc.music.bean.SongTypeInfo;
import com.yc.music.mapper.ITypeChangeMapper;
import com.yc.music.service.ITypeChangeService;
import com.yc.music.util.StringUtil;

@Service
public class TypeChangeServiceImpl implements ITypeChangeService {
	
	@Autowired
	private ITypeChangeMapper mapper;

	
	public int addApplicationType(ApplicationTypeInfo alt) {
		if( StringUtil.checkNull( alt.getAtname() ) ){
			return -1;
		}
		return mapper.addApplicationType(alt);
	}


	@Override
	public List<ApplicationTypeInfo> findApplicationType() {
		return mapper.findApplicationType();
	}


	@Override
	public int deleteApplicationType(ApplicationTypeInfo alt) {
		return mapper.deleteApplicationType(alt);
	}


	@Override
	public int deleteSongTypeInfo(ApplicationTypeInfo alt) {
		return mapper.deleteSongTypeInfo(alt);
	}


	@Override
	public int addSongType(int aitd,String stype) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("atid", aitd);
		map.put("stype", stype);
		return mapper.addSongType(map);
	} 


	@Override
	public List<SongTypeInfo> findByAtidSongType(int atid) {
		return mapper.findByAtidSongType(atid);
	}


	@Override
	public int deleteSongType(int sid) {
		return mapper.deleteSongType(sid);
	}

}
