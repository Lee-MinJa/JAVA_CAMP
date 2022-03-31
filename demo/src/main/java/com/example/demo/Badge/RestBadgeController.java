package com.example.demo.Badge;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.freeboard.FreeBoardController;
import com.example.demo.freeboard.FreeBoardLogic;
import com.google.gson.Gson;

@RestController
@RequestMapping("/Badge/*")
public class RestBadgeController {

	Logger logger = LogManager.getLogger(RestBadgeController.class);

	@Autowired
	private BadgeLogic badgeLogic = null;
	
	@GetMapping("JsonBadgeList")
	public List<Map<String,Object>> BadgeList(@RequestParam Map<String,Object> pMap) 
	
	{
		logger.info("BadgeList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> BadgeList = null;
		BadgeList=badgeLogic.BadgeList(pMap);
		
		return BadgeList;
}
	
}
