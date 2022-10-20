package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;

public interface OrderMasterService {

	public Result getAll();
	public Result getByUserId(Integer userId);
	public Result getByUserId(Integer userId, Integer OrderId);
	public Result getByStoreId(Integer storeId);
	public Result getByStoreId(Integer storeId, Integer orderId);
	public Result getById(Integer id);
	public Result getByStoreName(String storeName);

	
	
}
