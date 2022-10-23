package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.vo.ReviewVO;

public interface ReviewService {

	public Result getByOrderId(Integer orderId);
	public Result insert(ReviewVO vo);
	public Result updateResponse(String response, Integer orderId);
}
