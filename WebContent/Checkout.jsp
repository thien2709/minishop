<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link rel="stylesheet" href="client/fonts/icon/css/all.min.css">
<style>
.row {
	display: -ms-flexbox;
	/* IE10 */
	display: flex;
	-ms-flex-wrap: wrap;
	/* IE10 */
	flex-wrap: wrap;
	margin: 0 -16px;
}

.col-25 {
	-ms-flex: 25%;
	/* IE10 */
	flex: 25%;
}

.col-50 {
	-ms-flex: 50%;
	/* IE10 */
	flex: 50%;
}

.col-75 {
	-ms-flex: 75%;
	/* IE10 */
	flex: 75%;
}

.col-25, .col-50, .col-75 {
	padding: 0 16px;
}

.container {
	background-color: #f2f2f2;
	padding: 5px 20px 15px 20px;
	border: 1px solid lightgrey;
	border-radius: 3px;
}

input[type=text] {
	width: 100%;
	margin-bottom: 20px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

label {
	margin-bottom: 10px;
	display: block;
}

.icon-container {
	margin-bottom: 20px;
	padding: 7px 0;
	font-size: 24px;
}

.btn {
	background-color: #04AA6D;
	color: white;
	padding: 12px;
	margin: 10px 0;
	border: none;
	width: 100%;
	border-radius: 3px;
	cursor: pointer;
	font-size: 17px;
}

.btn:hover {
	background-color: #45a049;
}

span.price {
	float: right;
	color: grey;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-75">
			<div class="container">
				<form action="./checkout" method="post">
					<div class="row">
						<div class="col-50">
							<h3>Địa chỉ thanh toán</h3>
							<label for="fname"><i class="fa fa-user"></i>Tên</label> <input
								type="text" id="fname" name="firstname"
								placeholder="Nguyen Van A" required> <label for="email"><i
								class="fa fa-envelope"></i> Email</label> <input type="text" id="email"
								name="email" placeholder="mail@example.com" required> <label
								for="adr"><i class="fa fa-address-card-o"></i> Địa chỉ</label> <input
								type="text" id="adr" name="address"
								placeholder="Địa chỉ của bạn" required> <label
								for="city"><i class="fa fa-institution"></i> Thành phố</label> <input
								type="text" id="city" name="city" placeholder="Đà Nẵng" required>
						</div>
						<div class="col-50">
							<h3>Thanh toán</h3>
							<label for="fname">Thẻ được hỗ trợ</label>
							<div class="icon-container">
								<i class="fa fa-cc-visa" style="color: navy;"></i> <i
									class="fa fa-cc-amex" style="color: blue;"></i> <i
									class="fa fa-cc-mastercard" style="color: red;"></i> <i
									class="fa fa-cc-discover" style="color: orange;"></i>
							</div>
							<label for="cname">Tên trên thẻ</label> <input type="text"
								id="cname" name="cardname" placeholder="NGUYEN VAN A"> <label
								for="ccnum">Số thẻ</label> <input type="text" id="ccnum"
								name="cardnumber" placeholder="1111-2222-3333-4444"> <label
								for="expmonth">Tháng hiệu lực</label> <input type="text"
								id="expmonth" name="expmonth" placeholder="11">

							<div class="row">
								<div class="col-50">
									<label for="expyear">Năm hiệu lực</label> <input type="text"
										id="expyear" name="expyear" placeholder="2018">
								</div>
							</div>
						</div>
					</div>
					<label> <input type="checkbox" checked="checked"
						name="sameadr"> Địa chỉ giao hàng giống như thanh toán
					</label> <input type="submit" value="Đặt hàng" class="btn">
				</form>
			</div>
		</div>
		<div class="col-25">
			<div class="container">
				<p>
					Tổng tiền <span class="price" style="color: black"> <c:if
							test="${sum == 0}">0đ</c:if> <c:if test="${sum != 0}">
							<b>${sum + shipPrice}đ</b>
						</c:if>
					</span>
				</p>
			</div>
		</div>
	</div>
</body>
</html>