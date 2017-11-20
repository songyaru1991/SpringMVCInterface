package com.foxlink.realtime.service;

import java.util.List;

public interface IService<T> {
	public void AddNewRecord(T t);
	public void UpdateRecord(T t);
	public void DeleteRecord(T t);
	public List<T> FindAllRecords();
	public T FindRecordByKey(T t);
}
