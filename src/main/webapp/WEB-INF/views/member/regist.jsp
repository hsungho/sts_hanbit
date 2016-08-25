<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<section id="member_regist" >
<h1>회원가입</h1><br />
	<form action="${context}/member.do" method="post">
		<span>이름</span>	<input type="text" name="name" /><br />
		<span>ID</span> <input type="text" name="id"/><br />
		<span>비밀번호</span> <input type="text" name="pw" /><br />
		<span>SSN</span><input type="text" name="ssn" /><br />
		<span>EMAIL</span><input type="text" name="email" /><br />
		<span>전화번호</span><input type="text" name="phone" /><br />
		<span >전공</span> <br /><br />
		<input type="radio" name="major" value="computer" checked/> 컴공학부
		<input type="radio" name="major" value="mgmt" /> 경영학부
		<input type="radio" name="major" value="math" /> 수학부 
		<input type="radio" name="major" value="eng" /> 영문학부 <br /><br /><br/></brr>
		<span class="meta">수강과목</span> <br /><br />
		<input type="checkbox" name="subject" value="java" /> Java
		<input type="checkbox" name="subject" value="sql" /> SQL
		<input type="checkbox" name="subject" value="cpp" /> C++
		<input type="checkbox" name="subject" value="python" /> 파이썬
		<input type="checkbox" name="subject" value="delphi" /> 델파이
		<input type="checkbox" name="subject" value="html" /> HTML
		<br /><br /><br />
		<input type="hidden" name="action" value="regist" />
		<input type="hidden" name="page" value="login" />
		<input type="submit" value="회원가입" />
		<input type="reset" value="취소" />
	</form>
	<br />
</section>


