<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    	확장자는 jsp이지만 마임타입은 html이다.
    	브라우저는 이 파일을 html문서로 판단함
    	왜냐하면
    	1번 page 다이렉티브에 contentType에 설정된 마임타입때문이다.
    	실행하면 - URL주소에 해당 페이지를 요청하면
    	c.jsp 
    	-> (jsp-api.jar: jsp엔진, jsp컨테이너, 톰캣에 있음)-> c_jsp.java로 변경됨
		-> (servlet-api-jar: 서블릿엔진) -> c_jsp.class로 변경됨
		-> out.print() out은 jsp가 제공하는 내장객체 - dos창이 아닌 브라우저에 쓴다.
		-> 자바스크립트과 같은 원리로 자바인데 브라우저에서 동작이 가능함.
		D:\workspace_java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\20221228\common
		D:\workspace_java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\ROOT\org\apache\jsp\common
		확인 가능
     -->
<script>
	document.write("<b>굵은글씨</b>");
	
/*
	test.html문서 전체를 받극 객체가 document입니다.
 */
</script>