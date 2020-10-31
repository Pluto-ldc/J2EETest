package shop.controller.shop;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.domain.Cart;
import shop.model.PageModel;

/**
 * 购物车分页
 */
@WebServlet("/PageCart")
public class PageCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		List<Cart> cartList=(List<Cart>) session.getAttribute("cartList");
		if(cartList==null) {
			response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=cart");
			return;
		}
		Integer pageSize = 5;
		String pageIndexString = request.getParameter("pageIndex");
		Integer pageIndex = null;
		if (pageIndexString == null) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.valueOf(pageIndexString);
		}
		List<Object> carts = new PageModel().getDataList(cartList, pageSize, pageIndex);
		Integer priceCount=0;
		for (Object object : cartList) {
			Cart cart=(Cart) object;
			priceCount+=cart.getBook().getPrice();
		}
		carts.add(priceCount);
		session.setAttribute("carts", carts);
		response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
