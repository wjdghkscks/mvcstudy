<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	
	<c:when test="${result > 0 }">
		<script>
			alert("방명록 작성이 완료되었습니다.");
			location.href="/MyController?cmd=list";
		</script>
	</c:when>
	
	<c:otherwise>
		<script>
			alert("오류가 발생했습니다. 다시 시도해주세요.");
			location.href="/MyController?cmd=write";
		</script>
	</c:otherwise>
	
</c:choose>

