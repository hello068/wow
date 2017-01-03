<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><decorator:title /></title>
<decorator:head />
</head>
<body>

<table border="1" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3" align="right">
			<c:if test="${empty USER }">
							<a href="${path}/user/loginForm.shop">로그인</a>
			</c:if>
			<c:if test="${not empty USER}">
				<c:if test="${USER.userId == 'admin'}">
					<a href="${path}/user/admin.shop">관리자</a>
					<a href="${path}/user/mypage.shop?id=${USER.userId}">마이페이지</a>
					<a href="${path}/user/logout.shop">로그아웃</a>
				</c:if>
				<c:if test="${USER.userId != 'admin'}">
					환영합니다. ${USER.userName} 님
					<a href="${path}/user/mypage.shop?id=${USER.userId}">마이페이지</a>
					<a href="${path}/user/logout.shop">로그아웃</a>
				</c:if>
			</c:if> <%-- 로그인 부분 --%>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right" valign="top">
			<br>
			<a href="${path}/item/list.shop">상품관리</a><br>
			<a href="${path}/board/list.shop">게시판</a><br>
			<a href="${path}/cart/cartView.shop">장바구니</a><br>
		</td>
		<td colspan="2"><decorator:body /></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
			스프링 배우기 2016
		</td>
	</tr>
</table>




</body>
</html>























