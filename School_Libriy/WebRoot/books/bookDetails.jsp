<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page import="daomain.Publish"%>
<%@page import="dao.AuthorDao"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	BookDAO bookDao = new BookDAO();
	Book book = bookDao.get(request.getParameter("isbn"));
	List<Author> authors = bookDao.getAuthorModelsByIsbn(request.getParameter("isbn"));
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理-图书详细</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">
	<style type="text/css">
		table select{
			width:200px;
		}
		
		.head_color{
			background:  #DDDDFF;
		}
	
	</style>
	<script type="text/javascript">
	
	</script>

  </head>
  
  <body>
  	<%@include file="/inc/head.jsp" %>
   
	 <br />
	<form name="form1" action="" method="post" onsubmit="return checkform(this)">
		<table align="center" width="980">
			<caption>图书详细信息</caption>
			<tr>
				<td width="250" class="head_color">图书的ISBN</td>
				<td width="730">
					<%=book.getIsbn() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">书名</td>
				<td>
					<%=book.getTitle() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">出版社</td>
				<td width="">
					<%=book.getPublishName() %>
				<td>
			</tr>
			<tr>
				<td class="head_color">价格</td>
				<td width="">
					<%=book.getPrice() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">出版年份</td>
				<td width="">
					<%=book.getPublishId() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">版本号</td>
				<td width="">
					<%=book.getEditionNumber() %>
				</td>
			</tr>
			<tr>
				<td class="head_color">作者</td>
				<td width="">
				<%
					for(Author m : authors) {
						out.println(m.getFirstName()+"&nbsp;" + m.getLastName()+"<br>");
					}
				 %>
				<td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="head_color">
					<input type="button" value="关闭窗口" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>