<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dap2= request.getParameter( "htest2" );
	out.println("2번 문제 답안지 ===> "+dap2);
	out.print("<br/>");
	
	Cookie c2 = new Cookie("testForm2",dap2);
	c2.setPath("/onLineTest");
	c2.setMaxAge(60*60);//평가시간 60분 일때 시간 설정 값이다.
	response.addCookie(c2);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
<script type ="text/javascript">
	const test=(cb)=>{
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(cb===i)
				document.f_test1.cb[i].checked=1
			else
				document.f_test1.cb[i].checked=0
		}
	}//end of test
	const prev = ()=>{
		window.location.href="testForm2.jsp"
	}
	
	const next=()=>{
		let dap = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest3.value=dap;
			}else{
				dap = dap+1
			}
		}
		document.f_test1.submit();
	}
</script>
</head>
<body>
	<form name="f_test1" method="get" action="testForm4.jsp">
	<input type="hidden" name ="htest3"/>
	문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.	<br>
	<input type="checkbox" name="cb" onChange="test(0)">grant	<br>
	<input type="checkbox" name="cb" onChange="test(1)">drop	<br>
	<input type="checkbox" name="cb" onChange="test(2)">alter	<br>
	<input type="checkbox" name="cb" onChange="test(3)">delete	<br>
	<br>
	<input type="button" value="이전문제" onClick="prev()">
	<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>