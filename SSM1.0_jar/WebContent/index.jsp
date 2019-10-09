<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 以下方式定时跳转
	setTimeout("javascript:location.href='customer/list'", 3000);
</script>

</head>

<body>
	<div style="text-align: center;">
		<h2>正在跳转到客户管理首页,请等一会！</h2>
		<h3>
			<a href="${pageContext.request.contextPath }/customer/list">马上跳转</a>
		</h3>
	</div>
</body>

</html>