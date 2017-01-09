<%@page import="utils.PageUtil"%>
<%@page import="daomain.Book"%>
<%@page import="dao.BookDAO"%>
<%@page import="utils.ParamUtil"%>
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
	String isbn = ParamUtil.getString(request.getParameter("isbn"));
	String title = ParamUtil.getString(request.getParameter("title"));
	List<Book> books = bookDao.quickSearch(isbn, title);
	String queryParam = "&isbn="+isbn+"&title="+title;
 %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">

	<script type="text/javascript">
		function checkform(form) {
			var pName = form.publishName.value;
			
			if(pName == ""){
				alert("出版社名称不能为空！！");
				form.publishName.focus();
				return false;
			}
			return true;
		}
	
	</script>
  </head>
  
  <body>
  	<%@include file="/inc/head.jsp" %>
   
	  <br />
	<form action="books/index.jsp" method="post" onsubmit="return checkform(this)">
		  <table  align="center" width="980">
		 	 <tr>
		  		<td>
			  		ISBN<input type="text" size="20" name="isbn"  size="20" value="<%=isbn %>">
			  		书名<input type="text" size="20" name="title"  size="20" value="<%=title %>">
			  		<input type="submit" value="快速搜索">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
	  
	  <table align="center" width="980" border="1">
	  	<tr>
	  		<td colspan="8"><a href="books/addBook.jsp">+添加新书</a></td>
	  	</tr>
	  	<tr> 
	  		<th width="60">序号</th>
	  		<th width="140">ISBN</th>
			<th width="280">书名</th>
			<th width="150">出版社名</th>
			<th width="70">价格</th>
			<th width="70">版本号</th>
			<th width="80">出版年份</th>
			<th width="130">操作</th>
	  	</tr>
	  	<%
			int pageSize = 8; //每页显示条数
			int recordCount = books.size(); //记录总数

			String currentPageStr = request.getParameter("page"); 
			int currentPage = 1; //当前页
			if(currentPageStr != null) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			PageUtil pageUtil = new PageUtil(pageSize, recordCount, currentPage);
		%>
		<% for(int i=pageUtil.getFromIndex(); i<pageUtil.getToIndex(); i++) {
				Book book = books.get(i);
		%>
	
	  	<tr>
			<td width="50"><%=(i+1) %></td>
			<td width="130"><%=book.getIsbn() %></td>
			<td width="300"><a href="books/bookDetails.jsp?isbn=<%=book.getIsbn() %>" target="_blank"><%=book.getTitle() %></a></td>
			<td width="150"><%=book.getPublishName() %></td>
			<td width="70"><%=book.getPrice() %></td>
			<td width="70"><%=book.getEditionNumber() %></td>
			<td width="80"><%=book.getCopyright() %></td>
			<td width="130"><a href="books/Modify.jsp?isbn=<%=book.getIsbn() %>&page=<%=pageUtil.getCurrentPage() %>&qisbn=<%=isbn %>&title=<%=title %>">修改</a> | 
							<a href="books/delete.jsp?isbn=<%=book.getIsbn() %>&page=<%=pageUtil.getCurrentPage() %>&qisbn=<%=isbn %>&title=<%=title %>" onclick="return confirm('确定要删除该记录[ISBN：<%=book.getIsbn() %>]吗？');">删除</a></td>
	  	</tr>
	  	
	  	<%
			}
		%>
		<tr>
			<td colspan="8" align="right">
				记录总数 <%=recordCount %> 条 每页显示 <%=pageSize %> 条 当前页/总页数  <%=pageUtil.getCurrentPage() %>/<%=pageUtil.getPageCount() %>  
				<a href="books/index.jsp?page=1<%=queryParam %>">首页</a>   
				<a href="books/index.jsp?page=<%=pageUtil.getPrevPage() %><%=queryParam %>">上页</a> 
				<a href="books/index.jsp?page=<%=pageUtil.getNextPage() %><%=queryParam %>">下页</a> 
				<a href="books/index.jsp?page=<%=pageUtil.getPageCount() %><%=queryParam %>">末页</a>
				跳到<input type="text" size="3" id="newPage">页 <input type="button" value="Go" onclick="processGoPage()">
				<script type="text/javascript">
					function processGoPage() {
						var newPage = document.getElementById("newPage").value;
						var reg = /\d+$/;
						if(!newPage.match(reg)){
							alert('页面格式非法！');
							document.getElementById("newPage").focus();
						}else {
							window.location.href="books/index.jsp?page="+newPage;
					}
				}
			</script>
			</td>
		</tr>
	  </table>
  </body>
</html>
