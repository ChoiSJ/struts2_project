package com.tps.sample.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.sample.dto.LoginUserDto;
import com.tps.sample.dto.UserDto;
import com.tps.sample.service.DiaryService;
import com.tps.sample.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name="index", location="index.jsp"),
	@Result(name="category", location="category", type="redirect")
})
public class LoginAction extends ActionSupport implements SessionAware {

	// ユーザサービス
	@Resource
	private UserService userService;
	// ダイアリーサービス
	@Resource
	private DiaryService diaryService;
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

	// 画面：ユーザ情報
	private LoginUserDto loginUserDto;
	/**
	 * ユーザ情報を取得します。
	 * @return loginUserDto
	 */
	public LoginUserDto getLoginUserDto() {
		return loginUserDto;
	}
	/**
	 * ユーザ情報を設定します。
	 * @param loginUserDto
	 */
	public void setLoginUserDto(LoginUserDto loginUserDto) {
		this.loginUserDto = loginUserDto;
	}

	/**
	 * メイン画面に移動。
	 * @return
	 */
	@Action("/index")
	@SkipValidation
	public String index() {
		return "index";
	}

	/**
	 * メイン画面で入力されたユーザ情報をチェック。
	 * @return
	 */
	@Action("/login")
	public String login() {
		// 入力されたユーザが存在するかチェック。
		UserDto userDto = userService.findUser(loginUserDto);
		// 存在しない場合、メイン画面に移動。
		if (userDto == null) {
			return "index";
		}

		// 存在する場合、セッションに該当ユーザのIDを格納。
		session.put("LOGINED_USER", userDto.getId());

		return "category";
	}
}
