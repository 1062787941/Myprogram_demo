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
		.println("<script langugage='javascript'>alert('isbn�Ѿ����ڣ�');history.go(-1);</script>");
	} else{
			bookDao.saveBook(book);
		}
%>
<html>

	<head>
		<title>�ʻ�ͼ�������Ϣϵͳ-ͼ�����</title>
		<link rel=stylesheet href="../inc/main.css" type="text/css">
	</head>
	<table align="center" width="150">
		<caption>
			ͼ����ӳɹ���
		</caption>
		<tr>
			<td>
				<a href="addBook.jsp">�������ҳ��</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="index.jsp">����ͼ���б�ҳ��</a>
			</td>
		</tr>
	</table>
</html>


