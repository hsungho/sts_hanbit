<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<link rel="stylesheet" href="${css}/member.css" />
<style>
	iframe.ifrm{border:none;width:400px;height:400px}
</style>
	<div class="box">
	<h2>ID 검색</h2>
	<form action="${context}/member.do" method="post">
		<input type="text" name="keyword" placeholder="검색할 ID"/>
		<input type="hidden" name="action" value="find_by_id"/>
		<input type="hidden" name="page" value="find_by_id"/>
		<input type="submit" value="ID검색"/>
		<input type="reset" value="취소"/>
	</form>
	<h2>이름 검색</h2>
	<form action="${context}/member.do" method="post">
		<input type="text" name="keyword" placeholder="검색할 이름"/>
		<input type="hidden" name="action" value="find_by_name"/>
		<input type="hidden" name="page" value="list"/>
		<input type="submit" value="이름검색"/>
		<input type="reset" value="취소"/>
	</form>
		<iframe src="image.jsp" class="ifrm"></iframe><br>
	</div>