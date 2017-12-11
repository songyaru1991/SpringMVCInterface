package com.foxlink.realtime.dao.Imp;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.foxlink.realtime.dao.IAccountDAO;
import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.model.objectMapper.UserMapper;

public class AccountDAO implements IAccountDAO {
	private JdbcTemplate jdbcTemplate;
	/***
     * 獲取所有賬號列表
     * 
     * @Author Yaru Song 
     * @return
    */

	@Override
	public List<User> FindALLAccounts(int pageNum, int totalRecord) {
		// TODO Auto-generated method stub
		List<User> AllUsers = null;
		Page page = new Page(pageNum, totalRecord);	  
		String sSQL = "select * from (select a.*,rownum as rnum from (select * from USER_DATA where ENABLED=1 order by username) a)";
		try {
			int endIndex=page.getStartIndex() + page.getPageSize();
		    sSQL = sSQL + " where rnum > "+page.getStartIndex()+" and rnum <= "+ endIndex ;
			AllUsers = jdbcTemplate.query(sSQL, new UserMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return AllUsers;
	}
	
    /* 
     * 获得总记录数
     */
    public int getTotalRecord() {
    	int totalRecord=-1;
    	String sSQL = "select count(*) FROM USER_DATA where ENABLED=1";
    	try {    	
    		totalRecord = getJdbcTemplate().queryForObject(sSQL, new Object[] { },Integer.class); 
    	  } catch (Exception ex) {
    		  ex.printStackTrace();
    		  }
    	return totalRecord;
    }

    /* 
     * 获取当前页数据
     */
    @SuppressWarnings("unchecked")
    public Page getPage(int pageNum, int totalRecord) {
    	String sSQL = "select * from (select a.*,rownum as rnum from (select * from USER_DATA where ENABLED=1 order by username) a)";
        Page page = new Page(pageNum, totalRecord);
        int endIndex=page.getStartIndex() + page.getPageSize();
        sSQL = sSQL + " where rnum > "+page.getStartIndex()+" and rnum <= "+ endIndex ;
      //  List list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(clazz));    
        List list=jdbcTemplate.query(sSQL,   new UserMapper());    	      
        page.setList(list);
        return page;
    }

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
