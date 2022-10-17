package tw.com.fasterospring.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.UserDAO;
import tw.com.fasterospring.vo.UserVO;

@Repository
public class UserDAOIm implements UserDAO {

	@Autowired
	UserVO vo;

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> getAll() throws Exception {

		return this.getSession().getNamedQuery("selectAllUser").getResultList();
	}

	@Override
	public UserVO getById(Integer id) throws SQLException {
		try {
			return this.getSession().get(UserVO.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer insert(UserVO vo) {

		try {
			this.getSession().save(vo);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public UserVO getByAccount(String account) {

		Query query = this.getSession().getNamedQuery("selectUserByAccount").setParameter("account", account);
		try {
			return (UserVO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Integer update(UserVO vo) throws SQLException {

		try {
			this.getSession().update(vo);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	@Override
	public Integer updateNoPassword(UserVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
