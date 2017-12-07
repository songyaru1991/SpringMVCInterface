package com.foxlink.realtime.service;

import java.util.List;

import com.foxlink.realtime.model.Emp;
import com.foxlink.realtime.model.User;

public interface IEmpService extends IService {
	public void AddNewRecord(Object t);
	public void UpdateRecord(Object t);
	public void DeleteRecord(Object t);
	public List FindAllRecords();
	public Object FindRecordByKey(Object t);
}
