package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.FrontOffice;

public class FrontOfficeDaoImpl implements IFrontOfficeDao {

	// to interact with db
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
	}

	// method save to insert record into db table
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#save(com.ust.model.FrontOffice)
	 */
	@Override
	public int save(FrontOffice objFO) 
	{

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(objFO.getpDOB());

		String sql = "insert into cm_patientTable(pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate) values ('"
				+ objFO.getpFName()
				+ "','"
				+ objFO.getpLName()
				+ "','"
				+ objFO.getpGender()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"
				+ ",'"
				+ objFO.getpAddr()
				+ "','"
				+ objFO.getpPhNo()
				+ "','"
				+ objFO.getpBloodGrp()
				+ "',"
				+ "TO_DATE('" + java.time.LocalDate.now() + "','yyyy/MM/dd'))";
		return template.update(sql);

	}

	// method update to update db table
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#update(com.ust.model.FrontOffice)
	 */
	@Override
	public int update(FrontOffice objFO) 
	{

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(objFO.getpDOB());

		String sql = "update cm_patientTable set pFName='" + objFO.getpFName()
				+ "',pLName='" + objFO.getpLName() + "',pGender='"
				+ objFO.getpGender() + "',DOB=TO_DATE('" + sqlDate
				+ "' ,'yyyy-MM-dd')" + ",pAddr='" + objFO.getpAddr()
				+ "',pPhNo='" + objFO.getpPhNo() + "',pBloodGrp='"
				+ objFO.getpBloodGrp() + "' where regId=" + objFO.getRegId()
				+ "";
		return template.update(sql);

	}

	// age Calculation
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#ageCalculation(java.util.Date)
	 */
	@Override
	public int ageCalculation(Date s) 
	{
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(s);
		System.out.println(sqlDate);
		String s1 = sqlDate.substring(0, 4);
		int now1 = Integer.parseInt(s1);
		System.out.println("year: " + now1);

		int now2 = s.getMonth();
		System.out.println(now2);

		int now3 = s.getDate();
		System.out.println(now3);

		LocalDate l = LocalDate.of(now1, now2, now3);
		System.out.println(l);

		// gets local date
		LocalDate now4 = LocalDate.now();
		Period diff = Period.between(l, now4);
		System.out.println(diff);

		int age = diff.getYears();
		System.out.println("age: " + age);

		return age;
	}

	// search patient by name and phone number

	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getPatient(java.lang.String)
	 */
	@Override
	public List<FrontOffice> getPatient(String searchString) 
	{
		return template.query("select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where  pFName= '"
						+ searchString + "' or pPhNo='" + searchString + "'",
						new RowMapper<FrontOffice>() 
						{
							public FrontOffice mapRow(ResultSet rs, int row)
									throws SQLException 
									{
										FrontOffice adm = new FrontOffice();
										adm.setRegId(rs.getInt(1));
										adm.setpFName(rs.getString(2));
										adm.setpLName(rs.getString(3));
										adm.setpGender(rs.getString(4));
										adm.setpDOB(rs.getDate(5));
										adm.setpAddr(rs.getString(6));
										adm.setpPhNo(rs.getString(7));
										adm.setpBloodGrp(rs.getString(8));
										adm.setCreatedDateP(rs.getDate(9));
		
										return adm;
									}
						});

	}

	// method to get required details
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getPatientDetails(int, com.ust.model.FrontOffice)
	 */
	@Override
	public FrontOffice getPatientDetails(int regId, FrontOffice objFO) 
	{
		Date dob1 = getdob(regId);
		int newAge = ageCalculation(dob1);
		String sql = "select regId,pFName,pLName,pAddr,pGender,DOB,pPhNo,pBloodGrp from cm_patientTable where regId=?";
		FrontOffice fobNew = template.queryForObject(sql,
			new Object[] { regId }, new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));
		fobNew.setAge(newAge);
		return fobNew;
	}

	//Getting DOB using regId
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getdob(int)
	 */
	@Override
	public Date getdob(int regId) 
	{
		String sql2 = "select DOB from cm_patientTable where regId=" + regId
				+ "";
		Date dob = template.queryForObject(sql2, new Object[] {}, Date.class);
		return dob;
	}

	// method to get all patients
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getPatients()
	 */
	@Override
	public List<FrontOffice> getPatients() 
	{
		return template.query("select regId,pFName,pLName,pGender,"
				+ "DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable",
						new RowMapper<FrontOffice>() 
						{
							public FrontOffice mapRow(ResultSet rs, int row) throws SQLException 
							{
								FrontOffice objF = new FrontOffice();
								objF.setRegId(rs.getInt(1));
								objF.setpFName(rs.getString(2));
								objF.setpLName(rs.getString(3));
								objF.setpGender(rs.getString(4));
								objF.setpDOB(rs.getDate(5));
								objF.setpAddr(rs.getString(6));
								objF.setpPhNo(rs.getString(7));
								objF.setpBloodGrp(rs.getString(8));
								objF.setCreatedDateP(rs.getDate(9));
								return objF;
							}
						});
	}
	
	//Getting Day From Week
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getDay()
	 */
	@Override
	public DayOfWeek getDay() 
	{
		LocalDate now = LocalDate.now();
		DayOfWeek now1 = now.getDayOfWeek();
		System.out.println(now1);
		return now1;
	}

	// method to get Todays Appointment
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getTodaysAppointment()
	 */
	@Override
	public List<FrontOffice> getTodaysAppointment() 
	{
		return template.query("select regId,pFName,pGender,appId,dId,sName from cm_patientTable join cm_appoinmentTable using (regId) join cm_doctorTable using (dId) join cm_staffTable using (sId) where trunc(dateOfApp)=trunc(sysdate)",
						new RowMapper<FrontOffice>() 
						{
							public FrontOffice mapRow(ResultSet rs, int row) throws SQLException 
							{
								FrontOffice objF = new FrontOffice();
								objF.setRegId(rs.getInt(1));
								objF.setpFName(rs.getString(2));

								objF.setpGender(rs.getString(3));
								objF.setAppId(rs.getInt(4));
								objF.setdId(rs.getInt(5));
								objF.setsName(rs.getString(6));
								return objF;
							}
						});
	}

	// search todays appoinment by doctor name

	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getTodaysAppoinment(java.lang.String)
	 */
	@Override
	public List<FrontOffice> getTodaysAppoinment(String searchString) 
	{
		return template.query("select regId,pFName,sName from cm_patientTable pat join cm_appoinmentTable app using(regId) join cm_doctorTable doc on (app.dId=doc.dId) join cm_staffTable stf on(doc.sId=stf.sId) where  sName= '"
						+ searchString + "'", new RowMapper<FrontOffice>() 
						{
							public FrontOffice mapRow(ResultSet rs, int row) throws SQLException 
							{
								FrontOffice adm = new FrontOffice();
								adm.setRegId(rs.getInt(1));
								adm.setpFName(rs.getString(2));
								adm.setsName(rs.getString(3));
								return adm;
							}
						});

	}
	
	// search doctor by name for consultation
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getDoctorForConsult(java.lang.String)
	 */
	@Override
	public FrontOffice getDoctorForConsult(String sName) 
	{	
		String sql ="select cm_doctorTable.dId, cm_staffTable.sName,cm_doctorTable.dSpec,cm_doctorTable.consultFee,cm_staffTable.sPhNo from cm_doctorTable join cm_staffTable on cm_doctorTable.sId  =cm_staffTable.sId where sName=? and cm_staffTable.isActive='yes' ";
					return template.queryForObject(sql, new Object[] {sName},new BeanPropertyRowMapper<FrontOffice>(FrontOffice.class));			
	}
	
	//Getting the exact day from Week
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getToday()
	 */
	@Override
	public DayOfWeek getToday()
	{
		LocalDate date=LocalDate.now();
		DayOfWeek now=date.getDayOfWeek();
		return now;
	}
	
	// Get available doctor
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getAvailableDoctor()
	 */
	@Override
	public List<FrontOffice> getAvailableDoctor()
	{
		DayOfWeek today=getToday();
		
		String sql="select sName,dSpec,consultFee,cm_consultDaysTable.dId from cm_doctorTable join cm_staffTable on cm_doctorTable.sId=cm_staffTable.sId join cm_consultDaysTable on cm_consultDaysTable.dId=cm_doctorTable.dId where "+today+"='true' and isActive='yes'";
		
		return template.query(sql,
				new RowMapper<FrontOffice>()
				{
					public FrontOffice mapRow(ResultSet rs,int row) throws SQLException
					{
						FrontOffice fb_bean=new FrontOffice();
						fb_bean.setsName(rs.getString(1));
						fb_bean.setdSpec(rs.getString(2));
						fb_bean.setConsultFee(rs.getDouble(3));
						return fb_bean;
					}
			});
	}
	
	// For editing patient 
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#getEditPatientDetails(int)
	 */
	@Override
	public List<FrontOffice> getEditPatientDetails(int regId)
	{	
		return template.query( "select regId,pFName,pLName,pGender,DOB as pDOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId="+regId+"",
				new RowMapper<FrontOffice>() 
				{			
					public FrontOffice mapRow(ResultSet rs, int row) throws SQLException 
					{
								FrontOffice adm = new FrontOffice();			
								adm.setRegId(rs.getInt(1));
								adm.setpFName(rs.getString(2));
								adm.setpLName(rs.getString(3));
								adm.setpGender(rs.getString(4));
								adm.setpDOB(rs.getDate(5));
								adm.setpAddr(rs.getString(6));
								adm.setpPhNo(rs.getString(7));
								adm.setpBloodGrp(rs.getString(8));
								adm.setCreatedDateP(rs.getDate(9));
								
								return adm;
					}
				});
	}

	//Add New Appointment
	/* (non-Javadoc)
	 * @see com.ust.dao.IFrontOfficeDao#addAppoinment(com.ust.model.FrontOffice)
	 */
	@Override
	public int addAppoinment(FrontOffice fob)
	{	
		String sql="insert into cm_appoinmentTable(regId,dId,dateOfApp,consultStatus) values("+fob.getRegId()+","+fob.getdId()+",TO_DATE('"+java.time.LocalDate.now()+"','yyyy-mm-dd'),'no')";
		return template.update(sql);
	}
}
