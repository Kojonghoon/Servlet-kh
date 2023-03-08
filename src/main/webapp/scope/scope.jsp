<%@page import="com.book.scope.Sonata"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="myCar" scope="request" class="com.book.scope.Sonata" />
	<jsp:useBean id="herCar" scope="page" class="com.book.scope.Sonata" />
	<jsp:useBean id="yourCar" scope="session" class="com.book.scope.Sonata" />
	<%
	//유지문제 ->request, session+cookie
	com.book.scope.Sonata himCar = new com.book.scope.Sonata(); // 나는 scope를 가질 수 없다.
	out.print( "<h3>" + himCar.toString() + "</h3>" );
	out.print( "<h3>" + myCar.toString() + "</h3>" );
	out.print( "<h3>" + herCar.toString() + "</h3>" );
	out.print( "<h3>" + yourCar.toString() + "</h3>" );
	request.setAttribute( "myCar", myCar );
	out.print( "<hr>" );
	pageContext.setAttribute( "herCar", herCar );
	out.print( "<hr>" );
	session.setAttribute( "yourCar", yourCar );
	%>
	<jsp:forward page="./move1.jsp"> 
	<jsp:param value="<%=myCar.toString()%>" name="oMyCar" />
	<jsp:param value="<%=herCar.toString()%>" name="oHerCar" />
	<jsp:param value="<%=yourCar.toString()%>" name="oYourCar" />
	</jsp:forward>
</body>
</html>