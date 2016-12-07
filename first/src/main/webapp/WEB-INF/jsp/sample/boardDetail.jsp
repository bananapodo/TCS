<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<div id="header">
<div class="dropdown"> Project Name
  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
  <c:choose>
			<c:when test="${fn:length(list) > 0}">
				<c:forEach items="${list }" var="row">
					<tr>
						    <li>
                                <a href="#this" name="title">${row.project_name }</a>
                                <input type="hidden" id="project_key" value="${row.project_key }">
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
  </div>
<body>
	<table class="board_list">

		<h2>detail</h2>
			<thead>
		<tr>
			<th>No</th>
			<th>project name</th>
			<th>project key</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>이메일 등록수신</th>
			<th>이메일 자동</th>
			<th>SNS</th>
			<th>SNS 수신여부</th>
			<th>SNS 자동</th>
			<th>사진이름</th>
			<th>이메일전송</th>
			<th>전송시간</th>
		</tr>
	</thead>
		<tbody>
					<c:choose>
			<c:when test="${fn:length(map) > 0}">
				<c:forEach items="${map}" var="row">
					<tr>
						<td>${row.seq}</td>
 						<td>${row.project_name }</td> 
						<td>${row.project_key }</td>
						<td>${row.first_name }</td>
						<td>${row.last_name }</td>
						<td>${row.email_addr }</td>
						<td>${row.email_agree }</td>
						<td>${row.email_auto }</td>
						<td>${row.sns_addr }</td>
						<td>${row.sns_agree }</td>
						<td>${row.sns_auto }</td>
						<td>${row.img_name }</td>
						<td class="title">
                                <a href="#this" name="mail"> 보내기 </a>
                                <input type="hidden" id="email_addr" value="${row.email_addr }">
                                <input type="hidden" id="project_key" value="${row.project_key }"> 
                                <input type="hidden" id="seq" value="${row.seq }">                               
                            </td>
                        <td>${row.email_date }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>		
			
		</tbody>
	</table>
	
	<a href="#this" class="btn" id="list">목록으로</a>

	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
		});
	
		$(document).ready(function(){
			$("a[name='mail']").on("click", function(e){ //제목 
				e.preventDefault();
				fn_mailSend($(this));
			});
		});
		
		$(document).ready(function(){
			$("a[name='title']").on("click", function(e){ //제목 
				e.preventDefault();
				fn_openBoardDetail($(this));
			});
		});

		function fn_openBoardDetail(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/openBoardDetail.do' />");
			comSubmit.addParam("project_key", obj.parent().find("#project_key").val());
			comSubmit.submit();
		}
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/openSampleBoardList.do' />");
			comSubmit.submit();
		}
		
		function fn_mailSend(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/sendMailBox.do' />");
			comSubmit.addParam("email_addr", obj.parent().find("#email_addr").val());
			comSubmit.addParam("project_key", obj.parent().find("#project_key").val());
			comSubmit.addParam("seq", obj.parent().find("#seq").val())
			comSubmit.submit();
		}
		
	</script>
</body>
</html>