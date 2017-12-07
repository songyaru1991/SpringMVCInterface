package com.foxlink.realtime.dao;

import java.util.List;

import com.foxlink.realtime.model.User;

public interface IAccountDAO {

	public List<User> FindALLAccounts() throws Exception;
	
}
