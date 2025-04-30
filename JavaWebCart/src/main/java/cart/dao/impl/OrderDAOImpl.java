package cart.dao.impl;

import java.util.List;

import cart.dao.OrderDAO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public class OrderDAOImpl extends BaseDao implements OrderDAO{

	@Override
	public Integer addOrder(Integer addId) {
		
		return null;
	}

	@Override
	public void addOrderItem(Integer orderId, Integer productId, Integer quantity) {
		
		
	}

	@Override
	public List<Order> findAllOrdersByUserId(Integer userId) {
		
		return null;
	}

	@Override
	public List<OrderItem> findAllOrdersItemByOrderId(Integer orderId) {
		
		return null;
	}

}
