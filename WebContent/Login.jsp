<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="client/fonts/icomoon/style.css">

<link rel="stylesheet" href="client/asset/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="client/asset/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="client/asset/css/style.css">

<link rel="stylesheet" href="client/asset/style.css">

<title>Login</title>
</head>
<body>
	<div class="header_link-wrap"
		style="padding: 24px; margin: 0 auto; max-width: 1200px; display: flex; align-items: center;">
		<a href="home" class="header_link"> <img src="client/img/logo.png"
			alt="" class="header_img" style="background-color: rgb(238, 77, 45)">
		</a>
		<h1 style="font-size: 1.6rem; margin-left: 16px;">Đăng nhập</h1>
	</div>
	<div class="content" style="background-color: rgb(238, 77, 45);">
		<div class="container" style="background-color: #ee4d2d;">
			<div class="row">
				<div class="col-md-6">
					<img src="client/img/shoppe.png" alt="Image"
						class="img-fluid">
				</div>
				<div class="col-md-6 contents">
					<div class="row justify-content-center"
						style="background-color: #fff; margin: 48px 0;">
						<div class="col-md-8"
							style="margin-top: 24px; margin-bottom: 16px;">
							<div class="mb-4">
								<h3>Đăng nhập</h3>
								<p class="mb-4">Hãy đăng nhập để trải nghiệm ứng dụng mua
									sắm</p>
							</div>
							<form action="login" method="post">
								<div class="form-group first">
									<label for="username">Username</label> <input type="text"
										name="username" class="form-control" id="username">

								</div>
								<div class="form-group last mb-4">
									<label for="password">Password</label> <input type="password"
										name="password" class="form-control" id="password">

								</div>

								<div class="d-flex mb-5 align-items-center">
									<label class="control control--checkbox mb-0"><span
										class="caption">Nhớ mật khẩu</span> <input type="checkbox"
										checked="checked" />
										<div class="control__indicator"></div> </label> <span class="ml-auto"><a
										href="#" class="forgot-pass">Quên mật khẩu</a></span>
								</div>

								<input type="submit" value="Đăng nhập"
									class="btn btn-block btn-primary"
									style="background-color: #ee4d2d; border: none;"> <span
									class="d-block text-left my-4 text-muted">&mdash; Kết
									nối với &mdash;</span>

								<div class="social-login">
									<a href="#" class="facebook"> <span
										class="icon-facebook mr-3"></span>
									</a> <a href="#" class="twitter"> <span
										class="icon-twitter mr-3"></span>
									</a> <a href="#" class="google"> <span class="icon-google mr-3"></span>
									</a>
								</div>
								<div>Bạn chưa có tài khoản? <a href="register" style="text-decoration: none;">Đăng ký</a></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script src="client/js/jquery-3.3.1.min.js"></script>
	<script src="client/js/popper.min.js"></script>
	<script src="client/js/bootstrap.min.js"></script>
	<script src="client/js/main.js"></script>
</body>
</html>