<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<link rel="stylesheet" href="${css}/member.css" />
<jsp:include page="../global/top.jsp" />
<jsp:include page="../global/header.jsp" />
<jsp:include page="../global/navi.jsp" />
<div class="box">
		<h2>회원정보 수정</h2>
		<form action="${context}/member.do" method="post">
		<table id="member_detail">
				<tr>
				<td rowspan="7" style="width:30%">
				<img src="${img}/${user.img}" alt="W3Schools.com" width="104"
			height="142"></td>
				<td class="font_bold bg_color_yellow" style="width:20%">ID</td>
				<td style="width:40%">${user.id}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">비밀번호</td>
				<td>
				<input type="text" name="pw" 
					value="${user.pw}"/>
				</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${user.name}</td>
			</tr>
			
			<tr>
				
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">이메일</td>
				<td>
					<input type="text" name="email" 
					value="${user.email}"/>
				</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">전화번호</td>
				<td>
					<input type="text" name="phone" 
					value="${user.phone}"/>
				</td>
			</tr>
			<tr>
				
				<td class="font_bold bg_color_yellow">전공과목</td>
				<td>${user.major}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">수강과목</td>
				<td colspan="2">${user.subjects}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${user.birth}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${user.reg_date}</td>
			</tr>
		</table><br />
		<input type="hidden" name="id" value="${member.id}"/>
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="page" value="detail"/>
		<input type="submit" value="수 정" />
		<input type="reset" value="취 소" />
		</form>
		</div>
		 
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>