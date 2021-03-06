<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>

<h2>로그인</h2>
<form:form modelAttribute="user" method="post" action="login.shop">
<spring:hasBindErrors name="user">
<font color="red">
	<c:forEach items="${errors.globalErrors }" var="error">
		<sprint:message code="${error.code }" />
	</c:forEach>
</font>
</spring:hasBindErrors>
<table>
	<tr>
		<td>아이디</td><td><form:input path="userId" /><font color="red"><form:errors path="userId" /></font></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><form:password path="password" /><font color="red"><form:errors path="password" /></font></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='userEntryForm.shop'">
		</td>
	</tr>
</table>


</form:form>

</body>
</html>