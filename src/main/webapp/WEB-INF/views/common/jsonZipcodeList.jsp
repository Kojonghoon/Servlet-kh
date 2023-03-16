<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, com.google.gson.Gson"%>
<%
List<Map<String, Object>> zList = ( List<Map<String, Object>> ) request.getAttribute( "zList" );
Gson                      g     = new Gson();
String                    temp  = g.toJson( zList );
out.print( temp );
%>
