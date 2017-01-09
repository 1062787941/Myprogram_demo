<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录界面</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">
	<style type="text/css">
		table{
			font-size:12px;
		}
		
		table caption{
			font-size:14px;
		}
	</style>
	
	<script type="text/javascript">
		function checkForm(form){
			var msg = "";
			var setFocused = false;
			
			if(form.account.value == ""){
				msg += "账号不能为空\n";
				setFocused = true;
			}
			
			if(form.password.value == ""){
				msg += "密码不能为空\n";
				setFocused = true;
			}
			
			if(msg != ""){
				alert(msg);
				return false;
			}
			
			return true;
		}
	</script>
  </head>
  
  
  <body>
  		<table align="center">
			<tr>
				<td>
					<img src="<%=request.getContextPath() %>/images/head.jpg">
				</td>
			</tr>
		</table>
		<br/><br/>
		<%
			Object obj = request.getAttribute("errorMessage");
			//SuccessLogin.jsp
		%>
		<form action="<%=request.getContextPath()%>/SuccessLogin.jsp" method="post" name="form1" onsubmit="return checkForm(this);">
			<table align="center">
				<caption>用户登录</caption>
				
			<%if(obj != null){ %>
				<tr>
					<td colspan="22">
						<span style="color : red; font-weight : bold"><%=obj %></span>
					</td>
				</tr>
			<%} %>
				<tr>
					<td>用户账号:</td>
					<td>
						<input type="text" style="width:150px" name="account"/>
					</td>
				</tr>			

				<tr>
					<td>用户密码：</td>
					<td>
						<input type="password" style="width:150px" name="password"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="登录">
						<input type="reset" value="清空">
					</td>
				</tr>			
			
			</table>
		</form>
  	
  </body>
</html>
