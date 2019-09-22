package com.ust.model;

import java.util.Date;
import java.util.List;



	//Bean Class FrontOffice
	public class FrontOffice {
		
		//instance variables 
		private int regId;
		private String pFName;
		private String pLName;
		private String pGender;
		private Date pDOB;
		private String pAddr;
		private String pPhNo;
		private String pBloodGrp;
		private Date createdDateP;
		private int age;
		
		private int appId;
		private int dId;
		private Date dateOfApp;
		private String consultStatus;
		
		private int fBillId;
		
		private Date billDate;
		private double admFee;
		
		//Dr Table
		private int sId;
		private String dSpec;	
		private String dQualification;
		private double consultFee;
		
		//staff table
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
		
		//role Table
		private String roleName;
		
		//day Table
		private int dayId;
		private String dayName;
		
		//ConsultDay Table
		private int consultId;

	
		private int consultDayId;

		private String sun;
		private String mon;
		private String tue;
		private String wed;
		private String thu ;
		private String fri;
		private String sat;
		
		
		public FrontOffice() {
			super();
		}


		public FrontOffice(int regId, String pFName, String pLName,
				String pGender, Date pDOB, String pAddr, String pPhNo,
				String pBloodGrp, Date createdDateP, int age, int appId,
				int dId, Date dateOfApp, String consultStatus, int fBillId,
				Date billDate, double admFee, int sId, String dSpec,
				String dQualification, double consultFee, int roleId,
				String sName, Date sDOB, String sGender, String sAddr,
				String sExp, String sPhNo, String sEmail, String username,
				String password, String isActiveS, Date createdDateS,
				String roleName, int dayId, String dayName, int consultId,
				int consultDayId, String sun, String mon, String tue,
				String wed, String thu, String fri, String sat) {
			super();
			this.regId = regId;
			this.pFName = pFName;
			this.pLName = pLName;
			this.pGender = pGender;
			this.pDOB = pDOB;
			this.pAddr = pAddr;
			this.pPhNo = pPhNo;
			this.pBloodGrp = pBloodGrp;
			this.createdDateP = createdDateP;
			this.age = age;
			this.appId = appId;
			this.dId = dId;
			this.dateOfApp = dateOfApp;
			this.consultStatus = consultStatus;
			this.fBillId = fBillId;
			this.billDate = billDate;
			this.admFee = admFee;
			this.sId = sId;
			this.dSpec = dSpec;
			this.dQualification = dQualification;
			this.consultFee = consultFee;
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
			this.roleName = roleName;
			this.dayId = dayId;
			this.dayName = dayName;
			this.consultId = consultId;
			this.consultDayId = consultDayId;
			this.sun = sun;
			this.mon = mon;
			this.tue = tue;
			this.wed = wed;
			this.thu = thu;
			this.fri = fri;
			this.sat = sat;
		}


		public int getRegId() {
			return regId;
		}


		public void setRegId(int regId) {
			this.regId = regId;
		}


		public String getpFName() {
			return pFName;
		}


		public void setpFName(String pFName) {
			this.pFName = pFName;
		}


		public String getpLName() {
			return pLName;
		}


		public void setpLName(String pLName) {
			this.pLName = pLName;
		}


		public String getpGender() {
			return pGender;
		}


		public void setpGender(String pGender) {
			this.pGender = pGender;
		}


		public Date getpDOB() {
			return pDOB;
		}


		public void setpDOB(Date pDOB) {
			this.pDOB = pDOB;
		}


		public String getpAddr() {
			return pAddr;
		}


		public void setpAddr(String pAddr) {
			this.pAddr = pAddr;
		}


		public String getpPhNo() {
			return pPhNo;
		}


		public void setpPhNo(String pPhNo) {
			this.pPhNo = pPhNo;
		}


		public String getpBloodGrp() {
			return pBloodGrp;
		}


		public void setpBloodGrp(String pBloodGrp) {
			this.pBloodGrp = pBloodGrp;
		}


		public Date getCreatedDateP() {
			return createdDateP;
		}


		public void setCreatedDateP(Date createdDateP) {
			this.createdDateP = createdDateP;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public int getAppId() {
			return appId;
		}


		public void setAppId(int appId) {
			this.appId = appId;
		}


		public int getdId() {
			return dId;
		}


		public void setdId(int dId) {
			this.dId = dId;
		}


		public Date getDateOfApp() {
			return dateOfApp;
		}


		public void setDateOfApp(Date dateOfApp) {
			this.dateOfApp = dateOfApp;
		}


		public String getConsultStatus() {
			return consultStatus;
		}


		public void setConsultStatus(String consultStatus) {
			this.consultStatus = consultStatus;
		}


		public int getfBillId() {
			return fBillId;
		}


		public void setfBillId(int fBillId) {
			this.fBillId = fBillId;
		}


		public Date getBillDate() {
			return billDate;
		}


		public void setBillDate(Date billDate) {
			this.billDate = billDate;
		}


		public double getAdmFee() {
			return admFee;
		}


		public void setAdmFee(double admFee) {
			this.admFee = admFee;
		}


		public int getsId() {
			return sId;
		}


		public void setsId(int sId) {
			this.sId = sId;
		}


		public String getdSpec() {
			return dSpec;
		}


		public void setdSpec(String dSpec) {
			this.dSpec = dSpec;
		}


		public String getdQualification() {
			return dQualification;
		}


		public void setdQualification(String dQualification) {
			this.dQualification = dQualification;
		}


		public double getConsultFee() {
			return consultFee;
		}


		public void setConsultFee(double consultFee) {
			this.consultFee = consultFee;
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


		public String getRoleName() {
			return roleName;
		}


		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}


		public int getDayId() {
			return dayId;
		}


		public void setDayId(int dayId) {
			this.dayId = dayId;
		}


		public String getDayName() {
			return dayName;
		}


		public void setDayName(String dayName) {
			this.dayName = dayName;
		}


		public int getConsultId() {
			return consultId;
		}


		public void setConsultId(int consultId) {
			this.consultId = consultId;
		}


		public int getConsultDayId() {
			return consultDayId;
		}


		public void setConsultDayId(int consultDayId) {
			this.consultDayId = consultDayId;
		}


		public String getSun() {
			return sun;
		}


		public void setSun(String sun) {
			this.sun = sun;
		}


		public String getMon() {
			return mon;
		}


		public void setMon(String mon) {
			this.mon = mon;
		}


		public String getTue() {
			return tue;
		}


		public void setTue(String tue) {
			this.tue = tue;
		}


		public String getWed() {
			return wed;
		}


		public void setWed(String wed) {
			this.wed = wed;
		}


		public String getThu() {
			return thu;
		}


		public void setThu(String thu) {
			this.thu = thu;
		}


		public String getFri() {
			return fri;
		}


		public void setFri(String fri) {
			this.fri = fri;
		}


		public String getSat() {
			return sat;
		}


		public void setSat(String sat) {
			this.sat = sat;
		}
		
		
		
		
		
	}
