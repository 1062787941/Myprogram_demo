<%@page import="daomain.Publish"%>
<%@page import="daomain.Author"%>
<%@page import="dao.PublishDao"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	PublishDao dao = new PublishDao();
	int publishId = Integer.parseInt(request.getParameter("publishId"));
	Publish publish = dao.getPublish(publishId);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改作者信息</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">

	<script type="text/javascript">
		function checkform(form) {
			var fName = form.publishName.value;
			var pName = form.publishName.value;
			
			if(pName == ""){
				alert("出版社名不能为空");
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
	<form action="publishers/update.jsp" method="post" onsubmit="return checkform(this)">
		  <table  align="center" width="980">
		 	 <tr>
		  		<td>
			  		出版社名称：<input type="text" size="20" name="publishName" value="<%=publish.getPublisherNam() %>" >
			  		<input type="hidden" name="publishId" value="<%=publishId%>">
			  		<input type="submit" value="修改出版社">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
  </body>
</html>
