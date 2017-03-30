package com.shop.controller.good;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.Good;
import com.shop.service.good.GoodService;

/**
 * 
 * <pre>项目名称：shopWeb    
 * 类名称：GoodController    
 * 类描述：    商品控制层
 * 创建人：赵志宏  
 * 创建时间：2017年3月6日 下午4:26:24    
 * 修改人：赵志宏    
 * 修改时间：2017年3月6日 下午4:26:24    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("goodController")
public class GoodController {
	
	@Resource
	private GoodService goodService;
	
	/**
	 * <pre>queryAllGoods(商品查询分页)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 上午10:38:25    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 上午10:38:25    
	 * 修改备注： 
	 * @param pageSize
	 * @param offSet
	 * @return</pre>
	 */
	@RequestMapping("queryAllGoods")
	@ResponseBody
	public Map<String,Object> queryAllGoods(Integer pageSize, Integer offSet, String goodNo, String goodName, String goodSaleId){
		Map<String, Object> allGoods = goodService.queryAllGoods(offSet, pageSize, goodNo, goodName, goodSaleId);
		return allGoods;
	}
	
	/**
	 * <pre>querySaleType(查询商品类型)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 上午10:41:21    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 上午10:41:21    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("querySaleType")
	@ResponseBody
	public List<Map<String,Object>> querySaleType(){
		List<Map<String, Object>> saleType = goodService.querySaleType();
		return saleType;
	}
	
	/**
	 * <pre>insertGood(新增商品)   
	 * 创建人：赵志宏     
	 * 创建时间：2017年3月7日 下午8:37:51    
	 * 修改人：赵志宏       
	 * 修改时间：2017年3月7日 下午8:37:51    
	 * 修改备注： 
	 * @param good
	 * @return</pre>
	 */
	@RequestMapping("insertGood")
	@ResponseBody
	public Map<String,Object> insertGood(Good good){
		goodService.insertGood(good);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("success", true);
		resultMap.put("tip", "新增成功");
		return resultMap;
	}
	
	@RequestMapping("updateGood")
	@ResponseBody
	public Map<String,Object> updateGood(Good good){
		goodService.updateGood(good);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("success", true);
		resultMap.put("tip", "修改成功");
		return resultMap;
	}
	
	
	@RequestMapping("deleteGoods")
	@ResponseBody
	public Map<String,Object> deleteGoods(@RequestBody List<String> ids){
		goodService.deleteGoods(ids);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("success", true);
		resultMap.put("tip", "删除成功");
		return resultMap;
	}
}
