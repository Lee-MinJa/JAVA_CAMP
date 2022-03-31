package com.example.demo.Review_Cmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Review.ReviewDao;

@Service
public class ReviewCmntDao {

	Logger logger = LogManager.getLogger(ReviewCmntDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	
	public List<Map<String, Object>> ReviewCmntList(Map<String, Object> pMap) {
		logger.info("ReviewCmntList DAO 호출 성공");
		List<Map<String, Object>> ReviewCmntList = null;
		ReviewCmntList = sqlSessionTemplate.selectList("ReviewCmntList", pMap);
		logger.info("ReviewList : "+ReviewCmntList);
		
		return ReviewCmntList;
	}


	public int ReviewCmntInsert(Map<String, Object> pMap) {
		int result=0;
		result = sqlSessionTemplate.insert("ReviewCmntInsert", pMap);
		logger.info("리뷰 인서트 결과=========> : "+result);
		return result;

	}


	public int ReviewCmntUpdate(Map<String, Object> pMap) {
		int result=0;
		result = sqlSessionTemplate.update("ReviewCmntUpdate", pMap);
		logger.info("ReviewList : "+result);
		
		return result;

	}


	public int ReviewCmntDelete(Map<String, Object> pMap) {
		int result=0;
		result = sqlSessionTemplate.delete("ReviewCmntDelete", pMap);
		logger.info("ReviewList : "+result);
		
		return result;

	}


	public int ReviewYnUpdate(Map<String, Object> pMap) {
		int result=0;
		result = sqlSessionTemplate.update("ReviewYNUpdate", pMap);
		logger.info("ReviewCmntYnUpdate 결과========> : "+result);
		
		return result;
	}

}
