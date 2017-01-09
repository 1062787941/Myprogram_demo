<%@page import="utils.ParamUtil"%>
<%@page import="dao.BookDAO"%>
<%@page contentType="text/html;charset=utf-8" %>
<%
	BookDAO bookDao = new BookDAO();
	bookDao.delete(request.getParameter("isbn"));
	
	//request.getParameter("qisbn")
	
	String url = "index.jsp";
	url = ParamUtil.appendParam(url, "isbn", request.getParameter("qisbn"));
	url = ParamUtil.appendParam(url, "page", request.getParameter("page"));
	url = ParamUtil.appendParam(url, "title", request.getParameter("title"));
	response.sendRedirect(url);
		
%>
