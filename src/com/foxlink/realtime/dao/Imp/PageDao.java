package com.foxlink.realtime.dao.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.foxlink.realtime.dao.IPageDao;
import com.foxlink.realtime.model.Page;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.model.objectMapper.UserMapper;

public class PageDao implements IPageDao{
	    private JdbcTemplate jdbcTemplate;

	    /* 
	     * 获得总记录数
	     */
	    @SuppressWarnings("deprecation")
	    public int getTotalRecord(String sql, Class clazz) {	    	  
	    	int totalRecord = getJdbcTemplate().queryForObject(sql, new Object[] { },Integer.class); 
	        return totalRecord;
	    }

	    /* 
	     * 获取当前页数据
	     */
	    @SuppressWarnings("unchecked")
	    public Page getPage(int pageNum, Class clazz, String sql, int totalRecord) {
	        Page page = new Page(pageNum, totalRecord);
	        int endIndex=page.getStartIndex() + page.getPageSize();
	        sql = sql + " where rnum > "+page.getStartIndex()+" and rnum <= "+ endIndex ;
	      //  List list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(clazz));    
	        List list=jdbcTemplate.query(sql,   new UserMapper());    	      
	        page.setList(list);
	        return page;
	    }

		@Override
		public int getTotalRecord() {
			// TODO Auto-generated method stub
			return 0;
		}
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
}
