package com.example.demo.Tag;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagDao {
	Logger logger = LogManager.getLogger(TagDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public List<Map<String, Object>> TagList(Map<String, Object> pMap) {
		List<Map<String, Object>> TagList = null;
		TagList=sqlSessionTemplate.selectList("TagList",pMap);
		
		return TagList;
	}

}
