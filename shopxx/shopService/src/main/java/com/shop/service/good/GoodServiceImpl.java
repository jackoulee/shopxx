package com.shop.service.good;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Good;
import com.shop.mapper.good.GoodMapper;

/**
 * 
 * <pre>项目名称：shopService    
 * 类名称：GoodServiceImpl    
 * 类描述：    商品Service实现
 * 创建人：赵志宏  
 * 创建时间：2017年3月6日 下午4:19:15    
 * 修改人：赵志宏    
 * 修改时间：2017年3月6日 下午4:19:15    
 * 修改备注：       
 * @version </pre>
 */
/** 
 * <pre>项目名称：shopService    
 * 类名称：GoodServiceImpl    
 * 类描述：    
 * 创建人：赵志宏  
 * 创建时间：2017年3月7日 上午10:29:17    
 * 修改人：赵志宏    
 * 修改时间：2017年3月7日 上午10:29:17    
 * 修改备注：       
 * @version </pre>    
 */
/** 
 * <pre>项目名称：shopService    
 * 类名称：GoodServiceImpl    
 * 类描述：    
 * 创建人：赵志宏  
 * 创建时间：2017年3月7日 上午10:29:30    
 * 修改人：赵志宏    
 * 修改时间：2017年3月7日 上午10:29:30    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class GoodServiceImpl implements GoodService {
	
	@Resource
	private GoodMapper goodMapper;
	/**
	 * 商品分页查询
	 * 赵志宏
	 */
	public Map<String, Object> queryAllGoods(Integer startRow, Integer pageSize, String goodNo, String goodName, String goodSaleId) {
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		pageInfo.put("startRow", startRow);
		pageInfo.put("endRow", startRow+pageSize);
		pageInfo.put("goodNo", goodNo);
		pageInfo.put("goodName", goodName);
		pageInfo.put("goodSaleId",goodSaleId);
		List<Map<String, Object>> dataList = goodMapper.queryAllGoods(pageInfo);
		Integer count = goodMapper.queryGoodsCount(pageInfo);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("total", count);
		data.put("rows", dataList);
		return data;
	}
	
	
	@Override
	public List<Map<String, Object>> querySaleType() {
		return goodMapper.querySaleType();
	}


	/**
	 * <pre>insertGood(新增商品)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 下午8:21:19    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 下午8:21:19    
	 * 修改备注： 
	 * @param good</pre>
	 */
	@Override
	public void insertGood(Good good) {
		goodMapper.insertGood(good);
	}

	
	@Override
	public void updateGood(Good good) {
		goodMapper.updateGood(good);
	}


	@Override
	public void deleteGoods(List<String> ids) {
		goodMapper.deleteGoods(ids);
	}

}
