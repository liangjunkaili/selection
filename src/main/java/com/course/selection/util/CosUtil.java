package com.course.selection.util;

import com.course.selection.bean.UploadBean;
import com.qcloud.cosapi.api.CosCloud;
import com.qcloud.cosapi.sign.Sign;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import qcloud.video.api.VideoCloud;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class COSUtil {
	//下面是cos服务的相关配置
	public static String BUCKETNAME = "qinmi";
	public static int APPID = 10040507;
	//项目密钥
	public static String SECRETID = "AKIDyZeEbSIH02M4M4LNFRi3OVDqz1AvgAeU";
	public static String SECRETKey = "feliNXkUxDX8DUa5AcndmQtURBVWxaAp";
	public static long expired = System.currentTimeMillis() / 1000 + 30*24*60*60;
	public static String remotePath = "upload";
	public static String BUCKETNAME_VIDEO = "qinmivideo";
	private static CosCloud cos = new CosCloud(APPID, SECRETID, SECRETKey, 60);
	private static VideoCloud video = new VideoCloud(APPID, SECRETID, SECRETKey, 60);
	public static String getCosSign(){
        String sign_str = Sign.appSignature(APPID, SECRETID, SECRETKey, expired, BUCKETNAME);
        return sign_str;
	}
	/**
	 * 流文件上传，适用于小文件，如果对应的文件过大，容易造成OOM
		Parameters:
		bucketName bucket名称
		remotePath 远程文件路径
		inputStream 文件流
	 * @param inputStream
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public static String uploadImage(InputStream inputStream,String uid) throws Exception{
		String returnData = cos.uploadFile(BUCKETNAME, uid, inputStream);
        return returnData;
	}
	/**
	 * 分片上传，不需要指定分片大小，采取默认切片大小512KB
		Parameters:
		bucketName bucket名称
		remotePath 远程文件路径
		localPath 本地文件路径
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public static String sliceUploadFile(String remotePath, String localPath) throws Exception{
		String returnData = cos.sliceUploadFile(BUCKETNAME, remotePath, localPath);
		System.out.println(returnData);
		return returnData;
	}
	//视频上传
	public static String uploadVideo() throws Exception{
		String returnData = video.uploadFile(BUCKETNAME_VIDEO, "", "", "", "", "", "", "");
		System.out.println(returnData);
		return returnData;
	}
	
	//视频分片上传
	public static String sliceUploadVideo(String localPath,String name) throws Exception{
		String returnData = video.sliceUploadFile(BUCKETNAME_VIDEO, "video1/"+name,localPath);
		System.out.println(returnData);
		return returnData;
	}
	
	//创建目录
	public static void createFolder(){
		try {
			String data = cos.createFolder(BUCKETNAME, "/myFolder/");
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFolderList(){
		try {
			String data = cos.getFolderList(BUCKETNAME, "//", 100, "", 0, CosCloud.FolderPattern.Both);
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFolderListprefix(){
		try {
			String data = cos.getFolderList(BUCKETNAME, "/book/","1475", 100, "", 0, CosCloud.FolderPattern.Both);
			Map<String,Object> json = JsonUtil.getMapFromJson(data);
			JSONObject json1 = (JSONObject) json.get("data");
			json1.get("filecount");
			json1.get("has_more");
			JSONArray arr = (JSONArray) json1.get("infos");
			List<UploadBean> list=JSONArray.toList(arr,UploadBean.class);
			for(UploadBean u:list){
				String url = u.getAccess_url();
				String time = u.getCtime();
//				String t = DateUtil.TimeStamp2Date(Long.parseLong(time));
				String file = url.substring(39, url.length());
				deleteFile(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String file){
		try {
			String data = cos.deleteFile(BUCKETNAME, file);
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		createFolder();
//		getFolderListprefix();
		try {
//			sliceUploadVideo("E://Wildlife.wmv","ss.mp4");
			File f = new File("C://Users//admin//Desktop//emm//emm_pad_UXVGA.zip");
			String res = sliceUploadFile("hb/aa.zip", f.getAbsolutePath());
			System.out.println(res);
//			deleteFile("book/");
//			getFolderListprefix();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
