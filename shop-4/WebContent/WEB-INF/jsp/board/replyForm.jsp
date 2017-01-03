<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 답글 쓰기</title>
</head>
<body>
<form:form modelAttribute="board" action="reply.shop" enctype="multipart/form-data" name="replyform">
	<input type="input" name="num" value="${board.num }">
	<input type="hidden" name="ref" value="${board.ref }">
	<input type="hidden" name="refLevel" value="${board.refLevel }">
	<input type="hidden" name="refStep" value="${board.refStep }">
	
	<table border="1" cellspacing="0" cellpadding="0">
		<tr align="center">
			<td colspan="2">Spring 게시판</td>
		</tr>
		<tr>
			<td>작성자</td><td><form:input path="name" /><font color="red"><form:errors path="name" /></font> </td>
		</tr>
		<tr>
			<td>비밀번호</td><td><form:password path="pass" /><font color="red"><form:errors path="pass" /></font></td>
		</tr>
		<tr>
			<td>제목</td><td><form:input path="subject" /><font color="red"><form:errors path="subject" /></font></td>
		</tr>
		<tr>
			<td>내용</td><td><form:textarea path="content" rows="15" cols="67" /><font color="red"><form:errors path="content" /></font></td>
		</tr>
		<tr>
			<td colspan="2"><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td colspan="2"><a href="javascript:document.replyform.submit()">[답글등록]</a> <a href="list.shop">[목록]</a></td>
		</tr>
		
	</table>
</form:form>


</body>
</html>