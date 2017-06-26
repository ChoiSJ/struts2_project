<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
<style>
th, td {
	text-align: center;
}

.panel-body {
	overflow: auto;
	height: 300px;
}
</style>
<script type="text/javascript">
$(function() {
	// 年を押下したら、該当する年で登録した月がすべて表示される。
	$("td[id^='year']").click(function() {
		if ($("td[class='success']")) {
			$("td[class='success']").removeClass("success");
		}

		$(this).toggleClass("success");
		var year = $(this).text();

		$.ajax({
			url: "<s:url action='ajax_find_month'/>?year=" + year,
			type: "GET",
			dataType: "json",
			success: function(result) {
				if (result) {
					$("td:odd").text("").removeAttr("id");

					$("tbody td:even").each(function(index, item) {
						if (!$(item).text()) {
							$(item).parent().remove();
						}
					});

					for (var i=0; i<result.length; i++) {
						if ($("tbody").find("td:eq(" + (2 * i) + ")").text()) {
							$("td:eq(" + ((2 * i) + 1) + ")").text(result[i]).attr("id", "month-" + result[i]);
						} else {
							var tr = "<tr><td></td><td id='month-" + result[i] + "'>" + result[i] + "</td></tr>";
							$("tbody").append(tr);
						}
					}
				}
			}
		});
	});

	// 月を押下したら、さっき押下した年と、今押下した月を元に検索し、結果の詳細ページに移動する。
	$("tbody").on("click", "td[id^='month']", function() {
		var year = $("td:even[class='success']").text();
		var month = $(this).text();
		location.href = "<s:url action='diary_detail'/>?year=" + year + "&month=" + month;
	});
})
</script>
<div class="container">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<div class="panel panel-success">
				<div class="panel-heading text-center">TPSダイアリー</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
					<thead>
						<tr>
							<th>年</th>
							<th>月</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="yearListView">
						<tr>
							<td id="year-<s:property/>"><s:property/></td>
							<td></td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
				</div>
				<div class="panel-footer text-right">
					<a href="<c:url value='modify_user_init'/>" class="btn btn-default">ユーザ情報修正</a>
					<a href="<c:url value='create_diary_init'/>" class="btn btn-default">日記作成</a>
					<a href="<c:url value='logout'/>" class="btn btn-default">ログアウト</a>
				</div>
			</div>
		</div>
	</div>
</div>