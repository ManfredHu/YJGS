package com.yjgs.dcl;

import com.yjgs.enumdata.ProductPictureType;

public class ProductPicture {
	
	private 	int 				pictureID		=0;			//图片ID
	
	private 	int 				productID		=0;			//产品ID
	
	private 	String 				fileName		=null;		//图片文件名字

	private 	ProductPictureType	display			=null;		//展示类型
	
	private 	String 				pictureAddr		=null;		//图片原图地址
	
	private 	String 				pictureBreAddr	=null;		//图片缩略图地址

	public int getPictureID() {
		return pictureID;
	}

	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public ProductPictureType getDisplay() {
		return display;
	}

	public void setDisplay(ProductPictureType display) {
		this.display = display;
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

	
	
	


}
