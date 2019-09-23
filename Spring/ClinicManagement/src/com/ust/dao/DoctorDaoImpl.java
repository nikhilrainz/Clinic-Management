package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Admin;
import com.ust.model.Doctor;
import com.ust.model.FrontOffice;

public class DoctorDaoImpl implements IDoctorDao 
{
	// jdbc template
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;

	}
	
	
	// Get Doctors Appointment by Id

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getDoctorsAppointment(int)
	 */
	@Override
	public List<Doctor> getDoctorsAppointment(int dId) 
	{
		return template	.query("select appId,regId,dId,pFName,pLName,pGender,consultStatus from cm_PatientTable "
				+ "join cm_AppoinmentTable using(regId) where dId = "
						+ dId
						+ " and dateOfApp = TO_DATE('"
						+ java.time.LocalDate.now() + "' ,'YYYY-MM-DD') ",
						new RowMapper<Doctor>() 
						{
							public Doctor mapRow(ResultSet rs, int row) throws SQLException 
							{
								Doctor db = new Doctor();
								db.setAppId(rs.getInt(1));
								db.setRegId(rs.getInt(2));
								db.setdId(rs.getInt(3));
								db.setpFName(rs.getString(4));
								db.setpLName(rs.getString(5));
								db.setpGender(rs.getString(6));
								db.setConsultStatus(rs.getString(7));
								return db;
							}
						});
	}

	// getting dId for doctors appoinment

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getdId(java.lang.String, java.lang.String)
	 */
	@Override
	public Doctor getdId(String username, String password) 
	{
		String sql = "select did  from cm_doctortable join cm_stafftable using(sid) where roleid = 3 and username= ? and password = ?";
		return template.queryForObject(sql,
				new Object[] { username, password },
				new BeanPropertyRowMapper<Doctor>(Doctor.class));

	}

	// get all medicines
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAllMedicines()
	 */
	@Override
	public List<Doctor> getAllMedicines() 
	{
		return template.query("select medId,medName from cm_medicineTable where isActive = 1",
		new RowMapper<Doctor>() 
		{
			public Doctor mapRow(ResultSet rs, int row) throws SQLException {
				Doctor d = new Doctor();
				d.setMedId(rs.getInt(1));
				d.setMedName(rs.getString(2));
				System.out.println(d);
				return d;
		}
		});
	}

	//Fetching labId From labtest table
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#d_getLabId(java.lang.String)
	 */
	@Override
	public Integer d_getLabId(String lName) 
	{
		String sql = "select labId from cm_labTestTable where lName =?";
		return template.queryForObject(sql, new Object[] { lName },
				Integer.class);
	}

	// add lab request
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAddLabRequest(com.ust.model.Doctor)
	 */
	@Override
	public int getAddLabRequest(Doctor dr) 
	{
		Integer labId = d_getLabId(dr.getlName());
		String sql = "insert into cm_assignLabTable(assigLabDate,regId,dId,labId)values(TO_DATE('"
				+ java.time.LocalDate.now()
				+ "','YYYY-MM-DD'),"
				+ dr.getRegId() + "," + dr.getdId() + "," + labId + ")";
		return template.update(sql);
	}

	// get all test
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAllTest()
	 */
	@Override
	public List<Doctor> getAllTest() 
	{
		return template.query("select labId,lName from cm_labTestTable",
				new RowMapper<Doctor>() 
				{
					@Override
					public Doctor mapRow(ResultSet rs, int row) throws SQLException 
					{
						Doctor doc = new Doctor();
						doc.setLabId(rs.getInt(1));
						doc.setlName(rs.getString(2));
						return doc;

					}
				});
	}

	// getAllLabprescription

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAlllabPrescription(int, int)
	 */
	@Override
	public List<Doctor> getAlllabPrescription(int regId, int dId) 
	{
		return template.query("select labId,lName,assignLabId from cm_assignLabTable join cm_LabTestTable using(labId) join cm_doctorTable using (dId) where trunc(assigLabDate) = trunc(sysdate)and regId="
						+ regId + " and dId=" + dId + "",
				new RowMapper<Doctor>() 
				{
					public Doctor mapRow(ResultSet rs, int row)	throws SQLException 
					{
						Doctor db = new Doctor();
						db.setLabId(rs.getInt(1));
						db.setlName(rs.getString(2));
						db.setAssignLabId(rs.getInt(3));

						return db;
					}
				});
	}

	//Delete a Lab Test
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#lab_delete(int)
	 */
	@Override
	public int lab_delete(int assignLabId) 
	{
		String sql = "delete from cm_assignLabTable where assignLabId= "+assignLabId;
		return template.update(sql);
	}

	// add patient comments
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getPatientComments(com.ust.model.Doctor)
	 */
	@Override
	public int getPatientComments(Doctor doctor) 
	{
		String sql = "insert into cm_doctorObsTable(obserDate,obsNotes,regId,dId)values(TO_DATE('"
				+ java.time.LocalDate.now()
				+ "','YYYY-MM-DD'),'"
				+ doctor.getObsNotes()
				+ "',"
				+ doctor.getRegId()
				+ ","
				+ doctor.getdId() + ")";
		return template.update(sql);
	}

	// add medicine prescription by doctor
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getMedicineId(java.lang.String)
	 */
	@Override
	public int getMedicineId(String mName) 
	{
		String sql = "select medId from cm_medicineTable where medName = ?";
		return template.queryForObject(sql, new Object[] { mName },
				Integer.class);

	}

	//Save DOctors prescription
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#saveDoctorPrescription(com.ust.model.Doctor[])
	 */
	@Override
	public int saveDoctorPrescription(Doctor d[]) 
	{
		int arrayObjLength = d.length;
		int[] a = new int[arrayObjLength];
		for (int i = 0; i < arrayObjLength; i++) 
		{
			String mName = d[i].getMedName();
			int id = getMedicineId(mName);
			System.out.println("mED iD" + id);
			String sql = "insert into cm_prescriptionTable(dId,regId,medId,medFreq,medDays,prescDate,pharmacyStatus) values("
					+ d[i].getdId()
					+ ","
					+ d[i].getRegId()
					+ ",?,'"
					+ d[i].getMedFreq()
					+ "',"
					+ d[i].getMedDays()
					+ ",TO_DATE('"
					+ java.time.LocalDate.now()
					+ "', 'YYYY-MM-DD'),'" + d[i].getPharmacyStatus() + "')";

			a[i] = template.update(sql, new Object[] { id });
		}
		return 1;

	}

	// view patient history

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAllPrescrip(int)
	 */
	@Override
	public List<Doctor> getAllPrescrip(int regId) {
		return template
				.query("select prescId,medName,prescDate,sName from cm_PrescriptionTable join cm_MedicineTable using(medId) join cm_doctorTable using(dId) join cm_staffTable using(sId) where regId = "
						+ regId + "", new RowMapper<Doctor>() {
					public Doctor mapRow(ResultSet rs, int row)
							throws SQLException {
						Doctor db = new Doctor();
						db.setPrescId(rs.getInt(1));
						db.setMedName(rs.getString(2));
						db.setPrescDate(rs.getDate(3));
						db.setsName(rs.getString(4));

						return db;
					}
				});
	}

	//Observation History
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#ObslistHistory(int)
	 */
	@Override
	public List<Doctor> ObslistHistory(int regId) 
	{
		return template.query("select cm_doctorObsTable.obsNotes ,cm_doctorObsTable.obserDate,cm_StaffTable.sName from cm_doctorObsTable join cm_doctorTable on(cm_doctorObsTable.dId = cm_doctorTable.dId) join cm_StaffTable on(cm_doctorTable.sId = cm_StaffTable.sId)where regId = "
						+ regId + "", new RowMapper<Doctor>() 
						{
							public Doctor mapRow(ResultSet rs, int row) throws SQLException 
							{
								Doctor db = new Doctor();
								db.setObsNotes(rs.getString(1));
								db.setObserDate(rs.getDate(2));
								db.setsName(rs.getString(3));
								return db;
							}
						});
	}

	// View patient Details
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#pDetails(int)
	 */
	@Override
	public List<Doctor> pDetails(int regId) 
	{
		return template.query("select regId,pFName,DOB,pbloodGrp from cm_patientTable "
				+ "where regId = "+ regId + "", 
				new RowMapper<Doctor>() 
				{
					public Doctor mapRow(ResultSet rs, int row)	throws SQLException 
					{
						Doctor dctr = new Doctor();
						dctr.setRegId(rs.getInt(1));
						dctr.setpFName(rs.getString(2));
						dctr.setpDOB(rs.getDate(3));
						dctr.setpBloodGrp(rs.getString(4));
						return dctr;
					}
				});
	}

	// Lab history Details
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#lablistHistory(int)
	 */
	@Override
	public List<Doctor> lablistHistory(int regId) 
	{
		return template.query("select labId,lName,sName from cm_labTesttable join "
						+ "cm_assignlabtable using(labId) join cm_doctorTable using(dId) "
						+ "join cm_staffTable using(sId) where regId = "
						+ regId + "", 
						new RowMapper<Doctor>() 
						{
							public Doctor mapRow(ResultSet rs, int row) throws SQLException 
							{
								Doctor db = new Doctor();
								db.setLabId(rs.getInt(1));
								db.setlName(rs.getString(2));
								db.setsName(rs.getString(3));
								return db;
							}
						});
	}

	// Save Doctor Prescription
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#saveDoctorPrescription(com.ust.model.Doctor)
	 */
	@Override
	public int saveDoctorPrescription(Doctor doc) 
	{
		Integer medId = getMedicineId(doc.getMedName());
		String sql = "insert into cm_prescriptionTable(dId,regId,medId,medFreq,medDays,prescDate) values("
				+ doc.getdId()
				+ ", "
				+ doc.getRegId()
				+ ",?,'"
				+ doc.getMedFreq()
				+ "',"
				+ doc.getMedDays()
				+ ",TO_DATE('"
				+ java.time.LocalDate.now() + "', 'YYYY-MM-DD'))";
		return template.update(sql, new Object[] { medId });
	}

	// getAllprescription

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getAllPrescription(int, int)
	 */
	@Override
	public List<Doctor> getAllPrescription(int regId, int dId) 
	{
		return template.query("select p.dId,p.regId,p.prescId,p.prescdate,p.medDays , p.medFreq ,m.medName from cm_prescriptiontable p join cm_medicineTable m on p.medid=m.medid where trunc(prescdate) = trunc(sysdate) and regId = "
						+ regId + "and dId=" + dId + " ",

				new RowMapper<Doctor>() 
				{
					public Doctor mapRow(ResultSet rs, int row) throws SQLException 
					{
						Doctor db = new Doctor();
						db.setdId(rs.getInt(1));
						db.setRegId(rs.getInt(2));
						db.setPrescId(rs.getInt(3));
						db.setPrescDate(rs.getDate(4));
						db.setMedDays(rs.getInt(5));
						db.setMedFreq(rs.getString(6));
						db.setMedName(rs.getString(7));
						return db;
					}
				});
	}
	
	//Delete prescription
	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#presc_delete(int)
	 */
	@Override
	public int presc_delete(int prescId) 
	{
		String sql = "delete from cm_prescriptionTable where prescId= "
				+ prescId;
		return template.update(sql);
	}

	// search doctors todays appoinment by patient name

	/* (non-Javadoc)
	 * @see com.ust.dao.IDoctorDao#getTodaysAppoinment1(java.lang.String)
	 */
	@Override
	public List<Doctor> getTodaysAppoinment1(String searchString) 
	{
		return template.query(" select appid,regid,pfname,consultstatus from cm_appoinmenttable app "
						+ "join cm_patienttable pat using (regid) where  pfname= '"
						+ searchString
						+ "' and trunc(dateOfApp)=trunc(sysdate)",
						new RowMapper<Doctor>() 
						{
							public Doctor mapRow(ResultSet rs, int row)
									throws SQLException {

								Doctor adm = new Doctor();
								adm.setAppId(rs.getInt(1));
								adm.setRegId(rs.getInt(2));
								adm.setpFName(rs.getString(3));
								adm.setConsultStatus(rs.getString(4));

								return adm;
						}
					});

	}

}
