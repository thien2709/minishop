<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RegistrationForm_v10 by Colorlib</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- LINEARICONS -->
<link rel="stylesheet" href="client/fonts/linearicons/style.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="client/asset/register.css">

<link rel="stylesheet" href="client/asset/style.css">
</head>

<body>
	<div class="header_link-wrap"
		style="padding: 24px; margin: 0 auto; max-width: 1200px; display: flex; align-items: center;">
		<a href="home" class="header_link"> <img src="client/img/logo.png"
			alt="" class="header_img" style="background-color: rgb(238, 77, 45)">
		</a>
		<h1 style="font-size: 1.6rem; margin-left: 16px;">Đăng ký</h1>
	</div>
	<div class="wrapper" style="background-color: rgb(238, 77, 45);">
		<div class="inner">
			<img src="client/img/image-1.png" alt="" class="image-1">
			<form action="register" method="post">
				<h3>Đăng ký</h3>
				<div class="form-holder">
					<span class="lnr lnr-user"></span> <input type="text"
						name="username" class="form-control" placeholder="Tài khoản">
				</div>
				<!-- <div class="form-holder">
                <span class="lnr lnr-phone-handset"></span> <input type="text"
                    name="phone" class="form-control" placeholder="Phone Number">
            </div> -->
				<!-- <div class="form-holder">
                <span class="lnr lnr-envelope"></span> <input type="text"
                    name="mail" class="form-control" placeholder="Mail">
            </div> -->
				<div class="form-holder">
					<span class="lnr lnr-lock"></span> <input type="password"
						name="password" class="form-control" placeholder="Mật khẩu">
				</div>
				<!-- <div class="form-holder">
                <span class="lnr lnr-lock"></span> <input type="password"
                    name="password" class="form-control"
                    placeholder="Confirm Password">
            </div> -->
				<button style="background: rgb(238, 77, 45);">
					<span>Đăng ký</span>
				</button>
				<div style="margin-top: 24px;">
					Bạn đã có tài khoản, hãy <a href="login"
						style="color: #333; text-decoration: none; font-size: 1rem;">Đăng
						nhập</a>
				</div>
			</form>
			<img src="client/img/image-2.png" alt="" class="image-2">
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="client/js/jquery-3.3.1.min.js"></script>
	<script src="client/js/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>