package tw.com.fasterospring.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.StoreDAO;
import tw.com.fasterospring.vo.StoreVO;
import tw.com.fasterospring.vo.UserVO;

@Repository
public class StoreDAOIm implements StoreDAO {

	@Autowired
	StoreVO vo;

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreVO> getAll() {
		return this.getSession().getNamedQuery("selectAllStore").getResultList();
	}

	@Override
	public StoreVO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(StoreVO vo) {
		try {
			this.getSession().save(vo);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(StoreVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreVO getByAccount(String account) throws SQLException {
		Query query = this.getSession().getNamedQuery("selectStoreByAccount").setParameter("account", account);
		try {
			return (StoreVO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Integer updateNoPassword(StoreVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
