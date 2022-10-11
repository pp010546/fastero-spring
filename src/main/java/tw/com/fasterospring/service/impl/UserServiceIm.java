package tw.com.fasterospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.fasterospring.common.Regex;
import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.UserDAO;
import tw.com.fasterospring.service.intf.UserService;
import tw.com.fasterospring.vo.UserVO;

@Service
@Transactional
public class UserServiceIm implements UserService{
	
	@Autowired private UserDAO DAO;
	
	@Autowired private Result R;

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
	public Result register(UserVO vo) {
		String account = vo.getUserAccount();
		String password = vo.getUserPassword();
		String name = vo.getUserName();
		String phone = vo.getUserPhone();
		
		try {
			List<UserVO> allVo = DAO.getAll();
			List<String> allPhone = new ArrayList<String>();
			List<String> allAccount = new ArrayList<String>();
			
			for(UserVO v : allVo) {
				allPhone.add(v.getUserPhone());
				allAccount.add(v.getUserAccount());
			}
			// 1.檢查帳號
			if(account == null || "".equals(account)) return R.fail("帳號不可為空！");
				// 	1-1. 檢查帳號是否為email
				if (!Regex.emailCheck(account)) return R.fail("email格式錯誤！");
				// 	1-2. 檢查帳號是否存在
				if (allAccount.contains(account)) return R.fail("帳號已存在！");
			// 2.檢查密碼
			if(password == null || "".equals(password)) return R.fail("密碼不可為空！");
				// 	2-1. 檢查密碼格式
				if (!Regex.passwordCheck(password)) return R.fail("密碼格式錯誤！");
			// 3. 檢查姓名
			if(name == null || "".equals(name)) return R.fail("姓名不可為空！");
				// 	3-1. 檢查姓名格式
				if(!Regex.nameCheck(name)) return R.fail("姓名格式錯誤！");
			// 4. 檢查電話
			if(phone == null || "".equals(phone)) return R.fail("電話不可為空！");
				// 	4-1 檢查電話格式
				if(!Regex.phoneCheck(phone)) return R.fail("電話格式錯誤！");
				// 4-2 檢查電話是否重複
				if(allPhone.contains(phone)) return R.fail("此電話已被使用！");
			
			//檢查完畢無問題，將資料寫DB
			
			return R.success(DAO.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result login(String account, String password) {
		
		try {
			// 查詢帳號，將回傳資料存至變數
			final UserVO vo = DAO.getByAccount(account);
			// 若帳號查詢有資料
			if(vo!=null) {
				// 比對回傳密碼與使用者輸入密碼是否相符
				if(password.equals(vo.getUserPassword())) {
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
	public Result update(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
