package com.foxlink.realtime.model;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int ID;
	private String USERID;
	private String PASSWORD;
	private String CHINESENAME;
	private String ASSISTANT_ID;
	private String DEPARTMENTCODE;
	private String COSTID;
	private String SWIPE_SYSTEM_CHIEF;
	private String EMAIL;
	private String PHONE_TEL;
	private String PHONE_SYSTEM;
	private String PHONE_SN;
	private String WECHAT_ID;
	private int WECHAT_CHECK;
	private Date WECHAT_UPDATE_DATE;
	private int MODIFICATION_PROVE;
	private Date CHPASS_TIME;
	private String QUERY_COSTID;
	
	
	
	
	public User() {
		
	}
	
	public User(int ID,String UserID,String Password,String ChineseName,String AssistantID,String DepartmentCode,String CostID,
			String SwipeSystemChief,String eMail,String PhoneTEL,String PhoneSystem,String PhoneSN,String WeChatID,
			int WeChatCheck,Date WeChatUpdateDate,int ModificationProve,Date ChpassTime,String QueryCostID) {
		this.ID=ID;
		this.USERID=UserID;
		this.PASSWORD=Password;
		this.CHINESENAME=ChineseName;
		this.ASSISTANT_ID=AssistantID;
		this.DEPARTMENTCODE=DepartmentCode;
		this.COSTID=CostID;
		this.SWIPE_SYSTEM_CHIEF=SwipeSystemChief;
		this.EMAIL=eMail;
		this.PHONE_TEL=PhoneTEL;
		this.PHONE_SYSTEM=PhoneSystem;
		this.PHONE_SN=PhoneSN;
		this.WECHAT_ID=WeChatID;
		this.WECHAT_CHECK=WeChatCheck;
		this.WECHAT_UPDATE_DATE=WeChatUpdateDate;
		this.MODIFICATION_PROVE=ModificationProve;
		this.CHPASS_TIME=ChpassTime;
		this.QUERY_COSTID=QueryCostID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getCHINESENAME() {
		return CHINESENAME;
	}

	public void setCHINESENAME(String cHINESENAME) {
		CHINESENAME = cHINESENAME;
	}

	public String getASSISTANT_ID() {
		return ASSISTANT_ID;
	}

	public void setASSISTANT_ID(String aSSISTANT_ID) {
		ASSISTANT_ID = aSSISTANT_ID;
	}

	public String getDEPARTMENTCODE() {
		return DEPARTMENTCODE;
	}

	public void setDEPARTMENTCODE(String dEPARTMENTCODE) {
		DEPARTMENTCODE = dEPARTMENTCODE;
	}

	public String getCOSTID() {
		return COSTID;
	}

	public void setCOSTID(String cOSTID) {
		COSTID = cOSTID;
	}

	public String getSWIPE_SYSTEM_CHIEF() {
		return SWIPE_SYSTEM_CHIEF;
	}

	public void setSWIPE_SYSTEM_CHIEF(String sWIPE_SYSTEM_CHIEF) {
		SWIPE_SYSTEM_CHIEF = sWIPE_SYSTEM_CHIEF;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE_TEL() {
		return PHONE_TEL;
	}

	public void setPHONE_TEL(String pHONE_TEL) {
		PHONE_TEL = pHONE_TEL;
	}

	public String getPHONE_SYSTEM() {
		return PHONE_SYSTEM;
	}

	public void setPHONE_SYSTEM(String pHONE_SYSTEM) {
		PHONE_SYSTEM = pHONE_SYSTEM;
	}

	public String getPHONE_SN() {
		return PHONE_SN;
	}

	public void setPHONE_SN(String pHONE_SN) {
		PHONE_SN = pHONE_SN;
	}

	public String getWECHAT_ID() {
		return WECHAT_ID;
	}

	public void setWECHAT_ID(String wECHAT_ID) {
		WECHAT_ID = wECHAT_ID;
	}

	public int getWECHAT_CHECK() {
		return WECHAT_CHECK;
	}

	public void setWECHAT_CHECK(int wECHAT_CHECK) {
		WECHAT_CHECK = wECHAT_CHECK;
	}

	public Date getWECHAT_UPDATE_DATE() {
		return WECHAT_UPDATE_DATE;
	}

	public void setWECHAT_UPDATE_DATE(Date wECHAT_UPDATE_DATE) {
		WECHAT_UPDATE_DATE = wECHAT_UPDATE_DATE;
	}

	public int getMODIFICATION_PROVE() {
		return MODIFICATION_PROVE;
	}

	public void setMODIFICATION_PROVE(int mODIFICATION_PROVE) {
		MODIFICATION_PROVE = mODIFICATION_PROVE;
	}

	public Date getCHPASS_TIME() {
		return CHPASS_TIME;
	}

	public void setCHPASS_TIME(Date cHPASS_TIME) {
		CHPASS_TIME = cHPASS_TIME;
	}

	public String getQUERY_COSTID() {
		return QUERY_COSTID;
	}

	public void setQUERY_COSTID(String qUERY_COSTID) {
		QUERY_COSTID = qUERY_COSTID;
	}

}
