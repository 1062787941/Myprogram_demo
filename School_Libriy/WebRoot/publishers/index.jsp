<%@page import="utils.PageUtil"%>
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
	PublishDao dao = new PublishDao();
	List<Publish> publishs = dao.getAll();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出版社管理</title>
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
	<form action="publishers/addPublish.jsp" method="post" onsubmit="return checkform(this)">
		  <table  align="center" width="980">
		 	 <tr>
		  		<td>
			  		出版社名称<input type="text" size="20" name="publishName">
			  		<input type="submit" value="添加出版社">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
	  
	  <table align="center" width="980" border="1">
	  	<caption>出版社列表</caption>
	  	<tr> 
			<th width="300">出版社ID</th>
			<th width="500">出版社名称</th>
	  	</tr>
	  	
	  	<%
			int pageSize = 8; //每页显示条数
			int recordCount = publishs.size(); //记录总数
			String currentPageStr = request.getParameter("page"); 
			int currentPage = 1; //当前页
			if(currentPageStr != null) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			PageUtil pageUtil = new PageUtil(pageSize, recordCount, currentPage);
		%>
	  	
		 <%
		 	 for(int i = pageUtil.getFromIndex(); i < pageUtil.getToIndex(); i++){
		 	 	Publish publish = publishs.get(i);
		  %>
	  	<tr>
			<td><%=publish.getPublisherID() %></td>
			<td><%=publish.getPublisherNam() %></td>
			<td>
				<a href="publishers/modefyPublish.jsp?publishId=<%=publish.getPublisherID() %>">修改</a>|
				<a href="publishers/deletePublish.jsp?publishId=<%=publish.getPublisherID() %>" onclick=" return confirm('确认删除吗？？')" >删除</a>
			</td>
	  	</tr>
	  <% 
	  	}
	  %> 
	  <tr>
			<td colspan="8" align="right">
				记录总数 <%=recordCount %> 条 每页显示 <%=pageSize %> 条 当前页/总页数  <%=pageUtil.getCurrentPage() %>/<%=pageUtil.getPageCount() %>  
				<a href="publishers/index.jsp?page=1">首页</a>   
				<a href="publishers/index.jsp?page=<%=pageUtil.getPrevPage() %>">上页</a> 
				<a href="publishers/index.jsp?page=<%=pageUtil.getNextPage() %>">下页</a> 
				<a href="publishers/index.jsp?page=<%=pageUtil.getPageCount() %>">末页</a>
				跳到<input type="text" size="3" id="newPage">页 <input type="button" value="Go" onclick="processGoPage()">
				<script type="text/javascript">
					function processGoPage() {
						var newPage = document.getElementById("newPage").value;
						var reg = /\d+$/;
						if(!newPage.match(reg)){
							alert('页面格式非法！');
							document.getElementById("newPage").focus();
						}else {
							window.location.href="publishers/index.jsp?page="+newPage;
					}
				}
			</script>
			</td>
		</tr>
	  </table>
  </body>
</html>
