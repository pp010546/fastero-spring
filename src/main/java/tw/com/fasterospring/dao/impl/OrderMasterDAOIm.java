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
	
	@SuppressWarnings("unchecked")
	public List<OrderMasterVOForHistory> getByStoreName(String storeName) {
		return this.getSession().getNamedQuery("selectByStoreName").setParameter("storeName", "%" + storeName + "%").getResultList();
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
		
		return this.getSession().getNamedQuery("selectByUserId").setParameter("userId", userId)
//				.setFirstResult(0)
//				.setMaxResults(10)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMasterVOForHistory> getByStoreId(Integer storeId) {
		return this.getSession().getNamedQuery("selectByStoreId").setParameter("storeId", storeId)
//				.setFirstResult(0)
//				.setMaxResults(10)
				.getResultList();
	}

}
