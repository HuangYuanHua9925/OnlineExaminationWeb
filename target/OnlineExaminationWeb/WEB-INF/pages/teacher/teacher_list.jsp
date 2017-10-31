<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="../common/common.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
</style>
<script type="text/javascript">
	var id;
	$(document).ready(function() {
		initTable();
		$("#btn-delete").on("click", function() {
			if (confirm("确定要删除吗？")) {
				deleteTeacher();
			}
		})

	});
	function initTable() {

		$("#row")
				.bootstrapTable(
						{
							method : 'POST',
							dataType : 'json',
							contentType : "application/x-www-form-urlencoded",
							cache : false,
							striped : true, //是否显示行间隔色
							sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
							url : ctx + "/teacher/getTeachersByPage",
							height : 500,
							width : 600,
							showColumns : false,
							pagination : true,
							queryParams : queryParams,
							minimumCountColumns : 2,
							pageNumber : 1, //初始化加载第一页，默认第一页
							pageSize : 10, //每页的记录行数（*）
							pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
							uniqueId : "id", //每一行的唯一标识，一般为主键列
							showExport : true,
							exportDataType : 'all',
							showToggle : true,
							search : false,
							searchOnEnterKey : false,
							showRefresh : true,
							onClickRow : onClickRow,
							columns : [
									{
										checkbox : true,
										field : "",
										title : "编号",
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "name",
										title : "姓名"
									},

									{
										field : "sex",
										title : "性别"
									},
									{
										field : "height",
										title : "身高",
										formatter : function(value, row, index) {
											if (!value) {
												return value;
											} else {
												return value + "cm";
											}
										}
									},
									{
										field : "weight",
										title : "体重",
										formatter : function(value, row, index) {
											if (value) {
												return value + "kg";
											}
											return value;
										}
									},
									{
										field : "position",
										title : "职位"
									},

									{
										field : "nationality",
										title : "民族"
									},
									{
										field : "school",
										title : "学校"
									},
									{
										field : "tel",
										title : "电话"
									},
									{
										field : "",
										title : "编辑",
										formatter : function(value, row, index) {
											var string = "<a href='${ctx}/teacher/toUpdateTeacher?id="
													+ row.id
													+ "'>编辑 </a>"
													+ "<a id='btn-delete' href='javascript:'> 删除</a>";
											return string;
										}

									}

							]
						});

	}
	function queryParams(params) {
		params.page = this.pageNumber;
		params.pageSize = this.pageSize;
		return params;
	}
	function onClickRow(row, $element) {
		id = row.id;
	}
	function deleteTeacher() {
		$.ajax({
			url : ctx + "/teacher/deleteTeacher",
			data : {
				"id" : id
			},
			type : "get",
			success : function(data) {
				alert(data);
			}
		});

	}
</script>
<title>teacher_list</title>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div id="center">
		<div align="center">
			<h3 style=" width: 200px;">教师列表</h3>
		</div>
		<div style="width: 70% ;margin: 10px auto">
			<table id="row"></table>
		</div>
	</div>
</body>
</html>