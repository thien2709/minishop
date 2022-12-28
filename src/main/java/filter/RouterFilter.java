package filter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.User;

@WebFilter("/*")
public class RouterFilter extends HttpFilter implements Filter {
	public RouterFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		List<String> listURL = List.of("//", "/home", "/login", "/register", "/detail", "/Login.jsp", "/Register.jsp","/search","/Search.jsp");
		List<String> listURL2 = List.of("/login", "/register", "/Login.jsp", "/Register.jsp");
		List<String> listURL3 = List.of("/manager", "/Manager.jsp", "LoadProduct.jsp");
		List<String> listURL4 = List.of("/checkout", "/Checkout.jsp", "/success", "/Success.jsp");
		List<String> listURL5 = List.of("/admin", "/Admin.jsp");

		HttpServletRequest httRequest = (HttpServletRequest) request;
		HttpServletResponse httResponse = (HttpServletResponse) response;

		HttpSession session = httRequest.getSession();
		User user = (User) session.getAttribute("user");
		String url = httRequest.getServletPath();
		String path = httRequest.getRequestURI().substring(httRequest.getContextPath().length());

		if (path.startsWith("/client/")) {
			chain.doFilter(request, response); // Goes to default servlet.
		} else if (Objects.isNull(user) && listURL.contains(url)) {
			chain.doFilter(request, response);
		} else if (Objects.isNull(user) && url.contains("cart")
				|| Objects.isNull(user) && url.contains("add-to-cart")
				|| Objects.isNull(user) && url.contains("pay")) {
			httResponse.sendRedirect("login");
		} else if (Objects.isNull(user) && !listURL.contains(url)
				|| Objects.nonNull(user) && user.getIsSell() != 1 && user.getIsAdmin() != 1 && listURL3.contains(url)
				|| Objects.nonNull(user) && user.getIsAdmin() != 1 && listURL5.contains(url)) {
			httResponse.sendRedirect("Error.html");
		} else if (Objects.nonNull(user) && !listURL2.contains(url)
				|| Objects.nonNull(user) && listURL4.contains(url)) {
			chain.doFilter(request, response);
		} else if (Objects.nonNull(user) && user.getIsAdmin() == 1 && url.contains("/login")) {
			httResponse.sendRedirect("admin");
		} else {
			httResponse.sendRedirect("home");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
