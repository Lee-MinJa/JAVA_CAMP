package com.example.demo.Review_Cmnt;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/ReviewCmnt/*")
public class ReviewCmntController {
	Logger logger = LogManager.getLogger(ReviewCmntController.class);
	
	@Autowired
	private ReviewCmntLogic reviewCmntLogic = null;
	
	//댓글 조회해서 대댓글 작성할때 사용하면될거같음 댓글 자세히 보기 기능?
//	@GetMapping("ReviewCmntList")
//	public List<Map<String,Object>> ReviewCmntList(@RequestParam Map<String,Object> pMap) 
//	
//	{
//		logger.info("PrBoardList 호출 성공");
//		logger.info("사용자가 입력한 정보 ==> "+pMap);
//		List<Map<String,Object>> ReviewCmntList = null;
//		ReviewCmntList=reviewCmntLogic.ReviewCmntList(pMap);
//		
//		return ReviewCmntList;
//}
	
	
	@GetMapping("ReviewCmntInsert")
	public String ReviewInsert(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardCmntInsert 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		logger.info("REVIEW_NUM1111111111111111============>"+pMap.get("REVIEW_NUM"));
		int result = 0;
		logger.info("REVIEW_NUM=====2222222222222222=======>"+pMap.get("REVIEW_NUM"));
		result = reviewCmntLogic.ReviewCmntInsert(pMap);
		logger.info("REVIEW_NUM============>"+pMap.get("REVEIW_NUM"));
		return "redirect:./JsonReviewCmntList?REVIEW_NUM="+pMap.get("REVIEW_NUM");
	}
	@GetMapping("ReviewCmntUpdate")
	public String ReviewUpdate(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardUpdate 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = reviewCmntLogic.ReviewCmntUpdate(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonReviewCmntList?REVIEW_NUM="+pMap.get("REVIEW_NUM");
	}
	@GetMapping("ReviewCmntDelete")
	public String ReviewDelete(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardDelete 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = reviewCmntLogic.ReviewCmntDelete(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonReviewCmntList?REVIEW_NUM="+pMap.get("REVIEW_NUM");
		
	}
	
	
}

	
	
