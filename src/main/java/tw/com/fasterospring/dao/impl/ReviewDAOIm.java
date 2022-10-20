package tw.com.fasterospring.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.ReviewDAO;
import tw.com.fasterospring.vo.ReviewVO;

@Repository
public class ReviewDAOIm implements ReviewDAO{

	@PersistenceContext private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public ReviewVO getByOrderId(Integer orderId) {
		return (ReviewVO) this.getSession().getNamedQuery("selectByOrderId").setParameter("orderId", orderId).getSingleResult();
	}

}
