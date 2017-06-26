package com.tps.sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tps.sample.service.DiaryService;
import com.tps.sample.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name="success", type="json", params={"root", "monthList"})
})
public class AjaxAction extends ActionSupport {

	// ユーザサービス
	@Resource
	private UserService userService;
	// ダイアリーサービス
	@Resource
	private DiaryService diaryService;
	// 検索ワード（年）
	private Integer year;
	/**
	 * 年を取得します。
	 * @return year
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 年を設定します。
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	// 検索結果（月リスト）
	private List<Integer> monthList;
	/**
	 * 月リストを取得します。
	 * @return monthList
	 */
	public List<Integer> getMonthList() {
		return monthList;
	}

	/**
	 * 該当年で登録している月を検索
	 * @return monthList
	 */
	@Action("/ajax_find_month")
	public String ajaxFindMonth() {
		String userId = (String) ActionContext.getContext().getSession().get("LOGINED_USER");
		monthList = diaryService.findMonth(userId, year);

		return "success";
	}
}
