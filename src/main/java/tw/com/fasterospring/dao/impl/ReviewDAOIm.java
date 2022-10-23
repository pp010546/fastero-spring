package tw.com.fasterospring.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.ReviewDAO;
import tw.com.fasterospring.vo.ReviewVO;

@Repository
public class ReviewDAOIm implements ReviewDAO {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public ReviewVO getByOrderId(Integer orderId) {
		return (ReviewVO) this.getSession()
							  .getNamedQuery("selectByOrderId")
							  .setParameter("orderId", orderId)
							  .getSingleResult();
	}

	@Override
	public Integer insert(ReviewVO vo) {
		try {
			this.getSession().save(vo);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public Integer updateResponse(String response, Integer orderId) {
		try {
			return this.getSession().getNamedQuery("updateResponse")
									.setParameter("response", response)
									.setParameter("orderId", orderId)
									.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
