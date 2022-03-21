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
	
	public List<Map<String, Object>> getFreeCmntList() {
		logger.info("FreeCmntDao getFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = sqlSession.selectList(NAMESPACE+"getFreeCmntList");
		logger.info("freeCmntList : " + freeCmntList);
		return freeCmntList;
	}
}
