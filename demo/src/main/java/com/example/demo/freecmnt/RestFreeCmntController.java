package com.example.demo.freecmnt;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/freecmnt/*")
public class RestFreeCmntController {
	Logger logger = LogManager.getLogger(RestFreeCmntController.class);
	
	@Autowired
	private FreeCmntLogic freeCmntLogic = null;
	
	@RequestMapping("jsonFreeCmntList")
	public String jsonFreeCmntList() {
		logger.info("jsonFreeCmntList 호출 성공");
		List<Map<String,Object>> freeCmntList = null;
		freeCmntList = freeCmntLogic.getFreeCmntList();
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeCmntList);
		return result;
	}
}
