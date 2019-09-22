package com.ust.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.Login;

public class LoginDaoImpl {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
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

