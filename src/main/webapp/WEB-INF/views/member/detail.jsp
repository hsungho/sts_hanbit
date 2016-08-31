<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
		<h2>내정보보기</h2>
		<table id="member_detail">
		<tr>
			<td rowspan="7" style="width:30%">
				<img src="${img}/${member.profileImg}" alt="W3Schools.com" width="104" height="142">
			</td>
			<td class="font_bold bg_color_yellow" style="width:20%">ID</td>
			<td style="width:40%">${member.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이 름</td>
			<td>${member.name}</td>
		</tr>
		<tr>				
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${member.gender}</td>
			</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이메일</td>
			<td>${member.email}</td>
		</tr>
		<tr>
				
				<td class="font_bold bg_color_yellow">전공과목</td>
				<td></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">수강과목</td>
				<td colspan="2"></td>
				
			</tr>
		<tr>
			<td class="font_bold bg_color_yellow">전화번호</td>
			<td >${member.phone}</td>
		</tr>
		<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${member.birth}</td>
			</tr>
		<tr>
			<td class="font_bold bg_color_yellow">등록일</td>
			<td colspan="2">${member.regDate}</td>
		</tr>
	</table>
	</div>