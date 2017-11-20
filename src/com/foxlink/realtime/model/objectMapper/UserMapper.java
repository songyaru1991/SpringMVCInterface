package com.foxlink.realtime.model.objectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.foxlink.realtime.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		User user =new User();
		user.setID(rs.getInt(1));
		user.setUSERID(rs.getString(2));
		user.setPASSWORD(rs.getString(3));
		user.setCHINESENAME(rs.getString(4));
		user.setASSISTANT_ID(rs.getString(5));
		user.setDEPARTMENTCODE(rs.getString(6));
		user.setCOSTID(rs.getString(7));
		user.setSWIPE_SYSTEM_CHIEF(rs.getString(8));
		user.setEMAIL(rs.getString(9));
		user.setPHONE_TEL(rs.getString(10));
		user.setPHONE_SYSTEM(rs.getString(11));
		user.setPHONE_SN(rs.getString(12));
		user.setWECHAT_ID(rs.getString(13));
		user.setWECHAT_CHECK(rs.getInt(14));
		user.setWECHAT_UPDATE_DATE(rs.getDate(15));
		user.setMODIFICATION_PROVE(rs.getInt(16));
		user.setCHPASS_TIME(rs.getDate(17));
		user.setQUERY_COSTID(rs.getString(18));
		return user;
	}

}
