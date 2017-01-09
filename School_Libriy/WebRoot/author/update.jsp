<%@page import="dao.AuthorDao"%>
<%@page import="dao.PublishDao"%>
<%@page import="daomain.Author"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	AuthorDao authorDao = new AuthorDao();
	
	request.setCharacterEncoding("utf-8");
	
	String fName = request.getParameter("firstName");
	String lName = request.getParameter("lastName");
	int id = Integer.parseInt(request.getParameter("authorId"));
	Author author = new Author(id,fName,lName);
	
	authorDao.update(author); 
	
	response.sendRedirect("login.jsp");
%>
