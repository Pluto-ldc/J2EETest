package shop.controller.shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.domain.Book;
import shop.domain.Cart;
import shop.domain.Transaction;
import shop.model.BookModel;

import java.util.*;

/**
 * 将图书添加到购物车
 * 
 * @author pluto
 *
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer bookId = Integer.valueOf(request.getParameter("bookId"));
		HttpSession session = request.getSession();
		if (bookId == null) {
			response.sendRedirect(request.getContextPath() + "/FindAllBooksServlet");
			return;
		}
		Book book = new Book();
		book.setId(bookId);
		BookModel bookModel = new BookModel();
		Date nowDate = new Date();
		String nowString = nowDate.toLocaleString();
		try {
			book = bookModel.getBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

		if (cartList == null) {
			cartList = new ArrayList<Cart>();
		}

		Cart cart = new Cart();
		cart.setBook(book);
		cart.setDateString(nowString);
		cartList.add(cart);

		List<Transaction> transactionList = (List<Transaction>) session.getAttribute("transactionList");
		Transaction transaction = new Transaction();
		transaction.setCartList(cartList);
		if (transactionList == null) {
			// 若记录为空，添加第一条记录
			transactionList = new ArrayList<Transaction>();
			transactionList.add(transaction);
		} else {
			if (!transactionList.get(transactionList.size() - 1).isStatus()) {
				// 若记录不为空且最后一条记录订单未完成，修改最后一条
				transactionList.set(transactionList.size() - 1, transaction);
			} else {
				// 若记录不为空，且最后一条记录已完成，在后面添加
				transactionList.add(transaction);
			}
		}
		session.setAttribute("transactionList", transactionList);
		session.setAttribute("cartList", cartList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
