package com.example.demo.Badge;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Badge/")
public class BadgeController {
	Logger logger = LogManager.getLogger(BadgeController.class);
	@Autowired
	private BadgeLogic badgeLogic = null;
	
	@GetMapping("BadgeInsert")
	public String BadgeInsert(@RequestParam Map<String,Object> pMap) 
	{
		int result = 0;
		result = badgeLogic.BadgeInsert(pMap);
		return "redirect:./JsonBadgeList";
	}
	@GetMapping("BadgeUpdate")
	public String BadgeUpdate(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardUpdate 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = badgeLogic.BadgeUpdate(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonBadgeList";
	}
	
	@GetMapping("BadgeDelete")
	public String BadgeDelete(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardDelete 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = badgeLogic.BadgeDelete(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonBadgeList";
		
	}
	
}
