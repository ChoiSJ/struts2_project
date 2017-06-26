package com.tps.sample.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.sample.dao.DiaryDao;
import com.tps.sample.dao.UserDao;
import com.tps.sample.dto.DiaryDto;
import com.tps.sample.entity.Diary;
import com.tps.sample.entity.DiaryCategory;
import com.tps.sample.entity.User;
import com.tps.sample.service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {

	// ダイアリーのDAOクラス。
	@Resource
	private DiaryDao diaryDao;
	// ユーザのDAOクラス。
	@Resource
	private UserDao userDao;

	@Override
	public int upload(DiaryDto diaryDto, String id) {
		Diary diary = new Diary();
		BeanUtils.copyProperties(diaryDto, diary);
		User user = userDao.selectByUserId(id);
		diary.setUser(user);

		// 登録しようとするダイアリーに日付が含まれていない場合。
		if (diary.getRegdate() == null) {
			diary.setRegdate(new Date());
		}

		return diaryDao.insertDiary(diary);
	}

	@Override
	public int uploadCategory(String id) {
		User user = userDao.selectByUserId(id);
		// さっき登録したダイアリーを呼び出す。
		Diary diary = diaryDao.selectDiaryOneRowByUser(user);
		DiaryCategory diaryCategory = new DiaryCategory();
		// カテゴリーに登録するために日付から年と月を分離して格納。
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(diary.getRegdate());
		diaryCategory.setYear(calendar.get(Calendar.YEAR));
		diaryCategory.setMonth(calendar.get(Calendar.MONTH) + 1);
		diaryCategory.setDiary(diary);

		return diaryDao.insertDiaryCategory(diaryCategory);
	}

	@Override
	public List<Integer> findYear(String id) {
		User user = userDao.selectByUserId(id);

		return diaryDao.selectYearByUserNo(user.getNo());
	}

	@Override
	public List<Integer> findMonth(String id, Integer year) {
		User user = userDao.selectByUserId(id);
		// 検索用の変数をMapに格納。
		Map<String, Object> userNoAndYear = new HashMap<String, Object>();
		userNoAndYear.put("userNo", user.getNo());
		userNoAndYear.put("year", year);

		return diaryDao.selectMonthByUserNoAndYear(userNoAndYear);
	}

	@Override
	public List<DiaryDto> findDiary(String id, int year, int month) {
		User user = userDao.selectByUserId(id);
		// 検索用の変数をMapに格納。
		Map<String, Object> userNoAndCategory = new HashMap<String, Object>();
		userNoAndCategory.put("userNo", user.getNo());
		// Mapに年と月をカテゴリーに入れて格納。
		DiaryCategory diaryCategory = new DiaryCategory();
		diaryCategory.setYear(year);
		diaryCategory.setMonth(month);
		userNoAndCategory.put("diaryCategory", diaryCategory);
		List<Diary> diaryList = diaryDao.selectDiaryByUserNoAndCategory(userNoAndCategory);
		List<DiaryDto> diaryDtoList = new ArrayList<DiaryDto>();

		// diaryListのデータをdiaryDtoListに入れる。
		for (Diary diary : diaryList) {
			DiaryDto diaryDto = new DiaryDto();
			BeanUtils.copyProperties(diary, diaryDto);
			diaryDtoList.add(diaryDto);
		}

		return diaryDtoList;
	}

	@Override
	public DiaryDto findDiary(String id, int diaryNo, DiaryCategory diaryCategory) {
		User user = userDao.selectByUserId(id);
		Map<String, Object> userNoAndCategory = new HashMap<String, Object>();
		userNoAndCategory.put("userNo", user.getNo());
		userNoAndCategory.put("diaryCategory", diaryCategory);
		List<Diary> diaryList = diaryDao.selectDiaryByUserNoAndCategory(userNoAndCategory);
		Diary diary = new Diary();

		// diaryListのデータから、diaryNoの番号と一致するダイアリーを探して格納。
		for (int i=0; i<diaryList.size(); i++) {
			if (diaryNo == i+1) {
				diary = diaryList.get(i);
			}
		}

		DiaryDto diaryDto = new DiaryDto();
		BeanUtils.copyProperties(diary, diaryDto);

		return diaryDto;
	}

	@Override
	public int modify(String id, int diaryNo, DiaryCategory diaryCategory,
			DiaryDto diaryDto) {
		User user = userDao.selectByUserId(id);
		Map<String, Object> userNoAndCategory = new HashMap<String, Object>();
		userNoAndCategory.put("userNo", user.getNo());
		userNoAndCategory.put("diaryCategory", diaryCategory);
		List<Diary> diaryList = diaryDao.selectDiaryByUserNoAndCategory(userNoAndCategory);
		Diary diary = new Diary();
		BeanUtils.copyProperties(diaryDto, diary);

		// diaryListの順序とdiaryNoの数字が一致した場合、その順序に該当するListのデータにデータベースから取得したnoを格納する。
		for (int i=0; i<diaryList.size(); i++) {
			if (diaryNo == i+1) {
				diary.setNo(diaryList.get(i).getNo());
			}
		}

		return diaryDao.updateDiary(diary);
	}
}
