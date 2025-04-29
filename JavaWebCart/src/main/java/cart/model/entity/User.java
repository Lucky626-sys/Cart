//適合用在DAO層、Service層處理資料
package cart.model.entity;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String username;
	private String hashPassword;
	private String hashSalt;
	private String email;
	private Boolean completed;
}
