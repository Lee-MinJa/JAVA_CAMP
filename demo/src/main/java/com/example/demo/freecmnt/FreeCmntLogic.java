package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeCmntLogic {
	Logger logger = LogManager.getLogger(FreeCmntLogic.class);
	
	@Autowired
	private FreeCmntDao freeCmntDao = null;
	
	public List<Map<String, Object>> getFreeCmntList() {
		logger.info("FreeCmntLogic getFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = freeCmntDao.getFreeCmntList();
		return freeCmntList;
	}
}
