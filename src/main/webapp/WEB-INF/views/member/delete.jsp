<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/navi.jsp" />
<link rel="stylesheet" href="${css}/member.css" /><div class="box">
<style type="text/css">
	span.meta{position:absolute;margin:1px 0 0 -110px;}
</style>
	<h2>탈퇴</h2>
		<form action="${context}/member.do" method="post">
			<span class="meta">비밀번호 확인</span> <input type="password" name="confpw" />
			</br></br>	
			<input type="hidden" name="id" value="${member.id}" />
			<input type="hidden" name="pw" value="${member.pw}" />
			<input type="hidden" name="action" value="delete1" />
			<input type="hidden" name=directory value="global" />
			<input type="submit" value="탈 퇴"/>
	   		<input type="reset" value="취 소"/>
	   </form>
	</div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>