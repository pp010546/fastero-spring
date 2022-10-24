package tw.com.fasterospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.OrderMasterDAO;
import tw.com.fasterospring.service.intf.OrderMasterService;
import tw.com.fasterospring.vo.OrderMasterVOForHistory;

@Service
@Transactional
public class OrderMasterServiceIm implements OrderMasterService {

	@Autowired
	private OrderMasterDAO DAO;

	@Autowired
	private Result R;

	@Override
	public Result getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getByUserId(Integer userId) {
		try {
			return R.success(DAO.getByUserId(userId));
		} catch (Exception e) {
			return R.fail(e.toString());
		}
	}
	
	public Result getByUserId(Integer userId, Integer orderId) {
		try {
			OrderMasterVOForHistory vo = DAO.getById(orderId);

			if(vo == null || vo.getUserId() != userId) {
				return R.fail("查無此筆訂單");
			}
			
			return R.success(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getByStoreId(Integer storeId) {
		try {
			return R.success(DAO.getByStoreId(storeId));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	@Override
	public Result getByStoreId(Integer storeId, Integer orderId) {
		
		try {
			OrderMasterVOForHistory vo = DAO.getById(orderId);
			if(vo == null || vo.getStoreId() != storeId) {
				return R.fail("查無此筆訂單");
			}
			
			return R.success(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Result getByStoreName(String storeName, Integer userId) {
		try {
			List<OrderMasterVOForHistory> allVO = DAO.getByStoreName(storeName);
			List<OrderMasterVOForHistory> list = new ArrayList<OrderMasterVOForHistory>();
			
			for(OrderMasterVOForHistory vo :allVO) {
				if(vo.getUserId() == userId) {
					list.add(vo);
				}
			}
			
			if(!list.isEmpty()) {
				return R.success(list);				
			}else {
				return R.fail("查詢無結果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result updateStatus(Integer status, Integer orderId) {
		if(status>4 || status<0) {
			return R.fail("status is out of range!");
		}
		
		try {
			return R.success(DAO.updateStatus(status, orderId));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

}
