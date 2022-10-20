package tw.com.fasterospring.dao.intf;

import java.util.List;

import tw.com.fasterospring.vo.OrderMasterVOForHistory;

public interface OrderMasterDAO {
	
	public List<OrderMasterVOForHistory> getAll();
	public OrderMasterVOForHistory getById(Integer id);
	public List<OrderMasterVOForHistory> getByUserId(Integer userId);
	public List<OrderMasterVOForHistory> getByStoreId(Integer storeId);
	public Integer insert(OrderMasterVOForHistory vo);
	public Integer delete(Integer id);
	public Integer update(OrderMasterVOForHistory vo);
	public List<OrderMasterVOForHistory> getByStoreName(String storeName);

}
