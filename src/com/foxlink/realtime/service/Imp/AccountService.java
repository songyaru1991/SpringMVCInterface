package com.foxlink.realtime.service.Imp;

import java.util.List;
import com.foxlink.realtime.dao.IAccountDAO;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.service.IAccountService;

public class AccountService implements IAccountService {
	private IAccountDAO accountDao;
	/***
     * 獲取所有賬號列表
     * 
     * @Author Yaru Song 
     * @return
    */
	@Override
	public List<User> FindALLUsers() {
		// TODO Auto-generated method stub
		List<User> AllUsers=null;
		try {
			AllUsers = accountDao.FindALLAccounts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AllUsers;
	}

}
