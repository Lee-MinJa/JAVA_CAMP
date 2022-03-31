package com.example.demo.PrBoard;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
<<<<<<< HEAD
=======
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
>>>>>>> ac37c98 (Login)
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.freecmnt.FreeCmntController;
import com.example.demo.util.PageBar;

@Controller
@RequestMapping("/PrBoard/*")
public class PrBoardController {
	Logger logger = LogManager.getLogger(PrBoardController.class);
	
	@Autowired
	private PrBoardLogic prBoardLogic= null;
	private PageBar pageBar = null;
//	private MemberController memberController = null;
//	private MemberDao memberDao = null;
	int total =0;
	//리스트를 jsp페이지로 넘겨주긴하는데 RestController로 값만 넘겨주는방식으로 리스트는 전부 처리해야될거같음
	@GetMapping("PrBoardList")
	public String PrBoardList(@RequestParam Map<String,Object> pMap, Model model , HttpServletRequest request
			) {
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
<<<<<<< HEAD

		
		logger.info("사용자가 입력한 정보 ==> "+pb.getPageBar());
		
=======
		logger.info("사용자가 입력한 정보 ==> "+pb.getPageBar());
>>>>>>> ac37c98 (Login)
		model.addAttribute("total", total);
		model.addAttribute("getPageBar",pb);
		model.addAttribute("PrBoardList", PrBoardList);
		
		
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "forward:/PrBoard/PrBoardList.jsp";
		
	}
	@GetMapping("PrBoardDetail")
	public String PrBoardDetail(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("PrBoardDetail 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> PrBoardDetail = null;
		PrBoardDetail = prBoardLogic.PrBoardDetail(pMap);
		model.addAttribute("PrBoardDetail", PrBoardDetail);
		//쿠키값을 넘겨줄때는 변수에 저장해서 값을 넘겨주면 될거같음
		return "forward:/PrBoard/PrBoardList.jsp";
	}
	//태그조회
//	@GetMapping("PrBoardTagList")
	public List<Map<String,Object>> PrBoardTagList( Map<String,Object> pMap) {
		logger.info("TagList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> PrBoardTagList = null;
		PrBoardTagList = prBoardLogic.PrBoardTagList(pMap);
		
		return PrBoardTagList;
	}
	
<<<<<<< HEAD
//	public int PrBoardTagginDelete( Map<String,Object> pMap) {
//		logger.info("TagggingDelete 호출 성공");
//		logger.info("사용자가 입력한 정보 ==> "+pMap);
//		int Result=0;
//		Result = prBoardLogic.PrBoardTaggingDelete(pMap);
//		
//		return Result;
//	}
//	
//	public int PrBoardTaggingInsert( Map<String,Object> pMap) {
//		logger.info("TagggingInsert 호출 성공");
//		logger.info("사용자가 입력한 정보 ==> "+pMap);
//		int Result=0;
//		Result = prBoardLogic.PrBoardTaggingInsert(pMap);
//		return Result;
//	}
	
=======
>>>>>>> ac37c98 (Login)
	
	//홍보게시판의 글 작성은 사업자에게만 권한을 줘야 하는데 멤버 코드를 어디서 호출을 해서 권한을 줘야할까?
	@PostMapping("PrBoardInsert")
	public String PrBoardInsert(@RequestParam Map<String,Object> pMap, Model model , 
				@RequestParam(value="IMAGE_FILENAME", required=false) List<MultipartFile> IMAGE_FILENAME,
				HttpServletRequest request) {
<<<<<<< HEAD
//		if(Integer.parseInt(memberDao.MemberList(pMap).get(0).get("MEM_CODE").toString()) == 1) {
		 
		logger.info("PrBoardInsert 호출 성공");
=======
		 
>>>>>>> ac37c98 (Login)
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		int result = 0;
		String root_path = request.getSession().getServletContext().getRealPath("/");
		
		List<MultipartFile> fileList = new ArrayList();
	
		for(int i=0; i<IMAGE_FILENAME.size(); i++) {
				fileList.add(i, IMAGE_FILENAME.get(i));
<<<<<<< HEAD
				
				
				String savePath = root_path+"image";
=======
				logger.info("IMAGE_FILENAME.get(i)==========>"+IMAGE_FILENAME.get(i).getOriginalFilename());
				String savePath = root_path+"image";
				 String fname = null;
>>>>>>> ac37c98 (Login)
				String filename = null;
				String fullPath = null;
				if(IMAGE_FILENAME !=null) {
					filename =  IMAGE_FILENAME.get(i).getOriginalFilename();
					fullPath = savePath+"\\"+filename;
				}
<<<<<<< HEAD
				//첨부파일이 존재하니?
=======
>>>>>>> ac37c98 (Login)
				int ImgResult = 0;
				if(IMAGE_FILENAME !=null && !IMAGE_FILENAME.isEmpty()) {
					try {
						logger.info("fullPath : " + fullPath);
<<<<<<< HEAD
						//파일명만 객체로 만들어 주는 것일뿐이지 내용까지 생성되는 것은 아니다
=======
>>>>>>> ac37c98 (Login)
						File file = new File(fullPath);//내용은 아직 들어있지 않은.... 상태
						logger.info("file : "+ file);
						byte[] bytes = IMAGE_FILENAME.get(i).getBytes();
						BufferedOutputStream bos = 
								new BufferedOutputStream(new FileOutputStream(file));
<<<<<<< HEAD
						// 49번에서 생성된 File객체에 내용 쓰기
						bos.write(bytes);
						bos.close();
						//파일 크기
=======
						bos.write(bytes);
						bos.close();
>>>>>>> ac37c98 (Login)
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
<<<<<<< HEAD
//					ImgResult = prBoardLogic.PrBoardImgInsert(PrBoardImg);
					logger.info("ImgResult==========>"+ImgResult);
				}

		result = prBoardLogic.PrBoardInsert(pMap,fileList);
		Map<String,Object> PrBoardList = new HashMap();
		PrBoardList.put("result", result);
//		PrBoardList.put("TResult", TResult);
//		PrBoardList.put("ImgResult", ImgResult);
		logger.info("결과모음 ========> " +PrBoardList);
		
		
//		}
		}
=======
					logger.info("ImgResult==========>"+ImgResult);
				}
		
		}
		result = prBoardLogic.PrBoardInsert(pMap,fileList);
>>>>>>> ac37c98 (Login)
		return "redirect:/PrBoard/PrBoardList.jsp";
	}
	
	  @GetMapping("imageDownload")
	  @ResponseBody
	   public byte[] imageDownload(@RequestParam(value="IMAGE_FILENAME") String imageName) {
	      String fname = null;
	      logger.info("IMAGE_FILENAME=============>"+imageName);
	      try {
	         fname = URLDecoder.decode(imageName, "UTF-8");
	         logger.info(fname);
	      } catch (UnsupportedEncodingException e1) {
	         // TODO Auto-generated catch block
	         e1.printStackTrace();
	      }
	      //out.print("b_file: 8->euc"+b_file);      
	      //out.print("<br>");
	      
	      String filePath = "C:\\Users\\gk478\\Desktop\\demo\\demo\\src\\main\\webapp\\image"; // 절대경로.   
	      //가져온 파일이름을 객체화 시켜줌. - 파일이 있는 물리적인 경로가 필요함.
	      File file = new File(filePath, fname.trim());
	      logger.info("FilePath=============>"+filePath);
	      logger.info("File=============>"+file);
	      logger.info("fname.trim()=============>"+fname.trim());
	         
	       //해당 파일을 읽어오는 객체 생성해 줌. - 이 때 파일명을 객체화 한 주소번지가 필요함. 
	        FileInputStream fis = null;
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        try{
	            fis = new FileInputStream(file);
	            logger.info("fis=============>"+fis);
	            logger.info("file=============>"+file);
	        } catch(FileNotFoundException e){
	            e.printStackTrace();
	        }

	        int readCount = 0;
	        byte[] buffer = new byte[1024];
	        byte[] fileArray = null;

	        try{
	            while((readCount = fis.read(buffer)) != -1){
	                baos.write(buffer, 0, readCount);
	            }
	            fileArray = baos.toByteArray();
	            logger.info("파일의 내용을 모두 읽어들여 byte[]로 만들었습니다.");
	            logger.info("읽어들인 byte의 수 :" + fileArray.length);
	            fis.close();
	            baos.close();
	        } catch(IOException e){
	            throw new RuntimeException("File Error");
	        }
	        logger.info("fileArray=========>"+fileArray);
	        return fileArray;
	   }// end of boardList
	
	@GetMapping("PrBoardUpdate")
	public String PrBoardUpdate(@RequestParam Map<String,Object> pMap, Model model , 
			@RequestParam(value="IMAGE_FILENAME", required=false) MultipartFile IMAGE_FILENAME,
			HttpServletRequest request) {
//		if(Integer.parseInt(memberDao.MemberList(pMap).get(0).get("MEM_CODE").toString()) == 1) {
		logger.info("PrBoardUpdate 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		Map<String,Object> PrBoardInsert = new HashMap();
		PrBoardInsert.put("PROMO_NUM", pMap.get("PROMO_NUM"));
		PrBoardInsert.put("MEM_NUM", pMap.get("MEM_NUM"));
		PrBoardInsert.put("PROMO_REGION", pMap.get("PROMO_REGION"));
		PrBoardInsert.put("PROMO_CAMPSITE", pMap.get("PROMO_CAMPSITE"));
		PrBoardInsert.put("PROMO_MAIN_CONTENT", pMap.get("PROMO_MAIN_CONTENT"));
		PrBoardInsert.put("PROMO_DETAIL_CONTENT", pMap.get("PROMO_DETAIL_CONTENT"));
		int result = 0;
		result = prBoardLogic.PrBoardUpdate(PrBoardInsert);
		
		Map<String,Object> PrBoardTag = new HashMap();
		int TResult= 0;
		int TngResult= 0;
		PrBoardTag.put("PROMO_NUM", pMap.get("PROMO_NUM"));
		prBoardLogic.PrBoardTaggingDelete(PrBoardTag);
		//업데이트를 호출하는 순간 게시물 번호에 해당하는 태그들을 다 지우고 다시 집어넣기
		String TagArray []=pMap.get("TAG_NAME").toString().split(",");
		for(int i=0; i<TagArray.length; i++) {
			PrBoardTag.put("TAG_NAME", TagArray[i]);
			logger.info("Arrray[" + i + "]"+TagArray[i]);
			List<Map<String,Object>> tmp = PrBoardTagList(PrBoardTag);
			logger.info("tmp 사이즈======>"+tmp);
			//태그 이름이 없어서 insert하면 promo_num의 tag_code를 다 죽이고 새로운걸로 다시 넣어준다
			//제일 좋은방법은 인서트된 태그이름의 태그 코드만 인서트하는건데
			if(tmp.size() == 0) {
//				TResult = prBoardLogic.PrBoardTInsert(PrBoardTag);
				
			}
			logger.info("tmp 목록이름 ======>"+tmp);
			int TaggingInsertResult=0;
			TaggingInsertResult=prBoardLogic.PrBoardTaggingInsert(PrBoardTag);
			
		}
		
		String root_path = request.getSession().getServletContext().getRealPath("/");  
		Map<String,Object> PrBoardImg = new HashMap();
		PrBoardImg.put("IMAGE_FILENAME", IMAGE_FILENAME.getOriginalFilename());
		PrBoardImg.put("PROMO_NUM", pMap.get("PROMO_NUM"));
		
		logger.info("IMAGE_FILENAME : "+IMAGE_FILENAME.getOriginalFilename());
		String savePath = root_path+"image";
		String filename = null;
		String fullPath = null;
		if(IMAGE_FILENAME !=null) {
			filename =  IMAGE_FILENAME.getOriginalFilename();
			fullPath = savePath+"\\"+filename;
		}
		int ImgResult = 0;
		if(IMAGE_FILENAME !=null && !IMAGE_FILENAME.isEmpty()) {
			try {
				logger.info("fullPath : " + fullPath);
				File file = new File(fullPath);//내용은 아직 들어있지 않은.... 상태
				logger.info("file : "+ file);
				byte[] bytes = IMAGE_FILENAME.getBytes();
				BufferedOutputStream bos = 
						new BufferedOutputStream(new FileOutputStream(file));
				bos.write(bytes);
				bos.close();
				long size = file.length();
				double d_size = Math.floor(size/1024.0);
				logger.info("size : "+ size);
				PrBoardImg.put("IMAGE_FILEPATH", fullPath);
				logger.info("IMAGE_FILEFULLPATH : "+fullPath);
				PrBoardImg.put("IMAGE_SIZE", d_size);
				logger.info(PrBoardImg.get("IMAGE_FILENAME")+", "
				+PrBoardImg.get("IMAGE_SIZE")+", "+ PrBoardImg.get("PROMO_NUM") +","
				+PrBoardImg.get("IMAGE_FILEPATH"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			ImgResult = prBoardLogic.PrBoardImgUpdate(PrBoardImg);
		}

		Map<String,Object> PrBoardList = new HashMap();
		PrBoardList.put("result", result);
		PrBoardList.put("TResult", TResult);
		PrBoardList.put("ImgResult", ImgResult);
		logger.info("결과모음 ========> " +PrBoardList);
		
		
		//		}
		return "forward:/PrBoard/PrBoardList.jsp";
	}
	
	@GetMapping("PrBoardDelete")
	public String PrBoardDelete(@RequestParam Map<String,Object> pMap, Model model) {
		int result = 0;
		result = prBoardLogic.PrBoardDelete(pMap);
		
		
		
		return "forward:/PrBoard/PrBoardList.jsp";
	}
	
}
