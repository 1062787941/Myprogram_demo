<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page contentType="text/html;charset=gbk"%>

<jsp:useBean id="book" class="daomain.Book">
	<jsp:setProperty name="book" property="*" />
</jsp:useBean>
<%
	BookDAO bookDao = new BookDAO();
	Book myBook = bookDao.get(book.getIsbn());
	if (myBook != null) {
		out
		.println("<script langugage='javascript'>alert('isbn已经存在！');history.go(-1);</script>");
	} else{
			bookDao.saveBook(book);
		}
%>
<html>

	<head>
		<title>朗慧图书管理信息系统-图书管理</title>
		<link rel=stylesheet href="../inc/main.css" type="text/css">
	</head>
	<table align="center" width="150">
		<caption>
			图书添加成功！
		</caption>
		<tr>
			<td>
				<a href="addBook.jsp">返回添加页面</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="index.jsp">返回图书列表页面</a>
			</td>
		</tr>
	</table>
</html>


