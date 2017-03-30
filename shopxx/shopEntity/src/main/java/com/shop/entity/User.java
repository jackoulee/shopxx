package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：User    
 * 类描述：   员工实体类 
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:06:08    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:06:08    
 * 修改备注：       
 * @version </pre>
 */
public class User {
	private String userId;
	private String	userName;
	private String passWord;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
