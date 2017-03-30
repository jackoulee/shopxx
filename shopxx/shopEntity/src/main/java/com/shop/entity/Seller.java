package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：Seller    
 * 类描述：    买家实体类
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:12:22    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:12:22    
 * 修改备注：       
 * @version </pre>
 */

public class Seller {
	
	private String sellerId;
	private String sellerName;
	private String sellerPhone; //买家电话
	private Integer sellerLevel; //会员等级
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public Integer getSellerLevel() {
		return sellerLevel;
	}
	public void setSellerLevel(Integer sellerLevel) {
		this.sellerLevel = sellerLevel;
	}
	
	
}
