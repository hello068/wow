<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 목록 보기</title>
</head>
<body>
<div align="center">
	<form action="list.shop" method="post" name="sf">
		게시글 검색 : 
		<select name="column">
			<option value="">선택하세요</option>
			<option value="subject">제목</option>
			<option value="name">작성자</option>
			<option value="content">내용</option>
		</select>
		<script type="text/javascript">
			document.sf.column.value="${param.column}";
		</script>
		<input type="text" name="find" size="50" value="${find }">
		<input type="submit" value="검색">
	</form>
</div>








<table border="1" cellspacing="0" cellpadding="0" width="100%">
   <c:if test="${listcount >0 }">
   <tr><td colspan="4">Spring 게시판</td>
      <td>글개수 " ${listcount }"</td>
   </tr>
   <tr align="center" valign="middle" bordercolor="#212121">
   <td width="8%">번호</td>
   <td width="50%">제목</td>
   <td width="14%">작성자</td>
   <td width="17%">날짜</td>
   <td width="11%">조회수</td>
   </tr>
   <c:forEach items="${boardlist }" var="board">
   <tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='#5CD1E5'"
   onmouseout="this.style.backgroundColor=''">
   <td>${board.num }</td>
   <td align="left">
      <c:if test="${not empty board.fileUrl}">
      <a href="../fileupload/${board.fileUrl}">@</a>
      </c:if>
      <c:if test="${not empty board.fileUrl}">
         &nbsp;&nbsp;
      </c:if>
      <c:forEach begin="1" end="${board.refLevel}">
         &nbsp;&nbsp;&nbsp;
      </c:forEach>
      <c:if test="${board.refLevel > 0}">▶</c:if>
      <a href="detail.shop?num=${board.num}">${board.subject}</a>
      </td>
      <td align="left">${board.name}</td>
      <td align="center">
         <c:if test="${board.dateFormat == today}">
         <f:formatDate value="${board.regDate }" pattern="HH : mm : ss" />
         </c:if>
         <c:if test="${board.dateFormat != today}">
         <f:formatDate value="${board.regDate }" pattern="yyyy-MM-dd HH:mm" />
         </c:if>
      </td>
      <td align="center">${board.readCnt }</td>
   </tr></c:forEach>
   <tr align="center">
      <td colspan="5">
      <c:if test="${pageNum > 1}">
         <a href="list.shop?pageNum=${pageNum-1}&column=${param.column }&find=${find }">[이전]</a>
      </c:if>
      <c:if test="${pageNum <= 1}">[이전]</c:if>
      <c:forEach var="a" begin="${startpage }" end="${endpage }">
      <c:if test="${pageNum == a}">[${a}]</c:if>
      <c:if test="${pageNum != a}"><a href="list.shop?pageNum=${a}&column=${param.column }&find=${find }">[${a}]</a></c:if>
      </c:forEach>
      <c:if test="${pageNum < maxpage}">
      <a href="list.shpo?pageNum=${pageNum + 1}&column=${param.column }&find=${find }">[다음]</a></c:if>
      <c:if test="${pageNum >= maxpage}">[다음]</c:if>
   </c:if>
   <c:if test="${listcount == 0 }">
   <tr><td colspan="5">등록된 게시물이 없습니다.</td></tr>
   </c:if>
   <tr><td align="right" colspan="5">
      <a href="add.shop">[글쓰기]</a></td></tr>
</table>
</body>
</html>