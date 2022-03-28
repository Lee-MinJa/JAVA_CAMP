package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDao {
	Logger logger = LogManager.getLogger(FreeBoardDao.class);
	private static final String NAMESPACE = "com.example.demo.freeboard.";

	@Autowired
	private SqlSession sqlSession = null;

	int total = 0;

	public List<Map<String, Object>> getFreeBoardList(Map<String,Object> pMap) {
		logger.info("FreeBoardDao getFreeBoardList 호출 성공"+pMap);
		List<Map<String,Object>> freeBoardList = null;
		try {
			freeBoardList = sqlSession.selectList(NAMESPACE+"getFreeBoardList",pMap);
			logger.info("freeBoardList : " + freeBoardList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return freeBoardList;
	}

	public int totalRecord(Map<String, Object> pMap) {
		total = sqlSession.selectOne("totalRecord", pMap);
		return total;
	}

	public int insertFreeBoard(Map<String,Object> pMap) {
		logger.info("FreeBoardDao insertFreeBoard 호출 성공");
		int result = 0;
		result = sqlSession.insert(NAMESPACE+"insertFreeBoard",pMap);
		return result;
	}

	public List<Map<String, Object>> getFreeBoardDetail(Map<String, Object> pMap) {
		logger.info("FreeBoardDao getFreeBoardDetail 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		try {
			freeBoardDetail = sqlSession.selectList(NAMESPACE+"getFreeBoardDetail",pMap);
			logger.info("freeBoardDetail : " + freeBoardDetail);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return freeBoardDetail;
	}

	public int updateFreeBoard(Map<String,Object> pMap) {
		logger.info("FreeBoardDao updateFreeBoard 호출 성공");
		int result = 0;
		result = sqlSession.update(NAMESPACE+"updateFreeBoard",pMap);
		return result;
	}

	public int deleteFreeBoard(Map<String, Object> pMap) {
		logger.info("FreeBoardDao deleteFreeBoard 호출 성공");
		int result = 0;
		result = sqlSession.delete(NAMESPACE+"deleteFreeBoard",pMap);
		return result;
	}

	public int getFreeNum() {
		int result = 0;
		try {
			result = sqlSession.selectOne("getFreeNum");
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return result;
	}

	public int insertImageInfo(Map<String, Object> pMap) {
		logger.info("insertImageInfo 호출 성공");
		int result = 0;
		try {
			result = sqlSession.insert("insertImageInfo",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

