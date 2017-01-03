<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 삭제</title>
</head>
<body>

<form name="deleteform" action="delete.shop" method="post">
	<input type="hidden" name="num" value="${param.num } ">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>게시글 비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:document.deleteform.submit()">[삭제]</a>
				<a href="list.shop">[목록]</a>
			</td>
		</tr>
	</table>
</form>

</body>
</html>