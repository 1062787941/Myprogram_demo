<%@page import="daomain.User"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	
	
	UserDAO userDao = new UserDAO();
	User user = userDao.login(account, password);
	
	if(user == null){//登录失败
		request.setAttribute("errorMessage", "登录失败，帐号或者密码有误！");
		request.getRequestDispatcher("/").forward(request, response);
	}else{
		session.setAttribute("loginModel", user);
		response.sendRedirect(request.getContextPath()+"/author/index.jsp");
	}
	
	
%>