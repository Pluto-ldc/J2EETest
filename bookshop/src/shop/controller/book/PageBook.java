package shop.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.domain.Book;
import shop.model.PageModel;

/**
 * 实现图书分页
 */
@WebServlet("/PageBook")
public class PageBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		List<Book> allBooks=(List<Book>) session.getAttribute("allBooks");
		Integer pageSize = 10;
		String pageIndexString = request.getParameter("pageIndex");
		Integer pageIndex = null;
		if (pageIndexString == null) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.valueOf(pageIndexString);
		}
		List<Object> bookDataList = new PageModel().getDataList(allBooks, pageSize, pageIndex);
		session.setAttribute("bookDataList", bookDataList);
		response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=booklist");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
