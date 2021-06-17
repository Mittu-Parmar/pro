package in.mittu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/MainFilter")
public class MainFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO After complition of programe for fake request
		chain.doFilter(request, response);
	}
	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
