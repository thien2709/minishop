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

	<div class="full-banner">
		<div class="grid wide">
			<div class="banner-wrapper">
				<div class="row">
					<div class="banner-main col l-8">
						<div class="banner-main_wrapper">
							<c:forEach items="${listBannerL}" var="banner">
								<a href="" class="">
									<div class="banner-main_img" id="mySlides"
										style="background-image: url(client/img/banner-l/${banner.imagePath})"></div>
								</a>
							</c:forEach>
						</div>
						<div class="banner-main-baging_list">
							<c:forEach begin="1" end="${nBannerL}">
								<div class="banner-main-baging_item"></div>
							</c:forEach>
						</div>
						<a href="" class="prew">&#10094</a> <a href="" class="next">&#10095</a>
					</div>
					<div class="banner-more col l-4">
						<c:forEach items="${listBannerM}" var="banner">
							<a href="" class="banner-more_link"> <img
								src="client/img/baner-m/${banner.image}" alt=""
								class="banner-more_img">
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="banner-list row">
				<c:forEach items="${listBannerC}" var="o">
					<div class="banner-list_item col l-1">
						<a href="" class="banner-list_item_link">
							<div class=""
								style="background-image: url(client/img/banner-c/${o.image}); background-size: contain; background-repeat: no-repeat; width: 45px; height: 45px;">
							</div> <span> ${o.title} </span>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="grid wide">
			<div class="container-header_wrapper">
				<a href="" class="container-header_link"> <img
					src="client/img/container-header-img.png" alt=""
					class="container-header_img">
				</a>
			</div>
			<div class="container-category_wrapper">
				<h2 class="container-category_heading">DANH MỤC</h2>
				<div class="container-category_list_wrapper">
					<div class="container-category_list row">
						<c:forEach items="${listCategory}" var="o">
							<div class="container-category_item col l-1-10">
								<a href="search?cID=${o.cID}"
									class="container-category_item_link">
									<div class="-rN11Y edy5hG"
										style="background-image: url(client/img/category/${o.image}); background-size: contain; background-repeat: no-repeat; width: 85px; height: 85px;">
									</div> <span> ${o.type} </span>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="container-direction_item container-direction_item_left">
					<i class="fa-solid fa-chevron-left"></i>
				</div>
				<div class="container-direction_item container-direction_item_right">
					<i class="fa-solid fa-chevron-right"></i>
				</div>
			</div>
			<div class="container-product_wrapper">
				<div class="container-product_header">
					<button type="button" class="container-product_header_button">
						GỢI Ý HÔM NAY</button>
				</div>
				<div class="container-product_item_wrapper row">
					<c:forEach items="${listProduct}" var="p">
						<div class="container-product_item col l-2">
							<a href="detail?pid=${p.pID}" class="container-product_item_link">
							<div
                style="background-image: url(client/img/product/${p.image}); background-size: contain; background-repeat: no-repeat; padding-top: 100%;">
              </div>
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
			<div class="container-product_seemore">
				<a href="" class="container-product_seemore_link"> Xem thêm </a>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	<script>
    var i = 0;
    var igms = [];
    igms[0] = 'banner-l1.png';
    igms[1] = 'banner-l2.png';
    igms[2] = 'banner-l3.png';
    igms[3] = 'banner-l4.png';
    igms[4] = 'banner-l5.png';
    igms[5] = 'banner-l6.png';
    igms[6] = 'banner-l7.png';

    changeImage = function() {
      document.getElementById('mySlides').style.backgroundImage = "url(" + "client/img/banner-l/" + igms[i] + ")";
      if (i < igms.length - 1) {
        i++;
      } else {
        i = 0;
      }
      setTimeout(changeImage,3000);
    }
    window.onload = changeImage;
  </script>
</body>
</html>