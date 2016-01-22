package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductPicture;

/**
 * 产品图片的数据操作层操作（对产片图片数据的增、删、查和改）
 * @author yuqin
 *
 */
public interface IProductPictureDal {
	
	/**
	 * 增加产品图片
	 * @param fProductPicture		待增加的产品图片的信息
	 * @return						是否增加成功
	 */
	public boolean AddPicture(ProductPicture fProductPicture);
	
	/**
	 * 批量增加产品图片
	 * @param fProductPictures		待增加的产品图片的信息数组
	 * @return						是否增加成功
	 */
	public boolean AddPicture(ArrayList<ProductPicture> fProductPictures);

	/**
	 * 删除产品图片
	 * @param fProductPicture		待删除的产品图片信息
	 * @return						是否删除成功
	 */	
	public boolean DeletePicture(ProductPicture fProductPicture);
	
	/**
	 * 批量删除产品信息
	 * @param fProductPictures		待删除的产品图片信息数组
	 * @return						是否删除成功
	 */
	public boolean DaletePicture(ArrayList<ProductPicture> fProductPictures);
	
	/**
	 * 修改产品图片
	 * @param fProductPicture		待修改的产品图片信息
	 * @return						是否修改成功
	 */
	public boolean UpdatePicture(ProductPicture fProductPicture);
	
	/**
	 * 批量修改产品图片
	 * @param fProductPicture		待修改的产品图片信息数组
	 * @return						是否修改成功
	 */
	public boolean UpdatePicture(ArrayList<ProductPicture> fProductPicture);
	
	/**
	 * 查询产品图片信息
	 * @param fProduct			待查询的产品信息
	 * @return					查询的产片图片数据数组
	 */
	public ArrayList<ProductPicture> SearchPicture(Product fProduct);
}
