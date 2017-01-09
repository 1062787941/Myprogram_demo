<%@page import="dao.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<jsp:useBean id="user" class="daomain.User">
	<jsp:setProperty name="user" property="*" />
</jsp:useBean>
<%
	UserDAO userDao = new UserDAO();
	userDao.updateUser(user);
	response.sendRedirect("index.jsp");
%>

