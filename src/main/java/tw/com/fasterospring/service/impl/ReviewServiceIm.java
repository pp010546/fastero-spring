package tw.com.fasterospring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.ReviewDAO;
import tw.com.fasterospring.service.intf.ReviewService;

@Service
public class ReviewServiceIm implements ReviewService{
	@Autowired
	private Result R;
	@Autowired
	private ReviewDAO DAO;
	
	@Override
	public Result getByOrderId(Integer orderId) {
		try {
			return R.success(DAO.getByOrderId(orderId));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	
	
}
