package com.ctc.Common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ctc.Model.PageConstants;


/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
public class PageFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		int offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		try {
			PageConstants.setOffset(offset);
			PageConstants.setSize(5);
			chain.doFilter(req, res);
		}finally {
			PageConstants.removeOffset();
			PageConstants.removeSize();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

}
