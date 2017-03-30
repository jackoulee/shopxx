package com.shop.controller.count;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.service.count.CountService;
/**
 * 
 * <pre>项目名称：shopWeb    
 * 类名称：CountController    
 * 类描述：    
 * 创建人 :李昭源  
 * 创建时间：2017年3月8日 上午11:53:55    
 * 修改人：:李昭源     
 * 修改时间：2017年3月8日 上午11:53:55    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("countController")
public class CountController {
	private @Resource CountService countService;
	
	/**
	 * <pre>queryProCount(查询出商品的类型和总量)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月7日 下午7:18:59    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月7日 下午7:18:59    
	 * 修改备注： 
	 * @return</pre>
	 */
	@ResponseBody
	@RequestMapping("queryProCount")
	public List<Map<String, Object>> queryProCount() {
		return countService.queryProCount();
	}
	
}
