package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：SaleType    
 * 类描述：    促销类型实体类
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:10:21    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:10:21    
 * 修改备注：       
 * @version </pre>
 */

public class SaleType {
	private String saleId;
	private String saleName;
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	
}
