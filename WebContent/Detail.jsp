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
	<div class="detail-container">
		<div class="grid wide">
			<div class="row">
				<div class="detail-container_header">
					<a href="" class="detail-container_header_link">TShop</a> <span
						class="detail-container_header_next">></span> <a href=""
						class="detail-container_header_link"> </a> <span
						class="detail-container_header_next">></span> <a href=""
						class="detail-container_header_link"> </a> <span
						class="detail-container_header_next">></span> <a href=""
						class="detail-container_header_link"> </a> <span
						class="detail-container_header_next">></span>
					<p class="detail-container_header_describe">${p.describe}</p>
				</div>
			</div>
			<div class="detail-container_content row">
				<div class="detail-container_content_left col l-5">
					<div class=""
						style="background-image: url(client/img/product/${p.image}); background-size: contain; background-repeat: no-repeat;
						width: 450px; height: 450px; margin-left: 8px;margin-top: 16px;"></div>
					<div class="detail-container_content_album">
						<img src="client/img/product/${p.image}" alt=""
							class="detail-container_content_album_item"> <img
							src="client/img/product/${p.image}" alt=""
							class="detail-container_content_album_item"> <img
							src="client/img/product/${p.image}" alt=""
							class="detail-container_content_album_item"> <img
							src="client/img/product/${p.image}" alt=""
							class="detail-container_content_album_item"> <img
							src="client/img/product/${p.image}" alt=""
							class="detail-container_content_album_item">
					</div>
					<div class="detail-container_content_share">
						<div class="detail-container_content_social row">
							<p class="content-socical_lable">Chia sẻ:</p>
							<div class="content-socical_icon">
								<i
									class="fa-brands fa-facebook-messenger content-socical_icon_messgener"></i>
								<i class="fa-brands fa-facebook content-socical_icon_facebook"></i>
								<i class="fa-brands fa-pinterest content-socical_icon_pinterest"></i>
								<i class="fa-brands fa-twitter content-socical_icon_twitter"></i>
							</div>
						</div>
						<div class="detail-container_content_favourite row  ">
							<i class="fa-solid fa-heart content-favourite_icon"></i>
							<p class="content-favourite_lable">Đã thích (1,6k)</p>
						</div>
					</div>
				</div>
				<div class="detail-container_content_right col l-7">
					<div class="dccr-header row">
						<span class="dccr-header_favourite">Yêu thích</span>
						<h2 class="dccr-header_title">${p.describe}</h2>
					</div>
					<div class="ddcr-index row">
						<div class="ddcr-index-star">
							<span class="ddcr-index-star_number"> 4.8 </span> <i
								class="fa-solid fa-star ddcr-index-star-icon"></i> <i
								class="fa-solid fa-star ddcr-index-star-icon"></i> <i
								class="fa-solid fa-star ddcr-index-star-icon"></i> <i
								class="fa-solid fa-star ddcr-index-star-icon"></i> <i
								class="fa-solid fa-star ddcr-index-star-icon"></i>
						</div>
						<div class="ddcr-index-evaluate row">
							<span class="ddcr-index-evaluate_number"> </span>
							<p class="ddcr-index-evaluate_text">Đánh giá</p>
						</div>
						<div class="ddcr-index-sold row">
							<span class="ddcr-index-sold_number"> </span>
							<p class="ddcr-index-sold_text">
								Đã bán ${p.sold}
							</p>
						</div>
					</div>
					<div class="ddcr-price row">
						<span class="ddcr-price_money"> <sup>đ</sup> ${p.price}
						</span>
					</div>
					<div class="ddcr-number row">
						<div class="ddcr-number_label">Số lượng có sẵn</div>
						<div class="ddcr-number_count row">
							<div class="ddcr-number_count_number">${p.available}</div>
						</div>
					</div>
					<div class="ddcr-cart">
						<a href="add-to-cart?pid=${p.pID}" style="text-decoration: none;">
							<button type="submit" class="ddcr-cart_add">
								<i class="fa-solid fa-cart-plus"></i> Thêm vào giỏ hàng
							</button>
						</a> <a href="pay?pid=${p.pID}" style="text-decoration: none;">
							<button type="submit" class="ddcr-cart_buy">Mua ngay</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>