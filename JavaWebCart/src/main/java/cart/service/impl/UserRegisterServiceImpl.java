//UserRegisterService 介面的實作類別，主要負責處理用戶的註冊以及 email 驗證
package cart.service.impl;

import cart.dao.UserRegisterDAO;
import cart.dao.impl.UserRegisterDAOImpl;
import cart.model.entity.User;
import cart.service.UserRegisterService;
import cart.util.HashUtil;

public class UserRegisterServiceImpl implements UserRegisterService {
	
	// 取得 UserRegisterDAO 物件實體
	private UserRegisterDAO userRegisterDAO = new UserRegisterDAOImpl();
	
	@Override
	public void addUser(String username, String password, String email) {
		try {
			// 使用 HashUtil 來加密密碼
			String hashSalt = HashUtil.generateSalt(); // 取得鹽
			String hashPassword = HashUtil.hashPassword(password, hashSalt); // 取 hash 密碼
			
			// 建立 User 物件
			// 注意 User 物件中不可以存放明碼 password 資料 (資訊安全)
			User user = new User();
			user.setUsername(username);;
			user.setHashPassword(hashPassword);
			user.setHashSalt(hashSalt);
			user.setEmail(email);
			
			// 呼叫 DAO 層方法將資料存進資料庫
			int rowcount = userRegisterDAO.addUser(user);
			if(rowcount < 1) {
				System.out.println("user 新增失敗");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//更新該使用者的 completed 欄位為 true，表示 email 驗證成功
	@Override
	public void emailConfirmOK(String username) {
		if(username == null) {
			return;
		}
		userRegisterDAO.emailConfirmOK(username);
		
	}
	
}