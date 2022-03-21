package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/freeboard/*")
public class RestFreeBoardController {
	Logger logger = LogManager.getLogger(RestFreeBoardController.class);
	
	@Autowired
	private FreeBoardLogic freeBoardLogic = null;
	
	@RequestMapping("jsonFreeBoardList")
	public String jsonFreeBoardList() {
		logger.info("jsonFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardLogic.getFreeBoardList();		
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeBoardList);
		return result;
	}
}
