package tw.com.fasterospring.dao.intf;

import java.util.List;

import tw.com.fasterospring.vo.OrderDetailVO;

public interface OrderDetailDAO {
	
	public List<OrderDetailVO> getByOrderId(Integer orderId);

}
