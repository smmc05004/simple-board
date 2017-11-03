<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Board List</h1>
	
	<table class="table table-condensed">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty boards }">
				<c:forEach var="board" items="${boards }">
					<tr>
						<td>${board.no }</td>
						<!-- 사용자가 입력하는 내용에는 반드시 c:out으로 입력 필 -->
						<td><a href="detail.do?no=${board.no }"><c:out value="${board.title }" /></a></td>
						<td><fmt:formatDate value="${board.createdate }" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td colspan="3">게시글이 존재하지 않습니다.</td>			
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<div class="text-right">
		<a href="form.do" class="btn btn-sm btn-primary ">Add</a>
	</div>
</div>
</body>
</html>