package shop.controller.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * 账单显示详情
 */
@WebServlet("/TransactionInfo")
public class TransactionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session=request.getSession();
			String transactionIndexString=request.getParameter("transactionIndex");
			Integer transactionIndex=Integer.valueOf(transactionIndexString);
			List<Transaction> transactionList=(List<Transaction>) session.getAttribute("transactionList");
			List<Cart> cartListSelect=transactionList.get(transactionIndex-1).getCartList();
			List<Book> books=new ArrayList<Book>();
			BookModel bookModel=new BookModel();
			int priceCount=0;
			for (Cart cart : cartListSelect) {
				Book book=cart.getBook();
				priceCount+=book.getPrice();
				if (bookModel.checkBookNameRepeat(book)) {
					books.add(book);
				}else {
					book.setBookType(null);
					books.add(book);
				}
			}
			List<Object> transactionSelect=new ArrayList<Object>();
			transactionSelect.add(books);
			transactionSelect.add(priceCount);
			session.setAttribute("transactionSelect", transactionSelect);
			response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=history");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
