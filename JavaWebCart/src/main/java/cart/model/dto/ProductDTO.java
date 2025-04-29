package cart.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
	//對應entity.Product欄位資料
	private Integer priceId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imgBase64;
	//自訂欄位total (庫存成本:price*qty)
	private Integer total;
}
