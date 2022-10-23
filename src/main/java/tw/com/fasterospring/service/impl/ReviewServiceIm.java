package tw.com.fasterospring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.ReviewDAO;
import tw.com.fasterospring.service.intf.ReviewService;
import tw.com.fasterospring.vo.ReviewVO;

@Service
@Transactional
public class ReviewServiceIm implements ReviewService{
	@Autowired
	private Result R;
	@Autowired
	private ReviewDAO DAO;
	
	@Override
	public Result getByOrderId(Integer orderId) {
		try {
			return R.success(DAO.getByOrderId(orderId));
		}
		catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result insert(ReviewVO vo) {
		
		if(vo.getReviewPoint() == null) {
			return R.fail("請評分");
		}
		
		try {
			return R.success(DAO.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	@Transactional(
			propagation = Propagation.REQUIRES_NEW
			)
	public Result updateResponse(String response, Integer orderId) {
		
		if(response.isBlank() || response == null) {
			return R.fail("請輸入回覆");
		}
		
		try {
			return R.success(DAO.updateResponse(response, orderId));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	
	
}
