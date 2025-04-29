//這是一個介面（interface），規定好對User這張表要有哪些功能
package cart.dao;

import cart.model.entity.User;

public interface UserRegisterDAO {
	//新增User
	int addUser(User user);
	
	//email驗證成功並修改completed = true
	int emailConfirmOK(String username);
	
}
