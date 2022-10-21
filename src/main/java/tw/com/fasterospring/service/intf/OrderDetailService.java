package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;

public interface OrderDetailService {

	public Result getByOrderId(Integer OrderId);
}
