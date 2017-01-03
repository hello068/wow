<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- /WebContent/WEB-INF/jsp/item/detail.jsp -->
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="itemDetail.title" /></title>
</head>
<body>
<h2><spring:message code="itemDetail.title" /></h2>
<table>
	<tr>
		<td><img src="../img/${item.pictureUrl }" width="200" height="250"></td>
		<td align="center">
			<table>
				<tr>
					<td width="80">상품명</td>
					<td width="160">${item.name }</td>
				</tr>
				<tr>
					<td width="80">가격</td>
					<td width="160">${item.price }원</td>
				</tr>
				<tr>
					<td width="80">상품개요</td>
					<td width="160">${item.description }</td>
				</tr>
				<tr>
					<td colspan="2">
						<form action="../cart/cartAdd.shop">
							<input type="hidden" name="id" value="${item.id }">
							<table>
								<tr>
									<td>
										<select name="quantity">
											<c:forEach begin="1" end="10" var="idx">
												<option>${idx }</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<input type="submit" value="카트에 넣기">
										<input type="button" value="목록" onclick="location.href='list.shop'">
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>




</body>
</html>