package com.tps.sample.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.sample.dto.UserDto;
import com.tps.sample.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name="createUserInit", location="create_user.jsp"),
	@Result(name="createUser", location="index", type="redirect")
})
public class CreateUserAction extends ActionSupport {

	// ユーザサービス
	@Resource
	private UserService userService;
	// 画面：ユーザ情報
	private UserDto userDto;
	/**
	 * ユーザ情報を設定します。
	 * @param userDto
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	/**
	 * ユーザ情報を取得します。
	 * @return userDto
	 */
	public UserDto getUserDto() {
		return this.userDto;
	}

	/**
	 * ユーザ登録画面に移動。
	 * @return
	 */
	@Action("/create_user_init")
	public String createUserInit() {
		return "createUserInit";
	}

	/**
	 * ユーザを登録。
	 * @return
	 */
	@Action("/create_user")
	public String createUser() {
		userService.join(userDto);

		return "createUser";
	}
}
