package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.Product;
import com.yjgs.dcl.ProductParam;
import com.yjgs.dcl.ProductPicture;

/**
 * 发布新产品业务逻辑层
 * @author 周宇钦
 *
 */
public interface IPublishProBll {
	
	/**
	 * 发布产品
	 * @param fProduct				要添加的产品信息
	 * @param fProductParam			要添加的产品参数数组
	 * @param fProductPicture		要添加的产品图片
	 * @return						是否添加成功
	 */
	public Boolean PublishPro(Product fProduct,ArrayList<ProductParam> 
								fProductParam,ArrayList<ProductPicture> fProductPicture);

}
