package com.example.demo.util;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageDao {
	Logger logger = LogManager.getLogger(ImageDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public List<Map<String, Object>> ImageList(Map<String, Object> pMap) {
		logger.info("ImageList DAO 호출 성공");
		List<Map<String, Object>> ImageList = null;
		ImageList = sqlSessionTemplate.selectList("ImageList", pMap);
		logger.info("ImageList : "+ImageList);
		
		return ImageList;
	}

}
