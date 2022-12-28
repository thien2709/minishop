<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="client/asset/base.css">
<link rel="stylesheet" href="client/asset/grid.css">
<link rel="stylesheet" href="client/asset/style.css">
<link rel="stylesheet" href="client/fonts/icon/css/all.min.css">
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="grid wide">
		<div class="container">
			<div class="container-product_item_wrapper row">
				<c:forEach items="${listP}" var="p">
					<div class="container-product_item col l-2">
						<a href="detail?pid=${p.pID}" class="container-product_item_link">
							<img width="100%" alt="" style="object-fit: contain"
							src="client/img/product/${p.image}">
							<p class="container-product_item_describe">${p.describe}
							<div class="contaier-product_item_info">
								<span class="container-product_item_price"> <span
									class="container-product_item_unit">đ</span>${p.price}
								</span>
								<p class="container-product_item_sold">Đã bán</p>
							</div>
						</a>
						<div class="container-product_item_note">
							<a href="" class="container-product_item_note_link">Tìm sản
								phẩm tương tự</a>
						</div>
						<div class="container-product_item_favourite">Yêu thích</div>
						<div class="container-product_item_discount">
							<span class="container-product_item_discount--percent"> %
							</span> <br> GIẢM
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>