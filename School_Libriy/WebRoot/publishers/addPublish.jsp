<%@page import="daomain.Publish"%>
<%@page import="dao.PublishDao"%>
<%@page import="dao.AuthorDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	PublishDao publishDao = new PublishDao();
	
	request.setCharacterEncoding("utf-8");
	
	String pName = request.getParameter("publishName");
	Publish publish = new Publish(0,pName);
	publishDao.save(publish); 
	
	response.sendRedirect("index.jsp");
%>
