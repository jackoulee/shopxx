package com.shop.controller.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shop.service.store.StoreService;
import com.shop.util.ImportExcelUtil;

/** 
 * <pre>项目名称：shopWeb    
 * 类名称：StoreController    
 * 类描述：  仓库controller层  
 * 创建人：赵巧娟
 * 创建时间：2017年3月7日 上午8:31:42    
 * 修改人：赵巧娟     
 * 修改时间：2017年3月7日 上午8:31:42    
 * 修改备注：       
 * @version </pre>    
 */


@Controller
@RequestMapping("storeController")
public class StoreController {
	private @Resource StoreService storeService;

	/**
	 * <pre>importStoreInfo(导入商品信息)   
	 * 创建人：李昭源     
	 * 创建时间：2017年3月7日 上午8:33:17    
	 * 修改人：李昭源       
	 * 修改时间：2017年3月7日 上午8:33:17    
	 * 修改备注： 
	 * @param myFile</pre>
	 */
	@ResponseBody
	@RequestMapping("importStoreInfo")
   public void importStoreInfo(HttpServletRequest request,MultipartFile myFile){
		InputStream inputStream = null;
	   try {
		   inputStream = myFile.getInputStream();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   List<Map<String, Object>> listStore = ImportExcelUtil.readExcelInfo(inputStream);
	   storeService.insertAllStore(listStore);
   }
	
	
	/** 
	 * <pre>项目名称：shopWeb    
	 * 类名称：StoreController    
	 * 类描述：    仓库分页
	 * 创建人：李昭源  
	 * 创建时间：2017年3月7日 下午12:56:04    
	 * 修改人：李昭源     
	 * 修改时间：2017年3月7日 下午12:56:04    
	 * 修改备注：       
	 * @version </pre>    
	 */
	@RequestMapping("queryAllPro")
	@ResponseBody
	public Map<String,Object> queryAllPro(Integer pageSize,Integer offSet){
		Map<String,Object> mapPro = storeService.queryAllPro(pageSize,offSet);
		return mapPro;
	}
}
