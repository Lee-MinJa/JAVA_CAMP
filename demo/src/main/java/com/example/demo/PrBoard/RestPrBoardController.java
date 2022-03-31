package com.example.demo.PrBoard;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Review.ReviewLogic;
import com.example.demo.freeboard.RestFreeBoardController;
import com.example.demo.util.PageBar;

	@RestController
	@RequestMapping("/PrBoard/*")
	public class RestPrBoardController {
		Logger logger = LogManager.getLogger(RestFreeBoardController.class);
		
		@Autowired
		private PrBoardLogic prBoardLogic = null;
		@Autowired
		private ReviewLogic reviewLogic = null;
		
		
		@GetMapping("JsonPrBoardList")
		public List<Map<String,Object>> jsonPrBoardList(@RequestParam Map<String,Object> pMap, Model model , HttpServletRequest request) {
			int total = 0;
			logger.info("PrBoardList 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			List<Map<String,Object>> PrBoardList = null;
			PrBoardList = prBoardLogic.PrBoardList(pMap);
			total = prBoardLogic.totalRecord(pMap);
			String pagePath = "PrBoardList";
			int totalRecord = total;
			int numPerPage = 5;
			int nowPage = 0;
			if(nowPage!=0){
				nowPage = Integer.parseInt(pMap.get("nowPage").toString());
			}
			StringBuilder path = new StringBuilder(request.getContextPath());
			path.append("/");
			for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){
				if(total == i) break;
			}
			PageBar pb = new PageBar(numPerPage, totalRecord, nowPage, pagePath);

			
			logger.info("사용자가 입력한 정보 ==> "+pb.getPageBar());
			
			model.addAttribute("total", total);
			model.addAttribute("getPageBar",pb);
			model.addAttribute("PrBoardList", PrBoardList);
			
			
			//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
			return PrBoardList;
		}
	
		@GetMapping("JsonPrBoardDetail")
		public List<Map<String,Object>> PrBoardDetail(@RequestParam Map<String,Object> pMap, Model model) {
			logger.info("PrBoardDetail 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			List<Map<String,Object>> PrBoardDetail = null;
			PrBoardDetail = prBoardLogic.PrBoardDetail(pMap);
			
			model.addAttribute("PrBoardDetail", PrBoardDetail);
			//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
			return PrBoardDetail;
		}

//		@GetMapping("jsonReviewList")
//		public List<Map<String,Object>> ReviewList(@RequestParam Map<String,Object> pMap, Model model , HttpServletRequest request) 
//		{
//			logger.info("PrBoardList 호출 성공");
//			logger.info("사용자가 입력한 정보 ==> "+pMap);
//			List<Map<String,Object>> ReviewList = null;
//			ReviewList = reviewLogic.ReviewList(pMap);
//			model.addAttribute("ReviewList", ReviewList);
//			
//			return ReviewList;
//			
//		}
//		
		
	
}
