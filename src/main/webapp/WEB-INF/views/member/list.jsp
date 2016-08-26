<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">학생 목록</div>

  <!-- Table -->
  <table id="member_list" class="table">
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
</div>		