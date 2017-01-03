<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
	alert("관리자만 거래 가능합니다.");
	location.href="${pageContext.request.contextPath}/user/mypage.shop?id=${USER.userId}";
	// 위에 콘텍스트 그냥 ../user/loginForm.shop 으로 해도 상관없음.
</script>