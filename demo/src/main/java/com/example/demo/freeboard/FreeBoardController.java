package com.example.demo.freeboard;

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
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	Logger logger = LogManager.getLogger(FreeBoardController.class);

	@Autowired
	private FreeBoardLogic freeBoardLogic = null;
	
<<<<<<< HEAD
	//TEST URL : http://localhost:9000/freeboard/getFreeBoardList
	@GetMapping("getFreeBoardList")
	public String getFreeBoardList(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardLogic.getFreeBoardList(pMap);
=======
	@RequestMapping("FreeBoardList")
	public String getFreeBoardList(Model model) {
		logger.info("getFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
//		freeBoardList = freeBoardLogic.getFreeBoardList(meodel);
>>>>>>> ac37c98 (Login)
		model.addAttribute("freeBoardList", freeBoardList);
		return "freeboard/getFreeBoardList";		
	}
	
	//TEST URL : http://localhost:9000/freeboard/openFreeBoardWriteForm
	@GetMapping("openFreeBoardWriteForm")
	public String openFreeBoardWrite() {
		logger.info("openFreeBoardWrite 호출 성공");
		return "freeboard/freeBoardWriteForm";
	}
	
	@PostMapping("insertFreeBoard")
	public String insertFreeBoard(@RequestParam Map<String,Object> pMap) {
		logger.info("insertFreeBoard 호출 성공");
		freeBoardLogic.insertFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}
	
	//TEST URL : http://localhost:9000/freeboard/getFreeBoardDetail?FREE_NUM=글번호
	@GetMapping("getFreeBoardDetail")
	public String getFreeBoardDetail(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("getFreeBoardDetail 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardLogic.getFreeBoardDetail(pMap);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		return "freeboard/getFreeBoardDetail";		
	}
	
	//TEST URL : http://localhost:9000/freeboard/openFreeBoardModifyForm?FREE_NUM=글번호 
	@GetMapping("openFreeBoardModifyForm")
	public String openFreeBoardModify(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("openFreeBoardModify 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardLogic.getFreeBoardDetail(pMap);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		return "freeboard/freeBoardModifyForm";
	}
	
	@PostMapping("updateFreeBoard")
	public String updateFreeBoard(@RequestParam Map<String,Object> pMap) {
		logger.info("updateFreeBoard 호출 성공");
		freeBoardLogic.updateFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}
	
	//TEST URL : http://localhost:9000/freeboard/deleteFreeBoard?FREE_NUM=글번호&MEM_NUM=회원번호
	@GetMapping("deleteFreeBoard")
	public String deleteFreeBoard(@RequestParam Map<String,Object> pMap) {
		logger.info("deleteFreeBoard 호출 성공");
		freeBoardLogic.deleteFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}	
}
