package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.vo.StoreVO;

public interface StoreService {

	public Result getAll() throws Exception;

	public Result getById(Integer id);
	
	public Result register(StoreVO vo);
	
	public Result login(String account, String password);
	
	public Result update(StoreVO vo);
	
	public Result delete(Integer id);
}
