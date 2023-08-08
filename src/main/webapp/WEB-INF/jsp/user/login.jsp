<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="contents d-flex justify-content-center">
			<div class="join-box my-5 text-center">
				<h1 class="text-center my-4">로그인</h1>
				<input type="text" placeholder="아이디" class="form-control mt-2 mb-2"
					id="idInput"> <input type="password" placeholder="비밀번호"
					class="form-control mt-2 mb-2" id="passwordInput">
				<button type="button" class="btn btn-secondary btn-block mt-3 mb-3"
					id="loginBtn">로그인</button>
				<a href="/user/join-view" class="mt-3">회원가입</a>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js"
		integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		
		<script>
			$(document).ready(function(){
				
				$("#loginBtn").on("click", function(){
					let id = $("#idInput").val();
					let password = $("#passwordInput").val();
				
				if(id == ""){
					alert("아이디를 입력하세요");
					return;
				}
				
				if(password == ""){
					alert("비밀번호를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					,url:"/user/login"
					,data:{"loginId":id,"password":password}
					,success:function(data){
						if(data.result == "success"){
							location.href = "/post/list-view";
						} else{
							alert("아이디, 비밀번호를 확인하세요");
						}
					}
					,error:function(){
						alert("로그인 에러");
						
					}
				});
				
				
				});
				
			});
		</script>
		
</body>
</html>