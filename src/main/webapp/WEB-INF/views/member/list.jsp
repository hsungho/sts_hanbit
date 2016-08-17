<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<link rel="stylesheet" href="${css}/member.css" />
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/navi.jsp" />
<div class="box">
	<h2>리스트</h2>
	<table id="member_list">
  <tr>
    <th>I D</th>
    <th>이   름</th>
    <th>등 록 일</th>
    <th>생 년 월 일</th>
    <th>이 메 일</th>
    <th>전 화 번 호</th>
  </tr>
  <c:forEach var="member" items="${list}">
  <tr>
    <td>${member.id}</td>
    <td><a href="${context}/member.do?action=find_by_id&page=find_by_id&keyword=${member.id}">${member.name }</a></td>
    <td>${member.regDate}</td>
    <td>${member.ssn.substring(0,6)}</td>
    <td>${member.email}</td>
    <td>${member.phone}</td>
  </tr>
  </c:forEach>
</table>
</div>		
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>