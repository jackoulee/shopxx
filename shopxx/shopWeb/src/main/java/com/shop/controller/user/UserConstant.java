
package com.shop.controller.user;

/**
 * 
 * <pre>项目名称：shopWeb    
 * 类名称：UserConstant    
 * 类描述：    
 * 创建人：李昭源  
 * 创建时间：2017年3月3日 上午11:19:47    
 * 修改人：李昭源     
 * 修改时间：2017年3月3日 上午11:19:47    
 * 修改备注：       
 * @version </pre>
 */
public class UserConstant {
	/**
	 * 登录状态 用户名不存在
	 */
	public static final Integer LOGIN_STATUS_USERNAME_ERROR = 1;
	/**
	 * 登录状态 密码错误
	 */
	public static final Integer LOGIN_STATUS_PASSWORD_ERROR = 2;
	/**
	 * 登录状态，登录成功
	 */
	public static final Integer LOGIN_STATUS_SUCCESS = 3;
	/**
	 *
	 * 注册状态 注册成功
	 */
	public static final Integer REGISTER_STATUS_SUCCESS = 4;
	/**
	 *
	 * 注册状态 注册失败
	 */
	public static final Integer REGISTER_STATUS_FAIL = 5;
	/**
	 * 账号已经被注册
	 */
	public static final Integer ID_HAVE_BEEN_REGISTERED = 6;
	/**
	 * 帐号重置密码成功
	 */
	public static final Integer RESET_PASSWORD_SUCCESS = 7;
	
}

