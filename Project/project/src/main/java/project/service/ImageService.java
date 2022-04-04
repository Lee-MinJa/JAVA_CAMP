package project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.repository.FreeBoardDao;
import project.repository.ImageDao;

@Service
public class ImageService {

	@Autowired
	FreeBoardDao freeBoardDao;
		
	@Autowired
	ImageDao imageDao;
	
	public int imageUpload(Map<String,Object> pMap) {
		
		int result = 0;
		int freeNum = 0;
		
		freeNum = freeBoardDao.getFreeNum();
				
		pMap.put("free_num", freeNum);
		
		result = imageDao.imageUpload(pMap);
		
		return result;
			
	}
	
}
