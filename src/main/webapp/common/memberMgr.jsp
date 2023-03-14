<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리시스템</title>
<%@ include file="../common/easyUI_common.jsp"%>
</head>
<body>
<script>
	$(document).ready(function(){
		$("#btn_search").linkbutton({
			onClick:function(){
				const u_dong = $("#dong").val();
				if(u_dong==null||u_dong.length<1){
					alert("동을 입력하세요");
					//동 정보가 없으면 처음부터 새로 시작해야 하니끼...return을 썻다.
					return;
				}else{
					console.log(`사용자가 입력한 동이름은 ${u_dong}`);
					//오라클 서버를 경유해서 조회된 결과를 datagrid에 출력해보기
				}
				}
			}
		})
	})
</script>
	<!--======================= 우편번호 검색기 =======================-->
	<div id="dlg_zipcode"
		style="width: 100%; max-width: 600px; padding: 30px 30px;">
		<input class="easyui-textbox" id="dong" name="dong"
			labelPosition="top" data-options="prompt:'동이름 이나 주소정보 입력...'"
			style="width: 210px;"> <a id="btn_search" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-search'">찾기</a>
		<div style="margin-bottom: 10px;"></div>
		<table id="dg_zipcode">
		</table>
	</div>
	<!--======================= 우편번호 검색기 =======================-->
</body>
</html>