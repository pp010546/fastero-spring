package tw.com.fasterospring.dao.intf;

import tw.com.fasterospring.vo.ReviewVO;

public interface ReviewDAO {
	
	public ReviewVO getByOrderId(Integer orderId);

}
