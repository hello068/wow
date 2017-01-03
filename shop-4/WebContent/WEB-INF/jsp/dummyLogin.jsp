<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
	alert("로그인 후 거래 가능합니다.");
	location.href="${pageContext.request.contextPath}/user/loginForm.shop";
	// 위에 콘텍스트 그냥 ../user/loginForm.shop 으로 해도 상관없음.
</script>