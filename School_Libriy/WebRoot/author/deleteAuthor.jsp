<%@page import="dao.AuthorDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	AuthorDao dao = new AuthorDao();
	String authorId = request.getParameter("authorId");
	
	dao.delete(Integer.parseInt(authorId));
	
	response.sendRedirect("index.jsp");
%>