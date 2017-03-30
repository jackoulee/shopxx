/** 
 * <pre>项目名称:shopService 
 * 文件名称:RightService.java 
 * 包名:com.shop.service.Right 
 * 创建日期:2017年3月3日上午10:34:31 
 * Copyright (c) 2017,yangpei310@163.com All Rights Reserved.</pre> 
 */  
package com.shop.service.Right;

import java.util.List;

import com.shop.entity.Right;
import com.shop.entity.Role;
import com.shop.entity.User;

/** 
 * <pre>项目名称：shopService    
 * 类名称：RightService    
 * 类描述：   角色 权限业务逻辑层
 * 创建人：范祥376976173@qq.com    
 * 创建时间：2017年3月3日 上午10:34:31    
 * 修改人：范祥376976173@qq.com  
 * 修改时间：2017年3月3日 上午10:34:31    
 * 修改备注：       
 * @version </pre>    
 */
public interface RightService {

	List<Role> showRole(String userId);

	List<Right> showRight(String userId);

	void addRole(Role role);

	void addRight(String roleId, String rightIds);

	void updateRight(String roleId, String rightIds);

	void deleteRight(String roleId);

	List<Role> selectRole();

	void addUserRole(String userId, String roleIds);

	void updateUserRole(String userId, String roleIds);

	void deleteUser(String userId);


}
