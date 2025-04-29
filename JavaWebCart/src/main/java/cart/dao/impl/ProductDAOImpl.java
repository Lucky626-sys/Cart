package cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cart.dao.ProductDAO;
import cart.model.entity.Product;

public class ProductDAOImpl extends BaseDao implements ProductDAO{

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select product_id, product_name, price, qty, img_base64 from product";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				Product product = new Product();
				product.setPriceId(rs.getInt("id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQty(rs.getInt("qty"));
				product.setImgBase64(rs.getString("img"));
				
				products.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}

}
