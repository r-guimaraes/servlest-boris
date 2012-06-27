<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Include</title>
<img src="rodrigo.jpg" alt="boris" />
<%@ include file="banner.html"%>
<div style="width: 500px; float: left;">
	<%@ include file="toc.html"%>
</div>
<table>
	<tr>
		<td style="vertical-align: top">
			<%@ include file="clock2.jsp" %>
		</td>
	</tr>
</table>
</head>
<body>

</body>
</html>