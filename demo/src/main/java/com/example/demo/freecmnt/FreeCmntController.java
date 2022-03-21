package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freecmnt/*")
public class FreeCmntController {
	Logger logger = LogManager.getLogger(FreeCmntController.class);
	
	@Autowired
	private FreeCmntLogic freeCmntLogic = null;
	
	@RequestMapping("getFreeCmntList")
	public String getFreeCmntList(Model model) {
		logger.info("getFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = freeCmntLogic.getFreeCmntList();
		model.addAttribute("freeCmntList", freeCmntList);
		return "freecmnt/getFreeCmntList";		
	}
}
