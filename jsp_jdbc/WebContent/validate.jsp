<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="MySQLBean" scope="page" class="org.easybooks.bookstore.jdbc.MySQLConnBean" />
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
			
			String sql="select * from user";
			MySQLBean.openConn();
			ResultSet resultSet=MySQLBean.executeQuery(sql);
			while(resultSet.next()){
				if(resultSet.getString("userName").compareTo(userName)==0&&resultSet.getString("passWord").compareTo(passWord)==0){
					validated=true;
					break;
				}
			}
			resultSet.close();
			MySQLBean.closeStatement();
			MySQLBean.closeConnection();
			if(validated){
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		%>
	</body>
</html>