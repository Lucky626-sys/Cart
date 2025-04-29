//UserDTO 是專門用來安全傳資料的輕量版 User，只有必要欄位，沒有密碼！
package cart.model.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	private String username;
	private String email;
	private Boolean completed;
}
