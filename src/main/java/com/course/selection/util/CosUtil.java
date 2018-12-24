package com.course.selection.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

import static com.course.selection.util.WXConfiguration.key;

@Log4j2
public class CosUtil {
	//下面是cos服务的相关配置
	public static String BUCKETNAME = "qinmi-1258355325";
	//项目密钥
	public static String SECRETID = "AKIDNtJkXWvQ1dDPhtSTTWUYY6ZveJKLrY9r";
	public static String SECRETKey = "x5AxfP1XvBKPK3d5bDlU7INOL9qL0ZyC";

	public static final String IMG_URL = "https://qinmi-1258355325.cos.ap-beijing.myqcloud.com/";
	private static COSClient cosClient = null;
	static {
	    init();
    }
	public static void init(){
		COSCredentials cred = new BasicCOSCredentials(SECRETID, SECRETKey);
		ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
		cosClient = new COSClient(cred, clientConfig);
	}
	public static String uploadImage(String key,MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		InputStream inputStream = file.getInputStream();
//		File file1 = (File) file;
		ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setContentLength(500);
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult = cosClient.putObject(BUCKETNAME, key, inputStream,objectMetadata);
        String etag = putObjectResult.getETag();
        return etag;
	}


	public static String getImgUrl(MultipartFile file) throws IOException {
		long timestemp = new Date().getTime();
		String key = timestemp+file.getOriginalFilename();
		String str = CosUtil.uploadImage(key,file);
		log.info(str);
		return IMG_URL+key;
	}
	public static void main(String[] args) {
	}
}
