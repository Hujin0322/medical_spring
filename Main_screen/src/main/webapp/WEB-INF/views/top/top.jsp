<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
<header>
		<nav>
			<div id="logo">
				<a href="/index">
				HappyPawPet<div id="logoImg"></div>
				</a>
			</div>
		<script>
			function pBtn(){
				if (${sessionId == null}){
					$("#q06").css("display","inline-block");
					$("#q07").css("display","none");
					alert("로그인 이후 이용 가능한 페이지입니다.");
					location.href="/login/login";
				}else{
					$("#q06").css("display","none");
					$("#q07").css("display","inline-block");
				}
				
			}
		</script>
		<div id="navi">
				<div class="qmenu">
					<ul>
						<li><a href="/index" id="q01">Home</a></li>
						<li><a href="#" id="q02">CheckTools</a></li>
						<li><a href="#" id="q03">Emergency</a></li>
						<li><a href="#" id="q04">Adoption</a></li>
						<c:if test="${sessionId == null }">
						<li><a href="/login/login" id="q05">Login</a></li>
						<li><a href="#" id="q06" onclick="pBtn()">MyPage</a></li>
						</c:if>
						<c:if test="${sessionId != null }">
						<li><a href="/kakao/logout" id="q05">Logout</a></li>
						<li><a href="/mypage/myPage" id="q07" onclick="pBtn()">${sessionName} 님의 MyPage</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
</header>