package com.yc.music.bean;

import java.io.Serializable;

public class MusicInfo implements Serializable{
	
	private int mid;
	private int sgid;
	private int sid;
	private int cid;
	private int atid;
	private String mname;
	private String pices;
	private String musicaddr;
	private String Lyricaddr;
	private int judgestauts;
	private int status;
	private String rgdate;
	private String by2;
	private String by3;
	
	private String lname;
	private String sgname;
	private String stype;
	
	@Override
	public String toString() {
		return "MusicInfo [mid=" + mid + ", sgid=" + sgid + ", sid=" + sid + ", cid=" + cid + ", atid=" + atid
				+ ", mname=" + mname + ", pices=" + pices + ", musicaddr=" + musicaddr + ", Lyricaddr=" + Lyricaddr
				+ ", judgestauts=" + judgestauts + ", status=" + status + ", rgdate=" + rgdate + ", by2=" + by2
				+ ", by3=" + by3 + ", lname=" + lname + ", sgname=" + sgname + ", stype=" + stype + "]";
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getSgid() {
		return sgid;
	}

	public void setSgid(int sgid) {
		this.sgid = sgid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getAtid() {
		return atid;
	}

	public void setAtid(int atid) {
		this.atid = atid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPices() {
		return pices;
	}

	public void setPices(String pices) {
		this.pices = pices;
	}

	public String getMusicaddr() {
		return musicaddr;
	}

	public void setMusicaddr(String musicaddr) {
		this.musicaddr = musicaddr;
	}

	public String getLyricaddr() {
		return Lyricaddr;
	}

	public void setLyricaddr(String lyricaddr) {
		Lyricaddr = lyricaddr;
	}

	public int getJudgestauts() {
		return judgestauts;
	}

	public void setJudgestauts(int judgestauts) {
		this.judgestauts = judgestauts;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRgdate() {
		return rgdate;
	}

	public void setRgdate(String rgdate) {
		this.rgdate = rgdate;
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

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSgname() {
		return sgname;
	}

	public void setSgname(String sgname) {
		this.sgname = sgname;
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
		result = prime * result + ((Lyricaddr == null) ? 0 : Lyricaddr.hashCode());
		result = prime * result + atid;
		result = prime * result + ((by2 == null) ? 0 : by2.hashCode());
		result = prime * result + ((by3 == null) ? 0 : by3.hashCode());
		result = prime * result + cid;
		result = prime * result + judgestauts;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((musicaddr == null) ? 0 : musicaddr.hashCode());
		result = prime * result + ((pices == null) ? 0 : pices.hashCode());
		result = prime * result + ((rgdate == null) ? 0 : rgdate.hashCode());
		result = prime * result + sgid;
		result = prime * result + ((sgname == null) ? 0 : sgname.hashCode());
		result = prime * result + sid;
		result = prime * result + status;
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
		MusicInfo other = (MusicInfo) obj;
		if (Lyricaddr == null) {
			if (other.Lyricaddr != null)
				return false;
		} else if (!Lyricaddr.equals(other.Lyricaddr))
			return false;
		if (atid != other.atid)
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
		if (judgestauts != other.judgestauts)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (musicaddr == null) {
			if (other.musicaddr != null)
				return false;
		} else if (!musicaddr.equals(other.musicaddr))
			return false;
		if (pices == null) {
			if (other.pices != null)
				return false;
		} else if (!pices.equals(other.pices))
			return false;
		if (rgdate == null) {
			if (other.rgdate != null)
				return false;
		} else if (!rgdate.equals(other.rgdate))
			return false;
		if (sgid != other.sgid)
			return false;
		if (sgname == null) {
			if (other.sgname != null)
				return false;
		} else if (!sgname.equals(other.sgname))
			return false;
		if (sid != other.sid)
			return false;
		if (status != other.status)
			return false;
		if (stype == null) {
			if (other.stype != null)
				return false;
		} else if (!stype.equals(other.stype))
			return false;
		return true;
	}

	public MusicInfo(int mid, int sgid, int sid, int cid, int atid, String mname, String pices, String musicaddr,
			String lyricaddr, int judgestauts, int status, String rgdate, String by2, String by3, String lname,
			String sgname, String stype) {
		super();
		this.mid = mid;
		this.sgid = sgid;
		this.sid = sid;
		this.cid = cid;
		this.atid = atid;
		this.mname = mname;
		this.pices = pices;
		this.musicaddr = musicaddr;
		Lyricaddr = lyricaddr;
		this.judgestauts = judgestauts;
		this.status = status;
		this.rgdate = rgdate;
		this.by2 = by2;
		this.by3 = by3;
		this.lname = lname;
		this.sgname = sgname;
		this.stype = stype;
	}

	public MusicInfo() {
		super();
	}
	
	
	
}
