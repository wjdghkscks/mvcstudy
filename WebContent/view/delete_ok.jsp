<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>

	<c:when test="${result > 0}">
		<script>
			alert("데이터가 성공적으로 삭제되었습니다.");
			location.href="/MyController?cmd=list";
		</script>
	</c:when>
	
	<c:otherwise>
		<script>
			alert("데이터 삭제에 실패했습니다.\n다시 시도해주세요.")
			history.go(-2);
		</script>
	</c:otherwise>
	
</c:choose>