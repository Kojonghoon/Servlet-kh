<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.book.scope.Sonata"%>

<%
Sonata             myCar    = ( Sonata ) request.getAttribute( "myCar" );
String             oMyCar   = request.getParameter( "oMyCar" );
Sonata             herCar   = ( Sonata ) request.getAttribute( "herCar" );
String             oHerCar  = request.getParameter( "oHerCar" );
Sonata             yourCar  = ( Sonata ) session.getAttribute( "yourCar" );
String             oYourCar = request.getParameter( "oYourCar" );
out.print( "scope11.jsp에서 생성된 객체가 유지 되나요?" );
out.print( "<hr>" );
out.print( myCar + "," + oMyCar );
out.print( "<hr>" );
out.print( herCar + "," + oHerCar );
out.print( "<hr>" );
out.print( yourCar + "," + oYourCar );
%>