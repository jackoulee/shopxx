package com.shop.service.good;

import java.util.List;
import java.util.Map;

import com.shop.entity.Good;
/**
 * 
 * <pre>项目名称：shopService    
 * 类名称：GoodService    
 * 类描述：  商品分页
 * 创建人：赵志宏  
 * 创建时间：2017年3月6日 下午4:15:24    
 * 修改人：赵志宏    
 * 修改时间：2017年3月6日 下午4:15:24    
 * 修改备注：       
 * @version </pre>
 */
public interface GoodService {
	/**
	 * <pre>queryAllGoods(商品分页查询)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月6日 下午4:18:34    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月6日 下午4:18:34    
	 * 修改备注： 
	 * @param nowPage
	 * @param pageSize
	 * @return</pre>
	 */
	Map<String,Object> queryAllGoods(Integer nowPage, Integer pageSize, String goodNo, String goodName, String goodSaleId);
	
	/**
	 * <pre>queryGoodsType(查询促销类型)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 上午10:20:28    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 上午10:20:28    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<Map<String,Object>> querySaleType();
	
	/**
	 * <pre>insertGood(新增商品)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 下午8:21:19    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 下午8:21:19    
	 * 修改备注： 
	 * @param good</pre>
	 */
	void insertGood(Good good);
	
	/**
	 * <pre>updateGood(商品修改)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月8日 下午2:21:49    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月8日 下午2:21:49    
	 * 修改备注： 
	 * @param good</pre>
	 */
	void updateGood(Good good);
	
	/**
	 * <pre>deleteGoods(批量删除商品)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月8日 下午3:51:29    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月8日 下午3:51:29    
	 * 修改备注： 
	 * @param ids</pre>
	 */
	void deleteGoods(List<String> ids);
}
