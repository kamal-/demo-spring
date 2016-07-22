package com.j.dao;

import java.util.List;
import java.util.Map;

public interface VisitRecordsDao {

	public List<Map<String,String>> getRecords(String profileID);
}
