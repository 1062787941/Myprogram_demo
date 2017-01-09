<%@page import="dao.UserDAO"%>
<%@page import="daomain.Publish"%>
<%@page import="dao.AuthorDao"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<jsp:useBean id="user" class="daomain.User">
	<jsp:setProperty name="user" property="*" />
</jsp:useBean>
<%
	UserDAO userDao = new UserDAO();
	userDao.saveUser(user);
	response.sendRedirect("index.jsp");
%>

