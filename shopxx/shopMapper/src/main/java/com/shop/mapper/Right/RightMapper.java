/** 
 * <pre>项目名称:shopMapper 
 * 文件名称:RightMapper.java 
 * 包名:com.shop.mapper.Right 
 * 创建日期:2017年3月3日上午10:35:42 
 * Copyright (c) 2017,yangpei310@163.com All Rights Reserved.</pre> 
 */  
package com.shop.mapper.Right;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.shop.entity.Right;
import com.shop.entity.Role;
import com.shop.entity.User;

/** 
 * <pre>项目名称：shopMapper    
 * 类名称：RightMapper    
 * 类描述：    角色权限数据库持久层
 * 创建人：范祥376976173@qq.com    
 * 创建时间：2017年3月3日 上午10:35:42    
 * 修改人：范祥376976173@qq.com  
 * 修改时间：2017年3月3日 上午10:35:42    
 * 修改备注：       
 * @version </pre>    
 */
public interface RightMapper {

	//根据用户id查询对应角色集合
	@Select("select role_id as roleId, role_name as roleName from t_role where role_id in( select role_id from t_user_role where user_id=#{userId})")
	List<Role> showRole(String userId);
    
	//根据用户id查询对应权限集合
	@Select("select right_id as rightId, right_name as rightName,right_pid as rightPid ,right_title as rightTitle from t_right where right_id in(select right_id from t_right_role where role_id in(select role_id from t_user_role where user_id=#{userId}))")
	List<Right> showRight(String userId);

	//根据传过来的角色对象进行相应的增加操作
	@Insert("insert into t_role(role_id,role_name) values(#{roleId},#{roleName})")
	void addRole(Role role);

	//根据传过来的数据进行对应角色赋权操作
	void addRight(List<Map<String, Object>> ids);

	//根据要修改的角色id对中间表中该角色对应的权限id进行删除
	@Delete("delete from t_right_role where role_id=#{roleId}")
	void deleteRight(String roleId);

	//根据传过来的角色修改后权限id集合对该角色进行修改
	void updateRight(List<Map<String, Object>> roleRightList);

	//根据角色id删除该角色
	@Delete("delete from t_role where role_id=#{roleId}")
	void deleteRole(String roleId);

	//查询角色集合用于给用户赋予角色
	@Select("select role_id as roleId,role_name as roleName from t_role")
	List<Role> selectRole();


	//根据用户id和角色集合对用户进行增加角色操作
	void addUserRole(List<Map<String, Object>> ids);

	//根据要删除的角色id将所有用户所拥有的该角色删除
	@Delete("delete from t_user_role where role_id=#{roleId}")
	void deleteUserRole(String roleId);

	//根据要修改的用户id将中间表中的该用户的角色全部删除//根据用户id删除中间表中的该用户所有角色
	@Delete("delete from t_user_role where user_id=#{userId}")
	void deleteRoleUser(String userId);

	void updateUserRole(List<Map<String, Object>> userRoleList);

	//根据用户id删除用户
	@Delete("delete from t_user where user_id=#{userId}")
	void deleteUser(String userId);

}
