<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="doMember" name="frm" method="post">
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>비밀번호</label>
		<input type="password" name="pw"><br>
		<label>이름</label>
		<input type="text" name="name"><br>
		<label>전화번호</label>
		<input type="text" name="phone"><br>
		<label>성별</label>
		<label>남성</label>
		<input type="checkbox" name="gender" value="male">
		<label>여성</label>
		<input type="checkbox" name="gender" value="female"><br>
		<label>취미</label>
		<label>달리기</label>
		<input type="checkbox" name="hobby" value="run">
		<label>독서</label>
		<input type="checkbox" name="hobby" value="book">
		<label>골프</label>
		<input type="checkbox" name="hobby" value="golf">
		<label>수영</label>
		<input type="checkbox" name="hobby" value="swim">
		<input type="submit" value="전송">
		</form>
	</body>
</html>