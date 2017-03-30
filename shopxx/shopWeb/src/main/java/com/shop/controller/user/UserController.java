package com.shop.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.shop.entity.Count;
import com.shop.entity.User;
import com.shop.service.login.UserService;
/**
 * 
 * <pre>项目名称：shopWeb    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：李昭源  
 * 创建时间：2017年3月3日 上午11:19:56    
 * 修改人：李昭源     
 * 修改时间：2017年3月3日 上午11:19:56    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("userController")
public class UserController {
	private @Resource UserService userService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Map<String,Object> updateNumberByDay;
	Count count ;
	Date date;

	/**
	 * <pre>register(注册方法)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月3日 上午11:21:11    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月3日 上午11:21:11    
	 * 修改备注： 
	 * @param user
	 * @return</pre>
	 */
	@ResponseBody
	@RequestMapping("register")
	public Integer register(User user){
		User queryUser = userService.queryUser(user.getUserName());
		if(queryUser != null){
			if(queryUser.getUserName().equals(user.getUserName())){
				return UserConstant.ID_HAVE_BEEN_REGISTERED;
			}
			return UserConstant.REGISTER_STATUS_FAIL;
		}else{
			user.setUserId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
			user.setPassWord(MD5Utils.md5(user.getPassWord()));
			userService.addUser(user);
			return UserConstant.REGISTER_STATUS_SUCCESS;
		}
	}
	/**
	 * <pre>reset(重置密码)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月3日 下午4:42:51    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月3日 下午4:42:51    
	 * 修改备注： 
	 * @param user
	 * @return</pre>
	 */
	@ResponseBody
	@RequestMapping("reset")
	public Integer reset(User user){
		User queryUser = userService.queryUser(user.getUserName());
		if(queryUser != null){
			user.setPassWord(MD5Utils.md5(user.getPassWord()));
			userService.resetUser(user);
			return UserConstant.RESET_PASSWORD_SUCCESS;//7
		}else{
			return UserConstant.LOGIN_STATUS_USERNAME_ERROR;//1
		}
	}
	/**
	 * <pre>login(登陆)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月3日 下午6:48:48    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月3日 下午6:48:48    
	 * 修改备注： 
	 * @param user
	 * @return</pre>
	 */
	@ResponseBody
	@RequestMapping("login")
	public Integer login(HttpServletRequest request, User user){
		User queryUser = userService.queryUser(user.getUserName());
		if(queryUser != null){
			if(queryUser.getPassWord().equals(MD5Utils.md5(user.getPassWord()))){
				Count queryOneDay = userService.queryOneDay();
				date = new Date();
				if(queryOneDay.getCountDay().equals(sdf.format(date))){
					updateNumberByDay = new HashMap<String,Object>();
					Integer countNumber = queryOneDay.getCountNumber();
					countNumber++;
					updateNumberByDay.put("countNumber", countNumber);
					updateNumberByDay.put("countDay", queryOneDay.getCountDay());
					userService.updateNumber(updateNumberByDay);
				}else{
					count = new Count();
					count.setCountId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
					count.setCountNumber(1);
					count.setCountDay(sdf.format(date));
					count.setCountDaytime(date);
					userService.addCount(count);
				}
				request.getSession().setAttribute("user", queryUser);
				return UserConstant.LOGIN_STATUS_SUCCESS;//3
			}else{
				return UserConstant.LOGIN_STATUS_PASSWORD_ERROR;//2
			}
		}
		return UserConstant.LOGIN_STATUS_USERNAME_ERROR;//1
	}
	
	//登录获取验证码
    @RequestMapping("getSysManageLoginCode")
    @ResponseBody
    public String getSysManageLoginCode(HttpServletResponse response,
            HttpServletRequest request) {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response,"imagecode");// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
  //验证码验证
    @RequestMapping("checkimagecode")
    @ResponseBody
    public String checkTcode(HttpServletRequest request,HttpServletResponse response) {
        String validateCode = request.getParameter("validateCode");
        System.out.println(validateCode);
        String code = null;
        //1:获取cookie里面的验证码信息
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("imagecode".equals(cookie.getName())) {
                code = cookie.getValue();
                break;
            }
        }
        //1:获取session验证码的信息
        //String code1 = (String) request.getSession().getAttribute("");
        //2:判断验证码是否正确
        if(!StringUtils.isEmpty(validateCode) && validateCode.equals(code)){
            return "ok";    

        }
        return "error";
    }
    
    /**
     * <pre>queryCount(查询一周的访问量)   
     * 创建人：李昭源     
     * 创建时间：2017年3月6日 下午2:50:55    
     * 修改人：李昭源       
     * 修改时间：2017年3月6日 下午2:50:55    
     * 修改备注： 
     * @return</pre>
     */
    @ResponseBody
    @RequestMapping("queryCount")
    public List<Map<String,Object>> queryCount(){
    	return userService.queryCount();
    }
}
