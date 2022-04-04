package project.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDao {
	Logger logger = LogManager.getLogger(ImageDao.class);
	
	private static final String NAMESPACE = "project.repository.";
	
	@Autowired
	private SqlSession sqlSession = null;
	
	public int imageUpload(Map<String,Object> pMap) {
		
		logger.info("pMap : "+pMap);
		
		int result = 0;
		try {
			result = sqlSession.insert(NAMESPACE+"insertImageInfo", pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}	

}
