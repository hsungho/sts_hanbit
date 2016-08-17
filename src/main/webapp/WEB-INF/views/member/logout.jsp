<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/navi.jsp" />
	<div class="box">
		<form action="${context}/member.do" method="post">
			<input type="hidden" name="id" value="${member.id}" />
			<input type="hidden" name="pw" value="${member.pw}" />
			<input type="hidden" name="action" value="log_out" />
			<input type="submit" value="로그아웃" />
		</form>
	</div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>