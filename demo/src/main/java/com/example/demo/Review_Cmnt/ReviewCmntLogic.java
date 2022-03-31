package com.example.demo.Review_Cmnt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Review.ReviewDao;
import com.example.demo.Review.ReviewLogic;

@Service
public class ReviewCmntLogic {
	
	Logger logger = LogManager.getLogger(ReviewCmntLogic.class);
	
	@Autowired
	private ReviewCmntDao reviewCmntDao = null;
	

	public List<Map<String, Object>> ReviewCmntList(Map<String, Object> pMap) {
	
		logger.info("PrBoardLogic 호출 성공");
		List<Map<String, Object>> ReviewList = null;
		ReviewList=reviewCmntDao.ReviewCmntList(pMap);
		
		return ReviewList;
		
	}
	//리뷰에 댓글달면 리뷰 YN Y로 업데이트 시켜주기
	 @Transactional
	public int ReviewCmntInsert(Map<String, Object> pMap) {
		logger.info("PrBoardInsert 호출 성공");
		int result = 0;
		result=reviewCmntDao.ReviewCmntInsert(pMap);
		
		int YN=0;
		
		logger.info("댓글 YN업데이트 결과 ========>"+pMap);
		YN=reviewCmntDao.ReviewYnUpdate(pMap);
		logger.info("댓글 YN업데이트 결과 ========>"+YN);
		
		return result;
		}
		

	public int ReviewCmntUpdate(Map<String, Object> pMap) {
		logger.info("ReviewCmntDelete 호출 성공");
		int result = 0;
		result=reviewCmntDao.ReviewCmntUpdate(pMap);
		return result;
	}
	
	public int ReviewCmntDelete(Map<String, Object> pMap) {
		logger.info("ReviewCmntDelete 호출 성공");
		int result = 0;
		result=reviewCmntDao.ReviewCmntDelete(pMap);
		return result;
	}

}
