package com.shop.service.count;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.mapper.count.CountMapper;

/**
 * 
 * <pre>项目名称：shopService    
 * 类名称：CountServiceImpl    
 * 类描述：    
 * 创建人 :李昭源  
 * 创建时间：2017年3月8日 上午11:54:13    
 * 修改人：:李昭源     
 * 修改时间：2017年3月8日 上午11:54:13    
 * 修改备注：       
 * @version </pre>
 */
@Service
public class CountServiceImpl implements CountService {
	private @Resource CountMapper countMapper;
	
	/**
	 * 查询出商品的类型和总量
	 */
	@Override
	public List<Map<String, Object>> queryProCount() {
		return countMapper.queryProCount();
	}

	
}
