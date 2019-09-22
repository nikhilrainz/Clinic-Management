package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.AdminDaoImpl;
import com.ust.model.Admin;

@RestController
public class AdminController {

	@Autowired
	AdminDaoImpl AdminDaoImpl = new AdminDaoImpl();

	/* ---------------- MEDICINE---------------------------- */

	// Display All medicines

	@RequestMapping(value = "/api/medicine", method = RequestMethod.GET)
	public List<Admin> getAllMedicines() {
		List list = AdminDaoImpl.list();
		return list;
	}

	// Search a medicine by medName
	@RequestMapping(value = "/api/medicine/{medName}", method = RequestMethod.GET)
	public List<Admin> getMedicineByName(@PathVariable("medName") String medName) {
		// System.out.println(medName);
		List list = AdminDaoImpl.get(medName);
		System.out.println(list);
		return list;
	}

	// find a medicine by Id
	@RequestMapping(value = "/api/searchmedicine/{medId}", method = RequestMethod.GET)
	public Admin getMedicineById(@PathVariable("medId") int medId) {
		return AdminDaoImpl.getMedById(medId);
	}

	// Add/Update Medicines

	@RequestMapping(value = "/api/insertmedicine", method = {
			RequestMethod.POST, RequestMethod.PUT })
	public void insertMedicine(@RequestBody Admin adm) {
		if (adm.getMedId() != 0) {
			System.out.println(adm.getsDOB());
			AdminDaoImpl.update(adm);
		} else {
			AdminDaoImpl.save(adm);
		}
	}

	// Disable Medicine
	@RequestMapping(value = "/api/disablemedicine/{medId}", method = RequestMethod.PUT)
	public void medicineDisable(@PathVariable("medId") int medId) {
		AdminDaoImpl.disableMedicine(medId);
	}

	/* -----------------------------DOCTOR------------------------------- */

	// display all doctors

	@RequestMapping(value = "/api/doctor", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> getAllDoctors() {
		List list = AdminDaoImpl.list1();
		return list;
	}

	// search doctor by id and phone number
	@RequestMapping(value = "/api/doctor/{searchString}", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> getDocById(
			@PathVariable("searchString") String searchString) {
		System.out.println(searchString);
		List list = AdminDaoImpl.getDoc(searchString);
		System.out.println(list);
		return list;
	}

	/*
	 * @RequestMapping(value = "/api/doctor/{searchString}", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public Admin getDoc(@PathVariable("searchString") String
	 * searchString) { System.out.println(searchString); return
	 * AdminDaoImpl.getDoc(searchString); }
	 */

	/*
	 * // insert doctor
	 * 
	 * // @ResponseBody
	 * 
	 * @RequestMapping(value = "/api/insertdoctor/{roleName}", method =
	 * RequestMethod.POST) public void save(@RequestBody Admin doc,
	 * 
	 * @PathVariable("roleName") String roleName) throws ParseException {
	 * 
	 * AdminDaoImpl.saveDoctor(doc, roleName);
	 * 
	 * }
	 */

	// Insert Doctor
	@RequestMapping(value = "/api/saveDoctor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void doctorInsert(@RequestBody Admin aBean) {
		System.out.println("Save Doc ID :" +aBean.getsId());
		if(aBean.getsId() != 0)
		{
			AdminDaoImpl.updateDoctorStaff(aBean);
		}
		else
		{
			AdminDaoImpl.insertDoctorStaff(aBean);
		}
	}
	
	//GET Doctor BY SID
	@RequestMapping(value = "/api/editDoctorDetail/{sId}", method = RequestMethod.GET,headers = "Accept=application/json")
	public Admin getDoctorDetailsById(@ModelAttribute("objF")Admin objF,@PathVariable("sId") int sId)
	{
		System.out.println("HITS : "+sId);
		List list = AdminDaoImpl.getDoctorDetailsById(sId);
		System.out.println("LIST : " +list);
		objF=(Admin) list.get(0);
		System.out.println("OBJF : "+objF);
		return objF;
	}

	// disable doctor
	@RequestMapping(value = "/api/disabledoctor/{dId}", method = RequestMethod.PUT)
	void doctorDisable(@PathVariable("dId") int dId) {
		AdminDaoImpl.disableDoctor(dId);
	}

	/*
	 * -----------------------------STAFF------------------
	 * ------------------------
	 */

	// display staff
	@RequestMapping(value = "/api/staff", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> getAllStaffs() {
		System.out.println("hi");
		List list = AdminDaoImpl.listS();
		return list;
	}

	// search staff by id and phone number
	@RequestMapping(value = "/api/staff/{searchString}", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> getStaffById(
			@PathVariable("searchString") String searchString) {
		System.out.println(searchString);
		List list = AdminDaoImpl.getStaff(searchString);
		System.out.println(list);
		return list;
	}

	// Insert and update staff
	/*
	 * @RequestMapping(value = "/api/insertStaff", method = {
	 * RequestMethod.POST, RequestMethod.PUT }) public void
	 * staffInsert(@RequestBody Admin aBean) { if (aBean.getsId() == 0) {
	 * AdminDaoImpl.insertStaff(aBean); } else {
	 * AdminDaoImpl.updateStaff(aBean); }
	 * 
	 * }
	 */
	// Insert and update Staff
	@RequestMapping(value = "/api/insertStaff", method = { RequestMethod.POST,RequestMethod.PUT })
	public void staffInsert(@RequestBody Admin aBean) {
		System.out.println(aBean.getRoleId());
		System.out.println("hits");
		System.out.println(aBean.getsName());
		if (aBean.getsId() != 0) {
			AdminDaoImpl.updateStaff(aBean);
		} else {
			AdminDaoImpl.insertStaff(aBean);
		}

	}

	// Disable Staff
	@RequestMapping(value = "/api/disablestaff/{sId}", method = RequestMethod.PUT)
	void staffDisable(@PathVariable("sId") int sId) {
		AdminDaoImpl.disableStaff(sId);
	}

	// Get all Roles

	@RequestMapping(value = "/api/roles", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> getAllRoles() {
		System.out.println("hi");
		List list = AdminDaoImpl.getAllRoles();
		return list;
	}
	
	//get staff by id

	
	@RequestMapping(value = "/api/editStaffDetail/{sId}", method = RequestMethod.GET,headers = "Accept=application/json")
	public Admin getStaffDetailsById(@ModelAttribute("objF")Admin objF,@PathVariable("sId") int sId)
	{
		System.out.println("HITS : "+sId);
	List list = AdminDaoImpl.getStaffDetailsById(sId);
	System.out.println("LIST : " +list);
	objF=(Admin) list.get(0);
	System.out.println("OBJF : "+objF);
	return objF;
	}
	

}
