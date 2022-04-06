package project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class StorageService {
	Logger logger = LogManager.getLogger(StorageService.class);

	@Value("${application.bucket.name}")
	private String bucketName;
	
	@Autowired
	private AmazonS3 s3Client;
	
	public @ResponseBody String uploadFile(MultipartFile image_filename) {
		File fileObj = convertMultiPartFileToFile(image_filename);
		String fileName = System.currentTimeMillis()+"_"+image_filename.getOriginalFilename();
		s3Client.putObject(new PutObjectRequest(bucketName,fileName,fileObj));
		String url = s3Client.getUrl(bucketName, fileName).toString();		
		fileObj.delete();
		return url;	
	}
	
	public byte[] downloadFile(String fileName) {
		S3Object s3Object = s3Client.getObject(bucketName, fileName);
		S3ObjectInputStream inputStream = s3Object.getObjectContent();
		try {
			byte[] content = IOUtils.toByteArray(inputStream);
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deleteFile(String fileName) {
		s3Client.deleteObject(bucketName, fileName);
		return fileName+" removed";
	}
	
    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
        	logger.info("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

}




