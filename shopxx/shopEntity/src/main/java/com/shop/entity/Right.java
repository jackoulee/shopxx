package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：Right    
 * 类描述：权限实体类    
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:06:25    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:06:25    
 * 修改备注：       
 * @version </pre>
 */
public class Right {
	private String rightId;
	private String rightName;
	private String rightPid;
	private String rightTitle;
	public String getRightId() {
		return rightId;
	}
	public void setRightId(String rightId) {
		this.rightId = rightId;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getRightPid() {
		return rightPid;
	}
	public void setRightPid(String rightPid) {
		this.rightPid = rightPid;
	}
	public String getRightTitle() {
		return rightTitle;
	}
	public void setRightTitle(String rightTitle) {
		this.rightTitle = rightTitle;
	}
	
}
