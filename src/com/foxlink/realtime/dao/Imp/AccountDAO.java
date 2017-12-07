package com.foxlink.realtime.dao.Imp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.foxlink.realtime.dao.IAccountDAO;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.model.objectMapper.UserMapper;

public class AccountDAO implements IAccountDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	/***
     * 獲取所有賬號列表
     * 
     * @Author Yaru Song 
     * @return
    */

	@Override
	public List<User> FindALLAccounts() {
		// TODO Auto-generated method stub
		List<User> AllUsers = null;
		String sSQL = "select * FROM USER_DATE where ENABLED=0";
		try {
			AllUsers = jdbcTemplate.query(sSQL, new UserMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return AllUsers;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
