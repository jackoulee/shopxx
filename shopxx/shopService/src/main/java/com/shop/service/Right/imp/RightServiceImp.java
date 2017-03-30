/** 
 * <pre>项目名称:shopService 
 * 文件名称:RightServiceImp.java 
 * 包名:com.shop.service.Right.imp 
 * 创建日期:2017年3月3日上午10:56:22 
 * Copyright (c) 2017,yangpei310@163.com All Rights Reserved.</pre> 
 */
package com.shop.service.Right.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Right;
import com.shop.entity.Role;
import com.shop.mapper.Right.RightMapper;
import com.shop.service.Right.RightService;

/**
 * <pre>
 * 项目名称：shopService    
 * 类名称：RightServiceImp    
 * 类描述： 角色权限业务逻辑层   
 * 创建人：范祥376976173@qq.com    
 * 创建时间：2017年3月3日 上午10:56:22    
 * 修改人：范祥376976173@qq.com  
 * 修改时间：2017年3月3日 上午10:56:22    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
/** 
 * <pre>项目名称：shopService    
 * 类名称：RightServiceImp    
 * 类描述：    
 * 创建人：范祥376976173@qq.com    
 * 创建时间：2017年3月4日 上午10:37:42    
 * 修改人：范祥376976173@qq.com  
 * 修改时间：2017年3月4日 上午10:37:42    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class RightServiceImp implements RightService {

	@Autowired
	private RightMapper rightMapper;

	// 根据传过来的用户id查询出角色集合并返回到控制层
	@Override
	public List<Role> showRole(String userId) {
		
		List<Role> roleList = rightMapper.showRole(userId);
		
		return roleList;
	}

	// 根据传过来的用户id查询用户对应的权限集合返回到控制层
	@Override
	public List<Right> showRight(String userId) {
		
		List<Right> rightList = rightMapper.showRight(userId);
		
		return rightList;
	}

	//将传过来的角色传进数据库持久层进行增加角色操作
	@Override
	public void addRole(Role role) {
		rightMapper.addRole(role);
	}

	//将传过来的数据传进数据库持久层进行角色的权限增加操作
	@Override
	public void addRight(String roleId, String rightIds) {
		
		if (!StringUtils.isEmpty(rightIds)) {
			String[] split = rightIds.split(",");
			List<Map<String,Object>> Ids=new ArrayList<Map<String,Object>>();
			for (String string : split) {
			   Map<String,Object> right=new HashMap<String,Object>();
			   right.put("rightId", string);
			   right.put("role_id", roleId);
			   Ids.add(right);
			}
	  rightMapper.addRight(Ids);
		}
		
	}

	//根据传前台传过来的角色id和对应的权限id集合对数据库进行修改操作
	@Override
	public void updateRight(String roleId, String rightIds) {
		//先将该角色对应的数据库权限在中间表中全部删除
				if (roleId!=null&&roleId!="") {
					rightMapper.deleteRight(roleId);
				}
				if (!StringUtils.isEmpty(rightIds)) {
					String[] split = rightIds.split(",");
			List<Map<String,Object>> roleRightList=new ArrayList<Map<String,Object>>();
					for (String string : split) {
				Map<String,Object> roleRight=new HashMap<String,Object>();
				roleRight.put("rightId",string);
				roleRight.put("role_id", roleId);
				roleRightList.add(roleRight);
					}
					rightMapper.updateRight(roleRightList);
				}
		
		
	}

	
	//根据前台传到后台的角色id进行相应的角色删除和删除权限操作以及上删除拥护 对应的该角色
	@Override
	public void deleteRight(String roleId) {
		//删除角色
		rightMapper.deleteRole(roleId);
		//删除赋给该角色的所有权限
		rightMapper.deleteRight(roleId);
		//删除所有用户对应的该角色
		rightMapper.deleteUserRole(roleId);
		
	}

	//查询所有的角色集合用于给用户赋予角色
	@Override
	public List<Role> selectRole() {

	List<Role> roleList=rightMapper.selectRole();
		
		return roleList;
	}

	
	
	//根据用户id及角色id集合进行给用户赋角色操作
	@Override
	public void addUserRole(String userId, String roleIds) {
		
		if (!StringUtils.isEmpty(roleIds)) {
			String[] split = roleIds.split(",");
			List<Map<String,Object>> Ids=new ArrayList<Map<String,Object>>();
			for (String string : split) {
			   Map<String,Object> role=new HashMap<String,Object>();
			   role.put("roleId", string);
			   role.put("user_id", userId);
			   Ids.add(role);
			}
	  rightMapper.addUserRole(Ids);
		}
		
	}

	
	//根据用户id及修改后的角色id集合对用户进行角色的修改操作
	@Override
	public void updateUserRole(String userId, String roleIds) {
		//先将该用户对应的数据库角色中间表中全部删除
		if (userId!=null&&userId!="") {
			rightMapper.deleteRoleUser(userId);
		}
		if (!StringUtils.isEmpty(roleIds)) {
			String[] split = roleIds.split(",");
	List<Map<String,Object>> userRoleList=new ArrayList<Map<String,Object>>();
			for (String string : split) {
		Map<String,Object> role=new HashMap<String,Object>();
		role.put("roleId",string);
		role.put("user_id", userId);
		userRoleList.add(role);
			}
			rightMapper.updateUserRole(userRoleList);
		}
		
		
	}

	
	//根据用户id对该用户进行删除操作并删除用户角色中间表中该用户的所有角色
	@Override
	public void deleteUser(String userId) {
		//根据用户id删除该用户
		rightMapper.deleteUser(userId);
		//根据用户id删除中间表中该用户的所有角色
		rightMapper.deleteRoleUser(userId);
	}
	
	
	

}
