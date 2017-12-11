package com.foxlink.realtime.service;

import java.util.List;

import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;

public interface IAccountService {
	public List<User> FindALLUsers(int pageNum);
	public Page getAccountPage(int pageNum);
}
