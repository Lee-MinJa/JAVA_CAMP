package project.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import project.service.ImageService;


@Controller
public class ImageController {
	
	Logger logger = LogManager.getLogger(ImageController.class);
	
	@Autowired
	ImageService imageService;
	
	@PostMapping("/image")
	public int imageUpload ( @RequestParam Map<String,Object> pMap,
								@RequestParam(value="image_filename",required=false) MultipartFile image_filename,
								HttpServletRequest request ) {
		
		logger.info("imageUpload image_filename: "+image_filename);
		logger.info("imageUpload request: "+request);
		
		String savePath = request.getSession().getServletContext().getRealPath("/image");
		String fileName = null;
		String fullPath = null;
		
		if(image_filename != null) {
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString()+"_"+image_filename.getOriginalFilename();
			fullPath = savePath+"\\"+fileName;
		}
		
		if(image_filename != null && !image_filename.isEmpty()) {
			try {
				File file = new File(fullPath);
				logger.info("file : "+file);
				byte[] bytes = image_filename.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				bos.write(bytes);
				bos.close();
				long size = file.length();
				double d_size = Math.floor(size/1024.0);
				pMap.put("image_filename", fileName);
				pMap.put("image_filepath", fullPath);
				pMap.put("image_size", d_size);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int result = imageService.imageUpload(pMap);
		logger.info("fileName : "+fileName);
		logger.info("savePath : "+savePath);
		imageDownload(fileName, savePath);
		
		return result;
			
	}
	

	@GetMapping
	public 	@ResponseBody byte[] imageDownload(String fileName, String savePath) {
		
		String fname = null;
		
		try {
			fname = URLDecoder.decode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		File file = new File(savePath, fname.trim());
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int readCount = 0;
		byte[] buffer = new byte[1024];
		byte[] fileArray = null;
		
		try {
			while((readCount = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, readCount);
			}
			fileArray = baos.toByteArray();
			logger.info("fileArray : "+fileArray);
			fis.close();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileArray;	
	}
	
}
