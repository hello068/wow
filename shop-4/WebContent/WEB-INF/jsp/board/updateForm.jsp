<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 수정 화면</title>

<script type="text/javascript">
	function file_delete(){
		document.updateform.file2.value="";
		document.getElementById("file_desc").innerHTML="";
	}

</script>


</head>
<body>

<form:form modelAttribute="board" action="update.shop" enctype="multipart/form-data" name="updateform">
	<input type="hidden" name="file2" value="${board.fileUrl }">
	<form:hidden path="num" />
	<form:hidden path="name" />
	<table border="1" cellspacing="0" cellpadding="0">
		<tr><td colspan="2">Spring 게시판</td></tr>
		<tr><td>제목</td><td><form:input path="subject" /><font color="red"><form:errors path="subject" /></font></td></tr>
		<tr><td>내용</td><td><form:textarea path="content" cols="67" rows="15" /><font color="red"><form:errors path="content" /></font></td></tr>
		<tr><td>첨부파일</td>
			<td>
				<c:if test="${not empty board.fileUrl }">
					<div id="file_desc">
						<a href="filedown.shop?filename=${board.fileUrl }">${board.fileUrl }</a>&nbsp;
						<a href="javascript:file_delete()">[첨부파일 삭제]</a>&nbsp;						
					</div>
				</c:if>
				<input type="file" name="file1" id="file1">
			</td>
		</tr>
		<tr><td>비밀번호</td>
			<td><form:password path="pass" /><font color="red"><form:errors path="pass" /></font></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:document.updateform.submit()">[수정]</a>
				<a href="list.shop">[목록]</a>
			</td>
		</tr>
		
	</table>
</form:form>














</body>
</html>








