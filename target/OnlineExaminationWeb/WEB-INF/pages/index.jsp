<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="common/taglibs.jsp"%>
<html>
<head>
<title>在线考试系统</title>

<link rel="stylesheet" type="text/css"
	href="${ctx}/css/index/index.css">
<script type="text/javascript" src="<c:url value='/js/common/jquery.min.js'/>"></script>	
<script type="text/javascript">
	var ctx = '${ctx}';
	var name;
	var password;
	
	$(document).ready(function(){
		$("#btn-login").click(function(){
			if(check()){
			   login();
			}
		});
	});
	function check(){
		
		name=$("#name").val().trim();
		password=$("#password").val().trim();
		if(name==""){
		 $("#massage").html("请输入姓名");
		  return false;
		}
		if(password==""){
		  $("#massage").html("请输入密码");
		  return false;
		}
		if(password.length<5||password.length>20){
		 $("#massage").html("密码错误，请重新输入");
		  return false;
		}
		return true;
	}
	function login(){
	$.ajax({
		url:ctx+"/teacherLogin",
		data:{"name":name,"password":password},
		type:"post",
		success:function(data,textStatus){
		  if(data.result=="success"){
		  setTimeout("window.location.href=ctx+'/teacher/teacherIndex';", 100);}
		},
		complete:function(XMLHttpRequest, textStatus){
			
		}
	});
	}
</script>
</head>

<body>
	<div class="login-area">
		<div class="title">
			<span></span>登录<span></span>
		</div>
		<div>
			<label for="">
			
			<input id="name" type="text" placeholder="姓名"
				class="common input" name="username" value="">
			
			<input
				id="password" type="password" placeholder="密码"
				class="common input psw-height" name="password"\>
			</label>
		</div>
		<div class="massagediv">
		 <span> <i id="massage"></i></span><br>
		</div>
		
		<div class="checkdiv">
			
			<input type="radio" value="teacher" id="cbx-teaher" class="checkbox" name="checkbox" checked="checked"><label> 教师</label>
			<input type="radio" value="examinee" id="cbx-examinee" class="checkbox" name="checkbox"><label>考生</label>
		</div>
		<button class="common login-btn" id="btn-login">登录</button>
	</div>


</body>
</html>
