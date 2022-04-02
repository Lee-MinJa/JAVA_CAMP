package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDao {
	Logger logger = LogManager.getLogger(FreeBoardDao.class);
	
	private static final String NAMESPACE = "com.example.demo.freeboard.";
	
	@Autowired
	private SqlSession sqlSession = null;
		
	public List<Map<String,Object>> getFreeBoardList(Map<String,Object> pMap) {
		logger.info("FreeBoardDao getFreeBoardList 호출 성공");
			List<Map<String,Object>> freeBoardList = sqlSession.selectList(NAMESPACE+"getFreeBoardList",pMap);
			logger.info("freeBoardList : " + freeBoardList);		
		return freeBoardList;
	}
	
	public List<Map<String, Object>> searchFreeBoard(String keyword) {
		logger.info("FreeBoardDao searchFreeBoard 호출 성공");
		logger.info("FreeBoardDao searchFreeBoard keyword : "+keyword);
		List<Map<String,Object>> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"searchFreeBoard",keyword);		
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return list;		
	}
	
	public List<Map<String, Object>> getFreeBoardDetail(int free_num) {
		logger.info("FreeBoardDao getFreeBoardDetail 호출 성공");
		logger.info("FreeBoardDao getFreeBoardDetail freeNum : "+free_num);
		List<Map<String,Object>> freeBoardDetail = null;
		try {
			freeBoardDetail = sqlSession.selectList(NAMESPACE+"getFreeBoardDetail",free_num);
			logger.info("freeBoardDetail : " + freeBoardDetail);		
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		return freeBoardDetail;
	}
	
	public void updateFreeBoardViews(int free_num) {
		logger.info("FreeBoardDao updateFreeBoardViews 호출 성공");
		sqlSession.update(NAMESPACE+"updateFreeBoardViews", free_num);
	}
	
	public int insertFreeBoard(Map<String, Object> pMap) {
		logger.info("FreeBoardDao insertFreeBoard 호출 성공");
		logger.info("FreeBoardDao insertFreeBoard pMap : "+pMap);

		int result = 0;
		result = sqlSession.insert(NAMESPACE+"insertFreeBoard",pMap);
		logger.info("FreeBoardDao insertFreeBoard result : "+result);
		return result;
	}
	
	public int getFreeNum() {
		int result = 0;
		try { result = sqlSession.selectOne("getFreeNum"); } 
		catch (Exception e) { logger.info("Exception : "+e.toString()); }
		return result;
	}
	
	public void insertImageFileList(List<Map<String, Object>> list) {
		logger.info("FreeBoardDao insertImageFileList 호출 성공");
		logger.info("FreeBoardDao insertImageFileList list : "+list);
		
		for(int i=0; i<list.size();i++) {
			Map<String,Object> rMap = list.get(i);
			int free_num = (int)list.get(i).get("free_num");
			String image_filename = list.get(i).get("image_filename").toString();
			String image_filepath = list.get(i).get("image_filepath").toString();
			String image_url = list.get(i).get("image_url").toString();
			float image_size = (long)list.get(i).get("image_size");
			rMap.put("free_num", free_num);			
			rMap.put("image_filename", image_filename);			
			rMap.put("image_filepath", image_filepath);			
			rMap.put("image_url", image_url);			
			rMap.put("image_size", image_size);
			logger.info("rMap : "+rMap);
			sqlSession.insert(NAMESPACE+"insertImageFileList",rMap);
		}
	}
	
	public int updateFreeBoard(Map<String, Object> pMap) {
		logger.info("FreeBoardDao updateFreeBoard 호출 성공");
		logger.info("FreeBoardDao updateFreeBoard free_num : "+pMap);
		int result = 0;
		result = sqlSession.update(NAMESPACE+"updateFreeBoard",pMap);
		return result;
	}

	public int deleteFreeBoard(int free_num) {
		logger.info("FreeBoardDao deleteFreeBoard 호출 성공");
		int result = 0;
		result = sqlSession.delete(NAMESPACE+"deleteFreeBoard",free_num);
		return result;
	}

}


