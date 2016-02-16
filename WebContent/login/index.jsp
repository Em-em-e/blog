<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	//获取项目部署后的url  如：http://0.0.0.0:8080/blog/  
	String path=application.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登陆</title>
	<link rel="stylesheet" href="<%=basePath %>login/style.css" type="text/css" />
		<script type="text/javascript" src="<%=basePath %>login/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>login/selectivizr.js"></script>
		<noscript><link rel="stylesheet" href="<%=basePath %>login/fallback.css" /></noscript>
	</head>

	<body>
		<div id="container">
			<form action="login.action" method="post">
				<div class="login">登&nbsp;&nbsp;陆   &nbsp;&nbsp;&nbsp;&nbsp;<span>${login_msg }</span></div>
				<div class="username-text">用户名：</div>
				<div class="password-text">密&nbsp;&nbsp; 码：</div>
				<div class="username-field">
					<input type="text" name="username" value="" />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="" />
				</div>
                <div class="code-text">验证码：</div>
                <div class="a-text">&nbsp;&nbsp;</div>
                <div class="code-field">
                    <input type="text" class="username-text" name="check_code">
                </div>
                <img src="check_code.action" onclick="this.src='check_code.action?#'+Math.random();">

				<input type="submit" name="submit" value="GO" />
			</form>
		</div>
		<div id="footer">
			Designed by Coder Liang 
		</div>
	</body>
</html>
