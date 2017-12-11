package com.foxlink.realtime.service.Imp;

import com.foxlink.realtime.dao.Imp.PageDao;
import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.service.IPageService;

public class PageService implements IPageService{	
	private PageDao pageDao;
	public void setPageDao(PageDao pageDao ) {
	      this.pageDao = pageDao;
	      }
	 public Page getAccountPage(int pageNum) {
	        String countSql = "select count(*) FROM USER_DATA where ENABLED=1";
	        int totalRecord = pageDao.getTotalRecord(countSql, User.class);
	        String selectSql = "select * from (select a.*,rownum as rnum from (select * from USER_DATA order by username) a)";
	        Page page = pageDao.getPage(pageNum, User.class, selectSql, totalRecord);
	        return page;
	    }
}
