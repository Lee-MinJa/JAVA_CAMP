package com.example.demo.Review_Cmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Review.RestReviewController;
import com.example.demo.Review.ReviewLogic;

@RestController
@RequestMapping("/ReviewCmnt/*")
public class RestReviewCmntController {
	Logger logger = LogManager.getLogger(RestReviewCmntController.class);
	@Autowired
	private ReviewCmntLogic reviewCmntLogic = null;
	
	
	
	//댓글 조회해서 대댓글 작성할때 사용하면될거같음 댓글 자세히 보기 기능?
	@GetMapping("JsonReviewCmntList")
	public List<Map<String,Object>> ReviewCmntList(@RequestParam Map<String,Object> pMap) 
	
	{
		logger.info("PrBoardList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> ReviewCmntList = null;
		ReviewCmntList=reviewCmntLogic.ReviewCmntList(pMap);
		
		return ReviewCmntList;
}
	
}
