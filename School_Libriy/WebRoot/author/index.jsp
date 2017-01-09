<%@page import="utils.PageUtil"%>
<%@page import="daomain.Author"%>
<%@page import="dao.AuthorDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	AuthorDao dao = new AuthorDao();
	List<Author> authors = dao.getAll();	

 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>作者管理</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">

	<script type="text/javascript">
		function checkform(form) {
			var fName = form.firstName.value;
			var lName = form.lastName.value;
			
			if(fName == ""){
				alert("名不能为空");
				form.firstName.focus();
				return false;
			}
			
			if(lName == ""){
				alert("姓不能为空");
				form.lastName.focus();
				return false;
			}
			
			return true;
		}
	
	</script>
  </head>
  
  <body>
  	<%@include file="/inc/head.jsp" %>
   
	  <br />
	<form action="author/addAuthor.jsp" method="post" onsubmit="return checkform(this)">
		  <table  align="center" width="980">
		 	 <tr>
		  		<td>
			  		名：<input type="text" size="20" name="firstName">
			  		姓：<input type="text" size="20" name="lastName">
			  		<input type="submit" value="增加用户">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
	  
	  <table align="center" width="980" border="1">
	  	<caption>作者列表</caption>
	  	<tr> 
			<th width="150">作者ID</th>
			<th width="300">姓</th>
			<th width="300">名</th>
			<th width="230">操作</th>
	  	</tr>
	  	
  	<%
			int pageSize = 10; //每页显示条数
			int recordCount = authors.size(); //记录总数

			String currentPageStr = request.getParameter("page"); 
			int currentPage = 1; //当前页
			if(currentPageStr != null) {
				currentPage = Integer.parseInt(currentPageStr);
			}

			PageUtil pageUtil = new PageUtil(pageSize, recordCount, currentPage);
		%>
		
		 <% for(int i=pageUtil.getFromIndex(); i<pageUtil.getToIndex(); i++) {
				Author author = authors.get(i);
		%>
			<td><%=author.getAuthorID() %></td>
			<td><%=author.getFirstName() %></td>
			<td><%=author.getLastName() %></td>
			<td>
				<a href="author/modefyAuthor.jsp?authorId=<%=author.getAuthorID() %>">修改</a>|
				<a href="author/deleteAuthor.jsp?authorId=<%=author.getAuthorID() %>" onclick=" return confirm('确认删除此条信息吗？')" >删除</a>
			</td>
	  	</tr>
	  <% 
	  	}
	  %> 
	  
		
		
		<tr>
			<td colspan="8" align="right">
				记录总数 <%=recordCount %> 条 每页显示 <%=pageSize %> 条 当前页/总页数  <%=pageUtil.getCurrentPage() %>/<%=pageUtil.getPageCount() %>  
				<a href="author/index.jsp?page=1">首页</a>   
				<a href="author/index.jsp?page=<%=pageUtil.getPrevPage() %>">上页</a> 
				<a href="author/index.jsp?page=<%=pageUtil.getNextPage() %>">下页</a> 
				<a href="author/index.jsp?page=<%=pageUtil.getPageCount() %>">末页</a>
				跳到<input type="text" size="3" id="newPage">页 <input type="button" value="Go" onclick="processGoPage()">
				<script type="text/javascript">
					function processGoPage() {
						var newPage = document.getElementById("newPage").value;
						var reg = /\d+$/;
						if(!newPage.match(reg)){
							alert('页面格式非法！');
							document.getElementById("newPage").focus();
						}else {
							window.location.href="author/index.jsp?page="+newPage;
					}
				}
			</script>
			</td>
		</tr>
	  </table>
    
  
  </body>
</html>
