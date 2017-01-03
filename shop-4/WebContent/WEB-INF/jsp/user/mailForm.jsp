<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메일 보내기</title>
<script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
</head>
<body>
<form name="mailform" method="post" action="mail.shop" enctype="multipart/form-data">
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr><td>보내는 사람</td><td>관리자 이메일</td>	</tr>
		<tr>
			<td>받는 사람</td><td><input type="text" name="recipient" size="100" value=
			'<c:forEach items="${userList }" var="user">${user.userName } &lt;${user.email }&gt;,</c:forEach>'>
			</td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="title" size="100"></td>
		</tr>
		<tr>
			<td>메시지 형식</td>
			<td>
				<select name="mtype">
					<option value="text/html; charset=euc-kr">HTML</option>
					<option value="text/plain; charset=euc-kr">TEXT</option>
				</select>
			</td>
		</tr>
		<tr><td>첨부파일</td><td><input type="file" name="file1"></td></tr>
		<tr>
			<td colspan="2">
				<textarea name="editor1" cols="120" rows="10"></textarea>
			</td>
			<script	type="text/javascript">
				CKEDITOR.replace('editor1');
			</script>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="메일 보내기">
			</td>
		</tr>
	</table>
</form>
</body>