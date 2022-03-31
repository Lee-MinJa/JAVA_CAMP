package com.example.demo.Badge;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeLogic {

	Logger logger = LogManager.getLogger(BadgeLogic.class);

	@Autowired
	private BadgeDao badgeDao = null;
	
	public List<Map<String, Object>> BadgeList(Map<String, Object> pMap) {
		List<Map<String, Object>> BadgeList =null;
		BadgeList=badgeDao.BadgeList(pMap);
	
		return BadgeList;
	}


	public int BadgeInsert(Map<String, Object> pMap) {
		int result = 0;
		result=badgeDao.BadgeInsert(pMap);
		return result;
	}


	public int BadgeUpdate(Map<String, Object> pMap) {
		int result = 0;
		result=badgeDao.BadgeUpdate(pMap);
		return result;
	}


	public int BadgeDelete(Map<String, Object> pMap) {
		int result = 0;
		result=badgeDao.BadgeDelete(pMap);
		return result;
	}

}
