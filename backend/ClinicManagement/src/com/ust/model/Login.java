package com.ust.model;

import java.util.Date;

public class Login {
	private int sId;
	private int roleId;
	private String sName;
	private Date sDOB;
    private String sGender;
    private String sAddr;
    private String sExp;
    private String sPhNo;
    private String sEmail; 
    private String username;
    private String password;
    private String isActiveS;
    private Date createdDateS;
    
    
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Login(int sId, int roleId, String sName, Date sDOB, String sGender,
			String sAddr, String sExp, String sPhNo, String sEmail,
			String username, String password, String isActiveS,
			Date createdDateS) {
		super();
		this.sId = sId;
		this.roleId = roleId;
		this.sName = sName;
		this.sDOB = sDOB;
		this.sGender = sGender;
		this.sAddr = sAddr;
		this.sExp = sExp;
		this.sPhNo = sPhNo;
		this.sEmail = sEmail;
		this.username = username;
		this.password = password;
		this.isActiveS = isActiveS;
		this.createdDateS = createdDateS;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Date getsDOB() {
		return sDOB;
	}
	public void setsDOB(Date sDOB) {
		this.sDOB = sDOB;
	}
	public String getsGender() {
		return sGender;
	}
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public String getsExp() {
		return sExp;
	}
	public void setsExp(String sExp) {
		this.sExp = sExp;
	}
	public String getsPhNo() {
		return sPhNo;
	}
	public void setsPhNo(String sPhNo) {
		this.sPhNo = sPhNo;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsActiveS() {
		return isActiveS;
	}
	public void setIsActiveS(String isActiveS) {
		this.isActiveS = isActiveS;
	}
	public Date getCreatedDateS() {
		return createdDateS;
	}
	public void setCreatedDateS(Date createdDateS) {
		this.createdDateS = createdDateS;
	}
	
    
    
    
}



