package tw.com.fasterospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.fasterospring.common.Regex;
import tw.com.fasterospring.common.Result;
import tw.com.fasterospring.dao.intf.StoreDAO;
import tw.com.fasterospring.service.intf.StoreService;
import tw.com.fasterospring.vo.StoreVO;

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
		try {
			return R.success(DAO.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result register(StoreVO vo) {
		// admin
		String adminAccount = vo.getStoreAdminAccount();
		String adminID = vo.getStoreAdminId();
		String adminPhone = vo.getStoreAdminPhone();
		String adminAddress = vo.getStoreAdminAddress();
		// store
		String storeAddress = vo.getStoreAddress();
		String storePhone = vo.getStorePhone();
		String storeEmail = vo.getStoreEmail();
		
		try {
			
			List<StoreVO> allVo = DAO.getAll();
			List<String> allAdinAccount = new ArrayList<String>();
			List<String> allAdinID = new ArrayList<String>();
			List<String> allAdminPhone = new ArrayList<String>();
			List<String> allstoreAddress = new ArrayList<String>();
			List<String> allstorePhone = new ArrayList<String>();
			List<String> allstoreEmail = new ArrayList<String>();
			

			for (StoreVO v : allVo) {
				allAdinAccount.add(v.getStoreAdminAccount());
				allAdinID.add(v.getStoreAdminId());
				allAdminPhone.add(v.getStoreAdminPhone());
				allstoreAddress.add(v.getStoreAddress());
				allstorePhone.add(v.getStorePhone());
				allstoreEmail.add(v.getStoreEmail());
			}
			// null / blank
			// admin
			if(adminAccount == null || adminAccount.isBlank()) return R.fail("帳號不可為空");
			if(adminID == null || adminID.isBlank()) return R.fail("負責人身分證字號不可為空");
			if(adminPhone == null || adminPhone.isBlank()) return R.fail("負責人電話不可為空");
			if(adminAddress == null || adminAddress.isBlank()) return R.fail("負責人地址不可為空");
			// store
			if(storeAddress == null || storeAddress.isBlank()) return R.fail("店家地址不可為空");
			if(storePhone == null || storePhone.isBlank()) return R.fail("店家電話不可為空");
			if(storeEmail == null || storeEmail.isBlank()) return R.fail("店家信箱不可為空");
			
			// format
			// admin
			if (!Regex.emailCheck(adminAccount)) return R.fail("負責人email格式錯誤");
			if (!Regex.idcheck(adminID)) return R.fail("身分證格式錯誤");
			if (!Regex.phoneCheck(adminPhone)) return R.fail("請輸入手機號碼");
			
			// store
			if (!Regex.emailCheck(storeEmail)) return R.fail("店家email格式錯誤");
			
			// duplicate
			// admin
			if(allAdinAccount.contains(adminAccount)) return R.fail("此帳號已被使用");
			if(allAdinID.contains(adminID)) return R.fail("此身分證字號已被使用");
			if(allAdminPhone.contains(adminPhone)) return R.fail("此電話已被使用");
	
			// store
			if(allstoreAddress.contains(storeAddress)) return R.fail("此店家地址已被使用");
			if(allstorePhone.contains(storePhone)) return R.fail("此店家電話已被使用");
			if(allstoreEmail.contains(storeEmail)) return R.fail("此店家信箱已被使用");
			
			// success
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
		// admin
		String adminAccount = vo.getStoreAdminAccount();
		String adminID = vo.getStoreAdminId();
		String adminPhone = vo.getStoreAdminPhone();
		String adminAddress = vo.getStoreAdminAddress();
		// store
		String storeAddress = vo.getStoreAddress();
		String storePhone = vo.getStorePhone();
		String storeEmail = vo.getStoreEmail();
		String storeName = vo.getStoreName();
		
		try {
			
			List<StoreVO> allVo = DAO.getAll();
			List<String> allAdinAccount = new ArrayList<String>();
			List<String> allAdinID = new ArrayList<String>();
			List<String> allAdminPhone = new ArrayList<String>();
			List<String> allstoreAddress = new ArrayList<String>();
			List<String> allstorePhone = new ArrayList<String>();
			List<String> allstoreEmail = new ArrayList<String>();
			

			for (StoreVO v : allVo) {
				allAdinAccount.add(v.getStoreAdminAccount());
				allAdinID.add(v.getStoreAdminId());
				allAdminPhone.add(v.getStoreAdminPhone());
				allstoreAddress.add(v.getStoreAddress());
				allstorePhone.add(v.getStorePhone());
				allstoreEmail.add(v.getStoreEmail());
			}
			// null / blank
			// admin
			if(adminAccount == null || adminAccount.isBlank()) return R.fail("帳號不可為空");
			if(adminID == null || adminID.isBlank()) return R.fail("負責人身分證字號不可為空");
			if(adminPhone == null || adminPhone.isBlank()) return R.fail("負責人電話不可為空");
			if(adminAddress == null || adminAddress.isBlank()) return R.fail("負責人地址不可為空");
			// store
			if(storeAddress == null || storeAddress.isBlank()) return R.fail("店家地址不可為空");
			if(storePhone == null || storePhone.isBlank()) return R.fail("店家電話不可為空");
			if(storeEmail == null || storeEmail.isBlank()) return R.fail("店家信箱不可為空");
			if(storeName == null || storeName.isBlank()) return R.fail("店家名稱不可為空");
			
			
			// format
			// admin
			if (!Regex.emailCheck(adminAccount)) return R.fail("負責人email格式錯誤");
			if (!Regex.idcheck(adminID)) return R.fail("身分證格式錯誤");
			if (!Regex.phoneCheck(adminPhone)) return R.fail("請輸入手機號碼");
			
			// store
			if (!Regex.emailCheck(storeEmail)) return R.fail("店家email格式錯誤");
			
			// success
			return R.success(DAO.update(vo));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
