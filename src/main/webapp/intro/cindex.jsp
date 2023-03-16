<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String cmem_id = null;
	String cmem_name = null;
	
	Cookie cs[] = request.getCookies();
	int    size = 0;
	size = cs.length;
	for ( int i = 0; i < size; i++ ) {
	    String c_name = cs[i].getName();
	    if("cmem_id".equals(c_name)){
	        cmem_id = cs[0].getValue();
	    }
	    if("cmem_name".equals(c_name)){
	        cmem_name = cs[1].getValue();
	    }
	}
	out.print("쿠키에서 꺼내온 값===> " +cmem_id+", "+cmem_name);
	if(cmem_id==null){
%>
<script>
    alert("로그인하세요");
</script>
<%	    
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Application</title>
<%@include file="../common/easyUI_common.jsp"%>
<style type="text/css">
a {	text-decoration: none;}
</style>
<script type="text/javascript">
	const login = ()=>{
	/*
	테스트 : com.mvc.dao.MemberDao.java
	xml : com.myBatis.mapper에 member.xml
	SELECT mem_name FROM book_member
    WHERE mem_id =:id
    AND  mem_pw =:pw
	*/
	//사용자가 입력한 아이디 가져오기
	const user_id = $("#_easyui_textbox_input1").val();
	//사용자가 입력한 비밀번호 가져오기
	const user_pw = $("#_easyui_textbox_input2").val();
	alert(user_id + user_pw);
	}
	</script>
</head>
<body>
	<h2>웹 어플리케이션 실습</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 1000px; height: 550px;">
		<!-- 메뉴 구성 [로그인화면 과 트리메뉴] -->
		<div id="p" data-options="region:'west'" title="KH정보교육원"
			style="width: 200px; padding: 10px">
			<!--============== [[ 로그인 화면 ]] ==============-->
			<div id="d_login" align="center">
				<div style="margin: 3px 0;"></div>
				<!-- create table member mem_id varchar2(10) -->
				<input id="tb_id" type="text" style="width: 170px">
				<script>
					$('#tb_id').textbox({
						iconCls : 'icon-man',
						iconAlign : 'right',
						prompt : '아이디'
					})
				</script>
				<div style="margin: 3px 0;"></div>
				<input id="pb_pw" type="text" style="width: 170px">
				<script>
					$('#pb_pw').passwordbox({
						prompt : 'Password',
						showEye : true
					});
				</script>
				<div style="margin: 3px 0;"></div>
				<a id="btn_login" href="javascript:login()">로그인</a>
				<script>
					$('#btn_login').linkbutton({
						iconCls : 'icon-man'
					});
				</script>
				<a id="btn_member" href="javascript:memberShip()">회원가입</a>
				<script>
					$('#btn_member').linkbutton({
						iconCls : 'icon-add'
					});
				</script>
			</div>
			<!--============= [[ 로그아웃 화면 ]] ==============-->
			<div id="d_logout" align="center"></div>
			<!-- 메뉴 구성 [로그인화면 과 트리메뉴] -->
			<div style="margin: 3px 0;"></div>
			<ul id="tre_gym" class="easyui-tree">
				<li data-options="state:'closed'"><span>회원관리</span>
					<ul>
						<li><a href="#">회원목록</a></li>
						<li><a href="#">회원등록</a></li>
						<li><a href="#">회원삭제</a></li>
					</ul></li>
				<li data-options="state:'closed'"><span>쪽지관리</span>
					<ul>
						<li><a href="#">받은쪽지함</a></li>
						<li><a href="#">보낸쪽지함</a></li>
					</ul></li>
				<li data-options="state:'closed'"><span>기타</span>
					<ul>
						<li><a href="#">우편번호검색기</a></li>
						<li><a href="#">게시판</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- 메인화면 [게시판, 온라인시험, 쪽지관리(받은쪽지함, 보낸쪽지함), 회원관리(회원목록,회원등록, 회원삭제), 우편번호검색기] -->
		<div data-options="region:'center', iconCls:'icon-ok'"
			title="TerrGYM2023">
			<div style="margin: 5px 0;"></div>
			Home > 회원관리 > 회원목록
			<hr>
			<div style="margin: 25px 0;"></div>
		</div>
		<!-- 메인화면 [게시판, 온라인시험, 회원관리, 우편번호검색기] -->
	</div>
</body>
</html>
<!--
부트스트랩 - 리액트수업 -> spring과 리액트 연계 수업 -> 프로젝트 적용
반응형지원, CSS라이브러리사용
CSS -JS거의 없다
jEasyUI
이벤트처리(jquery-레거시시스템)
자바스크립트 - 표준아니다 -> jquery기반이다
자바스크립트 기반의 UI솔루션 사용하기 - 큰 도움
개발자도구 활용 - 디버깅 -> 왜냐하면 html을 래핑하기 때문에
vue.js, reactjs
JSTL사용 - 1.1-> 1.2 -> 소개

로그인 테스트 흐름도
1. intro아래 index.jsp실행
2. 아이디와 비번을 입력 받는다
3. 로그인버튼을 누른다 ->자바스크립트의 login()호출
4. login.do호출한다 -> 로그인 처리를 하는 서블릿 호출 - doGet(),doPost()
5. com.mvc.dao.MemberDao클래스의 인스턴스화
6. 메소드 호출 - 로그인처리
7. MemberDao의 login(Map[mem_id(사용자가 입력한 아아디)와 mem_pw(사용자가 입력한 비번)있다])호출
8. 리턴타입으로 Map을 받아온다(mem_id, mem_name)
9. 8번에서 돌려받은 Map에서 오라클 서버에서 조회된 아이디와 이름을 세션에 담기
10. 페이지 이동은 sendRedirection나 forward둘다 모두 가능하다
단, forward로 응답을 처리한 경우 인증 후에 다른 서비스르르 forward로 처리하는것이 불가함 - 주의





 -->