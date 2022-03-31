package com.example.demo.Review;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewDao {
	Logger logger = LogManager.getLogger(ReviewDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public List<Map<String, Object>> ReviewList(Map<String, Object> pMap) {
		logger.info("ReviewList DAO 호출 성공");
		List<Map<String, Object>> ReviewList = null;
		ReviewList = sqlSessionTemplate.selectList("ReviewList", pMap);
		logger.info("ReviewList : "+ReviewList);
		
		return ReviewList;
	
	}
	public int ReviewInsert(Map<String, Object> pMap) {
		int result = 0;
		logger.info("ReviewInsert DAO 호출 성공");
		result = sqlSessionTemplate.insert("ReviewInsert", pMap);
		logger.info("리뷰인서트 결과 : "+result);
		return result;
		
	}
	public int ReviewImgInsert(Map<String, Object> pMap) {
		int result = 0;
		logger.info("Review이미지Insert DAO 호출 성공===============>"+pMap);
		result = sqlSessionTemplate.insert("ReviewImgInsert", pMap);
		logger.info("리뷰이미지인서트 결과 : "+result);
		return result;
		
	}
	public int ReviewUpdate(Map<String, Object> pMap) {
		int result = 0;
		logger.info("ReviewUpdate DAO 호출 성공");
		result = sqlSessionTemplate.update("ReviewUpdate", pMap);
		logger.info("리뷰 업데이트 결과 : "+result);
		return result;
		
	}
	public int ReviewImgUpdate(Map<String, Object> pMap) {
		int result = 0;
		logger.info("ReviewImgUpdate DAO 호출 성공");
		result = sqlSessionTemplate.update("ReviewImgUpdate", pMap);
		logger.info("리뷰 업데이트 결과 : "+result);
		return result;
	}
	public int ReviewDelete(Map<String, Object> pMap) {
		int result = 0;
		logger.info("ReviewDelete DAO 호출 성공");
		result = sqlSessionTemplate.update("ReviewDelete", pMap);
		logger.info("리뷰 삭제 결과 : "+result);
		return result;
	}
}
