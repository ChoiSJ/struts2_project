package com.tps.sample.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.sample.dao.DiaryDao;
import com.tps.sample.entity.Diary;
import com.tps.sample.entity.DiaryCategory;
import com.tps.sample.entity.User;

public class DiaryDaoImpl extends SqlSessionDaoSupport implements DiaryDao {

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
	public int insertDiary(Diary diary) {
		return sqlSession.insert("insertDiary", diary);
	}

	@Override
	public Diary selectDiaryOneRowByUser(User user) {
		return sqlSession.selectOne("selectDiaryOneRowByUser", user);
	}

	@Override
	public int insertDiaryCategory(DiaryCategory diaryCategory) {
		return sqlSession.insert("insertDiaryCategory", diaryCategory);
	}

	@Override
	public List<Integer> selectYearByUserNo(Integer userNo) {
		return sqlSession.selectList("selectYearByUserNo", userNo);
	}

	@Override
	public List<Integer> selectMonthByUserNoAndYear(Map<String, Object> userNoAndYear) {
		return sqlSession.selectList("selectMonthByUserNoAndYear", userNoAndYear);
	}

	@Override
	public List<Diary> selectDiaryByUserNoAndCategory(
			Map<String, Object> userNoAndCategory) {
		return sqlSession.selectList("selectDiaryByUserNoAndCategory", userNoAndCategory);
	}

	@Override
	public int updateDiary(Diary diary) {
		return sqlSession.update("updateDiary", diary);
	}
}
