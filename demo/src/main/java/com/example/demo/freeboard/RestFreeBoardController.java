package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/freeboard/*")
public class RestFreeBoardController {
	Logger logger = LogManager.getLogger(RestFreeBoardController.class);
	
	@Autowired
	private FreeBoardLogic freeBoardLogic = null;
	
	//TEST URL : http://localhost:9000/freeboard/jsonFreeBoardList
	@GetMapping("jsonFreeBoardList")
	public String jsonFreeBoardList(Map<String,Object> pMap) {
		logger.info("jsonFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardLogic.getFreeBoardList(pMap);		
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeBoardList);
		return result;
	}
}
