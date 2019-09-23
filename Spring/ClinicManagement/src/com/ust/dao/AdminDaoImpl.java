package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ust.model.Admin;

public class AdminDaoImpl implements IAdminDao {

	JdbcTemplate template;
	
	private String sId;

	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
	}

	/*************************************** MEDICINE ***************************************/

	// View medicineList
	@Override
	public List<Admin> list() 
	{
		return template.query("select medId,medName,manufacturer,medPrice from cm_medicineTable "
								+ "where isActive = 1 order by medId",
						new RowMapper<Admin>() 
						{
							public Admin mapRow(ResultSet rs, int row)throws SQLException 
							{
								Admin adm = new Admin();
								adm.setMedId(rs.getInt(1));
								adm.setMedName(rs.getString(2));
								adm.setManufacturer(rs.getString(3));
								adm.setMedPrice(rs.getDouble(4));
								return adm;
							}
						});
	}

	// Get Medcine By medName(Search)
	@Override
	public List<Admin> get(String medName) 
	{
		return template.query("select medId,medName,manufacturer,medPrice from cm_medicineTable "
								+ "where medName = '" + medName +"' and isActive = 1",
						new RowMapper<Admin>() 
						{
							public Admin mapRow(ResultSet rs, int row) throws SQLException 
							{
								Admin adm = new Admin();
								adm.setMedId(rs.getInt(1));
								adm.setMedName(rs.getString(2));
								adm.setManufacturer(rs.getString(3));
								adm.setMedPrice(rs.getDouble(4));
								return adm;
							}
						});
	}

	// Edit Medicine
	@Override
	public Admin getMedById(int medId) 
	{
		String sql = "select medId,medName,manufacturer,medPrice from cm_medicineTable where medId = ?";
		return (Admin) template.queryForObject(sql, new Object[] { medId },
				new BeanPropertyRowMapper<Admin>(Admin.class));
	}

	// ADD MEDICINE
	@Override
	public long save(Admin adm) 
	{
		String sql = "insert into cm_medicineTable (medName,medPrice,isActive,manufacturer) values ('"
				+ adm.getMedName()
				+ "',"
				+ adm.getMedPrice()
				+ ","
				+ 1
				+ ",'"
				+ adm.getManufacturer() + "')";
		return template.update(sql);
	}

	// Update Medicine
	@Override
	public int update(Admin adm) {
		String sql = "update cm_medicineTable set medName = '"
				+ adm.getMedName() + "',medPrice ='" + adm.getMedPrice()
				+ "',manufacturer = '" + adm.getManufacturer()
				+ "' where medId=" + adm.getMedId() + "";
		System.out.println("....." + adm.getMedId());
		return template.update(sql);

	}

	// DISABLE MEDICINE
	@Override
	public int disableMedicine(int medId) 
	{
		String sql = "update cm_medicineTable set isActive = 0  where medId = '"
				+ medId + "'";
		return template.update(sql);
	}

	/*************************************** DOCTOR ***************************************/

	// view doctor list
	@Override
	public List<Admin> list1() 
	{

		return template.query("select sId,dId,sName,dSpec,sPhNo from cm_staffTable join cm_doctorTable using(sId) where isActive = 'yes' order by sId"
						, new RowMapper<Admin>() 
						{
							public Admin mapRow(ResultSet rs, int row)throws SQLException 
							{
								Admin admin = new Admin();
								admin.setsId(rs.getInt(1));
								admin.setdId(rs.getInt(2));
								admin.setsName(rs.getString(3));
								admin.setdSpec(rs.getString(4));
								admin.setsPhNo(rs.getString(5));
								return admin;
							}
						});
	}

	// Search a doctor by id and phone number
	@Override
	public List<Admin> getDoc(String searchString) 
	{
		return template.query("select sId,dId,sName,dSpec,sPhNo from cm_staffTable join cm_doctorTable using(sId) where sId ='"
						+ searchString
						+ "' or sPhNo = '"
						+ searchString
						+ "'"
						+ "and isActive = 'yes'", 
					new RowMapper<Admin>() 
					{
						public Admin mapRow(ResultSet rs, int row) throws SQLException
						{
							Admin adm = new Admin();
							adm.setsId(rs.getInt(1));
							adm.setdId(rs.getInt(2));
							adm.setsName(rs.getString(3));
							adm.setdSpec(rs.getString(4));
							adm.setsPhNo(rs.getString(5));
	
							return adm;
						}
					});

	}

	// to get role id
	@Override
	public Admin getRoleName(String roleName) 
	{
		String sql = "select roleId from cm_roleTable where roleName='"
				+ roleName + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Admin>(Admin.class));
	}

	// DISPLAY ALL ROLES
	@Override
	public List<Admin> getAllRoles() 
	{
		return template.query("select roleName from cm_roleTable",
				new RowMapper<Admin>() {

					public Admin mapRow(ResultSet rs, int row)
							throws SQLException 
					{
						Admin objRole = new Admin();
						objRole.setRoleName(rs.getString(1));
						return objRole;
					}
				});
	}

	//GET DOCTOR DETAIL BY SID
	@Override
	public List<Admin> getDoctorDetailsById(int sId) 
	{
		return template.query("select sId,dob,sGender,sName,password,username,dId,dSpec,dQualification,consultFee,sExp,sPhNo,isActive,roleId,sAddr,sEmail,sunday,monday,tuesday,wednesday,thursday,friday,saturday from cm_doctorTable join cm_staffTable using (sId) join cm_consultDaysTable using (dId) where sId="+sId+"",new RowMapper<Admin>(){
			public Admin mapRow(ResultSet rs,int row) throws SQLException
			{
				Admin ab=new Admin();
				ab.setsId(rs.getInt(1));
				ab.setsDOB(rs.getDate(2));
				ab.setsGender(rs.getString(3));
				ab.setsName(rs.getString(4));
				ab.setPassword(rs.getString(5));
				ab.setUsername(rs.getString(6));
				ab.setdId(rs.getInt(7));
				ab.setdSpec(rs.getString(8));
				ab.setdQualification(rs.getString(9));
				ab.setConsultFee(rs.getDouble(10));
				ab.setsExp(rs.getString(11));
				ab.setsPhNo(rs.getString(12));
				ab.setIsActiveS(rs.getString(13));
				ab.setRoleId(rs.getInt(14));				
				ab.setsAddr(rs.getString(15));
				ab.setsEmail(rs.getString(16));
				ab.setSunday(rs.getString(17));
				ab.setMonday(rs.getString(18));
				ab.setTuesday(rs.getString(19));
				ab.setWednesday(rs.getString(20));
				ab.setThursday(rs.getString(21));
				ab.setFriday(rs.getString(22));
				ab.setSaturday(rs.getString(23));
				return ab;
			}
		});
	}

	//INSERT DOCTOR
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#insertDoctorStaff(com.ust.model.Admin)
	 */
	@Override
	public int insertDoctorStaff(Admin aBean)
	{
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate=ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values(3,'"
		+ aBean.getsName()
		+ "',"
		+"TO_DATE('" + sqlDate + "','yyyy-MM-dd')"

		 //+ aBean.getsDOB()
		+ ",'"
		+ aBean.getsGender()
		+ "','"
		+ aBean.getsAddr()
		+ "','"
		+ aBean.getsExp()
		+ "','"
		+ aBean.getsPhNo()
		+ "','"
		+ aBean.getsEmail()
		+ "','"
		+ aBean.getUsername()
		+ "','"
		+ aBean.getPassword()
		+ "','"
		+ "yes"
		+ "',"
		+ "TO_DATE('" + java.time.LocalDate.now() + "','yyyy/MM/dd'))";

		if(template.update(sql)!=0)
		{
			if(insertDoctor(aBean)!=0)
			{
				return insertAvailableDays(aBean);
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	//Getting MAX(SID) FROM STAFF TABLE FOR INSERTING DATA TO DOCTOR TABLE
	/* (non-Javadoc)
	* @see com.ust.dao.IAdminDao#insertDoctor(com.ust.model.Admin)
	*/
	@Override
	public int insertDoctor(Admin aBean)
	{
		String sql="select max(sId) from cm_staffTable";
		int sId=template.queryForObject(sql, Integer.class);

		String sql2="insert into cm_doctorTable(sId,dSpec,dQualification,consultFee) values(?,?,?,?)";

		return template.update(sql2,new Object[]{sId,aBean.getdSpec(),aBean.getdQualification(),aBean.getConsultFee()});
	}

	//DOCTORS CONSULTATION TABLE INSERTION
	/* (non-Javadoc)
	* @see com.ust.dao.IAdminDao#insertAvailableDays(com.ust.model.Admin)
	*/
	@Override
	public int insertAvailableDays(Admin aBean)
	{
		String sql="select max(dId) from cm_doctorTable";
		int dId=template.queryForObject(sql, Integer.class);

		String sql2="insert into cm_consultDaysTable(dId,sunday,monday,tuesday,wednesday,thursday,friday,saturday) values(?,?,?,?,?,?,?,?)";
		return template.update(sql2,new Object[]{dId,aBean.getSunday(),aBean.getMonday(),aBean.getTuesday(),aBean.getWednesday(),aBean.getThursday(),aBean.getFriday(),aBean.getSaturday()});
	}

	// UPDATE DOCTOR

	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#updateDoctorStaff(com.ust.model.Admin)
	 */
	@Override
	public int updateDoctorStaff(Admin aBean) 
	{
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		long t = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(t);

		String sql = "update cm_staffTable set sName='" + aBean.getsName()
				+ "',DOB=" + "TO_DATE('" + sqlDate + "','YYYY-MM-dd')"
				+ ",sGender='" + aBean.getsGender() + "',sAddr='"
				+ aBean.getsAddr() + "',sExp='" + aBean.getsExp() + "',sPhNo='"
				+ aBean.getsPhNo() + "',sEmail='" + aBean.getsEmail()
				+ "',username='" + aBean.getUsername() + "',password='"
				+ aBean.getPassword() + "',isActive='yes' where sId= "
				+ aBean.getsId() + "";
		template.update(sql, new Object[] {});
		
		String sql1 = "update cm_doctorTable set dSpec='" + aBean.getdSpec()
				+ "',dQualification='" + aBean.getdQualification()
				+ "',consultFee=" + aBean.getConsultFee() + " where sId="
				+ aBean.getsId() + "";
		template.update(sql1, new Object[] {});

		int dId = getSeqDid(aBean.getsId());

		String sql2 = "update cm_consultdaysTable set sunday='"
				+ aBean.getSunday() + "',monday='" + aBean.getMonday()
				+ "',tuesday='" + aBean.getTuesday() + "',wednesday='"
				+ aBean.getWednesday() + "',thursday='" + aBean.getThursday()
				+ "',friday='" + aBean.getFriday() + "',saturday='"
				+ aBean.getSaturday() + "'where dId=" + dId + "";
		return template.update(sql2, new Object[] {});

	}

	// Getting doctorId
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#getSeqDid(int)
	 */
	@Override
	public int getSeqDid(int sId) 
	{
		int id1;
		String sql = "select dId from cm_doctorTable where sId=?";

		id1 = template.queryForObject(sql, new Object[] { sId }, Integer.class);
		return id1;
	}

	// Disable doctor
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#disableDoctor(int)
	 */
	@Override
	public int disableDoctor(int dId) 
	{
		String sql = "update cm_staffTable set isActive= 'no' where sId in (select sId  from cm_doctorTable where dId=?)";
		return template.update(sql, new Object[] { dId });
	}

	/*************************************** STAFF ***************************************/
	
	// View StaffList
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#listS()
	 */
	@Override
	public List<Admin> listS() {
		return template
				.query("select sId,roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,"
						+ "isActive,createdDate,roleName from cm_staffTable "
						+ "join cm_roletable using(roleId) where isActive = 'yes' and roleId!=3 order by sId",
						new RowMapper<Admin>() {

							public Admin mapRow(ResultSet rs, int row)
									throws SQLException {
								Admin ab = new Admin();
								ab.setsId(rs.getInt(1));
								ab.setRoleId(rs.getInt(2));

								ab.setsName(rs.getString(3));
								ab.setsDOB(rs.getDate(4));
								ab.setsGender(rs.getString(5));
								ab.setsAddr(rs.getString(6));
								ab.setsExp(rs.getString(7));
								ab.setsPhNo(rs.getString(8));
								ab.setsEmail(rs.getString(9));
								ab.setUsername(rs.getString(10));
								ab.setPassword(rs.getString(11));
								ab.setIsActiveS(rs.getString(12));
								ab.setCreatedDateS(rs.getDate(13));
								ab.setRoleName(rs.getString(14));
								return ab;
							}
						});
	}

	// Add Staff(Edit)

	// Get roleid from rolename for staff

	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#getRoleId(java.lang.String)
	 */
	@Override
	public int getRoleId(String role) 
	{
		String sqlRoleId = "select roleId from cm_roleTable where roleName=? ";
		return template.queryForObject(sqlRoleId, new Object[] { role },
				Integer.class);
	}

	// Update Staff
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#updateStaff(com.ust.model.Admin)
	 */
	@Override
	public int updateStaff(Admin ab) 
	{

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(ab.getsDOB());

		String sql = "update cm_staffTable set roleId=" + ab.getRoleId()
				+ ",sName='" + ab.getsName() + "',DOB= TO_DATE('" + sqlDate
				+ "' ,'yyyy-MM-dd')" + ",sGender='" + ab.getsGender()
				+ "',sAddr='" + ab.getsAddr() + "',sExp='" + ab.getsExp()
				+ "',sPhNo='" + ab.getsPhNo() + "',sEmail='" + ab.getsEmail()
				+ "',username='" + ab.getUsername() + "',password='"
				+ ab.getPassword() + "',isActive='yes'  where sId="
				+ ab.getsId() + "";
		return template.update(sql);
	}

	// Insert Staff
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#insertStaff(com.ust.model.Admin)
	 */
	@Override
	public int insertStaff(Admin aBean) 
	{
		int id = getRoleId(aBean.getRoleName());
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values(?,'"
				+ aBean.getsName()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'"
				+ aBean.getsGender()
				+ "','"
				+ aBean.getsAddr()
				+ "','"
				+ aBean.getsExp()
				+ "','"
				+ aBean.getsPhNo()
				+ "','"
				+ aBean.getsEmail()
				+ "','"
				+ aBean.getUsername()
				+ "','"
				+ aBean.getPassword()
				+ "','yes',"
				+ "TO_DATE('"
				+ java.time.LocalDate.now() + "','yyyy/mm/dd'))";
		return template.update(sql, new Object[] { id });
	}

	// Search staff by id and phone number

	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#getStaff(java.lang.String)
	 */
	@Override
	public List<Admin> getStaff(String searchString) {
		return template.query("select sId,sName,RoleName,sPhNo from cm_staffTable "
						+ "stf join cm_roleTable role on (stf.roleId=role.roleId) where sId = '"
						+ searchString
						+ "' or sPhNo='"
						+ searchString
						+ "'"
						+ "and isActive = 'yes'", 
						new RowMapper<Admin>() 
						{
							public Admin mapRow(ResultSet rs, int row) throws SQLException 
							{
								Admin adm = new Admin();
								adm.setsId(rs.getInt(1));
								adm.setsName(rs.getString(2));
								adm.setRoleName(rs.getString(3));
								adm.setsPhNo(rs.getString(4));
		
								return adm;
							}
						});
	}

	// Disable staff

	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#disableStaff(int)
	 */
	@Override
	public int disableStaff(int sId) 
	{
		String sql = "update cm_staffTable set isActive = 'no'  where sId = '"+ sId + "'";
		return template.update(sql);
	}

	
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#saveDoctor(com.ust.model.Admin)
	 */
	@Override
	public int saveDoctor(Admin aBean) 
	{
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values("
				+ aBean.getRoleId()
				+ ",'"

				+ aBean.getsName()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'"
				+ aBean.getsGender()
				+ "','"
				+ aBean.getsAddr()
				+ "','"
				+ aBean.getsExp()
				+ "','"
				+ aBean.getsPhNo()
				+ "','"
				+ aBean.getsEmail()
				+ "','"
				+ aBean.getUsername()
				+ "','"
				+ aBean.getPassword()
				+ "','"
				+ aBean.getIsActiveS()
				+ "',"
				+ "TO_DATE('" + java.time.LocalDate.now() + "','yyyy/MM/dd'))";

			if (template.update(sql) != 0) 
			{
				if (insertDoctor(aBean) != 0) 
				{
					return insertAvailableDays(aBean);
				}
				else 
				{
					return 0;
				}
			} 
			else 
			{
				return 0;
			}
	}

	// get roleid from rolename for staff

	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#getRoleById(java.lang.String)
	 */
	@Override
	public Integer getRoleById(String roleName) {
		String sqlRoleId = "select roleId from cm_roleTable where roleName=? ";
		return template.queryForObject(sqlRoleId, new Object[] { roleName },
				Integer.class);
	}

	// get staff by staffid
	/* (non-Javadoc)
	 * @see com.ust.dao.IAdminDao#getStaffDetailsById(int)
	 */
	@Override
	public List<Admin> getStaffDetailsById(int sId) {
		return template
				.query("select sId,roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,"
						+ "password,isActive,createdDate,roleName from cm_staffTable "
						+ "join cm_roleTable using(roleId) where sId="
						+ sId + "", new RowMapper<Admin>() {

					public Admin mapRow(ResultSet rs, int row)
							throws SQLException {

						Admin adm = new Admin();

						adm.setsId(rs.getInt(1));
						adm.setRoleId(rs.getInt(2));
						adm.setsName(rs.getString(3));
						adm.setsDOB(rs.getDate(4));
						adm.setsGender(rs.getString(5));
						adm.setsAddr(rs.getString(6));
						adm.setsExp(rs.getString(7));
						adm.setsPhNo(rs.getString(8));
						adm.setsEmail(rs.getString(9));
						adm.setUsername(rs.getString(10));
						adm.setPassword(rs.getString(11));
						adm.setIsActiveS(rs.getString(12));
						adm.setCreatedDateS(rs.getDate(13));
						adm.setRoleName(rs.getString(14));
						return adm;
					}
				});
	}
}
