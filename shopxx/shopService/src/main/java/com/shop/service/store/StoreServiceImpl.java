package com.shop.service.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.mapper.store.StoreMapper;
import com.shop.service.login.UserService;

@Service
public class StoreServiceImpl implements StoreService{
	private @Resource StoreMapper storeMapper;

	@Override
	public void insertAllStore(List<Map<String, Object>> listStore) {
		List<Map<String, Object>> listCommon = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listCommons = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : listStore) {
			String proName = (String) map.get("pro_name");
			String proDis = (String) map.get("pro_dis");
			Map<String, Object> selectStoreByName = storeMapper.selectStore(proName, proDis);
			if (selectStoreByName == null) {
				listCommon.add(map);
			} else {
				Double proTotalOne = (Double) map.get("pro_totalno");
				Object proTotalTwo = selectStoreByName.get("PRO_TOTALNO");
				Double proTotalNo = proTotalOne + Double.parseDouble(proTotalTwo.toString());
				selectStoreByName.put("PRO_TOTALNO", proTotalNo);
				listCommons.add(selectStoreByName);
			}
		}
		if (!listCommon.isEmpty()) {
             storeMapper.insertStoreSame(listCommon);
		}
		if (!listCommons.isEmpty()) {
            storeMapper.updateStore(listCommons);
		}
		storeMapper.insertAllStore(listStore);
	}

	@Override
	public Map<String,Object> queryAllPro(Integer pageSize, Integer offSet) {
		Map<String,Object> param = new HashMap<String,Object>();
		Integer endRow = offSet+pageSize;
		List<Map<String, Object>> listPro = storeMapper.queryAllPro(offSet+1,endRow);
		Integer total = storeMapper.queryCountPro();
		param.put("total", total);
		param.put("rows", listPro);
		return param;
	}

	@Override
	public Map<String, Object> queryAllStore(Integer pageSize, Integer offSet) {
		Map<String,Object> param = new HashMap<String,Object>();
		Integer endRow = offSet+pageSize;
		List<Map<String, Object>> listStro = storeMapper.queryAllStore(offSet+1,endRow);
		Integer total = storeMapper.queryCountStore();
		param.put("total", total);
		param.put("rows", listStro);
		return param;
	}

	@Override
	public Map<String, Object> queryStoreByName(Integer pageSize, Integer offSet, String proOrder) {
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> storeParam = new HashMap<String,Object>();
		Integer endRow = offSet+pageSize;
		storeParam.put("endRow", endRow);
		storeParam.put("startRow", offSet+1);
		storeParam.put("proOrder",proOrder);
		List<Map<String, Object>> listPro = storeMapper.queryStoreByNames(storeParam);
		Integer total = storeMapper.queryCountStoreByName(proOrder);
		param.put("total", total);
		param.put("rows", listPro);
		return param;
	}
}
