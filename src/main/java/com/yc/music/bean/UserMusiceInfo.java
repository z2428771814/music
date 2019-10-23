package com.yc.music.bean;

import java.io.Serializable;

public class UserMusiceInfo implements Serializable {

	private static final long serialVersionUID = 4460148285442048929L;

	private int umid;
	private int lid;
	private int mid;
	private String by1;
	private String by2;
	private String by3;
	
	@Override
	public String toString() {
		return "UserMusiceInfo [umid=" + umid + ", lid=" + lid + ", mid=" + mid + ", by1=" + by1 + ", by2=" + by2
				+ ", by3=" + by3 + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((by1 == null) ? 0 : by1.hashCode());
		result = prime * result + ((by2 == null) ? 0 : by2.hashCode());
		result = prime * result + ((by3 == null) ? 0 : by3.hashCode());
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
		UserMusiceInfo other = (UserMusiceInfo) obj;
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
		if (mid != other.mid)
			return false;
		if (umid != other.umid)
			return false;
		return true;
	}

	public UserMusiceInfo(int umid, int lid, int mid, String by1, String by2, String by3) {
		super();
		this.umid = umid;
		this.lid = lid;
		this.mid = mid;
		this.by1 = by1;
		this.by2 = by2;
		this.by3 = by3;
	}

	public UserMusiceInfo() {
		super();
	}
	
	
	
}
