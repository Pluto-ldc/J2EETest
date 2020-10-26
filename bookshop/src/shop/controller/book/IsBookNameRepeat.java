package shop.controller.book;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Book;
import shop.model.BookModel;

/**
 * 查询是否有重复书名
 * 
 * @author pluto
 *
 */
@WebServlet("/IsBookNameRepeat")
public class IsBookNameRepeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		Book book = new Book();
		book.setBookName(bookName);
		BookModel bookModel = new BookModel();
		try {
			boolean isBookNameRepeat = bookModel.checkBookNameRepeat(book);
			response.getWriter().print(isBookNameRepeat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
