package com.foxlink.realtime.service.Imp;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.foxlink.realtime.model.User;
import com.foxlink.realtime.model.objectMapper.UserMapper;
import com.foxlink.realtime.service.IUserService;

public class UserService implements IUserService {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	
	public List<User> FindALLUsers() {
		// TODO Auto-generated method stub
		List<User> AllUsers=null;
		String sSQL="Select * FROM User";
		try {
			AllUsers=jdbcTemplateObject.query(sSQL, new UserMapper());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return AllUsers;
	}

}
