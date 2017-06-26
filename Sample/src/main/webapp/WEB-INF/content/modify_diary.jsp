<title>日記修正</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
<sx:head/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <div class="panel panel-success">
                <div class="panel-heading text-center">TPSダイアリー</div>
                <s:form action="modify_diary">
                <div class="panel-body">
                    <div class="form-group">
                    	<s:label value="タイトル"/>
                    	<s:textfield name="diaryDto.title" label="タイトル" cssClass="form-control" placeholder="タイトルを入力してください。"/>
                    </div>
                    <div class="form-group">
                    	<s:label value="内容"/>
                    	<s:textarea name="diaryDto.contents" label="内容" cssClass="form-control" rows="5" maxlength="10000" placeholder="内容を入力してください。"/>
                    </div>
                    <div class="form-inline form-group">
                    	<s:label value="日付"/><br>
                    	<sx:datetimepicker name="diaryDto.regdate" displayFormat="yyyy/MM/dd" cssClass="form-control"/>
                    </div>
                </div>
                <div class="panel-footer text-right">
                	<s:submit value="修正" cssClass="btn btn-default"/>
                	<s:hidden name="diaryNo"/>
                	<s:hidden name="year"/>
                	<s:hidden name="month"/>
                	<a href="<c:url value='javascript:history.back()'/>" class="btn btn-default">戻る</a>
                </div>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>