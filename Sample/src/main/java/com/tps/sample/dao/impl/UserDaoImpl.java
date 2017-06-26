package com.tps.sample.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.sample.dao.UserDao;
import com.tps.sample.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	// Sqlセッション
	private SqlSession sqlSession;
	/**
	 * <pre>
	 * 1. 概要 :SqlセッションのSetter
	 * 2. 処理内容 :Sqlセッションを作成時に設定する。
	 * </pre>
	 * @Method Name : setSqlSession
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param sqlSession
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertUser(User user) {
		return sqlSession.insert("insertUser", user);
	}

	@Override
	public User selectByLoginUser(User user) {
		return sqlSession.selectOne("selectByLoginUser", user);
	}

	@Override
	public User selectByUserId(String id) {
		return sqlSession.selectOne("selectByUserId", id);
	}

	@Override
	public int updateUser(User user) {
		return sqlSession.update("updateUser", user);
	}
}
