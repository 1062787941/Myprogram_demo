<%@page import="daomain.User"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	UserDAO dao = new UserDAO();
	int userId = Integer.parseInt(request.getParameter("userID"));
	User model = dao.getUser(userId);
%>
<html>
	<head>
		<title>朗慧图书管理信息系统-作者管理</title>
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<script type="text/javascript">
			function checkForm(myform){
				var userName = myform.name.value;
				var account = myform.account.value;
				var password = myform.password.value;
				if(userName == "") {
					alert('姓名不能为空！');
					myform.name.focus();
					return false;
				}
				if(account == "") {
					alert('帐号不能为空！');
					myform.account.focus();
					return false;
				}
				if(password == "") {
					alert('密码不能为空！');
					myform.password.focus();
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		<%@include file="/inc/head.jsp" %>
		<form action="updateUser.jsp" method="post" name="form1" onsubmit="return checkForm(this);">
		<table align="center" width="980">
			<tr>
				<td>
					姓名 <input type="text" name="name" size="20" value="<%=model.getName() %>">
					帐号 <input type="text" name="account" size="20" value="<%=model.getAccount() %>">
					密码 <input type="password" name="password" size="20" value="<%=model.getPassword() %>">
					<input type="hidden" name="userId" value="<%=model.getUserId() %>">
					<input type="submit" value="修改用户">
				</td>
			</tr>
		</table>
		</form>

	</html>