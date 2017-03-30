package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：GoodType    
 * 类描述：商品类型实体类    
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:06:39    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:06:39    
 * 修改备注：       
 * @version </pre>
 */
public class GoodType {
	private String typeId;
	private String typeName;
	private String typePid;
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypePid() {
		return typePid;
	}
	public void setTypePid(String typePid) {
		this.typePid = typePid;
	}
	
}
