//登入驗證的過濾器(Filter)，叫做LoginFilter，它會在使用者嘗試瀏覽/user/list或/product/list頁面時，檢查他有沒有登入
//HttpFilter 是 Java EE 的一個類別，用來處理「過濾器邏輯」。
//LoginFilter 是你自己定義的過濾器，用來攔截、判斷使用者是否已登入。
package cart.filter;
import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/list", "/product/list"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 根據 session 屬性是否有 userDTO 物件來判斷是否已經登入 ?
		HttpSession session = request.getSession();
		if(session.getAttribute("userDTO") == null) {
			//沒登入 → 導回登入頁面
			response.sendRedirect("/JavaWebCart/user/login");
		} else {
			//如果session裡有登入資訊 → 放行，繼續處理請求（例如進入 /user/list 頁面）
			//在Filter中，doFilter()方法代表「讓請求繼續往下傳遞」
			chain.doFilter(request, response);
		}
	}
}