package cart.model.entity;

import lombok.Data;

@Data
public class Product {
	private Integer priceId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imgBase64;
}
