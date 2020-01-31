package com.demo.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EntryFilter implements Filter {
	
	private Logger LOGGER = LogManager.getLogger();
	public final static String requestId = "requestId";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOGGER.info("inside filter dofilter method");
		
		Random rand = new Random();
		int id = rand.nextInt();
		request.setAttribute(requestId, id);
		chain.doFilter(request, response);
	}

}
