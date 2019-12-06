package ua.khnucea.csit.cs.pertseva.airline.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class EncodingFilter for encoding.
 *
 * @author Pertseva Veronika
 */
public class EncodingFilter implements Filter {

	private final Logger LOGGER = Logger.getLogger(EncodingFilter.class);

	private String encoding;

	/**
	 * Init encoding.
	 *
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) {
		encoding = config.getInitParameter("encoding");
		LOGGER.trace("Request encoding: " + encoding);

		if (encoding == null) {
			encoding = "UTF-8";
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
			throws IOException, ServletException {

		// Respect the client-specified character encoding
		// (see HTTP specification section 3.4.1)
		if (null == request.getCharacterEncoding()) {
			request.setCharacterEncoding(encoding);
		}

		/**
		 * Set the default response content type and encoding
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		next.doFilter(request, response);
	}

	public void destroy() {
	}

}
