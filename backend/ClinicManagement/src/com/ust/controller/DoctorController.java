package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.DoctorDaoImpl;
import com.ust.model.Doctor;
import com.ust.model.FrontOffice;

@RestController
public class DoctorController {
	@Autowired
	DoctorDaoImpl dao;

	//GETTING DOCTOR ID FOR VALIDATING DOCTOR
	@RequestMapping(value = "/api/doctordId/{username}/{password}",method = RequestMethod.GET)
	public Doctor getdId(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		System.out.println(username);
		System.out.println(password);
		return dao.getdId(username,password);
		
	}
	
	// get all medicines
	@ResponseBody
	@RequestMapping(value = "/api/doctor/medicine", method = RequestMethod.GET)
	public List getAllMedicines() {

		List medicinelist = dao.getAllMedicines();
		return medicinelist;
	}

	/*
	 * //get todays appointment list of patients
	 * 
	 * @RequestMapping(value = "/api/doctor/appoinment/{date}", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public List getTodaysAppoinment(@ModelAttribute("doc")
	 * Doctor doc, @PathVariable("date") String date) {
	 * 
	 * List appoinmentlist = dao.getTodaysAppoinment(date); return
	 * appoinmentlist;
	 * 
	 * }
	 */

	/*
	 * //get doctors appointment
	 * 
	 * @RequestMapping(value = "/api/doctor/drappoinment/{dId}", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public List getDoctorsAppoinment(@ModelAttribute("doc")
	 * Doctor doc, @PathVariable("dId") int dId) {
	 * 
	 * System.out.println(dId); List drappoinmentlist =
	 * dao.getDoctorsAppoinment(dId); return drappoinmentlist;
	 * 
	 * }
	 */

	/*
	 * //RequestMapping to get the appointments of each doctor
	 * 
	 * @RequestMapping(value = "/api/getdoctorsappointment/{dId}",method =
	 * RequestMethod.GET) public List<Doctor>
	 * getDoctorsApponintment(@PathVariable("dId") int dId) { List list =
	 * dao.getDoctorsAppointment(dId);
	 * 
	 * return list; }
	 */
	// RequestMapping to get the appointments of each doctor
	@RequestMapping(value = "/api/getdoctorsappointment/{dId}", method = RequestMethod.GET)
	public List<Doctor> getDoctorsApponintment(@PathVariable("dId") int dId) {
		System.out.println("DOCT CONTROLLER : " + dId);
		List list = dao.getDoctorsAppointment(dId);

		return list;
	}
	
	// get all test details
		@ResponseBody
		@RequestMapping(value = "/api/doctor/test", method = RequestMethod.GET)
		public List getAllTest() {

			List testlist = dao.getAllTest();
			return testlist;
		}


	// insert lab Request
	@RequestMapping(value = "/api/doctor/insertlab", method = RequestMethod.POST)
	public void getAddLabRequest(@RequestBody Doctor d) {
		dao.getAddLabRequest(d);

	}

	//getall lab prescription
	@RequestMapping(value = "/api/alllabpreslist/{regId}/{dId}", method = RequestMethod.GET)
	 public List<Doctor> getAllLabPrescription(@PathVariable("regId") int regId ,@PathVariable("dId") int dId )
	 {
	    List presList=dao.getAlllabPrescription(regId , dId);
	return presList;
	 }



	//delete lab presc
	@RequestMapping(value="/api/doctor/deletelab/{assignLabId}",headers="Accept=Application/json",method= RequestMethod.DELETE)
	public void deleteLab(@RequestBody Doctor d,@PathVariable("assignLabId") int assignLabId )
	{
	dao.lab_delete(assignLabId);

	}

	// get doctor observation

	// insert patient comments
	@RequestMapping(value = "/api/doctor/docObservation", method = RequestMethod.POST)
	public void getPatientComments(@RequestBody Doctor d) {
		dao.getPatientComments(d);

	}

	// add medicine prescription by doctor

	
	// patient history

	@RequestMapping(value = "/api/labtests/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllPrescription(@PathVariable("regId") int regId) {
		List list = dao.getAllPrescrip(regId);
		return list;
	}

	@RequestMapping(value = "/api/labtestshis/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllLabTestsHistory(@PathVariable("regId") int regId) {
		List list = dao.lablistHistory(regId);
		return list;
	}

	// controller
	@RequestMapping(value = "/api/Obsshis/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllObservationsHistory(
			@PathVariable("regId") int regId) {
		List list = dao.ObslistHistory(regId);
		return list;
	}

	@RequestMapping(value = "/api/details/{regId}", method = RequestMethod.GET)
	public List<Doctor> pDetails(@PathVariable("regId") int regId) {
		List list = dao.pDetails(regId);
		return list;
	}

	// prescription
	@RequestMapping(value = "/api/insertpres", method = RequestMethod.POST)
	public void insertDoctorPrescription(@RequestBody Doctor doc) {
		System.out.println("insert prescr");
		dao.saveDoctorPrescription(doc);

	}

	@RequestMapping(value = "/api/medlists", method = RequestMethod.GET)
	public List<Doctor> getAllMedicineList() {
		List list = dao.getAllMedicines();
		return list;
	}

	@RequestMapping(value = "/api/allpreslist/{regId}/{dId}", method = RequestMethod.GET)
	public List<Doctor> getAllPrescription(@PathVariable("regId") int regId,
			@PathVariable("dId") int dId) {
		List presList = dao.getAllPrescription(regId, dId);
		return presList;
	}

	/*
	 * @RequestMapping(value = "api/patientHistory", headers =
	 * "Accept=application/json", method = RequestMethod.GET) public List
	 * viewPatientHistory(@ModelAttribute("db") Doctor db) { //List patHis =
	 * ddao.viewPatientHistory(regId); List patHis = dao.viewPatientHistory();
	 * return patHis; }
	 */

	// search todaysAppoinment by patientName

	@RequestMapping(value = "/api/doctorApp/{searchString}", method = RequestMethod.GET)
	@ResponseBody
	public List<Doctor> getTodaysAppoinment(
			@PathVariable("searchString") String searchString) {
		System.out.println(searchString);
		List list = dao.getTodaysAppoinment1(searchString);
		System.out.println(list);
		return list;
	}
}
