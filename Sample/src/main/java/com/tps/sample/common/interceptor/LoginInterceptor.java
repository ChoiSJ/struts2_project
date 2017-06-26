package com.tps.sample.common.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object userId = session.get("LOGINED_USER");

		if (userId != null && userId instanceof String) {
			return invocation.invoke();
		} else {
			return "noLogin";
		}
	}
}
