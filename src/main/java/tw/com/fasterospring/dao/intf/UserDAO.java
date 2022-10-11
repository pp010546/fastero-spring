package tw.com.fasterospring.dao.intf;

import java.sql.SQLException;
import java.util.List;

import tw.com.fasterospring.vo.UserVO;

public interface UserDAO {
	
	public List<UserVO> getAll() throws Exception;

	public UserVO getById(Integer id) throws SQLException;
	
	//傳帳號回傳全部資料，登入用
	public UserVO getByAccount(String account) throws SQLException;
	
	public Integer insert(UserVO vo) throws SQLException;
	
	public Integer update(UserVO vo) throws SQLException;
	
	public Integer updateNoPassword(UserVO vo) throws SQLException;

}
