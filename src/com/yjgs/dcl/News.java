package com.yjgs.dcl;

import java.sql.Date;


public class News {
	
	private int 		newsID		=0;			//新闻ID
	
	private int 		typeID		=0;			//新闻类型ID
	
	private String 		title		=null;		//新闻标题
	
	private String 		content		=null;		//新闻内容
	
	private Date 		publishTime	=null;		//新闻发布时间

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	
}
