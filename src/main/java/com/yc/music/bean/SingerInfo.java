package com.yc.music.bean;

import java.io.Serializable;

public class SingerInfo implements Serializable {
	
	private int sgid;
	private String sgname;
	private String addr;
	private String sex;
	private String genre;
	private int status;
	private int cid;
	private int num;
	private String by1;
	private String by2;
	private String by3;
	
	private int uid;

	@Override
	public String toString() {
		return "SingerInfo [sgid=" + sgid + ", sgname=" + sgname + ", addr=" + addr + ", sex=" + sex + ", genre="
				+ genre + ", status=" + status + ", cid=" + cid + ", num=" + num + ", by1=" + by1 + ", by2=" + by2
				+ ", by3=" + by3 + ", uid=" + uid + "]";
	}

	public int getSgid() {
		return sgid;
	}

	public void setSgid(int sgid) {
		this.sgid = sgid;
	}

	public String getSgname() {
		return sgname;
	}

	public void setSgname(String sgname) {
		this.sgname = sgname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((by1 == null) ? 0 : by1.hashCode());
		result = prime * result + ((by2 == null) ? 0 : by2.hashCode());
		result = prime * result + ((by3 == null) ? 0 : by3.hashCode());
		result = prime * result + cid;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + num;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + sgid;
		result = prime * result + ((sgname == null) ? 0 : sgname.hashCode());
		result = prime * result + status;
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
		SingerInfo other = (SingerInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
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
		if (cid != other.cid)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (num != other.num)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (sgid != other.sgid)
			return false;
		if (sgname == null) {
			if (other.sgname != null)
				return false;
		} else if (!sgname.equals(other.sgname))
			return false;
		if (status != other.status)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	public SingerInfo(int sgid, String sgname, String addr, String sex, String genre, int status, int cid, int num,
			String by1, String by2, String by3, int uid) {
		super();
		this.sgid = sgid;
		this.sgname = sgname;
		this.addr = addr;
		this.sex = sex;
		this.genre = genre;
		this.status = status;
		this.cid = cid;
		this.num = num;
		this.by1 = by1;
		this.by2 = by2;
		this.by3 = by3;
		this.uid = uid;
	}

	public SingerInfo() {
		super();
	}
	
	
	
	
}
