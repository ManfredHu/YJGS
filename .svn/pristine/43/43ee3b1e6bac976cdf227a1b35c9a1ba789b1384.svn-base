package com.yjgs.publ;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.naming.java.javaURLContextFactory;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.File;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class PictureDeal implements IPictureDeal {

	/**
	 * 获得Smartupload，以便获取file域中非文件的数据
	 * 
	 * @param fServlet				Servlet对象
	 * @param fRequest				Servlet请求
	 * @param fResponse			Servlet相应
	 * @return							返回Smartupload对象
	 */
	public SmartUpload getUpload(Servlet fServlet,
			HttpServletRequest fRequest,HttpServletResponse fResponse) {
		
		PageContext pageContext = null;

		// 使用SmartUpload类实际处理上传
		SmartUpload sU = null;
		
		//初始化并获得file域数据
		try {
			// 设置pageContext以及实例化upload类
			pageContext = JspFactory.getDefaultFactory().getPageContext(
					fServlet, fRequest, fResponse, null, true, 8192, true);
			sU = new SmartUpload();

			// 初始化upload类
			sU.initialize(pageContext);

			// 获取图片资源
			sU.upload();

		} catch (Exception e) {
			System.out.println("图片资源获取异常");
			e.printStackTrace();
			return null;
		}
		
		return sU;
	}
	
	/**
	 * 重载的另一个图片上传的方法，需要传入smartUpload参数
	 * 
	 * @param fRequest				Servlet请求
	 * @param fSU					smartUpload对象
	 * @param fFolder				存储文件夹
	 * @return							返回图片存储路径
	 */
	public String uploadPicture(HttpServletRequest fRequest,SmartUpload fSU,String fFolder) {
		
		String phyPath = null;		//项目物理路径
		String imgFileName = null;
		String imgPhyPath = null;	//图片物理路径
		String imgPath = null; //图片相对路径
		File img = null;
		String ext = null;
		
		// 步骤2：格式验证
		try {

			// 步骤2.1：获取所要上传的图片文件
			img = fSU.getFiles().getFile(0);

			// 步骤2.2：获取文件后缀名
			ext = img.getFileExt().toLowerCase();

			// 步骤2.3：检查后缀，若非图片格式则返回null
			switch (ext) {
			case "jpg":
				break;
			case "jpeg":
				break;
			case "png":
				break;
			case "bmp":
				break;
			case "gif":
				break;
			default:
				return null;
			}

		} catch (Exception e) {
			System.out.println("图片格式检测异常");
			e.printStackTrace();
			return null;
		}

		// 步骤3：获取图片文件名以及设置图片保存地址
		try {

			// 步骤3.1：获取项目根目录物理路径
			phyPath = getProjectPath(fRequest);

			// 步骤3.2：获取图片存放的文件夹名，设置图片物理路径以及相对地址
			String[] temp2 = fFolder.split("/");
			if (temp2.length == 0)
				return null;

			imgPhyPath = phyPath;
			imgPath = "../";
			for (int i = 0; i < temp2.length; i++) {

				imgPhyPath += temp2[i] + "\\";
				imgPath += temp2[i] + "/";
			}
			imgFileName = getPictureName("original", ext);
			imgPhyPath += imgFileName;
			imgPath += imgFileName;
			
			//步骤3.3：检查目录是否存在，不存在则创建
			java.io.File outImg = new java.io.File(imgPhyPath);
			if(!outImg.getParentFile().exists()) {
				outImg.getParentFile().mkdirs();
			}

		} catch (Exception e) {
			System.out.println("设置图片名称或保存地址异常");
			e.printStackTrace();
			return null;
		}

		// 步骤3：将图片保存到服务器
		try {
			img.saveAs(imgPhyPath);
		} catch (Exception e) {
			System.out.println("图片保存异常");
			e.printStackTrace();
			return null;
		}

		// 步骤4：返回图片保存于服务器的相对地址
		return imgPath;
		
	}
	
	@Override
	public String uploadPicture(Servlet fServlet,
			HttpServletRequest fRequest,HttpServletResponse fResponse,String fFolder ) {

		PageContext pageContext = null;
		
		//使用SmartUpload类实际处理上传
		SmartUpload sU = null;
		
		String phyPath = null;		//项目物理路径
		String imgFileName = null;
		String imgPhyPath = null;	//图片物理路径
		String imgPath = null; //图片相对路径
		File img = null;
		String ext = null;
		
		
		
		//步骤1：获取图片表单，获取图片资源
		try {
			//设置pageContext以及实例化upload类
			pageContext = JspFactory.getDefaultFactory().getPageContext(fServlet, fRequest, fResponse, null, true, 8192, true);
			sU = new SmartUpload();
			
			//初始化upload类
			sU.initialize(pageContext);
			
			//获取图片资源
			sU.upload();
			
		} catch (Exception e) {
			System.out.println("图片资源获取异常");
			e.printStackTrace();
			return null;
		}
		
		//步骤2：格式验证
		try {
			
			// 步骤2.1：获取所要上传的图片文件
			img = sU.getFiles().getFile(0);
			
			//步骤2.2：获取文件后缀名
			ext = img.getFileExt().toLowerCase();
			
			//步骤2.3：检查后缀，若非图片格式则返回null
			switch (ext) {
			case "jpg":
				break;
			case "jpeg":
				break;
			case "png":
				break;
			case "bmp":
				break;
			case "gif":
				break;
			default:
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("图片格式检测异常");
			e.printStackTrace();
			return null;
		}
		
		//步骤3：获取图片文件名以及设置图片保存地址
		try {
			  
			// 步骤3.1：获取项目根目录物理路径
			phyPath = getProjectPath(fRequest);

			// 步骤3.2：获取图片存放的文件夹名，设置图片物理路径以及相对地址
			String[] temp2 = fFolder.split("/");
			if (temp2.length == 0)
				return null;

			imgPhyPath = phyPath;
			imgPath = "../";
			for (int i = 0; i < temp2.length; i++) {

				imgPhyPath += temp2[i] + "\\";
				imgPath += temp2[i] + "/";
			}
			imgFileName = getPictureName("original", ext);
			imgPhyPath += imgFileName;
			imgPath += imgFileName;
			
			//步骤3.3：检查目录是否存在，不存在则创建
			java.io.File outImg = new java.io.File(imgPhyPath);
			if(!outImg.getParentFile().exists()) {
				outImg.getParentFile().mkdirs();
			}
			
		} 
		catch (Exception e) {
			System.out.println("设置图片名称或保存地址异常");
			e.printStackTrace();
			return null;
		}
		
		
		//步骤3：将图片保存到服务器
		try {
			img.saveAs(imgPhyPath);
		}
		catch (Exception e) {
			System.out.println("图片保存异常");
			e.printStackTrace();
			return null;
		}
		
		//步骤4：返回图片保存于服务器的相对地址
		return imgPath;
	}

	@Override
	public String cropPicture(HttpServletRequest fRequest,
			String fImgPath, int x, int y, int w, int h,int tarWidth,int tarHeight,String fFolder) {
		
		String phyPath = null;
		String imagePath = null;
		String imageOutPhyPath = null;
		String imageOutPath = null;
		String imageOutName = null;
		String ext = null;
		
				
		//步骤1：获取项目路径及图片物理路径
		phyPath = getProjectPath(fRequest);
		imagePath = getPhyPath(fImgPath, fRequest);
		
		//步骤2：获取文件后缀名
		ext = imagePath.substring(imagePath.lastIndexOf(".")+1);
		
		//步骤3：设置图片输出的物理路径和相对路径
		try {
			
			String[] temp2 = fFolder.split("/");
			if(temp2.length == 0) return null;
			
			imageOutPhyPath = phyPath;
			imageOutPath = "../";
			for(int i = 0; i<temp2.length; i++) {
				
				imageOutPhyPath+= temp2[i] + "\\";
				imageOutPath += temp2[i] + "/";
			}
			imageOutName = getPictureName("original", ext);
			imageOutPhyPath += imageOutName;
			imageOutPath += imageOutName;
			
		} 
		catch (Exception e) {

			System.out.println("设置图片输出路径异常");
			e.printStackTrace();
			return null;
			
		}
		
		try {
			
//			Image img;
//			ImageFilter cropFilter;
//
//			// 读取源图像
//			BufferedImage bi = ImageIO.read(new java.io.File(imagePath));
//			int srcWidth = bi.getWidth(); // 源图宽度
//			int srcHeight = bi.getHeight(); // 源图高度
//
//			// 若原图大小大于切片大小，则进行切割
//			if (srcWidth >= w && srcHeight >= h) {
//				Image image = bi.getScaledInstance(srcWidth, srcHeight,
//						Image.SCALE_DEFAULT);
//
//				//这里的400*270是目标图片的展示高宽
//				int x1 = x * srcWidth / 400;
//				int y1 = y * srcHeight / 270;
//				int w1 = w * srcWidth / 400;
//				int h1 = h * srcHeight / 270;
//
//				cropFilter = new CropImageFilter(x1, y1, w1, h1);
//				img = Toolkit.getDefaultToolkit().createImage(
//						new FilteredImageSource(image.getSource(), cropFilter));
//				BufferedImage tag = new BufferedImage(w1, h1,
//						BufferedImage.TYPE_INT_RGB);
//				Graphics g = tag.getGraphics();
//				g.drawImage(img, 0, 0, null); // 绘制缩小后的图
//				g.dispose();
//				// 输出为文件
//				ImageIO.write(tag, "JPEG", new java.io.File(imagePath));
//			}
			
			//------------------------------
			//------------------------------
			
//			FileInputStream is = null;
//			 
//	        ImageInputStream iis = null;
//	        
//	     // 读取图片文件
//	        
//            is = new FileInputStream(imagePath);
//            
//            Iterator<ImageReader> it = ImageIO
//                    .getImageReadersByFormatName("jpg");
// 
//            ImageReader reader = it.next();
//            
//         // 获取图片流
//            
//            iis = ImageIO.createImageInputStream(is);
//            
//            reader.setInput(iis, true);
//            
//            ImageReadParam param = reader.getDefaultReadParam();
//            
//            Rectangle rect = new Rectangle(x, y, w, h);
//            
//         // 提供一个 BufferedImage，将其用作解码像素数据的目标。
//            
//            param.setSourceRegion(rect);
//            
//            BufferedImage bi = reader.read(0, param);
//            
//            // 保存新图片
// 
//            ImageIO.write(bi, " jpg ", new java.io.File(imagePath));
//            
//            if (is != null)
//            	 
//                is.close();
// 
//            if (iis != null)
// 
//                iis.close();
			
			//------------------------------
			//------------------------------
			
//			String ext = imagePath.substring(imagePath.lastIndexOf(".")+1);
//			
//			java.io.File srcfile = new java.io.File(imagePath);
//			FileInputStream is = null ;
//			ImageInputStream iis = null;
//			
//			Image image =ImageIO.read(srcfile);
//			BufferedImage 	tag  = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
//			tag.getGraphics().drawImage(image.getScaledInstance(w,h, Image.SCALE_SMOOTH),0,0,null);
//		    FileOutputStream out = new FileOutputStream(srcfile);  
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//			             encoder.encode(tag);  
//			             out.close();  
//				
//			 is = new FileInputStream(srcfile);
//			 iis = ImageIO.createImageInputStream(is);
//			
//			Iterator<ImageReader> it= ImageIO.getImageReadersByFormatName(ext);
//			ImageReader reader = it.next();
//			reader.setInput(iis);
//			
//			ImageReadParam param =  reader.getDefaultReadParam();
//			Rectangle rect = new Rectangle(x,y,120,120);
//			param.setSourceRegion(rect);
//			
//			BufferedImage bi = reader.read(0, param);
//			ImageIO.write(bi, ext, new java.io.File(imagePath));
			
			//----------------------------------
			//----------------------------------
			
			//步骤4：获取图片文件
			java.io.File img = new java.io.File(imagePath); 
			java.io.File outImg = new java.io.File(imageOutPhyPath);
			if(!outImg.getParentFile().exists()) 
				outImg.getParentFile().mkdirs(); 
			BufferedImage bi = (BufferedImage)ImageIO.read(img);
			
			//步骤5：判断图片格式是否正确
			h = Math.min(h, bi.getHeight());
			w = Math.min(w, bi.getWidth());
			if(h <= 0) h = bi.getHeight();
			if(w <= 0) w = bi.getWidth();
			y = Math.min(Math.max(0, y), bi.getHeight()-h);
			x = Math.min(Math.max(0, x), bi.getWidth()-w);
			
			//步骤6：对切面进行放大处理
			int srcWidth = bi.getWidth();
			int srcHeight = bi.getHeight();
			int x1 = x * srcWidth / tarWidth;
			int y1 = y * srcHeight / tarHeight;
			int w1 = w * srcWidth / tarWidth;
			int h1 = h * srcHeight / tarHeight;
			
			//步骤7：实际裁减并输出
			BufferedImage bi_cropper = bi.getSubimage(x1, y1, w1, h1);
			ImageIO.write(bi_cropper, ext.equals("png")?"png":"jpeg", outImg);
			
			
		 } catch (IOException e) {
			 System.out.print("图片的后台裁减异常");
		     e.printStackTrace();
		     return null;
		 }
		return imageOutPath;
	}

	@Override
	public String compressPicture(HttpServletRequest fRequest
			,String fImgPath,String fOutFolder, int fW, int fH) {
		
		String phyPath = null;
		String imagePath = null;
		String imageOutPhyPath = null;
		String imageOutPath = null;
		String imageOutName = null;
		String ext = null;
				
		// 步骤1：获取图片物理路径
		phyPath = getProjectPath(fRequest);
		imagePath = getPhyPath(fImgPath, fRequest);
		
		// 步骤2：获取文件后缀名
		ext = imagePath.substring(imagePath.lastIndexOf(".") + 1);

		// 步骤3：设置图片输出的物理路径和相对路径
		try {

			String[] temp2 = fOutFolder.split("/");
			if (temp2.length == 0)
				return null;

			imageOutPhyPath = phyPath;
			imageOutPath = "../";
			for (int i = 0; i < temp2.length; i++) {

				imageOutPhyPath += temp2[i] + "\\";
				imageOutPath += temp2[i] + "/";
			}
			imageOutName = getPictureName("compressed", ext);
			imageOutPhyPath += imageOutName;
			imageOutPath += imageOutName;

		} catch (Exception e) {

			System.out.println("设置图片输出路径异常");
			e.printStackTrace();
			return null;

		}
		
		//步骤4：判断输出路径是否已经存在，不存在则创建
		try {
			
			java.io.File outImgFile = new java.io.File(imageOutPhyPath);
			if(!outImgFile.getParentFile().exists()) {
				outImgFile.getParentFile().mkdirs();
			}
			
		} catch (Exception e) {

			System.out.println("输出文件路径判断异常");
			e.printStackTrace();
			return null;
		}
		
		
		//步骤5：获取原图进行压缩
		try {
			
			java.io.File imgFile = new java.io.File(imagePath);
			Image img = ImageIO.read(imgFile);
			if(img.getWidth(null) == -1) {
				
				throw new Exception("不正确的图片格式");
			}
			
			BufferedImage tag = new BufferedImage
					(fW, fH, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(img.getScaledInstance
					(fW, fH, Image.SCALE_SMOOTH), 0, 0, null);
			
			FileOutputStream out = new FileOutputStream(
					imageOutPhyPath );
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
			
		} catch (Exception e) {
			
			System.out.println("图片压缩异常");
			e.printStackTrace();
			return null;
		}
		
		return imageOutPath;
	}

	/**
	 * 文件的批量删除
	 * 
	 * @param fFilePaths		文件路径数组(相对路径)
	 * @return						返回是否成功删除
	 */
	public boolean deleteFiles(ArrayList<String> fFilePaths ,HttpServletRequest fRequest) {
		
		try {
			
			for(String filePath : fFilePaths) {
				
				//步骤1：获取物理路径
				String filePhyPath = getPhyPath(filePath, fRequest);
				
				//步骤2：新建文件对象并判断文件是否存在
				java.io.File thisFile = new java.io.File(filePhyPath);
				if(!thisFile.exists() || !thisFile.isFile()) return false;
				
				//步骤3：实际删除
				if(!thisFile.delete()) return false;
				
			}
			
		} catch (Exception e) {
			
			System.out.println("文件删除异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 删除文件目录下的所有文件（不删除文件夹本身）
	 * 
	 * @param fPath				文件目录，相对路径形式“../XXXX/XXXX....”
	 * @param fRequest			Servlet请求
	 * @return						返回是否成功删除
	 */
	public boolean deleteDirectory(String fPath,HttpServletRequest fRequest) {
		
			
		//步骤1：获取文件夹物理路径
		String dirPhyPath = getPhyPath(fPath, fRequest);
		
		//步骤2：调用递归方法实际删除
		return deleteDir(dirPhyPath);

	}
	
	/**
	 * 实际删除目录
	 * 
	 * @param fPhyPath	目录物理路径
	 * @return					返回是否成功删除
	 */
	private boolean deleteDir(String fPhyPath) {
		
		try {
			
			//步骤1：检测文件夹是否以文件分隔符结尾，没有则自动添加
			if(!fPhyPath.endsWith(java.io.File.separator)) {
				
				fPhyPath += java.io.File.separator;
			}
			
			//步骤2：新建文件实例并检查其是否为目录
			java.io.File dirFile = new java.io.File(fPhyPath);
			if(!dirFile.exists() || !dirFile.isDirectory()) {
				
				return false;
			}
			
			//步骤3：删除目录下所有文件（包括子目录）(递归删除)
			java.io.File[] files = dirFile.listFiles();
			for(int i = 0; i< files.length; i++) {
				
				if(files[i].isFile()) {
		
					if(!files[i].delete()) return false;
				}
				else {
					
					if(!deleteDir(files[i].getAbsolutePath()))
						return false;
				}
			}
			
		} catch (Exception e) {
			
			System.out.println("目录删除异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * 对CK插件上传的原图进行长宽检测，并判断是否进行压缩处理
	 * 
	 * @param fImgPath			原图相对路径
	 * @param fRequest				Servlet请求
	 * @return							返回处理后的图片路径
	 */
	public  String picDealForCK(HttpServletRequest fRequest, String fImgPath,String fOutFolder) {
		
		String outImgPath = null;
		int[] wh = null;
		
		//步骤1：获取原图宽度高度
		wh = getImgWandH(fImgPath, fRequest);
		
		//步骤2：判断图片宽度是否超过650px，若是则进行压缩
		outImgPath = fImgPath;
		if(wh[0] > 650) {
			
			int tarHeight = 0;
			
			tarHeight = (int)Math.round(wh[1] * 650 / (double)wh[0]);
			
			outImgPath = compressPicture(fRequest, fImgPath, fOutFolder, 650, tarHeight);
		}
//		else {
//			
//			FileInputStream fi = null;
//	        FileOutputStream fo = null;
//	        FileChannel in = null;
//	        FileChannel out = null;
//			
//			//若宽度满足大小要求，则将图片复制到正式目录下
//	        try {
//
//		        String newPicName = null;
//	        	
//		        newPicName = getPictureName("original", ext);
//		        outImgPyhPath = phyPath + "PicForCK\\" + newPicName;
//		        outImgPath = "../PicForCK/" + newPicName;
//	        	
//	            fi = new FileInputStream(imagePath);
//	            fo = new FileOutputStream(outImgPyhPath);
//	            in = fi.getChannel();//得到对应的文件通道
//	            out = fo.getChannel();//得到对应的文件通道
//	            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
//
//	        } catch (IOException e) {
//	            
//	        	e.printStackTrace();
//	        	return null;
//	        } finally {
//
//	            try {
//	                fi.close();
//	                in.close();
//	                fo.close();
//	                out.close();
//
//	            } catch (IOException e) {
//
//	                e.printStackTrace();
//	                return null;
//	            }
//	        }
//		}
		
		return outImgPath;
	}
	
	/**
	 * 复制文件
	 * 
	 * @param fRequest			Servlet请求
	 * @param fSrcPath			源文件
	 * @param fTarFolder		目标文件夹
	 * @return
	 */
	public boolean fileCopy(HttpServletRequest fRequest,String fSrcPath,String fOutFolder) {
		
		String phyPath = null;
		String srcPhyPath = null;
		String outPhyPath = null;
		String fileName = null;
		
		// 步骤1：获取文件物理路径
		phyPath = getProjectPath(fRequest);
		srcPhyPath = getPhyPath(fSrcPath, fRequest);
		
		//步骤2：设置输出路径
		try {

			String[] temp2 = fOutFolder.split("/");
			if (temp2.length == 0)
				return false;

			outPhyPath = phyPath;
			for (int i = 0; i < temp2.length; i++) {

				outPhyPath += temp2[i] + "\\";
			}
			String[] temp3 = fSrcPath.split("/");
			fileName = temp3[temp3.length - 1];
			
			outPhyPath += fileName;

		} catch (Exception e) {

			System.out.println("设置图片输出路径异常");
			e.printStackTrace();
			return false;

		}
        
		FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
		
		
		//步骤3：实际复制
        try {
	
            fi = new FileInputStream(srcPhyPath);
            fo = new FileOutputStream(outPhyPath);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {
            
        	e.printStackTrace();
        	return false;
        } finally {

            try {
                fi.close();
                in.close();
                fo.close();
                out.close();

            } catch (IOException e) {

                e.printStackTrace();
                return false;
            }
        }
		
		return true;
	}
	
	/**
	 * 获取图片的长度以及宽度
	 * 
	 * @param fImgPath		图片相对地址
	 * @param fRequest			Servlet请求
	 * @return						返回图片长宽的整型数组
	 */
	public int[] getImgWandH(String fImgPath,HttpServletRequest fRequest) {
		
		String imagePath = null;
		int[] wh = null;
				
		// 步骤1：获取图片物理路径
		imagePath = getPhyPath(fImgPath, fRequest);
		
		//获取图片长宽
		try {
			
			wh = new int[2];
			java.io.File img = new java.io.File(imagePath); 
			BufferedImage bi = (BufferedImage)ImageIO.read(img);
			wh[0] = bi.getWidth();
			wh[1] = bi.getHeight();
			
		}
		catch (Exception e) {
			
			System.out.println("获取图片长宽异常");
			e.printStackTrace();
			return null;
		}
		
		return wh;
		
	}
	
	/**
	 * 根据当前时间生成图片文件名称
	 * 
	 * @param fPicType		图片类型（原图或缩略图）
	 * @param fExt				文件后缀
	 * @return					新的图片文件名称
	 */
	private String getPictureName(String fPicType,String fExt) {
		
		  //获取当前时间，使得图片文件名不重复
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		  String str = sdf.format(new Date()) + "." + fExt;
		  
		  //根据图片类型，返回相应的图片文件名
		  if(fPicType.equals("original")) {
			  
			  return "o_" + str;
		  }
		  else if(fPicType.equals("compressed")) {
			  
			  return "c_" + str;
		  }
		  
		  return null;
		 }
	
	/**
	 * 获取项目物理路径
	 * 
	 * @param fRequest		Servlet请求
	 * @return					返回项目的根目录物理路径
	 */
	private String getProjectPath(HttpServletRequest fRequest) {
		
//		String rootFolder = null; // 项目根路径文件夹名（项目名称）
		String phyPath = null; // 项目物理路径

		try {
			// 步骤1：获取项目名、物理路径
//			rootFolder = fRequest.getContextPath().substring(1);
			phyPath = fRequest.getSession(true).getServletContext()
					.getRealPath("/");

//			// 步骤2：对项目物理路径进行检测，判断其是否为使用Eclipse时的默认目录
//			Pattern p = Pattern.compile("(.+\\\\).metadata\\\\.+\\\\"
//					+ rootFolder + "\\\\");
//			Matcher m = p.matcher(phyPath);
//
//			if (m.find()) {
//
//				// Eclipse的工作空间目录
//				String eclipseWorkspace = m.group(1);
//				phyPath = eclipseWorkspace + rootFolder + "\\WebContent\\";
//			}
		} 
		catch (Exception e) {
			
			System.out.println("获取项目根目录路径异常");
			e.printStackTrace();
			return null;
		}
		
		return phyPath;
	}
	
	/**
	 * 获取文件的绝对路径
	 * 
	 * @param fPath				文件相对路径
	 * @param fRequest			Servlet请求
	 * @return						返回文件绝对路径
	 */
	private String getPhyPath(String fPath,HttpServletRequest fRequest) {
		
		String phyPath = null;
		String tarPhyPath = null;
		
		
		// 步骤1：获取图片物理路径
		try {

			phyPath = getProjectPath(fRequest);

			String[] temp1 = fPath.split("/");
			if (temp1.length == 0)
				return null;

			tarPhyPath = phyPath + temp1[1];
			for (int i = 2; i < temp1.length; i++) {

				tarPhyPath += "\\" + temp1[i];
			}

		} catch (Exception e) {

			System.out.println("获取图片物理地址异常");
			e.printStackTrace();
			return null;
		}
		
		return tarPhyPath;
	}

}
