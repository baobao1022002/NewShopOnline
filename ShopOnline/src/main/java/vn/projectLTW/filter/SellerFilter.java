package vn.projectLTW.filter;

import vn.projectLTW.model.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/seller/*")
public class SellerFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;

		//lấy session
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("account");
		Users user=(Users) obj;

		if(user!=null && user.getRoleId()==8) {
			chain.doFilter(request, response);	// di qua bộ lọc
			return;
		}else {
			resp.sendRedirect(req.getContextPath()+"/logout");
		}
	}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
		}
}
