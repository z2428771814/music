package com.yc.music.bean;

import java.io.Serializable;

public class UserListInfo implements Serializable {
	
	private static final long serialVersionUID = -5595710659992315132L;
	
	private int lid;
	private int uid;
	private String lname;
	private String by1;
	private String by2;
	private String by3;
	
	// 用户名字
	private String uname;
	// 歌单里面音乐的数量
	private int num;
	
	@Override
	public String toString() {
		return "UserListInfo [lid=" + lid + ", uid=" + uid + ", lname=" + lname + ", by1=" + by1 + ", by2=" + by2
				+ ", by3=" + by3 + ", uname=" + uname + ", num=" + num + "]";
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBy1() {
		return by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public String getBy2() {
		return by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((by1 == null) ? 0 : by1.hashCode());
		result = prime * result + ((by2 == null) ? 0 : by2.hashCode());
		result = prime * result + ((by3 == null) ? 0 : by3.hashCode());
		result = prime * result + lid;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + num;
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		UserListInfo other = (UserListInfo) obj;
		if (by1 == null) {
			if (other.by1 != null)
				return false;
		} else if (!by1.equals(other.by1))
			return false;
		if (by2 == null) {
			if (other.by2 != null)
				return false;
		} else if (!by2.equals(other.by2))
			return false;
		if (by3 == null) {
			if (other.by3 != null)
				return false;
		} else if (!by3.equals(other.by3))
			return false;
		if (lid != other.lid)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (num != other.num)
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}

	public UserListInfo(int lid, int uid, String lname, String by1, String by2, String by3, String uname, int num) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.lname = lname;
		this.by1 = by1;
		this.by2 = by2;
		this.by3 = by3;
		this.uname = uname;
		this.num = num;
	}

	public UserListInfo() {
		super();
	}
	
	
	
}
