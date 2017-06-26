package com.tps.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.sample.dao.UserDao;
import com.tps.sample.dto.LoginUserDto;
import com.tps.sample.dto.UserDto;
import com.tps.sample.entity.User;
import com.tps.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// ユーザDAOのクラス
	@Resource
	private UserDao userDao;

	@Override
	public int join(UserDto userDto) {
		User user = new User();
		// userDtoのデータをuserにコピー。
		BeanUtils.copyProperties(userDto, user);

		return userDao.insertUser(user);
	}

	@Override
	public UserDto findUser(LoginUserDto loginUserDto) {
		User user = new User();
		// loginUserDtoのデータをuserに入れる。
		BeanUtils.copyProperties(loginUserDto, user);
		// ログインユーザの情報でユーザを検索し、userの情報を入れ替える。
		user = userDao.selectByLoginUser(user);
		UserDto userDto = null;

		if (user != null) {
			userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
		}

		return userDto;
	}

	@Override
	public UserDto findUser(String id) {
		User user = userDao.selectByUserId(id);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);

		return userDto;
	}

	@Override
	public int modify(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		return userDao.updateUser(user);
	}
}
