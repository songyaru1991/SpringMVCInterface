package com.foxlink.realtime.model;

import java.io.Serializable;

public class Emp implements Serializable {
	private static final long serialVersionUID=1L;
	
	private String EMPNO;
	private String NAME;
	private String DEPTNO;
	
	public Emp() {}
	
	public Emp(String empNO,String name,String DeptNO) {
		this.setEMPNO(empNO);
		this.setNAME(name);
		this.setDEPTNO(DeptNO);
	}

	public String getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(String eMPNO) {
		EMPNO = eMPNO;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}
	
}
