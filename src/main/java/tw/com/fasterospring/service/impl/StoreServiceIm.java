package tw.com.fasterospring.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.StoreDAO;
import tw.com.fasterospring.service.intf.StoreService;
import tw.com.fasterospring.vo.StoreVO;
import tw.com.fasterospring.vo.UserVO;

@Service
@Transactional
public class StoreServiceIm implements StoreService {

	@Autowired
	private StoreDAO DAO;

	@Autowired
	private Result R;

	@Override
	public Result getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result register(StoreVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result login(String account, String password) {
		try {
			// 查詢帳號，將回傳資料存至變數
			final StoreVO vo = DAO.getByAccount(account);
			// 若帳號查詢有資料
			if(vo!=null) {
				// 比對回傳密碼與使用者輸入密碼是否相符
				if(password.equals(vo.getStoreAdminPassword())) {
//					System.out.println("login successful!");
					return R.success(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
		
		return R.fail("帳號或密碼錯誤！");
	}

	@Override
	public Result update(StoreVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
