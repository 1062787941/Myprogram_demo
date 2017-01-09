<%@page import="daomain.User"%>
<%@page contentType="text/html; charset=utf-8"%>
<table align="center" width="980px" style="background: #6688AA" id="headtb">
	<tr>
		<td colspan="2"><img src="images/head.jpg"></td>
	</tr>
	
	<%
		User loginModel =  (User)session.getAttribute("loginModel");
		String loginName = "";
		if(loginModel != null)
		loginName = loginModel.getName();
	%>
	
	<tr style="background: url(images/headbg.jpg) repeat-x;">
		<td>欢迎 <%=loginName %> [<a href="">更改密码</a>| <a href="<%=request.getContextPath() %>/logout.jsp">退出登录</a>]
		</td>
		<td align="right" height="25">
			<a href="<%=request.getContextPath() %>/author/index.jsp">作者管理</a> | 
			<a href="<%=request.getContextPath() %>/publishers/index.jsp">出版社管理</a>
			| <a href="<%=request.getContextPath() %>/books/index.jsp">图书管理</a> |
			<a href="<%=request.getContextPath() %>/bookquery/index.jsp">图书查询</a>
			| <a href="<%=request.getContextPath() %>/users/index.jsp">用户管理</a>
			|</td>
	</tr>
</table>