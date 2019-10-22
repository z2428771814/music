package com.yc.music.bean;

import java.io.Serializable;

public class UserListInfo implements Serializable {
	private int lid;
	private int uid;
	private String lname;
	
	@Override
	public String toString() {
		return "UserList [lid=" + lid + ", uid=" + uid + ", lname=" + lname + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lid;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + uid;
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
		if (lid != other.lid)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	public UserListInfo(int lid, int uid, String lname) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.lname = lname;
	}

	public UserListInfo() {
		super();
	}
	
	
}
