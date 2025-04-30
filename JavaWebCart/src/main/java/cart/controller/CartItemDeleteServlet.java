//因為購物車在結帳之前是放在session裡面不是資料庫裡面，所以不能在dao，service裡面做刪除購物車項目
//結帳後才會放在資料庫
package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.OrderDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 刪除購物車項目
@WebServlet("/product/cart/item/delete")
public class CartItemDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		HttpSession session = req.getSession();
		if(session.getAttribute("cart") != null) {
			List<OrderDTO> cart = (List<OrderDTO>)session.getAttribute("cart");
			cart.remove(index);
			// 回存給 session (可以不用加)
			session.setAttribute("cart", cart);
		}
		
		resp.sendRedirect("/JavaWebCart/product/cart");
	}
	
}