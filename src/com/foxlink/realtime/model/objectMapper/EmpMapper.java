package com.foxlink.realtime.model.objectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.foxlink.realtime.model.Emp;

public class EmpMapper implements RowMapper<Emp> {

	@Override
	public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Emp emp =new Emp();
		emp.setEMPNO(rs.getString(1));
		emp.setNAME(rs.getString(2));
		emp.setDEPTNO(rs.getString(3));
		return null;
	}

}
