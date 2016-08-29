<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<section id="member_regist" >
<h3>회원가입</h3><br />
	<form id="member_regist_form" action="${context}/member.do" method="post">
	<div >
      <label for="exampleInputEmail1">이 름</label>
      <div><input type="text"  id="username" placeholder="USERNAME"></div>
   	 </div>
 	 <div>
      <label for="exampleInputEmail1">I D</label>
      <div><input type="text"  id="id" placeholder="ID"></div>
  	 </div>
 	 <div >
      <label for="exampleInputEmail1">PassWord</label>
      <div><input type="text" id="pw" placeholder="PW"></div>
   	 </div>
 	 <div ">
      <label for="exampleInputEmail1">S S N</label>
      <div><input type="text" id="ssn" placeholder="예)800101-1"></div>
    </div>
 	 <div >
      <label for="exampleInputEmail1">E-MAIL</label>
      <div><input type="text" id="email" placeholder="예)abc@naver.com"></div>
    </div>
  <div>
      <label for="exampleInputPassword1">전화번호</label>
      <div><input type="text"  id="phone" placeholder="-없이 입력"></div>
    </div>
   <div id="rd_major">
 	    <label for="exampleInputPassword1">전공</label><br />
 	    <div>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio1" value="computer"> 컴공학부</label>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio2" value="mgmt"> 경영학부</label>
        <label class="radio-inline"><input type="radio" name="major" id="inlineRadio3" value="math"> 수학부 </label>
        <label class="radio-inline"><input type="radio" name="major" id="inlineRadio3" value="eng"> 영문학부</label>
		</div>
		</div>
	<div id="ck_subject">
        <label for="exampleInputPassword1">수강과목</label><br />
        <div>
        <div class="checkbox">
      	<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox1" name="subject" value="java"> Java</label>
        <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox2" name="subject" value="sql"> SQL</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="cpp"> C++</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="python">파이썬</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3"name="subject"  value="delphi"> 델파이</label>
        <label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3" name="subject" value="html">  HTML</label>
      </div>
    </div>
    </div>
	<br />
		<input type="hidden" name="action" value="regist" />
		<input type="hidden" name="page" value="login" />
		<input id="bt_join" type="submit" value="회원가입" />
		<input id="bt_cancel" type="reset" value="취소" />
	</form>
	<br />
</section>


