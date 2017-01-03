<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장바구니</title>
</head>
<body>

<h2>장바구니 상품</h2>
<table>
	<tr><td>상품명</td><td>가격</td><td>수량</td><td>합계</td></tr>
	<c:set var="tot" value="${0 }" />
	<c:forEach items="${cart.itemList }" var="itemSet" varStatus="stat">
	<tr>
		<td>${itemSet.item.name }</td>
		<td>${itemSet.item.price }</td>
		<td>${itemSet.quantity }</td>
		<td>${itemSet.item.price*itemSet.quantity }</td>
		<td><a href="cartDelete.shop?index=${stat.index }">ⓧ</a></td>
	</tr>
	<c:set var="tot" value="${tot + (itemSet.item.price * itemSet.quantity) }" />
	</c:forEach>
	<tr>
		<td colspan="4" align="right">총 구입 금액 : ${tot }원</td>
	</tr>
</table>
<br>
${message }
<br>
<a href="../item/list.shop">상품목록</a><br>
<a href="../checkout/checkout.shop">계산하기</a><br>

</body>
</html>