<%@page import="daomain.Publish"%>
<%@page import="dao.PublishDao"%>
<%@page import="daomain.Author"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	PublishDao publishDao = new PublishDao();
	
	request.setCharacterEncoding("utf-8");
	
	String pName = request.getParameter("publishName");
	int id = Integer.parseInt(request.getParameter("publishId"));
	Publish publish = new Publish(id,pName);
	
	publishDao.update(publish); 
	
	response.sendRedirect("index.jsp");
%>
