package com.tps.sample.dao;

import java.util.List;
import java.util.Map;

import com.tps.sample.entity.Diary;
import com.tps.sample.entity.DiaryCategory;
import com.tps.sample.entity.User;

public interface DiaryDao {

	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを登録。
	 * 2. 処理内容 :ダイアリーを登録する。
	 * </pre>
	 * @Method Name : insertDiary
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param diary
	 * @return
	 */
	public int insertDiary(Diary diary);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリー作成時、そのダイアリーの年と月を入力するために使用する。
	 * 2. 処理内容 ：作成し終わったダイアリーを呼び出す。
	 * </pre>
	 * @Method Name : selectDiaryOneRowByUser
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param user
	 * @return
	 */
	public Diary selectDiaryOneRowByUser(User user);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーの年と月を登録。
	 * 2. 処理内容 :ダイアリーの登録日付から年を月を取り、カテゴリーに登録。
	 * </pre>
	 * @Method Name : insertDiaryCategory
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param diaryCategory
	 * @return
	 */
	public int insertDiaryCategory(DiaryCategory diaryCategory);
	/**
	 * <pre>
	 * 1. 概要 :年を取得。
	 * 2. 処理内容 :ユーザ番号でダイアリーの作成年度だけを取得する。
	 * </pre>
	 * @Method Name : selectYearByUserNo
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param userNo
	 * @return
	 */
	public List<Integer> selectYearByUserNo(Integer userNo);
	/**
	 * <pre>
	 * 1. 概要 :月を取得。
	 * 2. 処理内容 :ユーザ番号と年でダイアリーの作成月を取得する。
	 * </pre>
	 * @Method Name : selectMonthByUserNoAndYear
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param userNoAndYear
	 * @return
	 */
	public List<Integer> selectMonthByUserNoAndYear(Map<String, Object> userNoAndYear);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを取得。
	 * 2. 処理内容 :ユーザ番号とカテゴリー情報でダイアリーを取得する。
	 * </pre>
	 * @Method Name : selectDiaryByUserNoAndCategory
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param userNoAndCategory
	 * @return
	 */
	public List<Diary> selectDiaryByUserNoAndCategory(Map<String, Object> userNoAndCategory);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを修正。
	 * 2. 処理内容 :ダイアリーを修正する。
	 * </pre>
	 * @Method Name : updateDiary
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param diary
	 * @return
	 */
	public int updateDiary(Diary diary);
}
