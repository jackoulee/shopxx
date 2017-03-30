package com.shop.mapper.count;

import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>项目名称：shopMapper    
 * 类名称：CountMapper    
 * 类描述：    
 * 创建人 :李昭源  
 * 创建时间：2017年3月7日 下午7:16:44    
 * 修改人：:李昭源     
 * 修改时间：2017年3月7日 下午7:16:44    
 * 修改备注：       
 * @version </pre>
 */

public interface CountMapper {

	/**
	 * <pre>queryProCount(查询出商品的类型和总量)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月7日 下午7:18:59    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月7日 下午7:18:59    
	 * 修改备注： 
	 * @return</pre>
	 */
	public List<Map<String,Object>> queryProCount();
}
