<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="../common/taglibs.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update_teacher</title>
<style type="text/css">
    #massage{
	 margin:10px auto;
 	
 	width:500px;
 	 border: solid;
	 font-size: 15px;
	 color: #808080;
	 border-width: 2px;
	}
	.table{
		margin: 50px auto;
		width: 100%;
	}
	td{
		width:100px;
	}
	img{
		border: solid;
		border-width: 1px;
		/* zoom:20%;  自动缩放图片*/
		width: 150px;
		height: auto;
		max-height: 200px;
	}
	input{
	width: 150px;
	}
	.btn-save{
	
    left: 50px; 
    background: #3090e7;
    border: none;
    width: 100px;
    height: 30px;
    color: #fff;
    font-size: 1em;
    cursor: pointer;
    border-radius: 4px;
	}
	
</style>
<script type="text/javascript">
	var id="${teacher.id}";
	var name;
	var sex;
	var nationality;
	var tel;
	var height;
	var weight;
	var position;
	var school;
	function checkData(){
		name=$("#name").val().trim();
		sex=$("#sex").val();
		nationality=$("#nationality").val().trim();
		tel=$("#tel").val();
		height=$("#height").val();
		weight=$("#weight").val();
		position=$("#position").val();
		school=$("#school").val(); 
	}
	function saveData(){
	
	
	}
	$(document).ready(function(){
		$("#btn-save").click(function(){
			checkData();
			$("#from").submit();
			
		});
	});

</script>
</head>
<body>
	<%@include file="../common/header.jsp" %>
	<div id="center">
	   <div align="center"> <h3 style=" width: 200px;"> 编辑教师</h3></div>
		<div id="massage">
		<form action="${ctx }/teacher/updateTeacher" enctype="multipart/form-data" id="form" method="post" >
		<table class="table">
			    <thead> <tr><td>基本信息</td><td>
			     <img id="img" alt="头像"  src="../images/teacher/${teacher.avater}">
  		        </td></tr>
  		          <tr><td > <input name="id" value="${teacher.id }"style="display: none;/*设置不可见  */"> </td><td>  <input id="imgage" type="file" name="file"></td> </tr>
  		        </thead>
				<tr> <td>姓名：<input id="name" name="name"value="${teacher.name}"></td> <td>性别:<select id="sex" name="sex"><option>男</option><option>女</option></select></td></tr>
				<tr> <td>民族：<input id="nationality"  name="nationality"value="${teacher.nationality }"></td> <td>电话：<input id="tel" name="tel"value="${teacher.tel }"></td></tr>
				<tr> <td>身高：<input id="height" name="height" value="${teacher.height }">cm</td><td>体重：<input id="weight" name="weight"value="${teacher.weight }">kg</td></tr>
				<tr> <td>职位：<input id="position" name="position"value="${ teacher.position}"></td> <td>学校：<input id="school" name="school" value="${teacher.school }"></td></tr>
				<tr><td></td><td align="center" ><button id="btn-save" class="btn-save" >保存</button></td></tr>
			
			</table>
			</form>
		</div>
	
	</div>
</body>
</html>