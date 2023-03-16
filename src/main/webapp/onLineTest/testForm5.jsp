<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dap4 = request.getParameter("htest4");
	out.println("4번 문제 답안지 ===> "+dap4);
	out.print("<br/>");
	
	Cookie c4 = new Cookie("testForm4",dap4);
	c4.setPath("/onLineTest");
	c4.setMaxAge(60*60);//평가시간 60분 일때 시간 설정 값이다.
	response.addCookie(c4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제5</title>
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
		window.location.href="testForm4.jsp"
	}
	
	const next=()=>{
		let dap = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest5.value=dap;
			}else{
				dap = dap+1
			}
		}
		document.f_test1.submit();
	}
</script>
</head>
<body>
	<form name="f_test1" method="get" action=testForm6.jsp>
	<!-- 
		최초에는 쿼리스트링으로 넘긱 ㅗ있어서 처음 입력한 답안을 계속 기억이 어려워
		페이지 이동 할 때 마다 계속 달고 다녀야 했다
		지금은 현재 페이지에서 이전 문제에 대한 답한 한 개만 request.getParameter로 가져오면 됨
		현재 문제에 대한 답안을 담은 hidden도 딱 한개만 필요함
	 -->
	<input type="hidden" name ="htest5"/>
	문제5. 다음 중 프로시저에 대한 설명으로 틀린 것을 고르시오.	<br>
	<input type="checkbox" name="cb" onChange="test(0)"> 프로시저를 생성할
	때 파라미터를 선언할 수 있다.	<br>
	<input type="checkbox" name="cb" onChange="test(1)"> 파라미터에 여러
	변수를 선언할 수 있다.	<br>
	<input type="checkbox" name="cb" onChange="test(2)"> 프로시저안에서
	SELECT,INSERT,UPDATE, DELETE 모두 사용 할 수 있다.	<br>
	<input type="checkbox" name="cb" onChange="test(3)"> 프로시저 안에서
	commit할 수 없다.	<br>
	<br>
	<input type="button" value="이전문제" onClick="prev()">
	<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>