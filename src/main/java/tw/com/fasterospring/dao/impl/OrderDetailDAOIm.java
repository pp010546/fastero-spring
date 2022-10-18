package tw.com.fasterospring.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.OrderDetailDAO;
import tw.com.fasterospring.vo.OrderDetailVO;

@Repository
public class OrderDetailDAOIm implements OrderDetailDAO{

	@PersistenceContext private Session session;
	public Session getSession() {
		return session;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailVO> getByOrderId(Integer orderId) {
		return this.getSession().getNamedQuery("selectAllDetailById").setParameter("id", orderId).getResultList();
	}

	
}
