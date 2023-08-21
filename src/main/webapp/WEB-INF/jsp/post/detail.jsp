<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 보기</title>
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
		<div class="contents-box my-5">
			<h1 class="text-center">메모 보기</h1>
			<div class="d-flex mt-4">
				<label class="col-2">제목 :</label>
				<input type="text" class="form-control col-10" id="titleInput" value="${post.title }">
			</div>
			<textarea rows="10" class="form-control mt-3" id="contentInput">${post.content }</textarea>
			<img src="${post.imagePath}" class="form-control">
			<div class="d-flex justify-content-between mt-3">
				<div>
				<a href="/post/list-view" class="btn btn-secondary">목록으로</a>				
				<button type="button" class="btn btn-danger" data-post-id="${post.id }" id="deleteBtn">삭제하기</button>
				</div>
				<button type="button" class="btn btn-secondary" data-post-id="${post.id }" id="saveBtn">수정</button>
			</div>
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
			
			$("#deleteBtn").on("click",function(){
				let postId = $(this).data("post-id");
				
				$.ajax({
					type:"delete"
					,url:"/post/delete"
					,data:{"postId":postId}
					,success:function(data){
						if(data.result == "success"){
							location.href = "/post/list-view";
						}else{
							alert("삭제 실패");
						}
					}
					,error:function(){
						alert("삭제 에러");
				
					}
				});
			});
			
			$("#saveBtn").on("click", function(){
				// 제목, 메모 내용, 게시글 id
				let title = $("#titleInput").val();
				let content = $("#contentInput").val();
				let postId = $(this).data("post-id");
				
				if(title == ""){
					alert("제목을 입력하세요");
					return;
				}
				
				if(content==""){
					alert("내용을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"put"
					,url:"/post/update"
					,data:{"postId":postId,"title":title, "content":content}
					,success:function(data){
						if(data.result == "success"){
							location.href = "/post/list-view";
						}else{
							alert("수정 실패");
						}
						
					}
					,error:function(){
						alert("수정 에러");
					}
				});
				
			});
			
		});
	</script>	
	
</body>
</html>