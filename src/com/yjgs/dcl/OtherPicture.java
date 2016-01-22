package com.yjgs.dcl;

public class OtherPicture {

	private int pictureID = 0; // 图片ID

	private String fileName = null; // 图片文件名

	private String pictureAddr = null; // 原图地址

	private String pictureBreAddr = null; // 图片缩略图地址

	private int pitureType = 0; //图片类型

	public int getPictureID() {
		return pictureID;
	}

	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPictureAddr() {
		return pictureAddr;
	}

	public void setPictureAddr(String pictureAddr) {
		this.pictureAddr = pictureAddr;
	}

	public String getPictureBreAddr() {
		return pictureBreAddr;
	}

	public void setPictureBreAddr(String pictureBreAddr) {
		this.pictureBreAddr = pictureBreAddr;
	}

	public int getPitureType() {
		return pitureType;
	}

	public void setPitureType(int pitureType) {
		this.pitureType = pitureType;
	}
	
	
}
