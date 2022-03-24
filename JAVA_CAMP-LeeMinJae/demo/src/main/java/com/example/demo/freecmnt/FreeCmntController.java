package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/freecmnt/*")
public class FreeCmntController {
	Logger logger = LogManager.getLogger(FreeCmntController.class);
	
	@Autowired
	private FreeCmntLogic freeCmntLogic = null;
	
	//TEST URL : http://localhost:9000/freecmnt/getFreeCmntList
	@RequestMapping("getFreeCmntList")
	public String getFreeCmntList(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("getFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = freeCmntLogic.getFreeCmntList(pMap);
		model.addAttribute("freeCmntList", freeCmntList);
		return "freecmnt/getFreeCmntList";		
	}
	
	//TEST URL : http://localhost:9000/freecmnt/openFreeCmntWriteForm
	@GetMapping("openFreeCmntWriteForm")
	public String openFreeCmntWriteForm() {
		logger.info("openFreeCmntWriteForm 호출 성공");
		return "freecmnt/freeCmntWriteForm";		
	}
	
	@PostMapping("insertFreeCmnt")
	public String insertFreeCmnt(@RequestParam Map<String,Object> pMap) {
		logger.info("insertFreeCmnt 호출 성공");
		freeCmntLogic.insertFreeCmnt(pMap);
		return "redirect:getFreeCmntList";
	}
	
	//TEST URL : http://localhost:9000/freecmnt/deleteFreeCmnt?FREE_CMNT_NUM=댓글번호
	@GetMapping("deleteFreeCmnt")
	public String deleteFreeCmnt(@RequestParam Map<String,Object> pMap) {
		logger.info("deleteFreeCmnt 호출 성공");
		freeCmntLogic.deleteFreeCmnt(pMap);
		return "redirect:getFreeCmntList";		
	}
}
