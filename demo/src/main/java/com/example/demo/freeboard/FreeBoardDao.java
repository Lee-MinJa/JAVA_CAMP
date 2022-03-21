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
	
	public List<Map<String, Object>> getFreeBoardList() {
		logger.info("FreeBoardDao getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = sqlSession.selectList(NAMESPACE+"getFreeBoardList");
		logger.info("freeBoardList : " + freeBoardList);
		return freeBoardList;
	}

}
