package com.royal.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

public class TestFilter extends HttpFilter implements Filter 
{
       
	public void init(FilterConfig fConfig) throws ServletException 
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// Pre-Filtering place your code here

		System.out.println("TestFilter doFilter() : Pre-Filtering ");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		// Post-Filtering place your code here
		System.out.println("TestFilter doFilter() : Post-Filtering ");
	}

	public void destroy() 
	{
	}
}
