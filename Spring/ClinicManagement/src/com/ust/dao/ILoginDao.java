package com.ust.dao;

import com.ust.model.Login;

public interface ILoginDao {

	//ROLE CHEKER
	public abstract Login RoleChecker(String username, String password);

}