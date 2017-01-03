<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function disp_div(id){
		
		document.getElementById("minfo").style.display="none";
		document.getElementById("oinfo").style.display="none";
		document.getElementById(id).style.display="block";
	}
	
	function list_disp(id){
		
		var disp = document.getElementById(id);
		
		if(disp.style.display == 'block'){
			disp.style.display = "none";
		}else{
			disp.style.display = "block";
		}
	}
</script>
</head>
<body>

<table>
	<tr>
		<td><a href="javascript:disp_div('minfo')">회원정보보기</a></td>
	</tr>
	<tr>
		<td><a href="javascript:disp_div('oinfo')">주문정보보기</a></td>
	</tr>

</table>

<div id="minfo" style="display: block; width:100%">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td>${user.userId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.userName }</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>${user.postCode }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${user.phoneNo }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${user.address }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${user.birthDay }</td>
		</tr>
	</table>
</div>
<div id="oinfo" style="display: none; width:100%">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="2">주문목록</td></tr>
		<tr><td>주문번호</td><td>주문일자</td></tr>
		
		<c:forEach items="${salelist }" var="sale" varStatus="stat">
			<tr>
				<td align="center">
					<a href="javascript:list_disp('saleLine${stat.index }')">${sale.saleId }</a>
				</td>
				<td>
					<f:formatDate value="${sale.updateTime }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<div id="saleLine${stat.index }" style="display:none;">
					<table border="1" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<th width="25%">상품명</th>
							<th width="25%">상품가격</th>
							<th width="25%">주문수량</th>
							<th width="25%">합계</th>
						</tr>
						<c:forEach items="${sale.saleItemList }" var="saleItem">
							<tr>
								<td>${saleItem.item.name }</td>
								<td>${saleItem.item.price }</td>
								<td>${saleitem.quantity}</td>
								<td>${saleItem.quantity * saleItem.item.price }</td>
							</tr>
						</c:forEach>
						
					
					</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>