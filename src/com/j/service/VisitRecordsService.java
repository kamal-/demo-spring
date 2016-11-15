package com.j.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.dao.VisitRecordsDao;
@Service
public class VisitRecordsService {

	@Autowired
	private VisitRecordsDao visitRecordsDaoImplement;
	public VisitRecordsService() {
		// TODO Auto-generated constructor stub
	}
	public List<Map<String, Object>> getRecords(final String profileID) {
	return visitRecordsDaoImplement.getRecords(profileID);	
	}
	
}
