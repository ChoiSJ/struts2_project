package com.tps.sample.service;

import java.util.List;

import com.tps.sample.dto.DiaryDto;
import com.tps.sample.entity.DiaryCategory;

public interface DiaryService {

	/**
	 * <pre>
	 * 1. 概要 ：ダイアリーを登録。
	 * 2. 処理内容 :ユーザIDで該当ユーザを検索し、ダイアリーを登録する。
	 * </pre>
	 * @Method Name : upload
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun			新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param diaryDto
	 * @param id
	 * @return
	 */
	public int upload(DiaryDto diaryDto, String id);
	/**
	 * <pre>
	 * 1. 概要 :カテゴリーの登録。
	 * 2. 処理内容 :カテゴリー（年と月）を登録する。
	 * </pre>
	 * @Method Name : uploadCategory
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @return
	 */
	public int uploadCategory(String id);
	/**
	 * <pre>
	 * 1. 概要 :年を取得。
	 * 2. 処理内容 :ユーザIDでダイアリーの作成年度を取得する。
	 * </pre>
	 * @Method Name : findYear
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @return
	 */
	public List<Integer> findYear(String id);
	/**
	 * <pre>
	 * 1. 概要 :月を取得。
	 * 2. 処理内容 :ユーザIDと年で作成月を取得する。
	 * </pre>
	 * @Method Name : findMonth
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @param year
	 * @return
	 */
	public List<Integer> findMonth(String id, Integer year);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを取得。
	 * 2. 処理内容 :ユーザIDと年、月でダイアリーのリストを取得する。
	 * </pre>
	 * @Method Name : findDiary
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @param year
	 * @param month
	 * @return
	 */
	public List<DiaryDto> findDiary(String id, int year, int month);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを取得。
	 * 2. 処理内容 :ユーザIDと画面のダイアリー番号、カテゴリー（年と月）でダイアリーを取得する。
	 * </pre>
	 * @Method Name : findDiary
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @param diaryNo
	 * @param diaryCategory
	 * @return
	 */
	public DiaryDto findDiary(String id, int diaryNo, DiaryCategory diaryCategory);
	/**
	 * <pre>
	 * 1. 概要 :ダイアリーを修正。
	 * 2. 処理内容 :ダイアリーを修正する。
	 * </pre>
	 * @Method Name : modify
	 * @date : 2017/06/19
	 * @author : c-seungjun
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	更新日				作成者						更新内容
	 *	----------- ------------------- ---------------------------------------
	 *	2017/06/19		c-seungjun				新規作成
	 *	-----------------------------------------------------------------------
	 *
	 * @param id
	 * @param diaryNo
	 * @param diaryCategory
	 * @param diaryDto
	 * @return
	 */
	public int modify(String id, int diaryNo, DiaryCategory diaryCategory, DiaryDto diaryDto);
}
