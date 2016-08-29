<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${css}/member.css" />
</head>
<body>

<div class="box">
	<form action="${context}/member/result/logout_result.jsp" method="post">
		<input type="hidden" name="id"  />
		<input type="hidden" name="pw"  />
		<input type="submit" value="로그아웃"  />
	</form>
	
	</div>	
</body>
</html>