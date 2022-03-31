package com.example.demo.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReviewLogic {
	Logger logger = LogManager.getLogger(ReviewLogic.class);
	
	@Autowired
	private ReviewDao reviewDao = null;
	
	public List<Map<String, Object>> ReviewList(Map<String, Object> pMap) {
		logger.info("PrBoardLogic 호출 성공");
		List<Map<String, Object>> ReviewList = null;
		ReviewList=reviewDao.ReviewList(pMap);
		
		return ReviewList;
	}
	 @Transactional
	public int ReviewInsert(Map<String, Object> pMap, List<MultipartFile> fileList) {
		logger.info("PrBoardInsert 호출 성공");
		int result = 0;
		result=reviewDao.ReviewInsert(pMap);
		logger.info("pMap 사라지나?===========>"+pMap);
		Map<String,Object> prBoardImg = new HashMap();
		prBoardImg.put("PROMO_NUM", pMap.get("PROMO_NUM"));
		prBoardImg.put("IMAGE_FILEPATH", pMap.get("IMAGE_FILEPATH"));
		prBoardImg.put("IMAGE_SIZE", pMap.get("IMAGE_SIZE"));
		
		for(int i=0; i<fileList.size(); i++) {
			prBoardImg.put("IMAGE_FILENAME", fileList.get(i).getOriginalFilename());
			logger.info("파일 리스트1111111111=======>"+prBoardImg.get("IMAGE_FILENAME"));
			int ImgResult = 0;
			ImgResult=reviewDao.ReviewImgInsert(prBoardImg);
		}
		logger.info("파일 리스트=======>"+pMap.get("IMAGE_FILENAME"));
		return result;
		}
		

	public int ReviewUpdate(Map<String, Object> pMap) {
		logger.info("ReviewUpdate 호출 성공");
		int result = 0;
		result=reviewDao.ReviewUpdate(pMap);
		int ImgResult =0;
		ImgResult = reviewDao.ReviewImgUpdate(pMap);
		
		return result;
	}
	public int ReviewDelete(Map<String, Object> pMap) {
		
		logger.info("ReviewDelete 호출 성공");
		int result = 0;
		result=reviewDao.ReviewDelete(pMap);
		
		return result;
	}

}
