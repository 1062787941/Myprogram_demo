<%@page import="daomain.User"%>
<%@page import="dao.UserDAO"%>
<%@page import="utils.PageUtil"%>
<%@page import="utils.ParamUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	UserDAO userDao = new UserDAO();
	List<User> users = userDao.queryAll();
 %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">

	<script type="text/javascript">
		function checkform(myform) {
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
   
	  <br />
	<form action="users/addUser.jsp" method="post" name="form1" onsubmit="return checkform(this)">
		  <table align="center" width="980">
		 	 <tr>
		  		<td>
			  		姓名 <input type="text" name="name" size="20">
					帐号 <input type="text" name="account" size="20">
					密码 <input type="password" name="password" size="20">
					<input type="submit" value="添加新用户">
		 	 	</td>
		 	 </tr>
	 	</table>
	 </form>
	  
	  <table align="center" width="980">
	  		<caption>用户列表</caption>
	  	<tr> 
	  		<th width="150">用户ID</th>
			<th width="200">姓名</th>
			<th width="200">帐号</th>
			<th width="230">创建时间</th>
			<th width="200">操作</th>
	  	</tr>
	  	<%
			int pageSize = 8; //每页显示条数
			int recordCount = users.size(); //记录总数

			String currentPageStr = request.getParameter("page"); 
			int currentPage = 1; //当前页
			if(currentPageStr != null) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			PageUtil pageUtil = new PageUtil(pageSize, recordCount, currentPage);
		%>
		<% for(int i=pageUtil.getFromIndex(); i<pageUtil.getToIndex(); i++) {
				User user = users.get(i);
		%>
	
	  	<tr>
			<td width="50"><%=user.getUserId() %></td>
			<td width="130"><%=user.getName() %></td>
			<td width="150"><%=user.getAccount() %></td>
			<td width="70"><%=user.getCreateTime() %></td>
			<td width="130"><a href="users/ModifyUser.jsp?userID=<%=user.getUserId()%>">修改</a> | 
							<a href="users/deleteUser.jsp?userID=<%=user.getUserId()%>" onclick="return confirm('确定要删除该记录[userID：<%=user.getUserId() %>]吗？');">删除</a></td>
	  	</tr>
	  	
	  	<%
			}
		%>
		<tr>
			<td colspan="8" align="right">
				记录总数 <%=recordCount %> 条 每页显示 <%=pageSize %> 条 当前页/总页数  <%=pageUtil.getCurrentPage() %>/<%=pageUtil.getPageCount() %>  
				<a href="books/index.jsp?page=1">首页</a>   
				<a href="books/index.jsp?page=<%=pageUtil.getPrevPage() %>">上页</a> 
				<a href="books/index.jsp?page=<%=pageUtil.getNextPage() %>">下页</a> 
				<a href="books/index.jsp?page=<%=pageUtil.getPageCount() %>">末页</a>
				跳到<input type="text" size="3" id="newPage">页 <input type="button" value="Go" onclick="processGoPage()">
				<script type="text/javascript">
					function processGoPage() {
						var newPage = document.getElementById("newPage").value;
						var reg = /\d+$/;
						if(!newPage.match(reg)){
							alert('页面格式非法！');
							document.getElementById("newPage").focus();
						}else {
							window.location.href="users/index.jsp?page="+newPage;
					}
				}
			</script>
			</td>
		</tr>
	  </table>
  </body>
</html>
