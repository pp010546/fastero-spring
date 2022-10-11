package tw.com.fasterospring.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.fasterospring.dao.intf.OrderMasterDAO;
import tw.com.fasterospring.vo.OrderMasterVOForHistory;

@Repository
public class OrderMasterDAOIm implements OrderMasterDAO{
	
	@PersistenceContext private Session session;
	public Session getSession() {
		return session;
	}
	@Autowired private OrderMasterVOForHistory vo;

	@Override
	public List<OrderMasterVOForHistory> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderMasterVOForHistory getById(Integer id) {
		
		return this.getSession().get(OrderMasterVOForHistory.class, id);
	}

	@Override
	public Integer insert(OrderMasterVOForHistory vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(OrderMasterVOForHistory vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMasterVOForHistory> getByUserId(Integer userId) {
		
		return this.getSession().getNamedQuery("selectByUserId").setParameter("userId", userId).getResultList();
	}

	@Override
	public List<OrderMasterVOForHistory> getByStoreId(Integer storeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
