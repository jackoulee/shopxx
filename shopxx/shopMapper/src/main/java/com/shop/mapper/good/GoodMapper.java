package com.shop.mapper.good;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.entity.Good;

/**
 * 
 * <pre>项目名称：shopMapper    
 * 类名称：GoodMapper    
 * 类描述：商品展示dao层
 * 创建人：赵志宏  
 * 创建时间：2017年3月6日 下午3:27:15    
 * 修改人：赵志宏    
 * 修改时间：2017年3月6日 下午3:27:15    
 * 修改备注：       
 * @version </pre>
 */
public interface GoodMapper {
	/**
	 * <pre>queryAllGoods(查询数据)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月6日 下午8:12:31    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月6日 下午8:12:31    
	 * 修改备注： 
	 * @param pageInfo
	 * @return</pre>
	 */
	List<Map<String,Object>> queryAllGoods(@Param("pageInfo") Map<String,Object> pageInfo);
	
	/**
	 * <pre>queryGoodsCount(查询条数)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月6日 下午8:12:17    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月6日 下午8:12:17    
	 * 修改备注： 
	 * @param pageInfo
	 * @return</pre>
	 */
	Integer queryGoodsCount(@Param("pageInfo") Map<String,Object> pageInfo);
	
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
