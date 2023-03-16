<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- react->nextjs->typescript->ECMAScript(번들러, 트랜스파일러) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<script type ="text/javascript">
	const test=(cb)=>{
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(cb===i)
				document.f_test1.cb[i].checked=1
			else
				document.f_test1.cb[i].checked=0
		}
	}//end of test
	//document는 이 문서(testForm1.jsp->SSR->html->다운로드-<text파일덩어리)를 가르킨다
	//document의 최상위 객체는 window
	//document에서 같은 이름이 두개 이상이면 브라우저가 자동으로 배열 전환 해줌
	//checked는 checkbox에서 선택된 상태일 떄 처리하는 속성임
	//1이면 선택 0이면 비선택
	//0은 false이고 나머지는 모두 true이다
	const next=()=>{
		let dap = 1;
		for(let i=0;i<document.f_test1.cb.length;i++){
			if(document.f_test1.cb[i].checked==1){
				document.f_test1.htest1.value=dap;
			}else{
				dap = dap+1
			}
		}
		document.f_test1.submit();
	}
	
	
</script>
</head>
<body>
	<form name="f_test1" method="get" action="testForm2.jsp">
	<input type="hidden" name ="htest1"/>
	문제1. 다음 중 DML구문이 아닌 것을 고르시오.	<br>
	<input type="checkbox" name="cb" onChange="test(0)">select	<br>                                                                                                                             
	<input type="checkbox" name="cb" onChange="test(1)">insert	<br>
	<input type="checkbox" name="cb" onChange="test(2)">create	<br>
	<input type="checkbox" name="cb" onChange="test(3)">delete	<br>
	<br>
	<input type="button" value="다음문제" onClick="next()"/>
	</form>
</body>
</html>