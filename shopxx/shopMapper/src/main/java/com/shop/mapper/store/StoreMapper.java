package com.shop.mapper.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.entity.Count;
import com.shop.entity.User;

public interface StoreMapper {

	Map<String, Object> selectStore(@Param("proName")String proName, @Param("proDis")String proDis);

	void insertStoreSame(List<Map<String, Object>> listCommon);

	void updateStore(List<Map<String, Object>> listCommons);

	void insertAllStore(List<Map<String, Object>> listStore);

	List<Map<String, Object>> queryAllPro(@Param("startRow")Integer startRow, @Param("endRow")Integer endRow);

	Integer queryCountPro();

	List<Map<String, Object>> queryAllStore(@Param("startRow")Integer startRow, @Param("endRow")Integer endRow);

	Integer queryCountStore();

	Integer queryCountStoreByName(String proOrder);

	List<Map<String, Object>> queryStoreByNames(Map<String, Object> storeParam);

}
