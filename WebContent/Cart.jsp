<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="client/asset/base.css">
<link rel="stylesheet" href="client/asset/grid.css">
<link rel="stylesheet" href="client/asset/style.css">
<link rel="stylesheet" href="client/fonts/icon/css/all.min.css">
<style>
/* body {
	background: #ddd;
	min-height: 100vh;
	vertical-align: middle;
	font-family: sans-serif;
	font-size: 0.8rem;
	font-weight: bold;
} */
.title {
	margin-bottom: 5vh;
}

.card {
	margin: auto;
	width: 90%;
	box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	border-radius: 1rem;
	border: transparent;
	margin: 24px auto;
}

@media ( max-width :767px) {
	.card {
		margin: 3vh auto;
	}
}

.cart {
	background-color: #fff;
	padding: 4vh 5vh;
	border-bottom-left-radius: 1rem;
	border-top-left-radius: 1rem;
}

@media ( max-width :767px) {
	.cart {
		padding: 4vh;
		border-bottom-left-radius: unset;
		border-top-right-radius: 1rem;
	}
}

.summary {
	background-color: #ddd;
	border-top-right-radius: 1rem;
	border-bottom-right-radius: 1rem;
	padding: 4vh;
	color: rgb(65, 65, 65);
}

@media ( max-width :767px) {
	.summary {
		border-top-right-radius: unset;
		border-bottom-left-radius: 1rem;
	}
}

.summary .col-2 {
	padding: 0;
}

.summary .col-10 {
	padding: 0;
}

.row {
	margin: 0;
}

.title b {
	font-size: 1.5rem;
}

.main {
	margin: 0;
	padding: 2vh 0;
	width: 100%;
}

.col-2, .col {
	padding: 0 1vh;
}

a {
	padding: 0 1vh;
}

.close {
	margin-left: auto;
	font-size: 0.7rem;
}

img {
	width: 3.5rem;
}

.back-to-shop {
	margin-top: 4.5rem;
}

h5 {
	margin-top: 4vh;
}

hr {
	margin-top: 1.25rem;
}

form {
	padding: 2vh 0;
}

select {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1.5vh 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247);
}

input {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247);
}

input:focus::-webkit-input-placeholder {
	color: transparent;
}

.btn {
	color: white;
	width: 100%;
	font-size: 1rem;
	margin-top: 4vh;
	padding: 1vh;
	border-radius: 0;
}

.btn:focus {
	box-shadow: none;
	outline: none;
	box-shadow: none;
	color: white;
	-webkit-box-shadow: none;
	-webkit-user-select: none;
	transition: none;
}

.btn:hover {
	opacity: .8;
}

.border {
	text-decoration: none;
	color: #333;
	font-size: 1.2rem;
	padding: 0 8px;
}

.border:hover {
	text-decoration: none;
	color: #333;
}

#code {
	background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253),
		rgba(255, 255, 255, 0.185)),
		url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
	background-repeat: no-repeat;
	background-position-x: 95%;
	background-position-y: center;
}

.border {
	color: #333;
}
</style>
</head>

<body>
	<jsp:include page="Pheader.jsp"></jsp:include>
	<div class="card">
		<div class="row">
			<div class="col-md-8 cart">
				<div class="title">
					<div class="row">
						<div class="col">
							<h4>
								<b>Giỏ hàng</b>
							</h4>
						</div>
						<div class="col align-self-center text-right text-muted">${total}</div>
					</div>
				</div>
				<div class="row border-top border-bottom">
					<c:forEach items="${cart.items}" var="item">
						<div class="row main align-items-center">
							<div class="col-2">
								<img class="img-fluid"
									src="client/img/product/${item.product.image}">
							</div>
							<div class="col">
								<div class="row text-muted">${item.product.cID}</div>
								<div class="row">${item.product.describe}</div>
							</div>
							<div class="col">
								<a href="set-quantity?pid=${item.product.pID}&&count=reduce"
									class="border">-</a><span class="border">${item.quantity}</span><a
									href="set-quantity?pid=${item.product.pID}&&count=augment"
									class="border">+</a>
							</div>
							<div class="col">
								${item.product.price} <sup>đ</sup> <a
									href="remove-item?pid=${item.product.pID}"><span
									class="close">&#10005;</span></a>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="back-to-shop">
					<a class="border" href="home">&leftarrow;</a><span
						class="text-muted">Trở về</span>
				</div>
			</div>
			<div class="col-md-4 summary">
				<div>
					<h5>
						<b>Tổng kết</b>
					</h5>
				</div>
				<hr>
				<div class="row">
					<div class="col" style="padding-left: 0;">Sản phẩm: ${total}</div>
					<div class="col text-right">
						${sum} <sup>đ</sup>
					</div>
				</div>
				<form action="checkout" method="get">
					<p>Đơn vị vận chuyển</p>
					<select name="sID">
						<c:forEach items="${listShipping}" var="o">
							<option class="text-muted" value="${o.sID}">${o.name} -
								${o.price} <sup>đ</sup></option>
						</c:forEach>
					</select>
					<p>Mã giảm giá</p>
					<input id="code" placeholder="Enter your code">
					<div class="row"
						style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
					</div>
					<a href="checkout" style="text-decoration: none"><button
							type="submit" class="btn">Tới trang thanh toán</button></a>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>