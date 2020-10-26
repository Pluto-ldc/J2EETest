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
 * 添加图书
 * 
 * @author pluto
 *
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String bookType = request.getParameter("bookType");
		String bookNote = request.getParameter("bookNote");
		String author = request.getParameter("author");
		Integer price = Integer.valueOf(request.getParameter("price"));
		Book book = new Book();
		book.setBookName(bookName);
		book.setBookType(bookType);
		book.setBookNote(bookNote);
		book.setAuthor(author);
		book.setPrice(price);
		BookModel bookModel = new BookModel();
		try {
			boolean isAddBookSucess = bookModel.addBook(book);
			if (isAddBookSucess) {
				response.sendRedirect(request.getContextPath() + "/FindAllBooksServlet");
			} else {
				request.setAttribute("msg", "添加失败，请联系管理员处理！");
				request.getRequestDispatcher("/pages/main.jsp?son=addbook").forward(request, response);
			}
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
