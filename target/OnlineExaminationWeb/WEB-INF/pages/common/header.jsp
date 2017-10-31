<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style  type="text/css">
body{
    overflow: scroll;	
	margin:0;
	font-family:'微软雅黑','Times New Roman', Times, serif;
	background-image: url("../images/bd.jpg")
	}
.navi_head{
	height:50px;
	background-color:#459df5;
}
.navi_body{
	overflow:hidden;
	height:50px;
	margin:10px auto;
	max-width:960px;
	min-width:960px;
	background:rgba(36,97,158,0.9);
	transition:height ease 0.5s;
	border-radius: 4px;
}
.navi_body:hover{
	height:300px;
}

.navi_head>div>span{
	width:150px;
	text-align:center;
	height:300px;
	display:inline-block;
	font-weight:bold;
	color:#FFF;
	font-size:14px;
	vertical-align:top;
}

.navi_head>div>span>p a{
	color:#FFF;
	text-decoration:none;
	cursor: pointer;
}
.navi_head>div>span>p a:hover{
	color:#FFF;
	text-decoration:underline;
}

.navi_title{
	font-size:16px;
	line-height:50px;
	margin-top:0;
}

.navi_head>div>span:hover{
	background:rgba(100,100,100,0.2);
}
</style>
</head>
<body>
<div>
		<div class="navi_body">
			<div class="navi_head">
				<div style="width:80%; margin-left:auto; margin-right:auto;">
					<span>
						<p class="navi_title">个人</p>
						<p><a href="${ctx }/teacher/teacherIndex">个人详细信息</a></p>
						<p><a href="${ctx }/loginOut">退出</a></p>
					</span>
					<span>
						<p class="navi_title">教师</p>
						<p><a href="${ctx }/teacher/teacherList">教师信息</a></p>
					</span>
					<span>
						<p class="navi_title">考生</p>
						<p><a href="${ctx }/teacher/examineeList">考生信息</a></p>
					</span>
					<span>
						<p class="navi_title">试题</p>
						<p><a>试题信息</a></p>
					</span>
					<span>
						<p class="navi_title">给我留言</p>
						<p><a href="">站内留言</a></p>
						<p><a href="">站长信箱</a></p>
					</span>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>