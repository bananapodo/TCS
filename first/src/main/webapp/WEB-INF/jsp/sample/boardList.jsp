<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div id="header">
		<div class="dropdown">
			Project Name
			<button id="dLabel" type="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list }" var="row">
							<tr>
								<li><a href="#this" name="title">${row.project_name }</a> <input
									type="hidden" id="project_key" value="${row.project_key }">
								</li>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>등록된 프로젝트가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</ul>

			<a href="#thiss" class="btn" name="btn" id="write">add</a>

		</div>


		<h2>LIST</h2>

		<table class="board_list">

			<thead>
				<tr align=center>
					<th>No</th>
					<th>project name</th>
					<th>project key</th>
					<th>저장 형식</th>
					<th>저장 주소</th>
					<th>오픈일</th>
					<th>마감일</th>
					<!-- 		<th>items</th> -->
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list }" var="row">
							<tr>
								<td>${row.SEQ }</td>
								<td class="title"><a href="#this" name="title">${row.project_name }</a>
									<input type="hidden" id="project_key"
									value="${row.project_key }"></td>
								<td>${row.project_key }</td>
								<td>${row.save_type }</td>
								<td>${row.save_path }</td>
								<td>${row.open_date }</td>
								<td>${row.close_date }</td>
								<%-- 					<td>${row.items }</td> --%>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8">등록된 프로젝트가 없습니다</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
		<br />
		<p>


			<%@ include file="/WEB-INF/include/include-body.jspf"%>
			<script type="text/javascript">
				$(document).ready(function() {
					$("a[name='title']").on("click", function(e) { //제목 
						e.preventDefault();
						fn_openBoardDetail($(this));
					});
				});

				$(document).ready(function() {
					$("a[name='btn']").on("click", function(e) { //제목 
						e.preventDefault();
						fn_buttonClick();
					});
				});

				function fn_buttonClick() {
					var comSubmit = new ComSubmit();
					comSubmit
							.setUrl("<c:url value='/sample/buttonClick.do' />");
					comSubmit.submit();
				}

				function fn_openBoardDetail(obj) {
					var comSubmit = new ComSubmit();
					comSubmit
							.setUrl("<c:url value='/sample/openBoardDetail.do' />");
					comSubmit.addParam("project_key", obj.parent().find(
							"#project_key").val());
					comSubmit.submit();
				}
			</script>
</body>
</html>
