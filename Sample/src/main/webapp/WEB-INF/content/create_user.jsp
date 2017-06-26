<title>ユーザ作成</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
<sx:head/>
<script type="text/javascript">
$(function() {
	// 条件を満たして作成ボタンが活性化されたとき、ボタンでsubmitできるようになる。
	$(":submit").click(function(event) {
		event.preventDefault();
		var id = $("#id").val();
		var password = $("#password").val();
		var name = $("#name").val();
		var checkPassword = $("#check-password").val();

		if (id && password && name && password == checkPassword) {
			$("form").submit();
		}
	});

	// 必須入力事項をチェックし、全部入力された場合にのみ作成ボタンが活性化される。
	$(":input").keyup(function() {
		var id = $("#id").val();
		var password = $("#password").val();
		var name = $("#name").val();
		var checkPassword = $("#check-password").val();

		if (id && password && name && password == checkPassword) {
			$(":submit").attr("class", "btn btn-success");
		} else {
			$(":submit").attr("class", "btn btn-success disabled");
		}
	});

	$(":input[id*='password']").on("paste", function() {
		return false;
	});
})
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<div class="panel panel-success">
				<div class="panel-heading text-center">ユーザ作成</div>
				<s:form action="create_user">
				<div class="panel-body">
					<div class="form-group">
						<div class="alert alert-success" id="alert">ユーザID、パスワード、名前は必須入力項目です。</div>
						<s:label value="ユーザID"/>
						<s:textfield name="userDto.id" label="ユーザID" cssClass="form-control" id="id"/>
					</div>
					<div class="form-group">
						<s:label value="パスワード"/>
						<s:password name="userDto.password" label="パスワード" cssClass="form-control" id="password"/>
					</div>
					<div class="form-group">
						<s:label value="もう一度パスワードを入力してください"/>
						<s:password label="パスワード確認" cssClass="form-control" id="check-password"/>
					</div>
					<div class="form-group">
						<s:label value="名前"/>
						<s:textfield name="userDto.name" label="名前" cssClass="form-control" id="name"/>
					</div>
					<div class="form-group">
						<s:label value="性別"/><br>
						<s:label cssClass="radio-inline"><s:radio list="#{'M': '&nbsp;男&nbsp;', 'Y': '&nbsp;女'}" name="userDto.gender" value="'M'" id="gender"/></s:label>
					</div>
					<div class="form-group">
						<s:label value="Eメールアドレス"/>
						<s:textfield name="userDto.email" label="Eメールアドレス" cssClass="form-control"/>
					</div>
					<div class="form-inline form-group">
						<s:label value="誕生日"/><br>
						<sx:datetimepicker name="userDto.birth" displayFormat="yyyy/MM/dd" cssClass="form-control"/>
					</div>
				</div>
				<div class="panel-footer text-right">
					<s:submit value="アカウント作成" cssClass="btn btn-success disabled"/>
					<a href="<c:url value='javascript:history.back()'/>" class="btn btn-default">戻る</a>
				</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>