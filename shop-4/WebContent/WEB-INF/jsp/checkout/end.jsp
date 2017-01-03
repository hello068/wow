<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 완료</title>
</head>
<body>
<h2>주문 해주셔서 감사합니다.</h2>
<font color="green"> 배송받을 곳 </font>
<table>
	<tr><td>사용자 ID</td><td>${loginUser.userId }</td></tr>
	<tr><td>이름</td><td>${loginUser.userName }</td></tr>
	<tr><td>우편번호</td><td>${loginUser.postCode }</td></tr>
	<tr><td>주소</td><td>${loginUser.address }</td></tr>
	<tr><td>전화번호</td><td>${loginUser.phoneNo }</td></tr>
	<tr><td>email</td><td>${loginUser.email }</td></tr>
</table>
<br><br>
<font color="green"> 주문 상품 목록 </font>
<table>
	<tr>
		<th>상품명</th><th>상품가격</th><th>수량</th><th>소계</th>
	</tr>
	<c:forEach items="${sale.saleItemList }" var="saleItem">
		<tr><td>${saleItem.item.name }</td><td>${saleItem.item.price }</td><td>${saleItem.quantity }</td><td>${saleItem.item.price * saleItem.quantity }</td></tr>
	</c:forEach>
</table>

<h2> 총 주문 금액 : ${totalAmount } </h2>
<a href="../item/list.shop"> 상품 목록 보기 </a>


</body>
</html>