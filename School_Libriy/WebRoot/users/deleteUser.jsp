<%@page import="dao.UserDAO"%>
<%@page import="daomain.Publish"%>
<%@page import="dao.AuthorDao"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%

	String userID = request.getParameter("userID");
	UserDAO userDao = new UserDAO();
	userDao.deleteUser(Integer.parseInt(userID));
	response.sendRedirect("index.jsp");
%>

