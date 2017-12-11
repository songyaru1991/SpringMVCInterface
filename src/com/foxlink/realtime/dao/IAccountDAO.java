package com.foxlink.realtime.dao;

import java.util.List;

import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;

public interface IAccountDAO {

	public List<User> FindALLAccounts(int pageNum, int totalRecord) throws Exception;

	int getTotalRecord() throws Exception;

	Page getPage(int pageNum, int totalRecord);
	
}
