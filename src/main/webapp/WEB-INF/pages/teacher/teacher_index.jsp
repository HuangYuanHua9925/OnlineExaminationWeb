<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>techer</title>
<style type="text/css">
	
	.massage{
	 margin:10px auto;
 	 height: 400px;
 	 width: 500px;
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
		width: 150px;
		height: aotu;
		max-height: 200px;
	}
	
</style>

</head>
<body>
	<%@include file="../common/header.jsp" %>
  	<div id="center">
  	 <div align="center"> <h3 style=" width: 200px;"> 个人信息</h3></div>
		<div class="massage"> 
			<table class="table">
			    <thead> <tr><td>基本信息</td><td>
			    <img id="img" alt="头像"  src="../images/teacher/<c:out value='${currTeacher.avater }' default='1.jpg'/>"><br/>
  		        </td></tr></thead>
				<tr> <td>姓名：${currTeacher.name }</td> <td>性别:${currTeacher.sex }</td></tr>
				<tr> <td>民族：${currTeacher.nationality }</td> <td>电话：${currTeacher.tel }</td></tr>
				<tr> <td>身高：${currTeacher.height } cm</td><td>体重：${currTeacher.weight }kg</td></tr>
				<tr> <td>职位：${ currTeacher.position}</td> <td>学校：${currTeacher.school }</td></tr>
				
			</table>
	</div>
  	
  	
  	</div>
</body>
</html>