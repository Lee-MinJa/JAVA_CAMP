package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class RestFreeCmntController {
	Logger logger = LogManager.getLogger(RestFreeCmntController.class);
	
	@Autowired
	private FreeCmntLogic freeCmntLogic = null;
	
	@GetMapping("freecmnt")
	public String jsonFreeCmntList(@RequestParam int free_num) {
		logger.info("RestFreeCmntController jsonFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = freeCmntLogic.getFreeCmntList(free_num);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeCmntList);
		return result;
	}
	
	@PostMapping("freecmnt/write")
	public String insertFreeCmnt(@RequestBody Map<String,Object> pMap) {
		logger.info("RestFreeCmntController insertFreeCmnt 호출 성공");
		logger.info("RestFreeCmntController insertFreeCmnt pMap : "+pMap);
		pMap.put("mem_num", pMap.remove("writer"));
		pMap.put("free_cmnt_content", pMap.remove("commentValue"));
		pMap.put("free_cmnt_regdate", pMap.remove("dateValue"));
		freeCmntLogic.insertFreeCmnt(pMap);
		return "입력완료";
	}
	
	@DeleteMapping("freecmnt/delete")
	public String deleteFreeCmnt(@RequestParam int free_cmnt_num) {
		logger.info("RestFreeCmntController deleteFreeCmnt 호출 성공");
		freeCmntLogic.deleteFreeCmnt(free_cmnt_num);
		return "삭제완료";	
		
	}
}

