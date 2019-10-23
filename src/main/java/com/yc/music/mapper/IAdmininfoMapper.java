package com.yc.music.mapper;

import java.util.List;
import java.util.Map;

import com.yc.music.bean.AdminInfo;

public interface IAdmininfoMapper {
	/**
	 * 管理员登陆
	 * @param af
	 * @return
	 */
	public AdminInfo login(AdminInfo af);
	
	/**
	 * 添加都统 (别称)
	 * @param a
	 * @return
	 */
	public int add(AdminInfo a);
	
	/**
	 * 查询帐下所有的都统	--查询所有的管理员
	 * @return
	 */
	public List<AdminInfo> findAll();
	
	/**
	 * 都统阵亡 	删除
	 * @param af
	 * @return
	 */
	public int deleAid(AdminInfo af);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<AdminInfo> paging(Map<String,Integer> map);
	
}
