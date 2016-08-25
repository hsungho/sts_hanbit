<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<section id="member_regist" >
<h1>회원가입</h1><br />
	<form action="${context}/member.do" method="post">
	
	 <div class="form-group">
    <label for="exampleInputEmail1">이 름</label>
    <input type="text" class="form-control" id="username" placeholder="USERNAME">
 	 </div>
 	  <div class="form-group">
    <label for="exampleInputEmail1">I D</label>
    <input type="text" class="form-control" id="id" placeholder="ID">
 	 </div>
 	  <div class="form-group">
    <label for="exampleInputEmail1">PassWord</label>
    <input type="text" class="form-control" id="pw" placeholder="PW">
 	 </div>
 	  <div class="form-group">
    <label for="exampleInputEmail1">S S N</label>
    <input type="text" class="form-control" id="ssn" placeholder="예)800101-1">
 	 </div>
 	  <div class="form-group">
    <label for="exampleInputEmail1">E-MAIL</label>
    <input type="text" class="form-control" id="email" placeholder="예)abc@naver.com">
 	 </div>
  <div class="form-group">
    <label for="exampleInputPassword1">전화번호</label>
    <input type="text" class="form-control" id="phone" placeholder="-없이 입력">
  </div>
  <div class="form-group">
 	       <label for="exampleInputPassword1">전공<<br />
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio1" value="computer"> 컴공학부</label>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio2" value="mgmt"> 경영학부</label>
        <label class="radio-inline"><input type="radio" name="major" id="inlineRadio3" value="math"> 수학부 </label>
        <label class="radio-inline"><input type="radio" name="major" id="inlineRadio3" value="eng"> 영문학부</label>
		</div>
	     <div class="form-group">
	    <label for="exampleInputPassword1">수강과목</label><br />
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox1" value="java"> Java</label>
        <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox2" name="subject" value="sql"> SQL</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="cpp"> C++</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="python">파이썬</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="delphi"> 델파이</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3" name="subject" value="html">  HTML</label>
		</label>
		</div>
		
		<br />
		
		<input id="bt_join" type="submit" value="회원가입" />
		<input id="bt_cancel" type="reset" value="취소" />
	</form>
	<br />
</section>


