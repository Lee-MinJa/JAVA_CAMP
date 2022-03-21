package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardLogic {
	Logger logger = LogManager.getLogger(FreeBoardLogic.class);
	
	@Autowired
	private FreeBoardDao freeBoardDao = null;
	
	public List<Map<String, Object>> getFreeBoardList() {
		logger.info("FreeBoardLogic getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardDao.getFreeBoardList();
		return freeBoardList;
	}

}
