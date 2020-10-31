package shop.controller.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.domain.Transaction;
import shop.model.PageModel;

/**
 * 交易记录分页Servlet
 */
@WebServlet("/PageTransaction")
public class PageTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		session.removeAttribute("transactionSelect");
		List<Transaction> transactionList=(List<Transaction>) session.getAttribute("transactionList");
		if(transactionList==null) {
			response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=history");
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
		List<Object> transactions = new PageModel().getDataList(transactionList, pageSize, pageIndex);
		session.setAttribute("transactions", transactions);
		response.sendRedirect(request.getContextPath() + "/pages/main.jsp?son=history");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
