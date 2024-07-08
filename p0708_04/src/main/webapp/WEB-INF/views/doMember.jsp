<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doMemebr</title>
	<style>
	table,th,td{border:1px solid black; border-collapse:collapse;}
	th,td{width:200px;}
	</style>
	</head>
	<body>
	<h2>회원 정보</h2>
	<form action="memUpdate" method="post">
	<input type="hidden" name="id" value="${id}">
	<input type="hidden" name="pw" value="${pw}">
	<input type="hidden" name="name" value="${name}">
	<input type="hidden" name="phone" value="${phone}">
	<input type="hidden" name="gender" value="${gender}">
	<input type="hidden" name="hobby" value="${hobby}">
		<table>
		<tr>
			<th>데이터</th>
			<th>값</th>
		</tr>
		<tr>
			<td>id</td>
			<td>${id }</td>
		</tr>
		<tr>
			<td>pw</td>
			<td>${pw}</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${name }</td>
		</tr>
		<tr>
			<td>phone</td>
			<td>${phone }</td>
		</tr>
		<tr>
			<td>gender</td>
			<td>${gender }</td>
		</tr>
		<tr>
			<td>hobby</td>
			<td>${hobby }</td>
		</tr>
		</table>
		<input type="submit" value="수정">
		</form>
	</body>
</html>