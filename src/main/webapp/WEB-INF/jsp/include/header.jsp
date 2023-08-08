<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="d-flex align-items-center justify-content-between">

		<h1 class="ml-3">Memo</h1>
		<%-- 세션에 userId 값이 있으면 사용자 정보 태그 포함 --%>
		<c:if test="${not empty userId }">
		<div class="mr-5">${userName }<a href="/user/logout"> 로그아웃</a>
		</div>
		</c:if>
	</header>
</body>
</html>