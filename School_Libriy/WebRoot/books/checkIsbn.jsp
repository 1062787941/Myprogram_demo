<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<title>�ʻ�ͼ�������Ϣϵͳ-ͼ�����</title>
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
				out.println("isbn�����ڣ� ����������ʹ�ã�");
			}
			else
			{
				out.println("isbn�Ѿ����ڣ� ����¼�룡");
			}
		 %>
	<p>
	<p align="center">
		<a href="#" onclick="javascript:window.close(); return false;">�رմ���</a>
	</p>
	</body>
</html>
