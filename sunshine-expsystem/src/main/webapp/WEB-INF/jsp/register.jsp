<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/login-register.css" />
		<!--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>-->	
		<!--<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/login-register.js"></script>
	</head>
	<body>
		<div class="content">
			<div class="logo">
				<img src="img/logo1.jpg" width="200px"/>
				<span>Admin</span>
			</div>
			<form action="#" method="post" class="login_in">
				<input type="email" class="user_email form-control" placeholder="请输入注册邮箱"/>
				<div class="error" id="email_error"></div>
				<input type="password" class="user_psd form-control" placeholder="请输入密码" />
				<div class="error" id="psd1_error"></div>
				<input type="password" class="user_againpsd form-control" placeholder="请重复输入密码" />
				<div class="error" id="psd2_error"></div>
				<button type="submit" class="btn register-btn">注&nbsp;册</button>
			</form>
			<div class="problem">
				<a href="login" class="register">已有账号去登陆</a>
			</div>
		</div>
		<div class="bg"><img class="bg_img" src="../img/bg2.jpg" /></div>
		
	</body>
</html>