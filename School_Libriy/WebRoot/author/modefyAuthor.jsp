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
	AuthorDao dao = new AuthorDao();
	int authorID = Integer.parseInt(request.getParameter("authorId"));
	Author author = dao.getAuthor(authorID);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改作者信息</title>
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
	<form action="author/update.jsp" method="post" onsubmit="return checkform(this)">
		  <table  align="center" width="980">
		 	 <tr>
		  		<td>
			  		名：<input type="text" size="20" name="firstName" value="<%= author.getFirstName() %>" >
			  		姓：<input type="text" size="20" name="lastName" value="<%=author.getLastName() %>">
			  		<input type="hidden" name="authorId" value="<%=authorID %>">
			  		<input type="submit" value="修改作者">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
  </body>
</html>
