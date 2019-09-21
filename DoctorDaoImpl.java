package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.ust.model.Doctor;

public class DoctorDaoImpl {

	// jdbc template
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;

	}

/*// getting todays appointment
public List<Doctor> getTodaysAppoinment(String searchString) {
	System.out.println(searchString);
	return template.query("select ca.appId,ca.regId,pFName,pLName,consultStatus"
			+ " from cm_appoinmentTable ca join cm_patientTable cp"
			+ " on ca.regId=cp.regId join cm_doctorTable cd on ca.dId=cd.dId" + " where ca.dateOfApp='"+searchString+"'",

			new RowMapper<Doctor>() {

				public Doctor mapRow(Result, int row) throws SQLException {
					Doctor dr = new Doctor();
					dr.setAppId(rs.getInt(1));
					dr.setRegId(rs.getInt(2));
					dr.setpFName(rs.getString(3));
					dr.setpLName(rs.getString(4));
					dr.setConsultStatus(rs.getString(5));
					System.out.println(dr);
					return dr;
				}
			});
}*/

/*// getting doctors appointment
public List<Doctor> getDoctorsAppoinment(int dId) {
	System.out.println(dId);
	return template.query(
			"select ca.appId,ca.regId,pFName,pLName,consultStatus"
					+ " from cm_appoinmentTable ca join cm_patientTable cp"
					+ " on ca.regId=cp.regId join cm_doctorTable cd on ca.dId=cd.dId"
					+ " where cd.dId="+dId+"",

			new RowMapper<Doctor>() {

				public Doctor mapRow(ResultSet rs, int row) throws SQLException {
					Doctor doct = new Doctor();
					doct.setAppId(rs.getInt(1));
					doct.setRegId(rs.getInt(2));
					doct.setpFName(rs.getString(3));
					doct.setpLName(rs.getString(4));
					doct.setConsultStatus(rs.getString(5));
					System.out.println(doct);
					return doct;
				}
			});
}
*/
	
	public List<Doctor> getDoctorsAppointment(int dId) {
	return template.query(
	"select appId,regId,pFName,pLName,pGender,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
	+ dId + " and dateOfApp = TO_DATE('" + java.time.LocalDate.now() + "' ,'YYYY-MM-DD') ",
	new RowMapper<Doctor>() {
	public Doctor mapRow(ResultSet rs, int row) throws SQLException {
	Doctor db = new Doctor();
	db.setAppId(rs.getInt(1));
	db.setRegId(rs.getInt(2));
	db.setpFName(rs.getString(3));
	db.setpLName(rs.getString(4));
	db.setpGender(rs.getString(5));
	db.setConsultStatus(rs.getString(6));
	return db;
	}
	});
	}
// get all medicines
public List<Doctor> getAllMedicines() {
	return template.query("select medName from cm_medicineTable",

			new RowMapper<Doctor>() {

				public Doctor mapRow(ResultSet rs, int row) throws SQLException {
					Doctor d = new Doctor();
					d.setMedName(rs.getString(1));
					System.out.println(d);
					return d;
				}
			});
}

// add lab request
public int getAddLabRequest(Doctor dr) {
	String sql = "insert into cm_assignLabTable(assigLabDate,regId,dId,labId)values(TO_DATE('"+java.time.LocalDate.now()+"','YYYY-MM-DD')," + dr.getRegId() + ","
			+ dr.getdId() + "," + dr.getLabId() + ")";
	return template.update(sql);
}

//get all test
public List<Doctor> getAllTest() {
	return template.query("select labId,lName from cm_labTestTable", new RowMapper<Doctor>() {

		@Override
		public Doctor mapRow(ResultSet rs, int row) throws SQLException {

			Doctor doc = new Doctor();
			doc.setLabId(rs.getInt(1));
			doc.setlName(rs.getString(2));
			return doc;

		}
	});

}

//add patient comments
public int getPatientComments(Doctor doctor)
{
String sql = "insert into cm_doctorObsTable(obserDate,obsNotes,regId,dId)values(TO_DATE('"+java.time.LocalDate.now()+"','YYYY-MM-DD'),'"+ 
		 doctor.getObsNotes()+ "'," + doctor.getRegId() + ","+doctor.getdId()+")";
return template.update(sql);
}

//add medicine prescription by doctor
public int getMedicineId(String mName) {
	String sql = "select medId from cm_medicineTable where medName = ?";
	return template.queryForObject(sql, new Object[] { mName }, Integer.class);
	
}

public int saveDoctorPrescription(Doctor d[]) {
	System.out.println("hiii");
	int arrayObjLength = d.length;
	int[] a = new int[arrayObjLength];
	for (int i = 0; i < arrayObjLength; i++) {
		String mName = d[i].getMedName();
		int id = getMedicineId(mName);
		System.out.println("mED iD" + id);
		String sql = "insert into cm_prescriptionTable(dId,regId,medId,medFreq,medDays,prescDate,pharmacyStatus) values("
				+ d[i].getdId() + "," + d[i].getRegId() + ",?,'" + d[i].getMedFreq() + "'," + d[i].getMedDays()
				+ ",TO_DATE('" + java.time.LocalDate.now() + "', 'YYYY-MM-DD'),'" + d[i].getPharmacyStatus() + "')";

		a[i] = template.update(sql, new Object[] { id });
	}
	return 1;

}
}

