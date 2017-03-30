package com.shop.entity;

/**
 * 
 * <pre>项目名称：shopEntity    
 * 类名称：Role    
 * 类描述：  员工角色实体类
 * 创建人：赵志宏  
 * 创建时间：2017年3月2日 下午7:05:34    
 * 修改人：赵志宏    
 * 修改时间：2017年3月2日 下午7:05:34    
 * 修改备注：       
 * @version </pre>
 */
public class Role {
	private String roleId;
	private String roleName;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
