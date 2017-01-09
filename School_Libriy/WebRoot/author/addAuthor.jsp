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
	Author author = new Author(0,fName,lName);
	authorDao.save(author); 
	
	response.sendRedirect("index.jsp");
%>
