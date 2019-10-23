package com.yc.music.bean;

public class ApplicationTypeInfo {
	private int atid;
	private String atname;
	private String by1;
	private String by2;
	private String by3;
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getAtname() {
		return atname;
	}
	public void setAtname(String atname) {
		this.atname = atname;
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
		result = prime * result + atid;
		result = prime * result + ((atname == null) ? 0 : atname.hashCode());
		result = prime * result + ((by1 == null) ? 0 : by1.hashCode());
		result = prime * result + ((by2 == null) ? 0 : by2.hashCode());
		result = prime * result + ((by3 == null) ? 0 : by3.hashCode());
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
		ApplicationTypeInfo other = (ApplicationTypeInfo) obj;
		if (atid != other.atid)
			return false;
		if (atname == null) {
			if (other.atname != null)
				return false;
		} else if (!atname.equals(other.atname))
			return false;
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
		return true;
	}
	@Override
	public String toString() {
		return "ApplicationTypeInfo [atid=" + atid + ", atname=" + atname + ", by1=" + by1 + ", by2=" + by2 + ", by3="
				+ by3 + "]";
	}
	public ApplicationTypeInfo(int atid, String atname, String by1, String by2, String by3) {
		super();
		this.atid = atid;
		this.atname = atname;
		this.by1 = by1;
		this.by2 = by2;
		this.by3 = by3;
	}
	public ApplicationTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
