package com.yc.music.util;

public class StringUtil {
	public  static boolean checkNull(String ... strs){
		if( strs==null || strs.length<=0 ){
			return true;
		}
		
		for( String str:strs ){
			if( str==null ){
				return true;
			}
		}
		
		return false;
		
	}
}
