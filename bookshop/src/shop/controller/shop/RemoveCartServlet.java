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
import shop.domain.Transaction;

/**
 * 从购物车中移除该商品
 * 
 * @author pluto
 *
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer bookId = Integer.valueOf(request.getParameter("bookId"));
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		if (bookId == null || cartList == null) {
			response.sendRedirect(request.getContextPath() + "/FindAllBooksServlet");
			return;
		}
		for (Cart cart : cartList) {
			if(cart.getBook().getId()==bookId) {
				cartList.remove(cart);
			}
		}
		List<Transaction> transactionList=(List<Transaction>) session.getAttribute("Transaction");
		Transaction transaction=new Transaction();
		transaction.setCartList(cartList);
		transactionList.set(transactionList.size()-1, transaction);
		session.setAttribute("transactionList", transactionList);
		session.setAttribute("cartList", cartList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
