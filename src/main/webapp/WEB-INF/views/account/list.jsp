<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">계좌 목록</div>

  <!-- Table -->
  <table id="account_list" class="table">
  <tr>
    <th>ID</th>
    <th>이름</th>
    <th>계좌번호</th>
    <th>잔액</th>
  </tr>
  <c:forEach var="account" items="${list}">
  	<tr>
    	<td>${account.id}</td>
    	<td><a href="${context}/member.do?action=find_by_id&page=find_by_id&keyword=${account.id}">${account.name }</a></td>
    	<td>${account.accountno}</td>
    	<td>${account.money}</td>
  	</tr>
  </c:forEach>
  </table>
</div>
</div>	