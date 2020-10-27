<%@page import="org.hibernate.query.Query"%>
<%@page import="org.easybooks.bookstore.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.sql.ResultSet"%>
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
			Configuration configuration = new Configuration();
			SessionFactory sf = configuration.configure().buildSessionFactory();
			Session session_hib = sf.openSession();
			String sql="from User u where u.userName = ?0 and u.passWord = ?1 ";
			Query<User> query_hib = session_hib.createQuery(sql,User.class)
					.setParameter(0, userName)
					.setParameter(1, passWord)
					.setMaxResults(1);
			List<User> users=query_hib.getResultList();
			if(users.size()!=0){
				validated=true;
			}
			session_hib.close();
			sf.close();
			if(validated){
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		%>
	</body>
</html>