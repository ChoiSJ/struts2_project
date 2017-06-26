<title>ログイン</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<div class="panel panel-success">
				<div class="panel-heading text-center">TPSダイアリー</div>
				<s:form action="login">
				<div class="panel-body">
					<div class="form-group">
						<s:label value="ユーザID"/>
						<s:textfield name="loginUserDto.id" label="ユーザID" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<s:label value="パスワード"/>
						<s:password name="loginUserDto.password" label="パスワード" cssClass="form-control"/>
					</div>
				</div>
				<div class="panel-footer text-right">
					<s:submit value="ログイン" cssClass="btn btn-default"/>
					<a href="<c:url value='/create_user_init'/>" class="btn btn-default">ユーザ作成</a>
				</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>