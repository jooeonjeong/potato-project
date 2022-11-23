<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/login/join.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#nextBtn").click(function(){
		//null 검사
		chkNull();
	});//click
});//ready

//null 검사
function chkNull(){
	if( $("#id").val().trim() == "" ){
		alert("아이디를 입력하세요");
		$("#id").val("");
		$("#id").focus();
		return;
	}//end if
	if( $("#pass").val().trim() == "" ){
		alert("비밀번호를 입력하세요");
		$("#pass").val("");
		$("#pass").focus();
		return;
	}//end if
	
	$("#joinFrm").submit();
}//chkNull
</script>

</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
	<!-- box-main -->
	<div class="box-main">
		<div class="navigation_wrap">
			<div class="bar_navigation" style="width: 50%;">20%</div>
		</div>
		<!-- main -->
		<div class="main-container">
		<form action="signUp2.do" method="post" id="joinFrm">
			<h2 class="input-title">아이디</h2>
			<input type="text" placeholder="아이디" class="id" name="id" id="id"><br/>
			<h2 class="input-title">비밀번호</h2>
			<input type="password" placeholder="비밀번호" class="pass" name="pass" id="pass"><br/>
			<h2 class="input-title">비밀번호 재확인</h2>
			<input type="password" placeholder="비밀번호 재확인" class="pass" name="passChk" id="passChk"><br/>
			<h2 class="input-title">이름</h2>
			<input type="text" placeholder="이름" class="text-join" name="name" id="name"><br/>
			<h2 class="input-title">별명</h2>
			<input type="text" placeholder="별명" class="text-join" name="nick" id="nick"><br/>
			<h2 class="input-title">생년월일</h2>
			<input type="text" placeholder="년(4자)" class="text-year" name="year" id="year">
			<select class="text-year" name="month" id="month">
			<c:forEach var="i" begin="1" end="12">
				<option value="${ i }">${ i }월</option>
			</c:forEach>
			</select>
			<input type="text" placeholder="일" class="text-year" name="day" id="day">
			<h2 class="input-title">이메일</h2>
			<input type="text" placeholder="이메일" class="text-join" name="email" id="email"><br/>
			<h2 class="input-title">휴대전화</h2>
			<input type="text" placeholder="전화번호 입력" class="text-join" name="phone" id="phone"><br/>
			<input type="button" value="다음" class="nextBtn" id="nextBtn">
		</form>
		</div>
		<!-- //main -->
	</div>
	<!-- //box-main -->
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>