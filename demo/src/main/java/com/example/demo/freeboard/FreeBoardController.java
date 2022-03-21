package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	Logger logger = LogManager.getLogger(FreeBoardController.class);

	@Autowired
	private FreeBoardLogic freeBoardLogic = null;
	
	@RequestMapping("getFreeBoardList")
	public String getFreeBoardList(Model model) {
		logger.info("getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardLogic.getFreeBoardList();
		model.addAttribute("freeBoardList", freeBoardList);
		return "freeboard/getFreeBoardList";		
	}
}
