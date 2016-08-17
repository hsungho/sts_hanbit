<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="nav">
    <div style="text-align:right;color:white;text-decoration: none;background-color: #333;">${user.name}님 환영합니다</div>
	<ul>
  		<li class="active"><a href="#" id="a_member">회원관리</a></li>
  		<li class="active"><a href="#" id="a_grade">성적관리</a></li>
  		<li class="active"><a href="#" id="a_account">계좌관리</a></li>
  		<li class="active"><a href="#" id="a_school">학교소계</a></li>
  </ul>
</div>
<script type="text/javascript">
$(function(){
	$('#a_member').click(function(){
		location.href="${context}/member.do"
	});
	$('#a_grade').click(function(){
		location.href="${context}/grade.do"
	});
	$('#a_account').click(function(){
		location.href="${context}/account.do"
	});
	$('#a_school').click(function(){
		location.href="${context}/global.do?page=school_info"
	});
});	
</script>