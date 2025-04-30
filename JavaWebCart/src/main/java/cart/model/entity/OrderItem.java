package cart.model.entity;

import lombok.Data;

@Data
public class OrderItem {
	private Integer itemId;		//每筆訂單內商品序號
	private Integer orderId;	//訂單編號
	private Integer productId;	//商品編號
	private Integer quantity;	//數量
}