package com.foxlink.realtime.service.Imp;

import java.util.List;
import com.foxlink.realtime.dao.Imp.AccountDAO;
import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.service.IAccountService;

public class AccountService implements IAccountService {
	/***
     * 獲取所有賬號列表
     * 
     * @Author Yaru Song 
     * @return
    */
	private AccountDAO accountDAO;
	public void setAccountDAO(AccountDAO accountDAO ) {
	      this.accountDAO = accountDAO;
	      }

	public List<User> FindALLUsers(int pageNum) {
		// TODO Auto-generated method stub
		List<User> AllUsers=null;
		try {
			int totalRecord = accountDAO.getTotalRecord();	     
			AllUsers = accountDAO.FindALLAccounts(pageNum,totalRecord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AllUsers;
	}
	
	 public Page getAccountPage(int pageNum) {
	      
	        int totalRecord = accountDAO.getTotalRecord();	      
	        Page page = new Page(pageNum, totalRecord);
	        //Page page = accountDAO.getPage(pageNum, User.class, totalRecord);
	        return page;
	    }

}
