<title>日記詳細</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp"%>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="panel panel-success">
				<div class="panel-heading text-center">TPSダイアリー</div>
				<div class="panel-body">
					<table class="table">
					<s:iterator value="diaryDtoList" status="no">
					<s:form action="modify_diary_init" method="GET">
						<thead>
							<tr class="success">
								<th><h4><s:date name="regdate" format="yyyy/MM/dd"/>:&nbsp;<s:property value="title"/></h4></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="contents"><s:property escapeHtml="false" value="contents.replaceAll('\n', '<br>')"/></td>
							</tr>
							<tr>
								<td>
									<s:submit value="修正" cssClass="btn btn-default"/>
									<s:hidden name="diaryNo" value="%{#no.count}"/>
									<s:hidden name="year"/>
									<s:hidden name="month"/>
								</td>
							</tr>
						</tbody>
					</s:form>
					</s:iterator>
					</table>
					<hr>
					<p class="text-right"><a href="<c:url value='category'/>" class="btn btn-default">リストへ戻る</a></p>
				</div>
				<!-- 1月と12月は、先月と来月が活性化しないように処理。  -->
				<div class="panel-footer text-center">
				<s:if test="month == 1">
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month-1'/>" class="btn btn-default disabled">先月</a>
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month+1'/>" class="btn btn-default">来月</a>
				</s:if>
				<s:elseif test="month == 12">
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month-1'/>" class="btn btn-default">先月</a>
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month+1'/>" class="btn btn-default disabled">来月</a>
				</s:elseif>
				<s:else>
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month-1'/>" class="btn btn-default">先月</a>
					<a href="<c:url value='diary_detail?year='/><s:property value='year'/>
						<c:url value='&month='/><s:property value='month+1'/>" class="btn btn-default">来月</a>
				</s:else>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>