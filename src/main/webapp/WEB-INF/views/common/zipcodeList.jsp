<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
List<Map<String, Object>> zList= (List<Map<String, Object>>) request.getAttribute("zList");
if (zList!= null) {
	for (int i = 0; i < zList.size(); i++) {
		out.print(zList.get(i)+"<br/>");
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색기</title>
</head>
<body>
	<h3>우편번호 검색기</h3>
	<br />
</body>
</html>