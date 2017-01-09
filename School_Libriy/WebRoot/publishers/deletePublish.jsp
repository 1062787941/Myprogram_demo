<%@page import="dao.PublishDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	PublishDao dao = new PublishDao();
	String publishId = request.getParameter("publishId");
	
	dao.delete(Integer.parseInt(publishId));
	
	response.sendRedirect("index.jsp");
%>