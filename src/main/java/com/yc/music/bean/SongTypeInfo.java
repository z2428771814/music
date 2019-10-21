package com.yc.music.bean;

import java.io.Serializable;

public class SongTypeInfo implements Serializable{
	
	private int sid;
	private int atid;
	private String stype;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atid;
		result = prime * result + sid;
		result = prime * result + ((stype == null) ? 0 : stype.hashCode());
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
		SongTypeInfo other = (SongTypeInfo) obj;
		if (atid != other.atid)
			return false;
		if (sid != other.sid)
			return false;
		if (stype == null) {
			if (other.stype != null)
				return false;
		} else if (!stype.equals(other.stype))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SongTypeInfo [sid=" + sid + ", atid=" + atid + ", stype=" + stype + "]";
	}
	public SongTypeInfo(int sid, int atid, String stype) {
		super();
		this.sid = sid;
		this.atid = atid;
		this.stype = stype;
	}
	public SongTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
