package com.yc.music.bean;

import java.io.Serializable;

public class UserMusicInfo implements Serializable{
	private int umid;
	private int lid;
	private int mid;
	
	@Override
	public String toString() {
		return "UserMusic [umid=" + umid + ", lid=" + lid + ", mid=" + mid + "]";
	}

	public int getUmid() {
		return umid;
	}

	public void setUmid(int umid) {
		this.umid = umid;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lid;
		result = prime * result + mid;
		result = prime * result + umid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMusicInfo other = (UserMusicInfo) obj;
		if (lid != other.lid)
			return false;
		if (mid != other.mid)
			return false;
		if (umid != other.umid)
			return false;
		return true;
	}

	public UserMusicInfo(int umid, int lid, int mid) {
		super();
		this.umid = umid;
		this.lid = lid;
		this.mid = mid;
	}

	public UserMusicInfo() {
		super();
	}
	
	
	
}
