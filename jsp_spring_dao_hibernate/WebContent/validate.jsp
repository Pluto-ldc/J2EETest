<%@page import="org.springframework.context.ConfigurableApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.easybooks.bookstore.vo.User"%>
<%@page import="org.easybooks.bookstore.dao.impl.UserDAO"%>
<%@page import="org.easybooks.bookstore.dao.IUserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");
			String userName=request.getParameter("userName");
			String passWord=request.getParameter("passWord");
			boolean validated=false;
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IUserDAO userDAO=(UserDAO)applicationContext.getBean("UserDAO");
			User user=userDAO.validate(new User(userName,passWord));
			((ConfigurableApplicationContext)applicationContext).close();
			if(user!=null){
				validated=true;
			}
			if(validated){
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		%>
	</body>
</html>