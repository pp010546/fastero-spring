package tw.com.fasterospring.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.OrderDetailDAO;
import tw.com.fasterospring.service.intf.OrderDetailService;

@Service
@Transactional
public class OrderDetailServiceIm implements OrderDetailService{

	@Autowired
	private OrderDetailDAO DAO;

	@Autowired
	private Result R;
	
	@Override
	public Result getByOrderId(Integer OrderId) {
		try {
			return R.success(DAO.getByOrderId(OrderId));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

}
