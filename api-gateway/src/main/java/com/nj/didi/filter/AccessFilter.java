package com.nj.didi.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class AccessFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		
		String url = request.getRequestURI();
		System.out.println("url>>>>>>"+url);
				
		Object accessToken = request.getParameter("accessToken");
		
		if(accessToken==null){
			
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
