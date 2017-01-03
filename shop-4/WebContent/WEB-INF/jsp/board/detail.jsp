<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 상세 보기</title>
</head>
<body>

<table border="1" cellspacing="0" cellpadding="0" width="100%">
	<tr><td colspan="2">Spring 게시물 상세 보기</td></tr>
	<tr><td width="15%">제목</td><td width="85%">${board.subject }</td></tr>
	<tr><td>작성자</td><td>${board.name }</td></tr>
	<tr><td>내용</td>
		<td>
			<table width="100%" height="250">
				<tr><td>${board.content }</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
			<c:if test="${not empty board.fileUrl }">
				<a href="filedown.shop?filename=${board.fileUrl }">${board.fileUrl }</a>
			</c:if>
			&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="replyForm.shop?num=${board.num}">[답변]</a>
			<a href="updateForm.shop?num=${board.num}">[수정]</a>
			<a href="deleteForm.shop?num=${board.num}">[삭제]</a>
			<a href="list.shop">[목록]</a>
		</td>
	</tr>
</table>


</body>
</html>