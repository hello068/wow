<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 작성하기</title>
</head>
<body>
<form:form modelAttribute="board" action="write.shop" enctype="multipart/form-data" name="boardform">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="2" align="center">Spring 게시물 작성하기</td></tr>
		<tr><td>작성자</td><td><form:input path="name"/><font color="red"><form:errors path="name" /></font></td></tr>
		<tr><td>비밀번호</td><td><form:password path="pass"/><font color="red"><form:errors path="pass" /></font></td></tr>
		<tr><td>제목</td><td><form:input path="subject"/><font color="red"><form:errors path="subject" /></font></td></tr>
		<tr><td>내용</td><td><form:textarea path="content" cols="67" rows="15"/><font color="red"><form:errors path="content" /></font></td></tr>
		<tr><td>첨부파일</td><td><input type="file" name="file1"></td>
		<tr><td colspan="2" align="center">
				<a href="javascript:document.boardform.submit()">[등록]</a>
				<a href="list.shop">[목록]</a>
			</td>
		</tr>
	</table>
</form:form>



</body>
</html>