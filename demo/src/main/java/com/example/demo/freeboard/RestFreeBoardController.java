package com.example.demo.freeboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.FileUtils;
import com.google.gson.Gson;

@RestController
@RequestMapping("/")
public class RestFreeBoardController {
	Logger logger = LogManager.getLogger(RestFreeBoardController.class);
	
	@Autowired
	FileUtils fileUtils;
	
	@Autowired
	FreeBoardDao freeBoardDao;
		
	@Autowired
	private FreeBoardLogic freeBoardLogic;
	
	@GetMapping("freeboard")
	public String jsonFreeBoardList(Map<String, Object> pMap) {
		logger.info("RestFreeBoardController jsonFreeBoardList 호출 성공");
		List<Map<String,Object>> freeBoardList = null;
		freeBoardList = freeBoardLogic.getFreeBoardList(pMap);		
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeBoardList);
		return result;
	}
	
	@GetMapping("freeboard/search")
	public String searchFreeBoard(@RequestParam String keyword) {
		logger.info("RestFreeBoardController searchFreeBoard 호출 성공");
		logger.info("RestFreeBoardController searchFreeBoard keyword"+keyword);
		List<Map<String,Object>> list = null;
		list = freeBoardLogic.searchFreeBoard(keyword);
		String result = null;
		Gson g = new Gson();
		result = g.toJson(list);
		return result;
	}
	
	@GetMapping("freeboard/post")
	public String getFreeBoardDetail(@RequestParam int free_num) {
		logger.info("getFreeBoardDetail 호출 성공");
		logger.info("FreeBoardController getFreeBoardDetail free_num"+free_num);
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardLogic.getFreeBoardDetail(free_num);		
		String result = null;
		Gson g = new Gson();
		result = g.toJson(freeBoardDetail);
		return result;		
	}
	
	@PutMapping("freeboard/views")
	public void updateFreeBoardViews(@RequestParam int free_num) {
		freeBoardLogic.updateFreeBoardViews(free_num);
	}
	
	@PostMapping("freeboard/write")
	public String insertFreeBoard(@RequestBody Map<String,Object> pMap) throws Exception {
		logger.info("RestFreeBoardController insertFreeBoard 호출 성공");	
		logger.info("RestFreeBoardController insertFreeBoard pMap : "+pMap);
		pMap.put("mem_num", pMap.remove("writer"));
		pMap.put("free_subject", pMap.remove("categoryValue"));
		pMap.put("free_title", pMap.remove("titleValue"));
		pMap.put("free_content", pMap.remove("contentValue"));
		pMap.put("free_regdate", pMap.remove("dateValue"));
		freeBoardLogic.insertFreeBoard(pMap);
		return "입력완료";
	}
	
	@PostMapping("freeboard/images")
	public String insertImageFileList(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		logger.info("RestFreeBoardController insertImageFileList 호출 성공");
		
		List<Map<String, Object>> list = fileUtils.parseFileInfo(freeBoardDao.getFreeNum(), multipartHttpServletRequest);
		
		List<String> urlList = new ArrayList<>();
		
		for(int i=0; i<list.size();i++) {
			logger.info("pathList에 담을값 : "+list.get(i).get("image_url").toString());
			urlList.add(i,list.get(i).get("image_url").toString());
		}
		logger.info("RestFreeBoardController insertFreeBoard urlList : "+urlList);
		
		String result = null;
		Gson g = new Gson();
		result = g.toJson(urlList);
		logger.info("RestFreeBoardController insertFreeBoard result : "+result);
		
		if(CollectionUtils.isEmpty(list) == false) {
			logger.info("RestFreeBoardController insertImageFileList list : "+list);
			freeBoardLogic.insertImageFileList(list);
		}
		
		return result;		
	}
		
	@PostMapping("freeboard/update")
	public String updateFreeBoard(@RequestParam Map<String, Object> pMap) {
		logger.info("RestFreeBoardController updateFreeBoard 호출 성공");
		logger.info("RestFreeBoardController updateFreeBoard pMap : "+pMap);
		freeBoardLogic.updateFreeBoard(pMap);
		return "수정완료";
	}
	
	@DeleteMapping("freeboard/delete")
	public String deleteFreeBoard(@RequestParam int free_num) {
		logger.info("deleteFreeBoard 호출 성공");
		freeBoardLogic.deleteFreeBoard(free_num);
		return "삭제완료";
	}
	
}
