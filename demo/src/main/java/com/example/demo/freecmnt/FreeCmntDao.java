package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeCmntDao {
	Logger logger = LogManager.getLogger(FreeCmntDao.class);
	private static final String NAMESPACE = "com.example.demo.freecmnt.";
	
	@Autowired
	private SqlSession sqlSession = null;
	
	public List<Map<String, Object>> getFreeCmntList(Map<String,Object> pMap) {
		logger.info("FreeCmntDao getFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		try {
			freeCmntList = sqlSession.selectList(NAMESPACE+"getFreeCmntList",pMap);
			logger.info("freeCmntList : " + freeCmntList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return freeCmntList;
	}
	
	public int insertFreeCmnt(Map<String,Object> pMap) {
		logger.info("FreeBoardDao insertFreeCmnt 호출 성공");
		int result = 0;
		result = sqlSession.insert(NAMESPACE+"insertFreeCmnt",pMap);
		return result;
	}

	public int deleteFreeCmnt(Map<String, Object> pMap) {
		logger.info("FreeBoardDao deleteFreeCmnt 호출 성공");
		int result = 0;
		result = sqlSession.delete(NAMESPACE+"deleteFreeCmnt",pMap);
		return result;
	}
}
