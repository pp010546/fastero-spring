package tw.com.fasterospring.service.intf;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.vo.UserVO;

public interface UserService {
	
	public Result getAll() throws Exception;

	public Result getById(Integer id);
	
	public Result register(UserVO vo);
	
	public Result login(String account, String password);
	
	public Result update(UserVO vo);
	
	public Result delete(Integer id);

}
