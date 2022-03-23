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
	
	public List<Map<String, Object>> getFreeBoardList(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardDao.getFreeBoardList(pMap);
		return freeBoardList;
	}

	public int insertFreeBoard(Map<String,Object> pMap) {
		logger.info("FreeBoardLogic insertFreeBoard 호출 성공");
		int result = 0;
		result = freeBoardDao.insertFreeBoard(pMap);
		return result;
	}

	public List<Map<String, Object>> getFreeBoardDetail(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic getFreeBoardDetail 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardDao.getFreeBoardDetail(pMap);		
		return freeBoardDetail;
	}
	
	public int updateFreeBoard(Map<String,Object> pMap) {
		logger.info("FreeBoardLogic updateFreeBoard 호출 성공");
		int result = 0;
		result = freeBoardDao.updateFreeBoard(pMap);
		return result;
	}

	public int deleteFreeBoard(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic deleteFreeBoard 호출 성공");
		int result = 0;
		result = freeBoardDao.deleteFreeBoard(pMap);
		return result;		
	}
}
