package com.shop.controller.Right;

import com.shop.entity.Right;
import com.shop.entity.Role;
import com.shop.service.Right.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * <pre>
 * 项目名称：shopWeb    
 * 类名称：RightController    
 * 类描述：   角色 权限控制层
 * 创建时间：2017年3月3日 上午10:35:03
 * 修改时间：2017年3月3日 上午10:35:03    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("rightController")
public class RightController {

	@Autowired
	private RightService rightService;

	/**
	 * <pre>
	 * showUser(根据传过来的用户id查询角色集合并返回到前台)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月3日 上午10:46:59
	 * 修改时间：2017年3月3日 上午10:46:59    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("showRole")
	public @ResponseBody List<Role> showRole(String userId) {
		
		//userId = "087664B3CBD34B22AE650388EA4FA45B";
		
		List<Role> roleList = rightService.showRole(userId);

		return roleList;
	}

	/**
	 * <pre>
	 * showRight(根据传过来的用户id查询权限集合并返回到前台)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月3日 下午6:48:18    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月3日 下午6:48:18    
	 * 修改备注： 
	 * &#64;param userId
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("showRight")
	public @ResponseBody List<Right> showRight(String userId) {
		
		//userId = "087664B3CBD34B22AE650388EA4FA45B";
		
		List<Right> rightList = rightService.showRight(userId);

		return rightList;
	}

	
	/** <pre>addRole(添加角色及给角色对应的权限)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月3日 下午7:45:39    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月3日 下午7:45:39    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("addRole")
	public  void addRole(String roleName,String rightIds){
		//roleName="吃瓜群众";
		//rightIds="0e98e343cf0a4ae7919c18f93e3364fb,31de179ce88e4a1eb47c608181f16fea";
		Role role=new Role();
		role.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
		role.setRoleName(roleName);
		//将接受的角色传进业务逻辑层
		rightService.addRole(role);
		//将接受的权限id集合及角色对应id传进业务逻辑层
		rightService.addRight(role.getRoleId(),rightIds);
	}
	
	
	
	/** <pre>updateRight(根据前台传过来的角色id及修改之后的权限id集合对对应的角色进行权限的修改)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月4日 上午10:21:25    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月4日 上午10:21:25    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("updateRight")
	public void updateRight(String roleId,String rightIds){
		//roleId="e4830e25ebc241048c2e75db1e16238e";
		//rightIds="4ae31faf53c74fe88d528ac7f004cb28,0e98e343cf0a4ae7919c18f93e3364fb,31de179ce88e4a1eb47c608181f16fea,e7ffb68eec6c4371a2319bf6098a5a61,d22f1ec142994a78bff1edcfc5f94a6e,04f86272c0a343cea2d05bd42f444f57";
		rightService.updateRight(roleId,rightIds);
	}
	
	
	
	/** <pre>deleteRight(根据角色id进行角色删除操作同时删除相对应赋给该角色的权限以及删除所有用户所拥有该的角色)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月4日 上午11:21:42    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月4日 上午11:21:42    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("deleteRight")
	public void deleteRight(String roleId){
		rightService.deleteRight(roleId);
	}
	
	
	/** <pre>showRole(查询角色集合并返回到前台以用于新增用户时给用户赋角色)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月6日 上午11:49:35    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月6日 上午11:49:35    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("selectRole")
	public @ResponseBody List<Role> selectRole(){
		List<Role> roleList=rightService.selectRole();
		
		
		return roleList;
	}
	
	
	
	/** <pre>addUserRole(根据用户id,及角色id集合对用户进行增加角色操作)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月6日 下午2:04:32    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月6日 下午2:04:32    
	 * 修改备注： 
	 * @param userId</pre>    
	 */
	@RequestMapping("addUserRole")
	public void addUserRole(String userId,String roleIds){
		//userId="5AEC7FE663924CC499345FFECF609E22";
		//roleIds="e4830e25ebc241048c2e75db1e16238e";
		rightService.addUserRole(userId,roleIds);
	}
	
	/** <pre>updateRole(根据用户id及修改后的角色id集合进行用户的角色修改操作)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月6日 下午2:52:03    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月6日 下午2:52:03    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("updateUserRole")
	public void updateUserRole(String userId,String roleIds){
		//userId="5AEC7FE663924CC499345FFECF609E22";
	    //roleIds="765f194ca35a47d2bd87b075872b9cdd";
		rightService.updateUserRole(userId,roleIds);
	}
	
	
	/** <pre>deleteUserRole(根据用户id删除用户)   
	 * 创建人：范祥376976173@qq.com      
	 * 创建时间：2017年3月6日 下午3:05:54    
	 * 修改人：范祥376976173@qq.com      
	 * 修改时间：2017年3月6日 下午3:05:54    
	 * 修改备注： </pre>    
	 */
	@RequestMapping("deleteUser")
	public void deleteUser(String userId){
		//userId="5AEC7FE663924CC499345FFECF609E22";
		rightService.deleteUser(userId);
	}
	
}
