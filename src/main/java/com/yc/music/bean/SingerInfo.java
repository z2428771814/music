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
	
	@Override
	public String toString() {
		return "SingerInfo [sgid=" + sgid + ", sgname=" + sgname + ", addr=" + addr + ", sex=" + sex + ", genre="
				+ genre + ", status=" + status + ", cid=" + cid + ", num=" + num + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + cid;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + num;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + sgid;
		result = prime * result + ((sgname == null) ? 0 : sgname.hashCode());
		result = prime * result + status;
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
		return true;
	}

	public SingerInfo(int sgid, String sgname, String addr, String sex, String genre, int status, int cid, int num) {
		super();
		this.sgid = sgid;
		this.sgname = sgname;
		this.addr = addr;
		this.sex = sex;
		this.genre = genre;
		this.status = status;
		this.cid = cid;
		this.num = num;
	}

	public SingerInfo() {
		super();
	}
	
	
}
