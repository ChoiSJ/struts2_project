package com.tps.sample.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
@InterceptorRefs({
	@InterceptorRef("clearSession")
})
@Result(name="logout", location="index", type="redirect")
public class LogoutAction extends ActionSupport {

	/**
	 * ログアウト。
	 * @return
	 */
	@Action("/logout")
	public String logout() {
		return "logout";
	}
}
