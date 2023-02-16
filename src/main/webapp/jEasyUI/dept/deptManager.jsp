<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리</title>
<%@ include file="../../common/easyUI_common.jsp"%>
<script type="text/javascript">
	const insertForm = () => {
		console.log('입력 화면 열기')
		$('#dg_dept').dialog({
		    title: '부서정보등록',
		    width: 400,
		    height: 400,
		    closed: false,
		    cache: false,
		    href: 'insertForm.jsp',
		    modal: true
		});		
	}
</script>
</head>
<body>
	<table id="dg"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="insertForm()">입력</a>
	</div>
	<div id="dg_dept"></div>
	<script type="text/javascript">
	$('#dg').datagrid({
		title:'부서관리',
	    url:'../dept.json',
	    toolbar: '#toolbar',
	    columns:[[
	        {field:'deptno',title:'부서번호',width:100},
	        {field:'dname',title:'부서명',width:100},
	        {field:'loc',title:'지역',width:100,align:'right'}
	    ]]
	});	//부서관리 테이블
	
	</script>
</body>
</html>