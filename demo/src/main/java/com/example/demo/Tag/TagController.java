package com.example.demo.Tag;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TagController {
	
	@Autowired
	private TagLogic tagLogic = null;
	
//	@GetMapping("JsonTagList")
//	public List<Map<String,Object>> ReviewList(@RequestParam Map<String,Object> pMap) 
//	
//	{
//		logger.info("JsonTagList 호출 성공");
//		logger.info("사용자가 입력한 정보 ==> "+pMap);
//		List<Map<String,Object>> ReviewList = null;
//		ReviewList = reviewLogic.ReviewList(pMap);
//		
//		return ReviewList;
//	}
	
	
}
