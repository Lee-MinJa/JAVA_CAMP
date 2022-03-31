package com.example.demo.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Review_Cmnt.ReviewCmntLogic;

@RestController
@RequestMapping("/Image/*")
public class ImageController {
	Logger logger = LogManager.getLogger(ImageController.class);
	@Autowired
	private ImageLogic imageLogic = null;
	
	
	
	//댓글 조회해서 대댓글 작성할때 사용하면될거같음 댓글 자세히 보기 기능?
	@GetMapping("ImageList")
	public String ImageList(@RequestParam Map<String,Object> pMap) 
	
	{
		logger.info("PrBoardList 호출 성공");
		logger.info("사용자가 입력한 정보 ==> "+pMap);
		List<Map<String,Object>> ImageList = null;
		ImageList=imageLogic.ImageList(pMap);
		
		return "redirect:/PrBoard/downLoad.jsp";
		}
	
	
//	@RequestMapping(value = "image/{imagename}", produces = MediaType.IMAGE_PNG_VALUE)
//	public ResponseEntity<byte[]> userSearch(@PathVariable("IMAGE_FILENAME") String imagename) 
//			throws IOException {
//		//out.print("<br>");
//		HttpHeaders headers = new HttpHeaders();
//		InputStream imageStream = new FileInputStream("C:\\Users\\gk478\\Desktop\\demo\\demo\\src\\main\\webapp\\image" + imagename);
//		byte[] imageByteArray = IOUtils.toByteArray(imageStream);
//		imageStream.close();
//		return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
//	}	
	
	@GetMapping(value = "image/{imagename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		logger.info("download file : " + fileName);
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		logger.info("resource :" + resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),
					"ISO-8859-1"));
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}