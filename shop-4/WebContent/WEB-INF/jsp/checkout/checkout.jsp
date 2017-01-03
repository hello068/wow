<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 확인 화면</title>
</head>
<body>
<h2>배송지 정보</h2>

<table>
	<tr>
		<td>구매자 ID</td><td>${loginUser.userId }</td>
	</tr>
	<tr>
		<td>이름</td><td>${loginUser.userName }</td>
	</tr>
	<tr>
		<td>우편번호</td><td>${loginUser.postCode }</td>
	</tr>
	<tr>
		<td>주소</td><td>${loginUser.address }</td>
	</tr>
	<tr>
		<td>전화번호</td><td>${loginUser.phoneNo }</td>
	</tr>
	<tr>
		<td>이메일</td><td>${loginUser.email }</td>
	</tr>
</table>
<br>
<table>
	<tr>
		<th>상품명</th><th>상품가격</th><th>수량</th><th>금액</th>
	</tr>
	<c:forEach items="${itemList }" var="itemSet">
		<tr>
			<td>${itemSet.item.name }</td>
			<td>${itemSet.item.price }</td>
			<td>${itemSet.quantity }</td>
			<td>${itemSet.item.price*itemSet.quantity }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4" align="right">총 금액 : ${totalAmount }원</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<a href="end.shop">확정</a>
			<a href="../item/list.shop">상품목록</a>
		</td>
	</tr>
</table>



</body>
</html>