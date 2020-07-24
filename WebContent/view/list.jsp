<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title> 방명록 </title>

<link rel="stylesheet" type="text/css" href="view/mystyle.css">

</head>

<body>

	<h2>방명록</h2>
	<hr>
	<div class="link">
		<a href="/MyController?cmd=write">[방명록 작성]</a>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
						<tr><td colspan="4"><p>자료가 존재하지 않습니다.</p></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${list}" varStatus="vs">
							<tr>
								<td>${vs.count}</td>
								<td>${k.name}</td>
								<td> <a href="/MyController?cmd=onelist&idx=${k.idx}">${k.subject}</a> </td>
								<td>${k.regdate.substring(0, 10)}</td>
							</tr>						
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
</body>
</html>