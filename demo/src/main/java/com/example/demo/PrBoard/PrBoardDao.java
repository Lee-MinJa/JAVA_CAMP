package com.example.demo.PrBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrBoardDao {
	Logger logger = LogManager.getLogger(PrBoardLogic.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	int total = 0;
	public List<Map<String, Object>> PrBoardList(Map<String, Object> pMap) {
		logger.info("PrBoardList DAO 호출 성공");
		List<Map<String, Object>> PrBoardList = null;
		PrBoardList = sqlSessionTemplate.selectList("PrBoardList", pMap);
		logger.info("boardList : "+PrBoardList);
		
		return PrBoardList;
	}
	public List<Map<String, Object>> PrBoardDetail(Map<String, Object> pMap) {
		logger.info("PrBoardDetail DAO 호출 성공");
		List<Map<String, Object>> PrBoardDetail = null;
		PrBoardDetail = sqlSessionTemplate.selectList("PrBoardDetail", pMap);
		logger.info("boardList : "+PrBoardDetail);
		
		return PrBoardDetail;
	}
	public List<Map<String, Object>> PrBoardTagList(Map<String, Object> pMap) {
		logger.info("PrBoardTagList DAO 호출 성공");
		logger.info("태그리스트 다오 :=========>"+pMap.get("TAG_NAME"));
		List<String> room = new ArrayList<String>();
		List<Map<String, Object>> PrBoardTagList = null;
		PrBoardTagList = sqlSessionTemplate.selectList("PrBoardTagList", pMap);
		logger.info("태그리스트 : "+PrBoardTagList);
		return PrBoardTagList;
	}
	//promo_board 테이블 insert하기
	public int PrBoardInsert(Map<String, Object> pMap) {
		logger.info("PrBoardInsert Dao 호출 성공");
		int result = sqlSessionTemplate.insert("PrBoardInsert", pMap);
		logger.info("게시판 인서트 결과 =========>" +result);
		return result;
	}
	//태그 insert 태깅 테이블에는  여기서 테그 테이블에 인서트를 성공하면 트리거로 태깅 테이블에 tag_code가 들어가게 되어있음
	public int PrBoardTInsert(Map<String, Object> prBoardTag) {
		logger.info("PrBoardTag Dao 호출 성공=========>"+prBoardTag );
		int TResult = sqlSessionTemplate.insert("PrBoardTInsert", prBoardTag);
		logger.info("태그 인서트 결과 =========>" +TResult);
		return TResult;
	}
	public int PrBoardTngInsert(Map<String, Object> prBoardTag) {
		
		int TngResult = sqlSessionTemplate.insert("PrBoardTngInsert", prBoardTag);
		logger.info("인서트결과===========>"+TngResult);
		return TngResult;
	}
	/*
	 * 	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public int boardSInsert(Map<String, Object> pMap) {
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("PrBoardImgInsert", pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	 */
	//img insert
	public int PrBoardImgInsert(Map<String, Object> prBoardImg) {
		logger.info("PrBoardImg Dao 호출 성공");
		int IResult = sqlSessionTemplate.insert("PrBoardImgInsert", prBoardImg);
		logger.info("이미지 인서트 결과 =========>" +IResult);
		return IResult;
	}
	public int PrBoardImgInsert2(Map<String, Object> prBoardImg) {
		logger.info("PrBoardImg Dao 22222222222호출 성공");
		int IResult = sqlSessionTemplate.insert("PrBoardImgInsert2", prBoardImg);
		logger.info("이미지 인서트 결과2222 =========>" +IResult);
		return IResult;
	}
	public int PrBoardUpdate(Map<String, Object> prBoardUpdate) {
		logger.info("PrBoardUpdate Dao 호출 성공");
		int result = sqlSessionTemplate.update("PrBoardUpdate", prBoardUpdate);
		logger.info("게시판 인서트 결과 =========>" +result);
		return result;
	}
	public int PrBoardTaggingDelete(Map<String, Object> pMap) {
		logger.info("태깅삭제  Dao 호출 성공");
		int result = sqlSessionTemplate.delete("PrBoardTaggingDelete", pMap);
		logger.info("태그 삭제 결과 =========>" +result);
		return result;
	}
	//태깅  삭제후 인서트할꺼임
	public int PrBoardTaggingInsert(Map<String, Object> prBoardTag) {
		logger.info("태깅인서트 호출성공=========>"+prBoardTag );
		int TResult = sqlSessionTemplate.insert("PrBoardTaggingInsert", prBoardTag);
		logger.info("태그 인서트 결과 =========>" +TResult);
		return TResult;
	}
	public int PrBoardImgUpdate(Map<String, Object> prBoardImg) {
		logger.info("이미지 업데이트 Dao 호출 성공");
		int IResult = sqlSessionTemplate.update("PrBoardImgUpdate", prBoardImg);
		logger.info("이미지 업데이트 결과 =========>" +IResult);
		return IResult;
	}
	public int PrBoardDelete(Map<String, Object> pMap) {
		logger.info("게시판 삭제Dao 호출 성공!!");
		logger.info("사용자가 입력한 정보======>"+pMap);
		int result = 0;
		result = sqlSessionTemplate.delete("PrBoardDelete",pMap);
		logger.info("게시판 삭제 결과 =========>" +result);
		
		return 0;
	}
	public  int totalRecord(Map<String, Object> pMap) {
		total = sqlSessionTemplate.selectOne("totalRecord", pMap);
		return total;
	}


}
