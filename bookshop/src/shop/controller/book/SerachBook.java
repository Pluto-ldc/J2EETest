package shop.controller.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Book;
import shop.model.BookModel;

/**
 * Servlet implementation class SerachBook
 */
@WebServlet("/SerachBook")
public class SerachBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyWord=request.getParameter("keyWord");
		try {
			List<Book> books=new BookModel().findByKeyWord(keyWord);
			request.getSession().setAttribute("allBooks",books);
			response.sendRedirect(request.getContextPath() + "/PageBook");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
