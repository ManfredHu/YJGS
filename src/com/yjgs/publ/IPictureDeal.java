package com.yjgs.publ;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IPictureDeal {

	/**
	 * 处理图片的实际上传以及压缩处理
	 * 
	 * @param fRequest				上传图片时的Servlet请求
	 * @param fFolder				存储文件夹名称
	 * @return							返回图片相对路径
	 */
	public String uploadPicture(Servlet fServlet,
			HttpServletRequest fRequest,HttpServletResponse fResponse,String fFolder);
	
	/**
	 * 自由裁减时的图片切割（替换原图）
	 * 
	 * @param fImgPath		需要切割的图片相对地址
	 * @param fRequest			Servlet请求
	 * @param x						x值
	 * @param y						y值
	 * @param w					w值
	 * @param h					h值
	 * @param tarWidth			前台展示的宽度
	 * @param tarHeight		前台展示的高度
	 * @param fFolder			目标文件夹
	 * @return						返回裁减后的图片地址
	 */
	public String cropPicture(HttpServletRequest fRequest,
			String fImgPath, int x, int y, int w, int h,int tarWidth,int tarHeight,String fFolder);
	
	/**
	 * 对图片进行压缩处理
	 * 
	 * @param fImgPath	需要进行压缩的图片路径
	 * @param fRequest    Servlet请求
	 * @param fOutFolder 压缩图片的输出文件夹
	 * @param fW				压缩后的宽度
	 * @param fH				压缩后的高度
	 * @return					返回缩略图的相对路径
	 */
	public String compressPicture(HttpServletRequest fRequest
			,String fImgPath,String fOutFolder,int fW,int fH);
}
