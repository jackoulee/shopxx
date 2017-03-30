package com.shop.service.login;

import java.util.List;
import java.util.Map;

import com.shop.entity.Count;
import com.shop.entity.User;

public interface UserService {

	/**
	 * <pre>addUser(注册方法)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月3日 上午11:20:40    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月3日 上午11:20:40    
	 * 修改备注： 
	 * @param user</pre>
	 */
	public void addUser(User user);
	
	/**
	 * <pre>queryUser(注册时查看是否已经被注册)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月3日 上午11:36:13    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月3日 上午11:36:13    
	 * 修改备注： 
	 * @param userName
	 * @return</pre>
	 */
	public User queryUser(String userName);
	
	/**
	 * <pre>resetUser(重置密码)   
	 * 创建人：李昭源
	 * 创建时间：2017年3月3日 下午3:59:32    
	 * 修改人：李昭源
	 * 修改时间：2017年3月3日 下午3:59:32    
	 * 修改备注： 
	 * @param user</pre>
	 */
	public void resetUser(User user);
	
	/**
	 * <pre>queryCount(查询一周的访问量)   
	 * 创建人：李昭源    
	 * 创建时间：2017年3月6日 下午1:37:33    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月6日 下午1:37:33    
	 * 修改备注： 
	 * @return</pre>
	 */
	public List<Map<String,Object>> queryCount();
	
	/**
	 * <pre>queryOneDay(查询最近一天的访问量)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月6日 下午2:47:09    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月6日 下午2:47:09    
	 * 修改备注： 
	 * @return</pre>
	 */
	public Count queryOneDay();
	
	/**
	 * <pre>addCount(重新统计时新增)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月6日 下午3:07:31    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月6日 下午3:07:31    
	 * 修改备注： 
	 * @param count</pre>
	 */
	public void addCount(Count count);
	
	/**
	 * <pre>updateNumber(统计访问人数及时刷新)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月6日 下午3:07:50    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月6日 下午3:07:50    
	 * 修改备注： 
	 * @param number</pre>
	 */
	public void updateNumber(Map<String,Object> number);
}
