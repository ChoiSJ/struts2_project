package com.tps.sample.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.sample.dto.UserDto;
import com.tps.sample.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name="modifyUserInit", location="modify_user.jsp")
})
public class ModifyUserAction extends ActionSupport implements SessionAware {
	
	// ユーザサービス
	@Resource
	private UserService userService;
	// 画面：ユーザ情報
	private UserDto userDto;
	/**
	 * ユーザ情報を取得します。
	 * @return userDto
	 */
	public UserDto getUserDto() {
		return userDto;
	}
	/**
	 * ユーザ情報を設定します。 
	 * @param userDto
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	// セッション
	private Map<String, Object> session;
	/**
	 * セッションを設定します。 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	/**
	 * ユーザ修正の初期画面に移動。 
	 * @return
	 */
	@Action("/modify_user_init")
	public String modifyUserInit() {
		// セッションからユーザIDを取得。
		String userId = (String) session.get("LOGINED_USER");
		// ユーザIDで現在ログイン中のユーザを検索。
		userDto = userService.findUser(userId);

		return "modifyUserInit";
	}
	
	/**
	 *  ユーザ情報を修正。
	 * @return
	 */
	@Action("/modify_user")
	public String modifyUser() {
		userService.modify(userDto);

		return "modifyUserInit";
	}
}
