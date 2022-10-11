package tw.com.fasterospring.dao.intf;

import java.sql.SQLException;
import java.util.List;

import tw.com.fasterospring.vo.StoreVO;

public interface StoreDAO {
	
	public List<StoreVO> getAll() throws SQLException;
	public StoreVO getById(Integer id) throws SQLException;
	public StoreVO getByAccount(String account) throws SQLException;
	public Integer insert(StoreVO vo) throws SQLException;
	public Integer delete(Integer id) throws SQLException;
	public Integer update(StoreVO vo) throws SQLException;
	public Integer updateNoPassword(StoreVO vo) throws SQLException;

}
