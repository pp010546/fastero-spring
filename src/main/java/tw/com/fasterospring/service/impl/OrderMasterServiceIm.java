package tw.com.fasterospring.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			
			// 1.先把該orderId取出
//			System.out.println("getting vo...");
			OrderMasterVOForHistory vo = DAO.getById(orderId);
//			if(vo == null) System.out.println("vo is null.");
//			if(vo.getUserId() != userId) System.out.println("incorrect userId, userId is " + vo.getUserId() + ", but input id is " + userId);
			// 2.判斷該訂單是否為空
			if(vo == null || vo.getUserId() != userId) {
				return R.fail("查無此筆訂單");
			}
			
			return R.success(vo);
		} catch (Exception e) {
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getByStoreId(Integer storeId) {
		try {
			return R.success(DAO.getByStoreId(storeId));
		} catch (Exception e) {
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
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
