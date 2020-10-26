package shop.controller.shop;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.domain.Cart;
import shop.domain.Transaction;
import shop.domain.User;

/**
 * 结算
 * 
 * @author pluto
 *
 */
@WebServlet("/CartSubmit")
public class CartSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 计算总价
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		int countPrice = 0;
		for (Cart cart : cartList) {
			int price = cart.getBook().getPrice();
			countPrice += price;
		}
		// 减去客户价格，加上管理员价格
		User user = (User) session.getAttribute("user");
		Integer userId = user.getId();

		// 订单完成
		List<Transaction> transactionList=(List<Transaction>) session.getAttribute("transactionList");
		Transaction transaction=transactionList.get(transactionList.size()-1);
		transaction.setStatus(true);
		Date nowDate=new Date();
		transaction.setDateString(nowDate.toLocaleString());
		transactionList.set(transactionList.size()-1, transaction);
		session.setAttribute("transactionList", transactionList);
		session.removeAttribute("cartList");
		response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
