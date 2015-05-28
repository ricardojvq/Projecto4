package projecto4.grupo1.albertoricardo.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig customedFilterConfig;

	@Override
	public void init(FilterConfig customedFilterConfig) throws ServletException {
		this.customedFilterConfig = customedFilterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		if (!(boolean)((HttpServletRequest) req).getSession().getAttribute("vip")) {
			((HttpServletResponse) resp).sendRedirect("../NonAuthorized.xhtml");
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		customedFilterConfig = null;
	}
}