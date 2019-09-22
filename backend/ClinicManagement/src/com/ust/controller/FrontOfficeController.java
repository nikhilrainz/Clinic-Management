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



import com.ust.dao.FrontOfficeDaoImpl;
import com.ust.model.FrontOffice;

@RestController
public class FrontOfficeController {

@Autowired
FrontOfficeDaoImpl objFODao;

//display patients
@RequestMapping(value= "/api/patients", method = RequestMethod.GET, headers = "Accept=application/json")

public List<FrontOffice> getAllPatients()
{
List list = objFODao.getPatients();
return list;
}



//search patient by name and phone number
@RequestMapping(value = "/api/patient/{searchString}", method = RequestMethod.GET)
@ResponseBody
public List<FrontOffice> getPatient(@PathVariable("searchString") String searchString) {
System.out.println(searchString);
List list = objFODao.getPatient(searchString);
System.out.println(list);
return list;
}

//search todaysAppoinment by doctorName

@RequestMapping(value = "/api/patientApp/{searchString}", method = RequestMethod.GET)
@ResponseBody
public List<FrontOffice> getTodaysAppoinment(@PathVariable("searchString") String searchString) {
System.out.println(searchString);
List list = objFODao.getTodaysAppoinment(searchString);
System.out.println(list);
return list;
}

//search  by doctorName  for consultation

@RequestMapping(value = "/api/consultdoctor/{sName}", method = RequestMethod.GET)
@ResponseBody
public FrontOffice getDoctorForConsult(@PathVariable("sName") String sName) {
System.out.println(sName);
 return objFODao.getDoctorForConsult(sName);

}

@RequestMapping(value = "/api/insertAppoinment", method = RequestMethod.POST)
public void addDoctorsAppoinment(@RequestBody FrontOffice fob) {
	
	objFODao.addAppoinment(fob);
	
}


@RequestMapping(value = "/api/getAvailableDoctor", method = RequestMethod.GET)
public List<FrontOffice> getAvailableDoctors() {

	List list = objFODao.getAvailableDoctor();
	//System.out.println(list);
	return list;
}
//find required details by Id
@RequestMapping(value = "/api/patdetail/{regId}", method = RequestMethod.GET,headers = "Accept=application/json")
public FrontOffice getPatientDetails(@ModelAttribute("objF")FrontOffice objF,@PathVariable("regId") int regId)
{
FrontOffice fob = objFODao.getPatientDetails(regId,objF);

return fob;
}

// for editing patients
//find required details by Id
@RequestMapping(value = "/api/editpatdetail/{regId}", method = RequestMethod.GET,headers = "Accept=application/json")
public FrontOffice getEditPatientDetails(@ModelAttribute("objF")FrontOffice objF,@PathVariable("regId") int regId)
{
List list = objFODao.getEditPatientDetails(regId);
objF=(FrontOffice) list.get(0);
return objF;
}

/*find a Patient by Name
@RequestMapping(value = "/api/patient/{pFName}", method = RequestMethod.GET, headers = "Accept=application/json")
@ResponseBody
public FrontOffice getPatientByName(@PathVariable("pFName") String pFName)
{
return objFODao.getPatientByName(pFName);
}
*/


//insert Patient and update Patient
@RequestMapping(value = "/api/insertpatient", method = {RequestMethod.POST,RequestMethod.PUT}, produces = "application/json")
public void insert(@RequestBody FrontOffice objF){

if(objF.getRegId()!=0){
objFODao.update(objF);
}
else{
objFODao.save(objF);

}
}

/*update patients
@RequestMapping(value = "/api/updatepatient", method = RequestMethod.PUT, headers = "Accept=application/json")
public void update(@RequestBody FrontOffice objF){


objFODao.update(objF);

}
*/
/*
//display Available Drs
@RequestMapping(value= "/api/availabledr", method = RequestMethod.GET, headers = "Accept=application/json")
public List getAvailableDrByDay(@ModelAttribute("objF") FrontOffice objF)
{
//objFODao.getDay();
List availDrList = objFODao.getAvailableDrByDay();
//System.out.println(now1);
return availDrList;
}*/

//todays appointment
@RequestMapping(value= "/api/appointments", method = RequestMethod.GET)
public List getAppointments(@ModelAttribute("objF")FrontOffice objF)
{
List list = objFODao.getTodaysAppointment();
return list;
}
}