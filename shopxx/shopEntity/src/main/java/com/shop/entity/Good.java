package com.shop.entity;

import java.util.Date;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：Good    
 * 类描述：商品实体类    
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:08:07    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:08:07    
 * 修改备注：       
 * @version </pre>
 */
public class Good {
	private String goodId;
	private String goodName;
	private String goodNo;
	private Double goodPrice;
	private Integer totalNumber;
	private String goodInfo;
	private Integer isSelling;//是否上架 1为上架 2为下架
	private String typeId; //外键 商品类型
	private String saleId; //外键 促销类型
	private String userId; //外键 录入商品员工Id
	private String creatDate; //录入时间
	private String note; //备注
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getGoodNo() {
		return goodNo;
	}
	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}
	public Double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public Integer getIsSelling() {
		return isSelling;
	}
	public void setIsSelling(Integer isSelling) {
		this.isSelling = isSelling;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getGoodInfo() {
		return goodInfo;
	}
	public void setGoodInfo(String goodInfo) {
		this.goodInfo = goodInfo;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	
}
