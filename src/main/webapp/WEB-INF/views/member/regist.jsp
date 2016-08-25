<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<section id="member_regist">	
	<h2>회원가입</h2>
	<form id="member_regist_form">
	    <div>
    		<label for="exampleInputEmail1">이름</label>
    		<div><input type="text" id="username" placeholder="NAME"></div>
  		</div>
  		<div>
    		<label for="exampleInputEmail1">ID</label>
    		<div><input type="text" id="id" placeholder="Id"></div>
  		</div>
  		<div>  		
    		<label for="exampleInputPassword1">비밀번호</label>
    		<div><input type="password" id="password" placeholder="PASSWORD"></div>
  		</div>
  		<div>
    		<label for="exampleInputEmail1">SSN</label>
    		<div><input type="text" id="ssn" placeholder="예)800101-1"></div>
  		</div>
  		<div>
    		<label for="exampleInputEmail1">이메일</label>
    		<div><input type="email" id="email" placeholder="EMAIL"></div>
  		</div>
  		<div>
    		<label for="exampleInputEmail1">전화번호</label>
    		<div><input type="text" id="phone" placeholder="PHONE"></div>
  		</div>
		<div id="rd_major">
		<label for="exampleInputEmail1">전공</label><br/>
		<div>
		<label><input type="radio" name="major" value="computer"> 컴공학부</label>
		<label><input type="radio" name="major" value="mgmt"> 경영학부</label>
		<label><input type="radio" name="major" value="math"> 수학부	</label>
		<label><input type="radio" name="major" value="eng"> 영문학부</label>
		</div>
		</div>
		<div>
			<label for="exampleInputEmail1">수강과목</label><br/>	
    		<div>    			
      			<div id="ck_subject" class="checkbox">        			
					<label><input type="checkbox" name="subject" value="java"> Java </label>
					<label><input type="checkbox" name="subject" value="sql"> SQL </label>
					<label><input type="checkbox" name="subject" value="cpp"> C++</label>
					<label><input type="checkbox" name="subject" value="python"> 파이썬</label>
					<label><input type="checkbox" name="subject" value="delphi"> 델파이</label>
					<label><input type="checkbox" name="subject" value="html"> HTML</label>
      			</div>
    		</div>
  		</div>
		<input type="hidden" name="action" value="regist" />
		<input id="bt_join" type="submit" value="회원가입"/>
		<input id="bt_cancel" type="reset" value="취소" />
	</form>
	</section>	