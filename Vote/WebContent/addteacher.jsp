<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>添加老师信息</h1>
<form action="/Vote/addteacher" method="post">
	<table>
	<tr><td>编号：<td><td><input type='text' name="id"></td></tr>
	<tr><td>姓名：<td><td><input type='text' name="name"></td></tr>
	<tr><td><td><td><input type='submit' value='提交'></td></tr>
	</table>
</form>
</body>
</html>