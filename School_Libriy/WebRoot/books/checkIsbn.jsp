<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<title>朗慧图书管理信息系统-图书管理</title>
		<link rel=stylesheet href="../inc/main.css" type="text/css">
		<style type="text/css">
			table select {
				width: 200px;
			}
			.tcolumn {
				background: #DDDDFF;
			}
		</style>
	</head>
	<body>
	
	<p align="center">
		<%
			String isbn = request.getParameter("isbn");
			Book book = new BookDAO ().get(isbn);
			if(book == null) {
				out.println("isbn不存在， 您可以正常使用！");
			}
			else
			{
				out.println("isbn已经存在， 不能录入！");
			}
		 %>
	<p>
	<p align="center">
		<a href="#" onclick="javascript:window.close(); return false;">关闭窗口</a>
	</p>
	</body>
</html>
