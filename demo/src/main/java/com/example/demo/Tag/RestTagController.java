package com.example.demo.Tag;

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
@RequestMapping("/Tag/*")
public class RestTagController {
	Logger logger = LogManager.getLogger(RestTagController.class);

	@Autowired
	private TagLogic tagLogic = null;
	
	@GetMapping("JsonTagList")
	public List<Map<String,Object>> TagList(@RequestParam Map<String,Object> pMap) 
	
	{
		logger.info("JsonTagList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> TagList = null;
		TagList = tagLogic.TagList(pMap);
		
		return TagList;
	}
	
	

}
