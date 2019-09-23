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




import com.ust.dao.IFrontOfficeDao;
import com.ust.model.FrontOffice;

@RestController
public class FrontOfficeController 
{

	@Autowired
	IFrontOfficeDao objFODao;
	
	//Display patients
	@RequestMapping(value= "/api/patients", method = RequestMethod.GET, 
	headers = "Accept=application/json")
	
	public List<FrontOffice> getAllPatients()
	{
		List list = objFODao.getPatients();
		return list;
	}
	
	//Search patient by name and phone number
	@RequestMapping(value = "/api/patient/{searchString}", method = RequestMethod.GET)
	public List<FrontOffice> getPatient(@PathVariable("searchString") String searchString) 
	{
		List list = objFODao.getPatient(searchString);
		return list;
	}
	
	//search todaysAppoinment by doctorName
	@RequestMapping(value = "/api/patientApp/{searchString}", method = RequestMethod.GET)
	public List<FrontOffice> getTodaysAppoinment(@PathVariable("searchString") String searchString) 
	{
		List list = objFODao.getTodaysAppoinment(searchString);
		return list;
	}
	
	//search  by doctorName  for consultation
	@RequestMapping(value = "/api/consultdoctor/{sName}", method = RequestMethod.GET)
	public FrontOffice getDoctorForConsult(@PathVariable("sName") String sName)
	{
		return objFODao.getDoctorForConsult(sName);
	}
	
	//Make appointment
	@RequestMapping(value = "/api/insertAppoinment", method = RequestMethod.POST)
	public void addDoctorsAppoinment(@RequestBody FrontOffice fob) 
	{
		objFODao.addAppoinment(fob);	
	}
	
	//Getting Available Doctor List
	@RequestMapping(value = "/api/getAvailableDoctor", method = RequestMethod.GET)
	public List<FrontOffice> getAvailableDoctors() 
	{
		List list = objFODao.getAvailableDoctor();
		return list;
	}
	
	//Find required details by Id
	@RequestMapping(value = "/api/patdetail/{regId}", 
					method = RequestMethod.GET,
					headers = "Accept=application/json")
	public FrontOffice getPatientDetails(@ModelAttribute("objF")FrontOffice objF,@PathVariable("regId") int regId)
	{
		FrontOffice fob = objFODao.getPatientDetails(regId,objF);
	
		return fob;
	}
	
	// For editing patients
	@RequestMapping(value = "/api/editpatdetail/{regId}", 
					method = RequestMethod.GET,
					headers = "Accept=application/json")
	public FrontOffice getEditPatientDetails(@ModelAttribute("objF")FrontOffice objF,@PathVariable("regId") int regId)
	{
		List list = objFODao.getEditPatientDetails(regId);
		objF=(FrontOffice) list.get(0);
		return objF;
	}
	
	//insert Patient and update Patient
	@RequestMapping(value = "/api/insertpatient", method = {RequestMethod.POST,RequestMethod.PUT},
					produces = "application/json")
	public void insert(@RequestBody FrontOffice objF)
	{
		if(objF.getRegId()!=0)
		{
			objFODao.update(objF);
		}
		else
		{
			objFODao.save(objF);
	
		}
	}
	
	//Todays Appointment
	@RequestMapping(value= "/api/appointments", method = RequestMethod.GET)
	public List getAppointments(@ModelAttribute("objF")FrontOffice objF)
	{
		List list = objFODao.getTodaysAppointment();
		return list;
	}
}