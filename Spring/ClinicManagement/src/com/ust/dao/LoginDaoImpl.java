package com.ust.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.Login;

public class LoginDaoImpl implements ILoginDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
	//Login Role Checking for Authentication
	/* (non-Javadoc)
	 * @see com.ust.dao.ILoginDao#RoleChecker(java.lang.String, java.lang.String)
	 */
	@Override
	public Login RoleChecker(String username,String password)
	{
		Login login = new Login();
		
		String sql = "select sId,username,password,roleId from cm_stafftable where username = ? and password = ?";
		try
		{
			login =  (Login) template.queryForObject(sql,new Object[] {username,password},
					new BeanPropertyRowMapper<Login>(Login.class));	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return login;
	}

}

