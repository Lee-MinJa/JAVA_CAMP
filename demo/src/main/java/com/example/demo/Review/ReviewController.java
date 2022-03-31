package com.example.demo.Review;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.PrBoard.PrBoardController;
import com.example.demo.util.PageBar;

@Controller
@RequestMapping("/Review/*")
public class ReviewController {
	Logger logger = LogManager.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewLogic reviewLogic = null;
	
//	@GetMapping("ReviewList")
//	public String ReviewList(@RequestParam Map<String,Object> pMap, Model model , HttpServletRequest request) 
//	{
//		logger.info("PrBoardList 호출 성공");
//		logger.info("사용자가 입력한 정보 ==> "+pMap);
//		List<Map<String,Object>> ReviewList = null;
//		ReviewList = reviewLogic.ReviewList(pMap);
//		
//		
////		model.addAttribute("total", total);
////		model.addAttribute("getPageBar",pb);
//		model.addAttribute("ReviewList", ReviewList);
//		
//		
//		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
//		return "forward:/Review/ReviewList.jsp";
//		
//	}
//	
	@PostMapping("ReviewInsert")
	public String ReviewInsert(@RequestParam Map<String,Object> pMap,
			@RequestParam(value="IMAGE_FILENAME", required=false) List<MultipartFile> IMAGE_FILENAME,
			HttpServletRequest request) 
	{
		logger.info("PrBoardInsert 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		String root_path = request.getSession().getServletContext().getRealPath("/");
		List<MultipartFile> fileList = new ArrayList();
	
		for(int i=0; i<IMAGE_FILENAME.size(); i++) {
				fileList.add(i, IMAGE_FILENAME.get(i));
				logger.info("IMAGE_FILENAME.get(i)==========>"+IMAGE_FILENAME.get(i).getOriginalFilename());
				String savePath = root_path+"image";
				String filename = null;
				String fullPath = null;
				if(IMAGE_FILENAME !=null) {
					filename =  IMAGE_FILENAME.get(i).getOriginalFilename();
					fullPath = savePath+"\\"+filename;
				}
				int ImgResult = 0;
				if(IMAGE_FILENAME !=null && !IMAGE_FILENAME.isEmpty()) {
					try {
						logger.info("fullPath : " + fullPath);
						File file = new File(fullPath);//내용은 아직 들어있지 않은.... 상태
						logger.info("file : "+ file);
						byte[] bytes = IMAGE_FILENAME.get(i).getBytes();
						BufferedOutputStream bos = 
								new BufferedOutputStream(new FileOutputStream(file));
						bos.write(bytes);
						bos.close();
						long size = file.length();
						double d_size = Math.floor(size/1024.0);
						logger.info("size : "+ size);
						pMap.put("IMAGE_FILEPATH", fullPath);
						logger.info("IMAGE_FILEFULLPATH : "+fullPath);
						pMap.put("IMAGE_SIZE", d_size);
						logger.info(pMap.get("IMAGE_FILENAME")+", "
						+pMap.get("IMAGE_SIZE")+", "+ pMap.get("PROMO_NUM") +","
						+pMap.get("IMAGE_FILEPATH"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("ImgResult==========>"+ImgResult);
				}
		
		}
				result = reviewLogic.ReviewInsert(pMap,fileList);
		return "redirect:./JsonReviewList?PROMO_NUM="+pMap.get("PROMO_NUM");
	}
	@GetMapping("ReviewUpdate")
	public String ReviewUpdate(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardUpdate 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = reviewLogic.ReviewUpdate(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonReviewList?PROMO_NUM="+pMap.get("PROMO_NUM");
		
	}
	@GetMapping("ReviewDelete")
	public String ReviewDelete(@RequestParam Map<String,Object> pMap) 
	{
		logger.info("PrBoardDelete 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		result = reviewLogic.ReviewDelete(pMap);
		logger.info("result ==>" +result);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "redirect:./JsonReviewList??PROMO_NUM="+pMap.get("PROMO_NUM");
		
	}
	
	
}
