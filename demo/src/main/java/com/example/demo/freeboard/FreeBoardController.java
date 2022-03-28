package com.example.demo.freeboard;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	Logger logger = LogManager.getLogger(FreeBoardController.class);

	@Autowired
	private FreeBoardLogic freeBoardLogic = null;

	int total = 0; //전체 레코드 수

	//TEST URL : http://localhost:9000/freeboard/getFreeBoardList
	@GetMapping("getFreeBoardList")
	public String getFreeBoardList(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("getFreeBoardList 호출 성공"+pMap);
		List<Map<String,Object>> freeBoardList = null;
		total = freeBoardLogic.totalRecord(pMap);
		freeBoardList = freeBoardLogic.getFreeBoardList(pMap);
		model.addAttribute("total", total);
		model.addAttribute("freeBoardList", freeBoardList);
		return "freeboard/getFreeBoardList";
	}

	//TEST URL : http://localhost:9000/freeboard/openFreeBoardWriteForm
	@GetMapping("openFreeBoardWriteForm")
	public String openFreeBoardWrite() {
		logger.info("openFreeBoardWrite 호출 성공");
		return "freeboard/freeBoardWriteForm";
	}

	@PostMapping("insertFreeBoard")
	public String insertFreeBoard(@RequestParam Map<String,Object> pMap,
								  @RequestParam(value="IMAGE_FILENAME",required=false) MultipartFile IMAGE_FILENAME,
								  HttpServletRequest request) { //절대경로
		logger.info("insertFreeBoard 호출 성공");
		logger.info("IMAGE_FILENAME : "+IMAGE_FILENAME);
		//String savePath = "C:\\workspace_board\\demo\\src\\main\\webapp\\image";
		String savePath = request.getSession().getServletContext().getRealPath("/image");
		String fileName = null;
		String fullPath= null;

		if(IMAGE_FILENAME != null) {
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString()+"_"+IMAGE_FILENAME.getOriginalFilename();
			fullPath = savePath+"\\"+fileName;

		}

		if(IMAGE_FILENAME != null && !IMAGE_FILENAME.isEmpty()) {
			try {
				File file = new File(fullPath);
				logger.info("file : "+file);
				byte[] bytes = IMAGE_FILENAME.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				bos.write(bytes);
				bos.close();
				long size = file.length();
				double d_size = Math.floor(size/1024.0);
				logger.info("size : "+size);
				pMap.put("IMAGE_FILENAME", fileName);
				pMap.put("IMAGE_FILEPATH", fullPath);
				pMap.put("IMAGE_SIZE", d_size);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		freeBoardLogic.insertFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}

	//TEST URL : http://localhost:9000/freeboard/getFreeBoardDetail?FREE_NUM=글번호
	@GetMapping("getFreeBoardDetail")
	public String getFreeBoardDetail(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("getFreeBoardDetail 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardLogic.getFreeBoardDetail(pMap);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		return "freeboard/getFreeBoardDetail";
	}

	//TEST URL : http://localhost:9000/freeboard/openFreeBoardModifyForm?FREE_NUM=글번호
	@GetMapping("openFreeBoardModifyForm")
	public String openFreeBoardModify(@RequestParam Map<String,Object> pMap, Model model) {
		logger.info("openFreeBoardModify 호출 성공");
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardLogic.getFreeBoardDetail(pMap);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		return "freeboard/freeBoardModifyForm";
	}

	@PostMapping("updateFreeBoard")
	public String updateFreeBoard(@RequestParam Map<String,Object> pMap) {
		logger.info("updateFreeBoard 호출 성공");
		freeBoardLogic.updateFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}

	//TEST URL : http://localhost:9000/freeboard/deleteFreeBoard?FREE_NUM=글번호&MEM_NUM=회원번호
	@GetMapping("deleteFreeBoard")
	public String deleteFreeBoard(@RequestParam Map<String,Object> pMap) {
		logger.info("deleteFreeBoard 호출 성공");
		freeBoardLogic.deleteFreeBoard(pMap);
		return "redirect:getFreeBoardList";
	}
}

