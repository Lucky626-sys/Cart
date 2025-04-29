//定義一個方法 findUserByName(String username)
//DAO Interface 的好處是「規範標準」，未來如果有不同的資料來源（如 NoSQL），也可以換不同的 DAO
package cart.dao;

import cart.model.entity.User;

public interface UserLoginDAO {
	User findUserByName(String username);
}