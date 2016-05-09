<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	// 分析Servlet异常
	Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
	
	// 异常的状态码
	Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
	
	// 发生错误的servlet name
	String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
	if(servletName==null){
		servletName = "Unknown";
	}
	
	// 请求的Uri
	String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
	if(requestUri==null){
		requestUri = "Unknown";
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ErrorPage</title>
</head>
<body>
	<% if(throwable==null && statusCode==null)
	{
		out.println("<h2>Error information is missing</h2>");
		out.println("Please return to the <a href=\""+
			response.encodeURL("http://localhost:8080/Together/welcome")+"\">Home Page");
	}
	else if(statusCode !=null){
		out.println("<h2>The status code" + statusCode +"</h2>");
	}else{
		out.println("<h2>Error information</h2>");
		out.println("Servlet Name : " + servletName + "</br>");
		out.println("Exception Type : " + throwable.getClass().getName());
		out.println("The request URI: " + requestUri + "</br>");
		out.println("The exception message:" + throwable.getMessage());
	}
	%>

</body>
</html>