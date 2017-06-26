<title>ユーザ修正</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
<sx:head/>
<script type="text/javascript">
$(function() {
	$(":submit").click(function(event) {
		event.preventDefault();
		var password = $("#password").val();
		var name = $("#name").val();
		var checkPassword = $("#check-password").val();

		if (password && name && password == checkPassword) {
			$("form").submit();
		}
	});

	$(":input").keyup(function() {
		var password = $("#password").val();
		var name = $("#name").val();
		var checkPassword = $("#check-password").val();

		if (password && name && password == checkPassword) {
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
                <div class="panel-heading text-center">TPSダイアリー</div>
                <s:form action="modify_user">
                <div class="panel-body">
                	<div class="form-group">
                		<div class="alert alert-success" id="alert">パスワード、名前は必須入力項目です。</div>
						<s:label value="ユーザID"/>
						<s:textfield name="userDto.id" label="ユーザID" cssClass="form-control" readonly="true" id="id"/>
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
						<s:label cssClass="radio-inline"><s:radio list="#{'M': '&nbsp;男', 'Y': '&nbsp;女'}" name="userDto.gender"/></s:label>
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
                    <s:submit value="修正" cssClass="btn btn-success disabled"/>
                    <a href="<c:url value='javascript:history.back()'/>" class="btn btn-default">戻る</a>
                </div>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>