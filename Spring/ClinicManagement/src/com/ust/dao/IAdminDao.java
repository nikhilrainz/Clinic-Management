package com.ust.dao;

import java.util.List;

import com.ust.model.Admin;

public interface IAdminDao {

	//GET ALL MEDICINELIST
	public abstract List<Admin> list();

	// GET BY MEDNAME(SEARCH)
	public abstract List<Admin> get(String medName);

	// EDIT MEDICINE
	public abstract Admin getMedById(int medId);

	//ADD MEDICINE
	public abstract long save(Admin adm);

	// UPDATE MEDICINE
	public abstract int update(Admin adm);

	//DISABLE MEDICINE
	public abstract int disableMedicine(int medId);

	//GET ALL DOCTOR LIST
	public abstract List<Admin> list1();

	// SEARCH A DOCTOR BY ID AND PHONE
	public abstract List<Admin> getDoc(String searchString);

	// TO GET ROLE NAME
	public abstract Admin getRoleName(String roleName);

	// DISPLAY ALL ROLES
	public abstract List<Admin> getAllRoles();

	//GET DOCTOR DETAIL BY SID
	public abstract List<Admin> getDoctorDetailsById(int sId);

	//INSERT DOCTOR
	public abstract int insertDoctorStaff(Admin aBean);

	//GETTING MAX ID FROM STAFF TABLE
	public abstract int insertDoctor(Admin aBean);

	//CONSULTATION DAYS OF EACH DOCTORS
	public abstract int insertAvailableDays(Admin aBean);

	//UPDATE A DOCTOR
	public abstract int updateDoctorStaff(Admin aBean);

	// GETTING DOCTOR ID FROM DOCTOR TABLE
	public abstract int getSeqDid(int sId);

	//DISABLE A DOCTOR
	public abstract int disableDoctor(int dId);

	//LIST ALL STAFFS
	public abstract List<Admin> listS();

	//GETTING ROLE ID
	public abstract int getRoleId(String role);

	// UPDATING A STAFF
	public abstract int updateStaff(Admin ab);

	//INSERTING A STAFF
	public abstract int insertStaff(Admin aBean);

	//SEARCH A STAFF USING ID AND PHONE
	public abstract List<Admin> getStaff(String searchString);

	//DISABLE STAFFS
	public abstract int disableStaff(int sId);

	//CONTROLLER METHOD FOR SAVE AND UPDATE
	public abstract int saveDoctor(Admin aBean);

	//GETTING ROLEID FROM ROLE TABLE FOR STAFF
	public abstract Integer getRoleById(String roleName);

	//SEARCHING A STAFF USING STAFFID
	public abstract List<Admin> getStaffDetailsById(int sId);

}