package com.course.selection.bean;

public class UploadBean {

	/**
	 * 生成的文件下载url
	 */
	private String access_url;
	/**
	 * 目录或文件属性，业务端维护
	 */
	private String biz_attr;
	/**
	 * 目录或文件的创建时间，unix时间戳
	 */
	private String ctime;
	/**
	 * 文件已传输大小(通过与filesize对比可知文件传输进度)
	 */
	private int filelen;
	/**
	 * 文件大小
	 */
	private int filesize;
	/**
	 * 目录或文件的修改时间，unix时间戳
	 */
	private String mtime;
	/**
	 * 文件或目录名
	 */
	private String name;
	/**
	 * 文件sha
	 */
	private String sha;
	/**
	 * 
	 */
	private String source_url;
	public String getAccess_url() {
		return access_url;
	}
	public void setAccess_url(String access_url) {
		this.access_url = access_url;
	}
	public String getBiz_attr() {
		return biz_attr;
	}
	public void setBiz_attr(String biz_attr) {
		this.biz_attr = biz_attr;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getFilelen() {
		return filelen;
	}
	public void setFilelen(int filelen) {
		this.filelen = filelen;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
}
