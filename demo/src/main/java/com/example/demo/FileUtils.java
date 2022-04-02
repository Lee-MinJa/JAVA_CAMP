package com.example.demo;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileUtils {
	Logger logger = LogManager.getLogger(FileUtils.class);

	public List<Map<String, Object>> parseFileInfo(int free_num, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		List<Map<String,Object>> fileList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = multipartHttpServletRequest.getSession().getServletContext().getRealPath("/image/");
		String port = Integer.toString(multipartHttpServletRequest.getServerPort());
		String url = "localhost:"+port+"/upload/";
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		String newFileName, originalFileExtension, contentType;
		
		while(iterator.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
			for(MultipartFile multipartFile : list) {
				if(multipartFile.isEmpty() == false) {
					contentType = multipartFile.getContentType();
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					}
					else {
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						}
						else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						}
						else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						}
						else {
							break;
						}
					}
					
					newFileName = current.format(format) +"_"+ Long.toString(System.nanoTime()) + originalFileExtension;
					Map<String, Object> pMap = new HashMap<>();
					pMap.put("free_num",free_num);
					pMap.put("image_size",multipartFile.getSize());
					pMap.put("image_filename",multipartFile.getOriginalFilename());
					pMap.put("image_filepath",path + newFileName);
					pMap.put("image_url",url + newFileName);
					logger.info("FileUtils pMap : "+pMap);
					fileList.add(pMap);
					logger.info("FileUtils fileList : "+fileList);
					
					File file = new File(path + newFileName);
					logger.info("FileUtils file : "+file);
					multipartFile.transferTo(file);
				}
			}
		}
		
		logger.info("FileUtils total fileList : "+fileList);
		return fileList;
	}
}
