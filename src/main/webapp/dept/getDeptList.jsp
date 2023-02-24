<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.List, java.util.Map" %>
   <%
   	List<Map<String,Object>> deptList=
   	(List<Map<String,Object>>)request.getAttribute( "deptList" );
   out.print(deptList);
   %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록Get</title>
</head>
<body>

</body>
</html>