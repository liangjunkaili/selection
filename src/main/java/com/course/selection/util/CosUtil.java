package com.course.selection.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.InputStream;

public class CosUtil {
	//下面是cos服务的相关配置
	public static String BUCKETNAME = "qinmi-1258355325";
	//项目密钥
	public static String SECRETID = "AKIDNtJkXWvQ1dDPhtSTTWUYY6ZveJKLrY9r";
	public static String SECRETKey = "x5AxfP1XvBKPK3d5bDlU7INOL9qL0ZyC";
	private static COSClient cosClient = null;
	static {
	    init();
    }
	public static void init(){
		COSCredentials cred = new BasicCOSCredentials(SECRETID, SECRETKey);
		ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
		cosClient = new COSClient(cred, clientConfig);
	}
	public static String uploadImage(String key,InputStream fileInputStream){
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(500);
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult = cosClient.putObject(BUCKETNAME, key, fileInputStream, objectMetadata);
        String etag = putObjectResult.getETag();
        return etag;
	}

	public static void main(String[] args) {
	}
}
