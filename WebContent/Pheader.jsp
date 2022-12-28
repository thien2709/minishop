<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="tshop_header">
	<nav class="header_navbar grid wide">
		<ul class="navbar_list">
			<li class="navbar_item navbar_item--separate"><a href=""
				class="navbar_item-link" style=""> Kênh người bán </a></li>
			<li class="navbar_item"><a href=""
				class="navbar_item-link navbar_item--separate"> Trở thành người
					bán T-SHOP </a></li>
			<li class="navbar_item navbar_item-has-qrcode navbar_item-peseudo">
				<a href="" class="navbar_item-link navbar_item--separate"> Tải
					ứng dụng </a>
				<div class="header-qrcode">
					<img src="client/img/QR.png" alt="" class="qrcode-img">
					<div class="app-img">
						<img src="client/img/appstore.png" alt="" class="app-icon">
						<img src="client/img/chplay.png" alt="" class="app-icon"> <img
							src="client/img/appgalley.png" alt="" class="app-icon">
					</div>
				</div>
			</li>
			<li class="navbar_item">Kết nối <a href=""
				class="navbar_item-link"> <i
					class="fa-brands fa-facebook navbar_item-icon"></i>
			</a> <a href="" class="navbar_item-link"> <i
					class="fa-brands fa-instagram navbar_item-icon"></i>
			</a>
			</li>
		</ul>
		<ul class="navbar_list">
			<li class="navbar_item navbar_item-has-notify"><a href=""
				class="navbar_item-link"> <i
					class="fa-solid fa-bell navbar_item-icon"></i> Thông báo
			</a>
				<div class="header-notify">
					<div class="notify-container"></div>
				</div></li>
			<li class="navbar_item"><a href="" class="navbar_item-link">
					<i class="fa-solid fa-circle-question navbar_item-icon"></i> Hỗ trợ
			</a></li>
			<li class="navbar_item navbar_item-has-language"><i
				class="fa-solid fa-globe navbar_item-icon"></i> Tiếng Việt <i
				class="fa-solid fa-angle-down"></i>
				<div class="header-language">
					<button class="language-item">Tiếng Việt</button>
					<button class="language-item">English</button>
				</div></li>
			<li class="header__navbar-user navbar_item" style="cursor: pointer;">
				<img src="client/img/avatar.png" alt=""
				class="header__navbar-user-img"
				style="border-radius: 50%; margin: 0 4px; border: 1px solid #848485; width: 20px; height: 20px;">
				<span class="header__navbar-user-name">${sessionScope.user.user}</span>
				<ul class="header__navbar-user-menu">
					<c:if test="${sessionScope.user.isSell == 1}">
						<li class="header__navbar-user-menu-item"><a href="manager">Quản
								lý sản phẩm</a></li>
					</c:if>
					<c:if test="${sessionScope.user.isAdmin == 1}">
						<li class="header__navbar-user-menu-item"><a href="admin">Quản
								lý Account</a></li>
						<li class="header__navbar-user-menu-item"><a href="manager">Quản
								lý sản phẩm</a></li>
					</c:if>
					<li class="header__navbar-user-menu-item"><a href="cart">Đơn
							mua</a></li>
					<li class="header__navbar-user-menu-item"><a href="logout">Đăng
							xuất</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</header>