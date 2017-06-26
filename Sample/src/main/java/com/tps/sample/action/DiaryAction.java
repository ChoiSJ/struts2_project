package com.tps.sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tps.sample.dto.DiaryDto;
import com.tps.sample.entity.DiaryCategory;
import com.tps.sample.service.DiaryService;
import com.tps.sample.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name="createDiaryInit", location="create_diary.jsp"),
	@Result(name="category", location="category.tiles", type="tiles"),
	@Result(name="diaryDetail", location="diary_detail.jsp"),
	@Result(name="createdDiary", location="category", type="redirect"),
	@Result(name="modifyDiary", location="modify_diary.jsp"),
	@Result(name="modifiedDiary", location="category", type="redirect")
})
public class DiaryAction extends ActionSupport {

	// ユーザサービス
	@Resource
	private UserService userService;
	// ダイアリーサービス
	@Resource
	private DiaryService diaryService;
	// 画面：ダイアリー情報
	private DiaryDto diaryDto;
	/**
	 * ダイアリー情報を取得します。
	 * @return diaryDto
	 */
	public DiaryDto getDiaryDto() {
		return diaryDto;
	}
	/**
	 * ダイアリー情報を設定します。
	 * @param diaryDto
	 */
	public void setDiaryDto(DiaryDto diaryDto) {
		this.diaryDto = diaryDto;
	}

	/**
	 * 画面：ダイアリーリスト情報
	 */
	private List<DiaryDto> diaryDtoList;
	/**
	 * ダイアリーリスト情報を取得します。
	 * @return diaryDtoList
	 */
	public List<DiaryDto> getDiaryDtoList() {
		return diaryDtoList;
	}
	/**
	 * ダイアリーリスト情報を設定します。
	 * @param diaryDtoList
	 */
	public void setDiaryDtoList(List<DiaryDto> diaryDtoList) {
		this.diaryDtoList = diaryDtoList;
	}

	/**
	 * 検索ワード（年）
	 */
	private int year;
	/**
	 * 年を取得します。
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * 年を設定します。
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 検索ワード（月）
	 */
	private int month;
	/**
	 * 月を取得します
	 * @return month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * 月を設定します。
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 検索結果（年リスト）
	 */
	private List<Integer> yearListView;
	/**
	 * 年リストを取得します。
	 * @return yearListView
	 */
	public List<Integer> getYearListView() {
		return yearListView;
	}
	/**
	 * 年リストを設定します。
	 * @param yearListView
	 */
	public void setYearView(List<Integer> yearListView) {
		this.yearListView = yearListView;
	}

	/**
	 * ダイアリーの順番
	 */
	private int diaryNo;
	/**
	 * 順番を取得します。
	 * @return diaryNo
	 */
	public int getDiaryNo() {
		return diaryNo;
	}
	/**
	 * 順番を設定します。
	 * @param diaryNo
	 */
	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	/**
	 * ダイアリー作成の初期画面に移動。
	 * @return
	 */
	@Action("/create_diary_init")
	public String createDiaryInit() {
		return "createDiaryInit";
	}

	/**
	 * ダイアリーを作成する。
	 * @return
	 */
	@Action("/create_diary")
	public String createDiary() {
		// セッションからユーザのIDを取得。
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		// ダイアリーを作成。
		diaryService.upload(diaryDto, userId);
		// ダイアリーのカテゴリー（年、月）を登録。
		diaryService.uploadCategory(userId);

		return "createdDiary";
	}

	/**
	 * ダイアリーの詳細情報を表示。
	 * @return
	 */
	@Action("/diary_detail")
	public String diaryDetail() {
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		// ダイアリーを検索
		diaryDtoList = diaryService.findDiary(userId, year, month);

		for (int i=0; i<diaryDtoList.size(); i++) {
			String contents = diaryDtoList.get(i).getContents().replaceAll(" ", "&nbsp;");
			diaryDtoList.get(i).setContents(contents);
		}

		// 年を設定
		setYear(year);
		// 月を設定
		setMonth(month);

		return "diaryDetail";
	}

	/**
	 * ログイン成功時、該当ユーザのダイアリーから年の情報だけ検索し、それを画面に表示。
	 * @return
	 */
	@Action("/category")
	public String category() {
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		yearListView = diaryService.findYear(userId);

		return "category";
	}

	/**
	 * ダイアリー修正の初期画面に移動。
	 * @return
	 */
	@Action("/modify_diary_init")
	public String modifyDiaryInit() {
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		DiaryCategory diaryCategory = new DiaryCategory();
		diaryCategory.setYear(year);
		diaryCategory.setMonth(month);
		// 初期画面に表示させるためのダイアリーを検索。
		DiaryDto diaryDto = diaryService.findDiary(userId, diaryNo, diaryCategory);
		// ダイアリー情報を設定。
		setDiaryDto(diaryDto);
		setDiaryNo(diaryNo);
		setYear(year);
		setMonth(month);

		return "modifyDiary";
	}

	/**
	 * ダイアリーを修正。
	 * @return
	 */
	@Action("/modify_diary")
	public String modifyDiary() {
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		DiaryCategory diaryCategory = new DiaryCategory();
		diaryCategory.setYear(year);
		diaryCategory.setMonth(month);
		diaryService.modify(userId, diaryNo, diaryCategory, diaryDto);

		return "modifiedDiary";
	}
}
