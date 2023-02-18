<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mimeHtmlResult2 응답페이지</title>
</head>
<body>
	<h2>mimeHtmlResult2 응답페이지</h2>
	<%
	//스크립틀릿안에서 선언한 변수는 지변이다.
	//왜냐하면 ?? - a.jsp ->a_jsp.java -> service메소드 안에 들어간다.
	String myName = null;
	myName = (String) session.getAttribute("myName");
	out.print(myName);
	out.print("<hr>");

	Integer age = null;
	age = (int) session.getAttribute("age");
	out.print(age);
	out.print("<hr>");

	Map<String, Object> rmap = (Map<String, Object>) session.getAttribute("rmap");
	if (rmap != null) { //NullpointerException방어 코드
		Object keys[] = rmap.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			out.print(rmap.get(keys[i]));
			out.print("<br>");
		}
	}
	out.print("<hr>");
	//getAttribute의 리턴타입은 Object이다. (getParameter의 리턴타입은 String이다.)
	List<Map<String, Object>> mList = (List<Map<String, Object>>) session.getAttribute("mList");
	if (mList != null) {
		for (int i = 0; i < mList.size(); i++) {
			Map<String, Object> rMap = mList.get(i);
			out.print(rMap.get("mem_id") + ", " + rMap.get("mem_pw") + ", " + rMap.get("mem_name"));
			out.print("<br/>");
		}
	}
	%>
</body>
</html>



