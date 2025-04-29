package cart.service.impl;

import java.util.List;

import cart.model.dto.ProductDTO;
import cart.model.entity.Product;
import cart.service.ProductService;
import cart.dao.ProductDAO;
import cart.dao.impl.ProductDAOImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<ProductDTO> findAllProducts() {
		// 1.從 productListDAO 取得 List<Product>
		List<Product> products = productDAO.findAllProducts();
		
		List<ProductDTO> productDTOs = products.stream();
		
		return productDTOs;
	}

	@Override
	public void add(String productName, String price, String qty, String productImageBase64) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}

}
