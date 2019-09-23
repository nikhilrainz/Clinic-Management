package com.ust.model;

import java.util.Date;

public class Doctor {
	
	private int appId;
	private int regId;
	private int dId;
	private Date dateOfApp;
	private String consultStatus;
	private int dObsId;
	private Date obserDate;
	private String obsNotes;
	private int prescId;
	private int medId;
	private String medFreq;
	private int medDays;
	private Date prescDate;
	private String pharmacyStatus;
	private String medName;
	private int medPrice;
	private int isActiveM;
	private String manufacturer;
	private Date createdDateM;
	private int assignLabId;
	private int labId;
	private Date assigLabDate;
	private String sampleStatus;
	private String testStatus;
	private String lName;
	private int lFee;
	private String description;
	private int lasbResId;
	private String labResult;
	private String sName;
	private int sId;
	
	private String pFName;
	private String pLName;
	private String pGender;
	private Date pDOB;
	private String pAddr;
	private String pPhNo;
	private String pBloodGrp;
	private Date createdDateP;
	
	public Doctor()
	{
	}
	// generate getters and setters
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
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
	public int getdObsId() {
		return dObsId;
	}
	public void setdObsId(int dObsId) {
		this.dObsId = dObsId;
	}
	public Date getObserDate() {
		return obserDate;
	}
	public void setObserDate(Date obserDate) {
		this.obserDate = obserDate;
	}
	public String getObsNotes() {
		return obsNotes;
	}
	public void setObsNotes(String obsNotes) {
		this.obsNotes = obsNotes;
	}
	public int getPrescId() {
		return prescId;
	}
	public void setPrescId(int prescId) {
		this.prescId = prescId;
	}
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public String getMedFreq() {
		return medFreq;
	}
	public void setMedFreq(String medFreq) {
		this.medFreq = medFreq;
	}
	public int getMedDays() {
		return medDays;
	}
	public void setMedDays(int medDays) {
		this.medDays = medDays;
	}
	public Date getPrescDate() {
		return prescDate;
	}
	public void setPrescDate(Date prescDate) {
		this.prescDate = prescDate;
	}
	public String getPharmacyStatus() {
		return pharmacyStatus;
	}
	public void setPharmacyStatus(String pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public int getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(int medPrice) {
		this.medPrice = medPrice;
	}
	public int getIsActiveM() {
		return isActiveM;
	}
	public void setIsActiveM(int isActiveM) {
		this.isActiveM = isActiveM;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getCreatedDateM() {
		return createdDateM;
	}
	public void setCreatedDateM(Date createdDateM) {
		this.createdDateM = createdDateM;
	}
	public int getAssignLabId() {
		return assignLabId;
	}
	public void setAssignLabId(int assignLabId) {
		this.assignLabId = assignLabId;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public Date getAssigLabDate() {
		return assigLabDate;
	}
	public void setAssigLabDate(Date assigLabDate) {
		this.assigLabDate = assigLabDate;
	}
	public String getSampleStatus() {
		return sampleStatus;
	}
	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getlFee() {
		return lFee;
	}
	public void setlFee(int lFee) {
		this.lFee = lFee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLasbResId() {
		return lasbResId;
	}
	public void setLasbResId(int lasbResId) {
		this.lasbResId = lasbResId;
	}
	public String getLabResult() {
		return labResult;
	}
	public void setLabResult(String labResult) {
		this.labResult = labResult;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
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
	
	
	
	
}


