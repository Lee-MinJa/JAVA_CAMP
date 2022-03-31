package com.example.demo.Tag;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagLogic {
	Logger logger = LogManager.getLogger(TagLogic.class);

	@Autowired
	private TagDao tagDao = null;
	
	public List<Map<String, Object>> TagList(Map<String, Object> pMap) {
		List<Map<String, Object>> TagList = null;
		TagList = tagDao.TagList(pMap);
		
		return TagList;
	}

}
