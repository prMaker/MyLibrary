package com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter
 */
public class FilterHome implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public FilterHome() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see FilterHome#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see FilterHome#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String[] strs = uris.split(",");
		
		String uri = req.getRequestURI();
		boolean flag=false;
		for(String str : strs){
			if(uri.startsWith(str)){
				flag=true;
				break;
			}
		}
		if(req.getSession().getAttribute("user")!=null){
			flag=true;
		}
		if(flag){
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("/index");
		}
	}

	/**
	 * @see FilterHome#init(FilterConfig)
	 */
	String uris;
	public void init(FilterConfig fConfig) throws ServletException {
		uris = fConfig.getInitParameter("uris");
	}

}
