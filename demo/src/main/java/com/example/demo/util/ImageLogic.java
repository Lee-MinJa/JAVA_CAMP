package com.example.demo.util;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageLogic {
	Logger logger = LogManager.getLogger(ImageLogic.class);
	@Autowired
	private ImageDao imageDao = null;
	public List<Map<String, Object>> ImageList(Map<String, Object> pMap) {
		List<Map<String, Object>> ImageList = null;
		ImageList=imageDao.ImageList(pMap);
		return ImageList;
	}

}
