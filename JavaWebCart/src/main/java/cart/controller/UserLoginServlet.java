package cart.controller;

import java.io.IOException;

import cart.model.dto.UserDTO;
import cart.service.UserLoginService;
import cart.service.impl.UserLoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	
	private UserLoginService userLoginService = new UserLoginServiceImpl();
	//顯示登入畫面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/cart/user_login.jsp").forward(req, resp);
	}
	//接收使用者輸入的帳號、密碼、驗證碼
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String authcode = req.getParameter("authcode");
		
		//從session取出系統產生的驗證碼(sessionAuthcode)
		HttpSession session = req.getSession();
		// 取得目前存放在 session 的驗證碼(驗證碼圖片內容)
		String sessionAuthcode = session.getAttribute("authcode") + "";
		
		String resultMessage = null;
		try {
			UserDTO userDTO = userLoginService.login(username, password, authcode, sessionAuthcode);
			resultMessage = username + " 登入成功!";
			// 當登入資訊存入到 session 中
			session.setAttribute("userDTO", userDTO);
		} catch (RuntimeException e) {
			session.removeAttribute("userDTO"); // 移除舊有的登入資訊
			resultMessage = e.getMessage();
		}
		
		// 給 result.jsp 的資訊
		//第一個""是你為變數取的名字，第二個是要給jsp的資訊
		req.setAttribute("resultTitle", "登入結果");
		req.setAttribute("resultMessage", resultMessage);
		
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}
}