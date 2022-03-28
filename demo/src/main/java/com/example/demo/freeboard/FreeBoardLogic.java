package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeBoardLogic {
	Logger logger = LogManager.getLogger(FreeBoardLogic.class);

	@Autowired
	private FreeBoardDao freeBoardDao = null;

	int total = 0;

	public List<Map<String, Object>> getFreeBoardList(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic getFreeBoardList 호출 성공"+pMap);
		List<Map<String,Object>> freeBoardList = null;

		int page = 0;
		int pageSize = 0;
		int start = 0;
		int end = 0;

		if(pMap.get("page") != null) {
			page = Integer.parseInt(pMap.get("page").toString());
		}
		if(pMap.get("pageSize") != null) {
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());
		}
		logger.info("page : "+page+", pageSize : "+pageSize);

		if(page > 0) {
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			pMap.put("start", start);
			if(end > total) {
				pMap.put("end", total);
			}
			else {
				pMap.put("end", end);
			}
		}
		logger.info("start : "+start+", end : "+end);

		freeBoardList = freeBoardDao.getFreeBoardList(pMap);
		return freeBoardList;
	}

	public int totalRecord(Map<String, Object> pMap) {
		total = freeBoardDao.totalRecord(pMap);
		return total;
	}

	@Transactional //트랜잭션
	public int insertFreeBoard(Map<String,Object> pMap) {
		logger.info("FreeBoardLogic insertFreeBoard 호출 성공");
		int result = 0;
		int freeNum = 0;
		freeNum = freeBoardDao.getFreeNum();
		result = freeBoardDao.insertFreeBoard(pMap);

		if(pMap.get("IMAGE_FILENAME") != null && pMap.get("IMAGE_FILENAME").toString().length() > 1) {
			pMap.put("FREE_NUM", freeNum);
			freeBoardDao.insertImageInfo(pMap);
		}

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

