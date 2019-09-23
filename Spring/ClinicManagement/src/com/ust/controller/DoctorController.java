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

import com.ust.dao.IDoctorDao;
import com.ust.model.Doctor;
import com.ust.model.FrontOffice;

@RestController
public class DoctorController 
{
	@Autowired
	IDoctorDao dao;

	//GETTING DOCTOR ID FOR VALIDATING DOCTOR
	@RequestMapping(value = "/api/doctordId/{username}/{password}",method = RequestMethod.GET)
	public Doctor getdId(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		return dao.getdId(username,password);	
	}
	
	// Get all medicines
	@RequestMapping(value = "/api/doctor/medicine", method = RequestMethod.GET)
	public List getAllMedicines() 
	{
		List medicinelist = dao.getAllMedicines();
		return medicinelist;
	}

	// RequestMapping to get the appointments of each doctor
	@RequestMapping(value = "/api/getdoctorsappointment/{dId}", method = RequestMethod.GET)
	public List<Doctor> getDoctorsApponintment(@PathVariable("dId") int dId) {
		System.out.println("DOCT CONTROLLER : " + dId);
		List list = dao.getDoctorsAppointment(dId);

		return list;
	}
	
	// Get all test details
	@RequestMapping(value = "/api/doctor/test", method = RequestMethod.GET)
	public List getAllTest() 
	{
		List testlist = dao.getAllTest();
		return testlist;
	}

	// Insert lab Request
	@RequestMapping(value = "/api/doctor/insertlab", method = RequestMethod.POST)
	public void getAddLabRequest(@RequestBody Doctor d) 
	{
		dao.getAddLabRequest(d);
	}

	//Getall lab prescription
	@RequestMapping(value = "/api/alllabpreslist/{regId}/{dId}", method = RequestMethod.GET)
	 public List<Doctor> getAllLabPrescription(@PathVariable("regId") int regId ,@PathVariable("dId") int dId )
	 {
	    List presList=dao.getAlllabPrescription(regId , dId);
	    return presList;
	 }

	//Delete lab request
	@RequestMapping(value="/api/doctor/deletelab/{assignLabId}",method= RequestMethod.DELETE)
	public void deletePresc(@PathVariable("assignLabId") int assignLabId )
	{
		dao.lab_delete(assignLabId);
	}
	
	// Get doctor observation

	// insert patient comments
	@RequestMapping(value = "/api/doctor/docObservation", method = RequestMethod.POST)
	public void getPatientComments(@RequestBody Doctor d) 
	{
		dao.getPatientComments(d);
	}

	// Add medicine prescription by doctor
					
			/* patient history */

	//Getting prescription details of each patient
	@RequestMapping(value = "/api/labtests/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllPrescription(@PathVariable("regId") int regId)
	{
		List list = dao.getAllPrescrip(regId);
		return list;
	}

	//Getting Lab Test history
	@RequestMapping(value = "/api/labtestshis/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllLabTestsHistory(@PathVariable("regId") int regId) 
	{
		List list = dao.lablistHistory(regId);
		return list;
	}

	// Getting Observation History
	@RequestMapping(value = "/api/Obsshis/{regId}", method = RequestMethod.GET)
	public List<Doctor> getAllObservationsHistory(@PathVariable("regId") int regId) 
	{
		List list = dao.ObslistHistory(regId);
		return list;
	}

	//Getting Patient Details for Auto-generation
	@RequestMapping(value = "/api/details/{regId}", method = RequestMethod.GET)
	public List<Doctor> pDetails(@PathVariable("regId") int regId) 
	{
		List list = dao.pDetails(regId);
		return list;
	}

	// Add New Prescription
	@RequestMapping(value = "/api/insertpres", method = RequestMethod.POST)
	public void insertDoctorPrescription(@RequestBody Doctor doc) 
	{
		dao.saveDoctorPrescription(doc);
	}

	@RequestMapping(value = "/api/medlists", method = RequestMethod.GET)
	public List<Doctor> getAllMedicineList() 
	{
		List list = dao.getAllMedicines();
		return list;
	}

	
	@RequestMapping(value = "/api/allpreslist/{regId}/{dId}", method = RequestMethod.GET)
	public List<Doctor> getAllPrescription(@PathVariable("regId") int regId,
			@PathVariable("dId") int dId) 
	{
		List presList = dao.getAllPrescription(regId, dId);
		return presList;
	}
	
	//delete prescription
	@RequestMapping(value="/api/doctor/deletepres/{prescId}",method= RequestMethod.DELETE)
	public void deleteLab(@PathVariable("prescId") int prescId )
	{
		dao.presc_delete(prescId);
	}

	// search doctors todaysAppoinment by patientName

	@RequestMapping(value = "/api/doctorApp/{searchString}", method = RequestMethod.GET)
	public List<Doctor> getTodaysAppoinment(@PathVariable("searchString") String searchString) 
	{
		List list = dao.getTodaysAppoinment1(searchString);
		return list;
	}
	
}
