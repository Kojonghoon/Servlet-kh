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
	<script type="text/javascript">
		$(document).ready(function() {

			$('#btn_search').linkbutton({
				onClick : function() {
					const user_dong = $('#_easyui_textbox_input1').val();
					if (user_dong == null || user_dong.length < 1) {
						alert('동을 입력해주세요.');
						/*입력된 동 정보가 없으면 처음부터 다시 시작하기.*/
						return;
					} else {
						console.log('사용자가 입력한 동 이름은 ===> ' + user_dong);
						$('#dg_zipcode').datagrid({
							url : '/common/zipcodeList.st3?dong=' + user_dong,
							columns : [ [ {
								field : 'ZIPCODE',
								title : '우편번호',
								width : 100
							}, {
								field : 'ADDRESS',
								title : '주소',
								width : 300,
								align : 'left'
							}, ] ]
						});
					}

				}
			}) //end of linkbutton
			$('#dong').textbox('textbox').bind('keydown', function(e) {
				const user_dong = $('#_easyui_textbox_input1').val();
				if (e.keyCode == 13) {
					$('#dg_zipcode').datagrid({
						url : '/common/zipcodeList.st3?dong=' + $(this).val(),
						columns : [ [ {
							field : 'ZIPCODE',
							title : '우편번호',
							width : 100
						}, {
							field : 'ADDRESS',
							title : '주소',
							width : 300,
							align : 'left'
						}, ] ]
					});
				}
			})
		})
	</script>
	<div id="dd">Dialog Content.</div>
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
	<!--======================= 회원가입 =======================-->
	<div id="dlg_ins"
		style="width: 100%; max-width: 480px; padding: 30px 60px;">
		<form id="f_ins">
			<input type="hidden" id="work" name="work" value="member" />
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_id" name="mem_id" label="아이디:"
					labelPosition="top" data-options="prompt:'Enter a ID'"
					style="width: 110px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_name" name="mem_name"
					label="이름:" labelPosition="top"
					data-options="prompt:'Enter a Name'" style="width: 150px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_zipcode" name="mem_zipcode"
					label="우편번호:" labelPosition="top"
					data-options="prompt:'Enter a ZipCode'" style="width: 100px;">
				<a id="btn_zipcode" href="#" class="easyui-linkbutton">우편번호찾기</a>

			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_addr" name="mem_addr"
					label="주소:" labelPosition="top"
					data-options="prompt:'Enter a ADDRESS'" style="width: 300px;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" id="mem_pw" name="mem_pw" label="비번:"
					labelPosition="top" data-options="prompt:'Enter a PASSWORD'"
					style="width: 110px;">
			</div>
		</form>
	</div>
	<div id="tb_ins" style="padding: 5px;">
		<a id="btn_save" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'">저장</a> <a id="btn_close" href="#"
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">닫기</a>
	</div>
	<!--======================= 회원가입 =======================-->
</body>
</html>