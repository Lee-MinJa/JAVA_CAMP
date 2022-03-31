package com.example.demo.PrBoard;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PrBoardLogic {

	Logger logger = LogManager.getLogger(PrBoardLogic.class);
	
	@Autowired
	private PrBoardDao prBoardDao = null;
	int total = 0;
	
	public List<Map<String, Object>> PrBoardList(Map<String, Object> pMap) {
		logger.info("PrBoardLogic 호출 성공");
		List<Map<String, Object>> PrBoardList = null;
		int page = 0;
		int pageSize = 0;
		int start = 0;
		int end = 0;
		if(pMap.get("page")!=null){
			page = Integer.parseInt(pMap.get("page").toString());
		}
		if(pMap.get("pageSize")!=null){
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());
		}
		logger.info("화면 page:"+page+"pageSize : "+pageSize);		
		if(page > 0){
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			logger.info("end : "+end);
			pMap.put("start", start);
			if(end >total){
				pMap.put("end", total);
			}else{
				pMap.put("end", end);
			}
		}			
		logger.info("start222222222222222222222222:"+start);
		logger.info("end2222222222222222:"+end);
		
		PrBoardList = prBoardDao.PrBoardList(pMap);
		
		return PrBoardList;
	}
	
	public int totalRecord(Map<String, Object> pMap) {
		int total = 0;
		total = prBoardDao.totalRecord(pMap);
		return total;
		
	}
	
	
	public List<Map<String, Object>> PrBoardDetail(Map<String, Object> pMap) {
		logger.info("PrBoardDetailLogic 호출 성공");
		List<Map<String, Object>> PrBoardDetail = null;
		PrBoardDetail = prBoardDao.PrBoardDetail(pMap);
		
		
		return PrBoardDetail;
	}
	
	public List<Map<String, Object>> PrBoardTagList(Map<String, Object> pMap) {
		logger.info("PrBoardTagList Logic 호출 성공TAG_NAME==========>"+pMap.get("TAG_NAME"));
		List<Map<String,Object>> PrBoardTagList = null;
		PrBoardTagList = prBoardDao.PrBoardTagList(pMap);
		
		return PrBoardTagList;
	}
	
	 @Transactional
	public int PrBoardInsert(Map<String, Object> pMap, List<MultipartFile> fileList) {
		 int result = 0;
		 int TResult = 0;
		int TngResult = 0;
			 logger.info("PrBoardInsert 호출 성공!!");
				logger.info("prBoardDao 호출 전");
				logger.info("prBoardDao 호출 후");
				Map<String,Object> PrBoardInsert = new HashMap();
				PrBoardInsert.put("PROMO_NUM", pMap.get("PROMO_NUM"));
				PrBoardInsert.put("MEM_NUM", pMap.get("MEM_NUM"));
				PrBoardInsert.put("PROMO_REGION", pMap.get("PROMO_REGION"));
				PrBoardInsert.put("PROMO_CAMPSITE", pMap.get("PROMO_CAMPSITE"));
				PrBoardInsert.put("PROMO_MAIN_CONTENT", pMap.get("PROMO_MAIN_CONTENT"));
				PrBoardInsert.put("PROMO_DETAIL_CONTENT", pMap.get("PROMO_DETAIL_CONTENT"));
				prBoardDao.PrBoardInsert(PrBoardInsert);
<<<<<<< HEAD
=======
				//리뷰 디폴트값
				int review = 0;
				review=	prBoardDao.ReviewDefault();
>>>>>>> ac37c98 (Login)
				
				Map<String,Object> PrBoardTag = new HashMap();
				String TagArray []=pMap.get("TAG_NAME").toString().split(",");
				for(int i=0; i<TagArray.length; i++) {
					PrBoardTag.put("TAG_NAME", TagArray[i]);
					logger.info("Arrray[" + i + "]"+TagArray[i]);
					List<Map<String,Object>> tmp = prBoardDao.PrBoardTagList(PrBoardTag);
				logger.info("tmp 사이즈======>"+tmp);
				if(tmp.size() == 0) {
					TResult = prBoardDao.PrBoardTInsert(PrBoardTag);
					logger.info("인서트한 태그이름 ======>"+PrBoardTag.get("TAG_NAME"));
					logger.info("Arrray[" + i + "]"+TagArray[i]);
				}
				TngResult = prBoardDao.PrBoardTngInsert(PrBoardTag);
				}
				
				
				if(fileList !=null) {
<<<<<<< HEAD
					
					Map<String,Object> prBoardImg = new HashMap();
					prBoardImg.put("IMAGE_FILEPATH", pMap.get("IMAGE_FILEPATH"));
					prBoardImg.put("IMAGE_SIZE", pMap.get("IMAGE_SIZE"));
					for(int i=0; i<fileList.size(); i++) {
						if(i==0) {
							prBoardImg.put("IMAGE_FILENAME", fileList.get(i).getOriginalFilename());
//							logger.info("파일 리스트1111111111=======>"+pMap.get("IMAGE_FILENAME"));
							int ImgResult = 0;
							ImgResult = prBoardDao.PrBoardImgInsert(prBoardImg);
						}else {
							int ImgResult2 = 0;
							prBoardImg.put("IMAGE_FILENAME", fileList.get(i).getOriginalFilename());
							ImgResult2 = prBoardDao.PrBoardImgInsert2(prBoardImg);
//							logger.info("파일 리스트2222222222=======>"+pMap.get("IMAGE_FILENAME"));
=======
					Map<String,Object> prBoardImg = new HashMap();
					prBoardImg.put("IMAGE_FILEPATH", pMap.get("IMAGE_FILEPATH"));
					prBoardImg.put("IMAGE_SIZE", pMap.get("IMAGE_SIZE"));
					
					for(int i=0; i<fileList.size(); i++) {
						if(i==0) {
							prBoardImg.put("IMAGE_FILENAME", fileList.get(i).getOriginalFilename());
							logger.info("파일 리스트1111111111=======>"+prBoardImg.get("IMAGE_FILENAME"));
							int ImgResult = 0;
							ImgResult = prBoardDao.PrBoardImgInsert(prBoardImg);
						}else  {
							int ImgResult2 = 0;
							prBoardImg.put("IMAGE_FILENAME", fileList.get(i).getOriginalFilename());
							ImgResult2 = prBoardDao.PrBoardImgInsert2(prBoardImg);
							logger.info("파일 리스트1111111111=======>"+prBoardImg.get("IMAGE_FILENAME"));
>>>>>>> ac37c98 (Login)
						}
					}
					logger.info("파일 리스트=======>"+pMap.get("IMAGE_FILENAME"));
					}
<<<<<<< HEAD
		
				return result;
	}
//	 @Transactional(rollbackFor = Exception.class)
//	public int PrBoardTInsert(Map<String, Object> prBoardTag) {
//		 logger.info("prBoardDao 호출 후");
//		logger.info("태그로직 태그 리스트 =====>"+prBoardTag.get("TAG_NAME"));
//		int TResult = 0;
//		TResult = prBoardDao.PrBoardTInsert(prBoardTag);
//			
//		return TResult;
//	}
//	
//	public int PrBoardTngInsert(Map<String, Object> prBoardTag) {
//		logger.info("태그로직 태그 리스트 =====>"+prBoardTag.get("TAG_NAME"));
//		int TngResult = 0;
//		TngResult = prBoardDao.PrBoardTngInsert(prBoardTag);
//		return TngResult;
//	}

//	public int PrBoardImgInsert(Map<String, Object> PrBoardImg) {
//		int TResult = 0;
//		TResult = prBoardDao.PrBoardImgInsert(PrBoardImg);
//		if(PrBoardImg.get("IMAGE_FILENAME")!=null && PrBoardImg.get("IMAGE_FILENAME").toString().length() >1) {
//		}
//		return TResult;
//	}
//	public int PrBoardImgInsert2(Map<String, Object> prBoardImg) {
//		int TResult = 0;
//		TResult = prBoardDao.PrBoardImgInsert2(prBoardImg);
//		if(prBoardImg.get("IMAGE_FILENAME")!=null && prBoardImg.get("IMAGE_FILENAME").toString().length() >1) {
//		}
//		return TResult;
//	}

	
=======
				
				
		
				return result;
	}
	 
	 
	 
>>>>>>> ac37c98 (Login)
	public int PrBoardUpdate(Map<String, Object> prBoardUpdate) {
		logger.info("PrBoardUpdate 호출 성공!!");
		int result = 0;
		result = prBoardDao.PrBoardUpdate(prBoardUpdate);
		
		return result;
	}
	public int PrBoardTaggingDelete(Map<String, Object> pMap) {
		logger.info("태깅 삭제 로직호출 성공!!==========>"+pMap);
		int result = 0;
		result = prBoardDao.PrBoardTaggingDelete(pMap);
		
		return result;
	}
	public int PrBoardTaggingInsert(Map<String, Object> prBoardTag) {
		logger.info("PrBoardInsert 호출 성공!!");
		int Tresult = 0;
		Tresult = prBoardDao.PrBoardTaggingInsert(prBoardTag);
		
		return Tresult;
	}
	public int PrBoardImgUpdate(Map<String, Object> prBoardImg) {
		
		logger.info("이미지업데이트 호출 성공!!"+prBoardImg);
		int Iresult = 0;
		Iresult = prBoardDao.PrBoardImgUpdate(prBoardImg);
		
		return Iresult;
	}
	public int PrBoardDelete(Map<String, Object> pMap) {
		logger.info("게시판 삭제로직 호출 성공!!");
		int result = 0;
		result = prBoardDao.PrBoardDelete(pMap);
		
		
		return result;
	}

	


}
