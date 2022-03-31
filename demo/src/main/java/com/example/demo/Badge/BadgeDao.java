package com.example.demo.Badge;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BadgeDao {
		Logger logger = LogManager.getLogger(BadgeDao.class);

		@Autowired
		private SqlSessionTemplate sqlSessionTemplate = null;

	public List<Map<String, Object>> BadgeList(Map<String, Object> pMap) {
		logger.info("Badge DAO 호출 성공");
		List<Map<String, Object>> BadgeList = null;
		BadgeList = sqlSessionTemplate.selectList("BadgeList", pMap);
		logger.info("BadgeList :  ===========> "+BadgeList);
		return BadgeList;
		
	}

	public int BadgeInsert(Map<String, Object> pMap) {
		logger.info("BadgeInsert DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("BadgeInsert", pMap);
		logger.info("result :  ===========> "+result);
		return result;
	}

	public int BadgeUpdate(Map<String, Object> pMap) {
		logger.info("BadgeUpdate DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("BadgeUpdate", pMap);
		logger.info("BadgeList :  ===========> "+result);
		return result;
	}

	public int BadgeDelete(Map<String, Object> pMap) {
		logger.info("BadgeDelete DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.delete("BadgeDelete", pMap);
		logger.info("BadgeList :  ===========> "+result);
		return result;	
	}

}
