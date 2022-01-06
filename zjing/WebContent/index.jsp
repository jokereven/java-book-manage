<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用武汉职业技术学院图书管理系统
		</div>
		<div id="back">
			<a href="#">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="${pageContext.request.contextPath }/UserServlet?action=login" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" class="username" name="uname" placeholder="admin"></div>
					<div><input type="password" class="pwd" name="upsw" placeholder="admin"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
	     <span style="color: #ffffff;">版权所有&copy;武汉职业技术学院20级软件1班</span>
	</div>
	<script>
	window.onload = function(){
		if(document.cookie === ""){
			document.cookie = "loginstatus=true";
			alert("请输入用户名和密码");
		}else{
			alert("用户名或密码错误");
		}	
	}
	</script>
</body>
</html>