var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
		move();
		member.init();
		$('footer').addClass('bottom');
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content h2')
		$('#global_content_a_regist').text('SIGN UP').click(function(){util.move('member','regist');});
		$('#global_content_a_login').text('LOG IN').click(function(){util.move('member','login');});
		$('#global_content_a_admin').text('ADMIN MODE').click(function(){admin.check();});
	};
	var context = function(){
		return sessionStorage.getItem('context');
	};
	var js = function(){
		return sessionStorage.getItem('js');
	};
	var css = function(){
		return sessionStorage.getItem('css');
	};
	var img = function(){
		return sessionStorage.getItem('img');
	};
	var move = function(){
		$('#title').click(function(){util.home();});
		$('#a_member').click(function(){util.move('member','main');});
		$('#a_grade').click(function(){util.move('grade','main');});
		$('#a_account').click(function(){util.move('account','main');});
		$('#a_shool').click(function(){util.move('global','school_info');});
	};
	
	return {
		init : init,
		move : move,
		context : context,
		img : img,
		js : js,
		css : css
	}
})();

var admin = (function() {
	var _pass;
    var	getPass = function(){return this._pass;};
    var setPass = function(pass){this._pass=pass;};
    return {
    	getPass : getPass,
    	setPass : setPass,
    	check : function() {
    		setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('관리자 비번을 입력바랍니다');
				if(password == getPass()){
					location.href = app.context()+'/admin/main';
				}else{
					alert('관리자 비번이 틀립니다.');
				}
			}
		}
    };
})();
var util = (function(){
	var _page,_directory;
	var setPage=function(page){this._page=page;};
	var setDirectory=function(directory){this._directory=directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory;};
	return {
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context()+'/'+getDirectory()+'/'+getPage();
				
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		},
		home : function(){location.href=app.context()+'/'}
		
	};
})();


var user = (function(){
	var context = sessionStorage.getItem("context");
	return {
		init : function() {
			$('#bt_bom').click(function(){move(context,'bom');});
			$('#bt_dom').click(function(){move(context,'dom');});
			$('#bt_kaup').click(function(){move(context,'kaup');});
			$('#bt_account').click(function(){move(context,'account');});
		},
		account : function(){
			$('#a_regist').click(function(){
				location.href=app.context()+"/account/regist"});
			$('#a_withdraw').click(function(){location.href=app.context()+"/account/withdraw"});
			$('#a_deposit').click(function(){location.href=app.context()+"/account/deposit"});
			$('#a_list').click(function(){location.href=app.context()+"/account/list"});
			$('#a_update').click(function(){location.href=app.context()+"/account/update"});
			$('#a_count').click(function(){location.href=app.context()+"/account/count"});
			$('#a_search').click(function(){location.href=app.context()+"/account/search"});
			$('#a_delete').click(function(){location.href=app.context()+"/account/delete"});
			$('#member_content_img_home').attr('src',app.img()+'/home.png');
		}
	};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : function() {
			$('#bt_spec_show').click(member.spec());
			$('#bt_make_account').click(this.spec());
			$('#bt_deposit').click(this.deposit());
			$('#bt_withdraw').click(this.withdraw());
		},
		spec : function(){
			setAccountNo(Math.floor(Math.random()*899999)+100000);
			setMoney(0);
			document.querySelector('#result_account').innerHTML = getAccountNo();
		},
		deposit : function (){
			var r_acc = document.querySelector('#result_account').innerText;
			console.log('계좌번호 : '+r_acc);
			switch(typeof r_acc){
				case 'number' : console.log('this is number type');break;
				case 'string' : console.log('this is string type');break;
				case 'undefined' : console.log('this is undefined type');break;
				default : console.log('type check fail !!');
			}
			if(r_acc == null){
				// r_acc === undefined
				alert('먼저 통장이 개설되어야 합니다');
			}else{
				var input_money = Number(document.querySelector('#money').value);
				var rest_money = getMoney();
				console.log('인풋 머니 타입 체크 : '+(typeof input_money === 'number'));
				console.log('잔액 타입 체크 : '+(typeof rest_money === 'number'));
				setMoney(input_money+rest_money);
				console.log('입금액 : '+getMoney());
				document.querySelector('#rest_money').innerHTML=getMoney();
			}
		},
		withdraw : function (){
			setMoney(document.querySelector('#money').value);
			document.querySelector('#rest_money').innerHTML='-'+getMoney();
		}
	};
})();
var member = (function(){
	var _age,_gender,_name,_ssn;
	var setAge = function(age){this._age=age;}
	var setGender = function(gender){this._gender=gender;}
	var setSSN = function(ssn){this._ssn=ssn;}
	var setName = function(name){this._name=name;}
	var getAge = function(){return this._age;}
	var getSSN = function(){return this._ssn;}
	var getName = function(){return this._name;}
	var getGender = function(){return this._gender;}
	
	return {
		setSSN : setSSN,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSSN : getSSN,
		getGender : getGender,
		spec : function (){
			console.log('SET SSN'+document.querySelector('#ssn').value);
			setSSN(document.querySelector('#ssn').value);
			console.log('GET SSN'+getSSN());
			setName(document.querySelector('#name').value);
			var now = new Date().getFullYear();
			var ssnArr = getSSN().split("-");
			var ageResult1 = ssnArr[0];
			var genderResult = Number(ssnArr[1]);
			var ageResult0 = 0;
			switch (genderResult) {
			case 1: case 5: 
				setGender("남"); 
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 3: case 7:
				setGender("남");
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 2: case 6:
				setGender("여");
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 4: case 8:
				setGender("여");
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;

		}	
			document.querySelector('#result_name').innerHTML = getName();
			document.querySelector('#result_age').innerHTML = getAge();
			document.querySelector('#result_gender').innerHTML = getGender();
		}
		
	};	
})();

var kaup = (function(){
	return {
		init : function (){
			document.getElementById('bt_kaup_calc').addEventListener('click',this.calc,false);
		},
		calc : function (){
			alert('카우푸 칼크 클릭');
			var name=document.querySelector('#name').value;
			var height=document.querySelector('#height').value;
			var weight=document.querySelector('#weight').value;
			console.log('name'+name);
			console.log('height'+height);
			console.log('weight'+weight);
			var result = '';
			var kaup = weight / (height / 100) / (height / 100);
			if (kaup < 18.5) {
				result = "저체중";
			} else if (kaup < 22.9 && kaup > 18.5) {
				result = "정상";
			} else if (kaup < 24.9 && kaup > 23.0) {
				result = "위험체중";
			} else if (kaup < 29.9 && kaup > 25.0) {
				result = "비만1단계";
			} else if (kaup < 40 && kaup > 30.0) {
				result = "비만2단계";
			} else if (kaup >= 40) {
				result = "비만3단계";
			}
			document.getElementById('result').innerHTML=name+'의 카우푸결과'+result;
		}
		
	};
})();
var grade = (function(){
	return {
		init : function(){
			$('#g_regist').click(function(){
				location.href=app.context()+"/grade/regist"});
			$('#g_update').click(function(){location.href=app.context()+"/grade/update"});
			$('#g_delete').click(function(){location.href=app.context()+"/grade/delete"});
			$('#g_list').click(function(){location.href=app.context()+"/grade/list"});
			$('#g_count').click(function(){location.href=app.context()+"/grade/count"});
			$('#g_find').click(function(){location.href=app.context()+"/grade/find"});
			
			$('#member_content_img_home').attr('src',app.img()+'/home.png');
		},
		init2 : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width','30px');
			$('#grade_content > article').css('width','300px').css('text-align','left').css('margin','0 auto');
			$('#title').css('font-size','40px');
			$('#a_regist').click(function() {location.href = "${context}/grade/regist.do";});
			$('#a_update').click(function() {location.href ="${context}/grade/update.do";});
			$('#a_delete').click(function() {location.href = "${context}/grade/delete.do";});
			$('#a_list').click(function() {location.href = "${context}/grade/list.do";});
			$('#a_count').click(function() {location.href = "${context}/grade/count.do";});
			$('#a_find').click(function() {location.href = "${context}/grade/search.do";});
		}
	};
})();
var member = (function(){
	return {
		init : function(){
			
			$('#regist').click(function(){location.href=app.context()+"/member/regist"});
			$('#detail').click(function(){location.href=app.context()+"/member/detail"});
			$('#update').click(function(){location.href=app.context()+"/member/update"});
			$('#delete').click(function(){location.href=app.context()+"/member/delete"});
			$('#login').click(function(){location.href=app.context()+"/member/login"});
			$('#logout').click(function(){location.href=app.context()+"/member/logout"});
			$('#list').click(function(){location.href=app.context()+"/member/list"});
			$('#find_by').click(function(){location.href=app.context()+"/member/find_by"});
			$('#count').click(function(){location.href=app.context()+"/member/count"});
			$('#member_content_img_home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#member_content_a_home').attr('alt','home').click(function(){location.href=app.context()+"/"});
			$('#member_content').addClass('box').css('font-size','20px');
			$('#member_content > article').css('width','300px').addClass('center').addClass('text_left');
			$('#member_content a').css('font-size','15px').addClass('cursor');
			$('#member_content > h1').text('MEMBER MGMT');
			$('#member_content_ol > li > a').addClass('remove_underline');
			$('#member_content_ol > li:first > a').text('SIGN UP');
			$('#member_content_ol > li:nth(1) > a').text('DETAIL');
			$('#member_content_ol > li:nth(2) > a').text('UPDATE');
			$('#member_content_ol > li:nth(3) > a').text('DELETE');
			$('#member_content_ol > li:nth(4) > a').text('LOG IN');
			$('#member_content_ol > li:nth(5) > a').text('LOG OUT');
			$('#member_content_ol > li:nth(6) > a').text('LIST');
			$('#member_content_ol > li:nth(7) > a').text('SEARCH');
			$('#member_content_ol > li:nth(8) > a').text('COUNT');
			$('#member_regist').addClass('box');
			$('#member_regist span').addClass('float_left').addClass('text_left').css('width','200px');
			$('#member_regist #bt_join').addClass('btn').addClass('btn btn-primary');
			$('#member_regist #bt_cancel').addClass('btn').addClass('btn btn-warning');


		}
	};
})();
