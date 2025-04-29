//定義一個 login 方法
//Service Interface的目的是「未來可替換 Service實作類（例如測試用、真實用）」
package cart.service;

import cart.model.dto.UserDTO;

public interface UserLoginService {
	//驗證是否登入成功
	//username, password, authCode = 登入三劍客(使用者所自行輸入的資訊)
	//sessionAuthCode = 目前存在session的驗證碼
	UserDTO login(String username, String password, String authCode, String sessionAuthCode);
}
