package com.example.demo.Review;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PrBoard.PrBoardController;

@RestController
@RequestMapping("/Review/*")
public class RestReviewController {
	Logger logger = LogManager.getLogger(RestReviewController.class);
	@Autowired
	private ReviewLogic reviewLogic = null;
	
	
	
	//댓글 조회해서 대댓글 작성할때 사용하면될거같음 댓글 자세히 보기 기능?
	@GetMapping("JsonReviewList")
	public List<Map<String,Object>> ReviewList(@RequestParam Map<String,Object> pMap) 
	
	{
		logger.info("PrBoardList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> ReviewList = null;
		ReviewList = reviewLogic.ReviewList(pMap);
		
		return ReviewList;
		
	}
	
	
}
