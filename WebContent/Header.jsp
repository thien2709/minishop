<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="tshop_header">
	<nav class="header_navbar grid wide">
		<ul class="navbar_list">
			<li class="navbar_item navbar_item--separate"><a href=""
				class="navbar_item-link"> Kênh người bán </a></li>
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
					<div class="notify-container">
						<c:if test="${sessionScope.user == null}">
							<img src="client/img/notifyimg.png" alt="" class="notify-img">
							<span class="notify-note">Đăng nhập để xem thông báo</span>
						</c:if>
					</div>
					<c:if test="${sessionScope.user == null}">
						<div class="notify-button">
							<button type="button" class="notify-button-item">Đăng ký</button>
							<button type="button" class="notify-button-item">Đăng
								nhập</button>
						</div>
					</c:if>
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
			<c:if test="${sessionScope.user == null}">
				<li class="navbar_item"><a href="register"
					class="navbar_item-link navbar_item--separate"> Đăng ký </a></li>

				<li class="navbar_item"><a href="login"
					class="navbar_item-link"> Đăng nhập </a></li>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<li class="header__navbar-user navbar_item" style="cursor: pointer;"><img
					src="client/img/avatar.png" alt="" class="header__navbar-user-img"
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
					</ul></li>
			</c:if>
		</ul>
	</nav>
	<div class="grid wide">
		<div class="header_wrap">
			<div class="header_link-wrap">
				<a href="home" class="header_link"> <img
					src="client/img/logo.png" alt="" class="header_img">
				</a>
			</div>
			<div class="header_search">
				<div class="searchbar">
					<div class="searchbar_main">
						<form action="search" class="searchbar_input" autocomplete="off">
							<input type="text" name="keyword" class="searchbar_input-input"
								placeholder="Nhập gì đó">
							<div class="header__search-history">
								<ul class="header__search-history-list">
									<c:if test="${sessionScope.user != null}">
										<c:forEach items="${sessionScope.listKeySearch}" var="o">
											<li class="header__search-history-item"><a
												href="search?keyword=${o.keyWord}"
												style="text-decoration: none; display: block; padding: 16px; color: #333;">${o.keyWord}</a>
											</li>
										</c:forEach>
									</c:if>
								</ul>
							</div>
							<button type="submit" class="btn btn-with-header_search">
								<i class="fa-solid fa-magnifying-glass search-icon"></i>
							</button>
						</form>
					</div>
				</div>
				<c:if test="${sessionScope.user == null}">
					<div class="header_search-list">
						<a href="search?keyword=Dép" class="header_search-item">Dép</a> <a
							href="search?keyword=Áo phông" class="header_search-item">Áo
							phông</a> <a href="search?keyword=Áo croptop"
							class="header_search-item">Áo croptop</a> <a
							href="search?keyword=Dép nữ" class="header_search-item">Dép
							nữ</a> <a href="search?keyword=Váy" class="header_search-item">Váy</a>
						<a href="search?keyword=Túi xách nữ" class="header_search-item">Túi
							xách nữ</a> <a href="search?keyword=Áo khoác"
							class="header_search-item">Áo khoác</a> <a
							href="search?keyword=Balo" class="header_search-item">Balo</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.user != null}">
					<div class="header_search-list">
						<c:forEach items="${sessionScope.listKeySearch}" var="o">
							<a href="search?keyword=${o.keyWord}" class="header_search-item">${o.keyWord}</a>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<div class="header__cart">
				<a href="cart" class="header__cart-wrap"> <i
					class="header__cart-icon fa-solid fa-cart-arrow-down"></i> <c:if
						test="${sessionScope.total != null}">
						<span class="header__cart-notice">${total}</span>
					</c:if>

					<div class="header__cart-list">
						<c:if test="${sessionScope.user == null}">
							<img src="client/img/no-cart.png" alt=""
								class="header__cart-list--no-cart-img">
							<span class="header__cart-list--no-cart-text">Chưa có sản
								phẩm</span>
						</c:if>
						<c:if test="${sessionScope.user != null}">
							<c:if test="${sessionScope.cart == null}">
								<img src="client/img/no-cart.png" alt=""
									class="header__cart-list--no-cart-img">
								<span class="header__cart-list--no-cart-text">Chưa có sản
									phẩm</span>
							</c:if>
							<c:if test="${sessionScope.cart != null}">
								<h4 class="header__cart-list-heading" style="padding: 8px;">Sản
									phẩm mới thêm</h4>
							</c:if>
							<c:forEach items="${cart.items}" var="item">
								<div class="header__cart-item"
									style="padding: 8px; align-items: center">
									<img src="client/img/product/${item.product.image}" alt=""
										class="header__cart-item-img">
									<div class="header__cart-item-info">
										<div class="header__cart-item-head">
											<h5 class="header__cart-item-name"
												style="font-size: .8rem; margin: 0 8px;">${item.product.describe}</h5>
											<span class="header__cart-item-price">${item.product.price}đ</span>
											<span class="header__cart-item-mutiply"
												style="margin: 0 4px;">x</span> <span
												class="header__cart-item-qnt">${item.quantity}</span>
										</div>
										<div class="header__cart-item-body"></div>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</a>
			</div>
		</div>
	</div>
</header>