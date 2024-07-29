<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/top.css" />
		<link rel="stylesheet" type="text/css" href="/css/login.css" />
		<link rel="stylesheet" type="text/css" href="/css/footer.css" />
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	  	<script>
				$(function(){
					$(".sbtn").click(function(){
						var idChk = $("#saveCheckbox").is(":checked") ; //아이디 저장이 체크되었는지 담아준다.
						var id = $("#id").val();
						var pw = $("#pw").val();
						
						//alert("로그인 진행");
						if(id == ""){
							alert("아이디를 입력하셔야 합니다.");
							$("#id").focus();
							return false;
						}else if(pw == ""){
							alert("패스워드를 입력하셔야 합니다.");
							$("#pw").focus();
							return false;
						}
						
						loginFrm.submit(); //form 형태로 controller로 입력값을 보냄
						
					});
				});
		</script>
		<title>HappyPawPet 로그인창</title>
	</head>
	<body id="loginPage">
		<%@ include file="../top/top.jsp" %>
		<!-- ------------------------------------------------------------------------- -->
		<section>
			<div class="main">
				<h2>Login</h2>
				<form action="/login/login" name="loginFrm" method="post">
					<div class="id">
						<input type="text" name="id" id="id" size="30" placeholder="아이디를 입력하세요.">
					</div>
					<div class="pw">
						<input type="password" name="pw" id="pw" size="45" placeholder="비밀번호 영문, 특수문자, 숫자혼합 8~12자">
					</div>
					<div id="save">
						<input type="checkbox" id="saveCheckbox" name="saveCheckbox" value="saveId">
						<label for="saveCheckbox">아이디 저장</label>
					</div>
					<div id="find">
						<a href="/login/findId"><span>아이디/비밀번호 찾기</span></a>
					</div>
					<button type="submit" class="sbtn">Login</button>
				</form>
			      <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=d6f5da98cfbe26c292397ddc4ff2a30b&redirect_uri=http://localhost:8181/kakao/oauth" class="kakao">
			      	<div id="kakaoBtn"><img src="/image/kakao_login.png"></div>
			      </a>
				<div class="sign-up-info">
					<h3>HappyPawPet의 회원이 아니신가요?</h3>
					<p>반려동물 건강관리를 한 곳에서! 우리 아이만을 생각한 특별하고 다양한 서비스가 있는 HappyPawPet에 지금바로 가입하세요! </p>
					<a href="/login/memberForm"><div class="sign-up">HappyPawPet 신규가입하기<div class="arrow">&emsp;</div></div></a>
				</div>
			</div>
		</section>
		<!-- ---------------------------------------------------------------------------- -->
		<%@ include file="../footer/footer.jsp" %>
	</body>
</html>