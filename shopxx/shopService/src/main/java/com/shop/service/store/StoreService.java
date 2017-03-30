package com.shop.service.store;

import java.util.List;
import java.util.Map;

public interface StoreService {

	void insertAllStore(List<Map<String, Object>> listStore);

	Map<String,Object> queryAllPro(Integer pageSize, Integer offSet);

	Map<String, Object> queryAllStore(Integer pageSize, Integer offSet);

	Map<String, Object> queryStoreByName(Integer pageSize, Integer offSet, String proOrder);

}
