package com.yc.music.bean;

import java.io.Serializable;

public class MusicInfo implements Serializable {
	private int mid;
	private int sgid;
	private int sid;
	private int cid;
	private int atid;
	private String mname;
	private String musciaddr;
	private String pices;
	private String Lyricaddr;
	private int judgestauts;
	private int status;
	private String sgname;
	private String lname;
	
	@Override
	public String toString() {
		return "MusicInfo [mid=" + mid + ", sgid=" + sgid + ", sid=" + sid + ", cid=" + cid + ", atid=" + atid
				+ ", mname=" + mname + ", musciaddr=" + musciaddr + ", pices=" + pices + ", Lyricaddr=" + Lyricaddr
				+ ", judgestauts=" + judgestauts + ", status=" + status + ", sgname=" + sgname + ", lname=" + lname
				+ "]";
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

	public String getMusciaddr() {
		return musciaddr;
	}

	public void setMusciaddr(String musciaddr) {
		this.musciaddr = musciaddr;
	}

	public String getPices() {
		return pices;
	}

	public void setPices(String pices) {
		this.pices = pices;
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

	public String getSgname() {
		return sgname;
	}

	public void setSgname(String sgname) {
		this.sgname = sgname;
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
		result = prime * result + ((Lyricaddr == null) ? 0 : Lyricaddr.hashCode());
		result = prime * result + atid;
		result = prime * result + cid;
		result = prime * result + judgestauts;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((musciaddr == null) ? 0 : musciaddr.hashCode());
		result = prime * result + ((pices == null) ? 0 : pices.hashCode());
		result = prime * result + sgid;
		result = prime * result + ((sgname == null) ? 0 : sgname.hashCode());
		result = prime * result + sid;
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
		MusicInfo other = (MusicInfo) obj;
		if (Lyricaddr == null) {
			if (other.Lyricaddr != null)
				return false;
		} else if (!Lyricaddr.equals(other.Lyricaddr))
			return false;
		if (atid != other.atid)
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
		if (musciaddr == null) {
			if (other.musciaddr != null)
				return false;
		} else if (!musciaddr.equals(other.musciaddr))
			return false;
		if (pices == null) {
			if (other.pices != null)
				return false;
		} else if (!pices.equals(other.pices))
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
		return true;
	}

	public MusicInfo(int mid, int sgid, int sid, int cid, int atid, String mname, String musciaddr, String pices,
			String lyricaddr, int judgestauts, int status, String sgname, String lname) {
		super();
		this.mid = mid;
		this.sgid = sgid;
		this.sid = sid;
		this.cid = cid;
		this.atid = atid;
		this.mname = mname;
		this.musciaddr = musciaddr;
		this.pices = pices;
		Lyricaddr = lyricaddr;
		this.judgestauts = judgestauts;
		this.status = status;
		this.sgname = sgname;
		this.lname = lname;
	}

	public MusicInfo() {
		super();
	}
	
	
	
	
	
	
}
