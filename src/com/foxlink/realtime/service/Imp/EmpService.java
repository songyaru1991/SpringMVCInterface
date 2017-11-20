package com.foxlink.realtime.service.Imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.foxlink.realtime.model.Emp;
import com.foxlink.realtime.model.objectMapper.EmpMapper;
import com.foxlink.realtime.service.IEmpService;
import com.foxlink.realtime.util.HibernateUtil;

public class EmpService implements IEmpService{
	Logger logger=Logger.getLogger(EmpService.class);
	private PlatformTransactionManager transactionManager;
	Emp emp=null;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public EmpService(Emp emp) {
		this.emp=emp;
	}

	@Override
	public void AddNewRecord(Object t) {
		// TODO Auto-generated method stub
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDef);
		String sSQL="INSERT INTO EMP (DEPTNO,EMPNO,NAME) VALUES(?,?,?)";
		try {
			Emp newEmp=(Emp) t;
			if(newEmp!=null) {
				jdbcTemplateObject.update(sSQL,new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement arg0) throws SQLException {
						// TODO Auto-generated method stub
						arg0.setString(1, newEmp.getDEPTNO());
						arg0.setString(2, newEmp.getEMPNO());
						arg0.setString(3, newEmp.getNAME());
					}	
				});
				transactionManager.commit(txStatus);
			}			
		}
		catch(Exception ex) {
			logger.error(ex);
			ex.printStackTrace();
			transactionManager.rollback(txStatus);
		}
	}

	@Override
	public void UpdateRecord(Object t) {
		// TODO Auto-generated method stub
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDef);
		String sSQL="UPDATE EMP SET DEPTNO=?,NAME=? WHERE EMPNO=?";
		try {
			Emp updateEmp=(Emp) t;
			if(updateEmp!=null) {
				jdbcTemplateObject.update(sSQL,new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement arg0) throws SQLException {
						// TODO Auto-generated method stub
						arg0.setString(1, updateEmp.getDEPTNO());
						arg0.setString(2, updateEmp.getNAME());
						arg0.setString(3, updateEmp.getEMPNO());
					}	
				});
				transactionManager.commit(txStatus);
			}	
		}
		catch(Exception ex) {
			logger.error(ex);
			transactionManager.rollback(txStatus);
		}		
	}

	@Override
	public void DeleteRecord(Object t) {
		// TODO Auto-generated method stub
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDef);
		String sSQL="DELETE EMP WHERE EMPNO=?";
		try {
			String delEmpNO=(String) t;
			if(delEmpNO!=null) {
				jdbcTemplateObject.update(sSQL,new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement arg0) throws SQLException {
						// TODO Auto-generated method stub
						arg0.setString(1, delEmpNO);
					}	
				});
				transactionManager.commit(txStatus);
			}
		}
		catch(Exception ex) {
			logger.error(ex);
			transactionManager.rollback(txStatus);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List FindAllRecords() {
		// TODO Auto-generated method stub
		List<Emp> AllEmps=null;
		String sSQL="SELECT * FROM EMP";
		try {
			AllEmps=jdbcTemplateObject.query(sSQL, new EmpMapper());
		}
		catch(Exception ex) {
			logger.error(ex);
		}
		return AllEmps;
	}

	@Override
	public Object FindRecordByKey(Object t) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction trans=null;
		String sSQL="SELECT * FROM EMP WHERE EMPNO=?";
		Emp findedEmp=null;
		try {
			String EmpNo=(String) t;
			List<Emp> findEmps=jdbcTemplateObject.query(sSQL, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement arg0) throws SQLException {
					// TODO Auto-generated method stub
					arg0.setString(1, EmpNo);
				}
			},new EmpMapper());
			if(findEmps.size()==1)
				findedEmp=findEmps.get(0);
		}
		catch(Exception ex) {
			logger.error(ex);
		}
		return findedEmp;
	}

}
