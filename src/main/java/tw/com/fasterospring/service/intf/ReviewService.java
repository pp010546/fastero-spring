package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;

public interface ReviewService {

	public Result getByOrderId(Integer orderId);
}
