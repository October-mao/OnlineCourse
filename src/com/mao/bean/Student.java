package com.mao.bean;

public class Student {
	private int SNo;
	private String Sname;
	private String Spassword;
	private String Sclass;
	private String Ssex;
	private String publishTime;
	private String photo;
	private float Scredit;
	public static float summary = 7;
	public static float MAXscore = 100;

	public Student() {
	}

	public int getSNo() {
		return SNo;
	}


	public void setSNo(int sNo) {
		SNo = sNo;
	}


	public String getSname() {
		return Sname;
	}


	public void setSname(String sname) {
		Sname = sname;
	}


	public String getSpassword() {
		return Spassword;
	}


	public void setSpassword(String spassword) {
		Spassword = spassword;
	}


	public String getSclass() {
		return Sclass;
	}


	public void setSclass(String sclass) {
		Sclass = sclass;
	}


	public String getSsex() {
		return Ssex;
	}


	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	
	public float getScredit() {
		return Scredit;
	}


	public void setScredit(float scredit) {
		Scredit = scredit;
	}
	
	/**
	 * @param sNo
	 * @param sname
	 * @param spassword
	 * @param sclass
	 * @param ssex
	 */
	public Student(int sNo, String sname, String spassword, String sclass,
			String ssex,float scredit,String PublishTime) {
		SNo = sNo;
		Sname = sname;
		Spassword = spassword;
		Sclass = sclass;
		Ssex = ssex;
		Scredit = scredit;
		publishTime =PublishTime;
	}
	public Student( String sname, String spassword, String sclass,
			String ssex,float scredit,String publishTime) {
		this.Sname = sname;
		this.Spassword = spassword;
		this.Sclass = sclass;
		this.Ssex = ssex;
		this.Scredit = scredit;
		this.publishTime = publishTime;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public String toString() {
		return "Student{" +
				"SNo=" + SNo +
				", Sname='" + Sname + '\'' +
				", Spassword='" + Spassword + '\'' +
				", Sclass='" + Sclass + '\'' +
				", Ssex='" + Ssex + '\'' +
				", publishTime='" + publishTime + '\'' +
				", photo='" + photo + '\'' +
				", Scredit=" + Scredit +
				'}';
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Student(String sname, String spassword, String sclass, String ssex,float scredit, String publishTime, String photo) {
		Sname = sname;
		Spassword = spassword;
		Sclass = sclass;
		Ssex = ssex;
		this.publishTime = publishTime;
		this.photo = photo;
		Scredit = scredit;
	}


	public Student(int SNo, String sname, String spassword, String sclass, String ssex, float scredit ,String publishTime, String photo) {
		this.SNo = SNo;
		Sname = sname;
		Spassword = spassword;
		Sclass = sclass;
		Ssex = ssex;
		this.publishTime = publishTime;
		this.photo = photo;
		Scredit = scredit;
	}
}
