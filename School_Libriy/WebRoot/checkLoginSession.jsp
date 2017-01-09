<%
	Object loginObj =  session.getAttribute("loginModel");
	if(loginObj == null) 
		request.getRequestDispatcher("/").forward(request, response);
%>