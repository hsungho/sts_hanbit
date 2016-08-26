var app = (function(){
	var init = function(context) {		
		onCreate();
		session.init(context);
		member.init();
		user.init();
		grade.init();
		admin.init();
		nav.init();
	};
	var context = function() {
		return session.getContextPath();
	};
	var js = function(){
		return session.getJavascriptPath();
	};
	var css = function(){
		return session.getCssPath();
	};
	var img = function(){
		return session.getImagePath();
	};
	var setContentView = function(){
		$('#footer').addClass('bottom').addClass('footer');
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content_a_regist').text('SIGN UP').click(function(){controller.move('member','regist');});
		$('#global_content_a_login').text('LOG IN').click(function(){controller.move('member','login');});
		$('#global_content_a_admin').text('ADMIN MODE').click(function(){admin.checkAdmin();});
	};
	var onCreate = function(){
		setContentView();
		$('#title').click(function(){controller.home();});
		$('#a_member').click(function(){controller.move('member','main');});
		$('#a_grade').click(function(){controller.move('grade','main');});
		$('#a_account').click(function(){controller.move('account','main');});
		$('#a_school').click(function(){controller.move('global','school_info');});
	};
	return {
		init : init,
		context : context,
		onCreate : onCreate,
		setContentView : setContentView,
		img : img,
		css : css,
		js : js
	}
})();
var user = (function(){
	var init = function(){
		onCreate();
	};
	var setContentView = function(){
		$('#account_content_img_home').attr('src',app.img()+'/home.jpg').css('width','30px');
		$('#account_content_a_home').attr('alt','home').click(function(){controller.home();});
		$('#account_content').addClass('box').css('font-size','20px');
		$('#account_content > article').css('width','300px')
		   .addClass('center').addClass('text_left');
		$('#account_content a').css('font-size','15px').addClass('cursor');
		$('#account_content > h1').text('ACCOUNT MGMT');
		$('#account_content_ol > li > a').addClass('remove_underline');
		$('#account_content_ol > li:first > a').text('MAKE ACCOUNT');
		$('#account_content_ol > li:nth(1) > a').text('DEPOSIT');
		$('#account_content_ol > li:nth(2) > a').text('WITHDRAWAL');
		$('#account_content_ol > li:nth(3) > a').text('UPDATE');
		$('#account_content_ol > li:nth(4) > a').text('DELETE');
		$('#account_content_ol > li:nth(5) > a').text('LIST');
		$('#account_content_ol > li:nth(6) > a').text('SEARCH');
		$('#account_content_ol > li:nth(7) > a').text('COUNT');
	};
	var onCreate = function(){
		setContentView();
		$('#bt_bom').click(function(){controller.move('','bom');});
		$('#bt_dom').click(function(){controller.move('','dom');});
		$('#bt_kaup').click(function(){controller.move('','kaup');});
		$('#bt_account').click(function(){controller.move('','account');});
		$('#c_deposit').click(function(){controller.move('account','deposit');});
		$('#c_withdraw').click(function(){controller.move('account','withdraw');});
		$('#c_update').click(function(){controller.move('account','update');});
		$('#c_delete').click(function(){controller.move('account','delete');});
		$('#c_list').click(function(){controller.move('account','list');});
		$('#c_search').click(function(){controller.move('account','search');});
		$('#c_count').click(function(){controller.move('account','count');});
		$('#c_regist').click(function(){controller.move('account','regist');});
	};
	var context = sessionStorage.getItem("context");	
	return{
		init : init
	};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		$('#bt_spec_show').click(member.spec());
		$('#bt_make_account').click(this.spec());
		$('#bt_deposit').click(this.deposit());
		$('#bt_withdrawal').click(this.withdrawal());
	};
	return{
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : init,
		spec : function(){
			setAccountNo(Math.floor((Math.random() * 899999) + 100000));
			document.querySelector('#result_account').innerHTML= getAccountNo();
			setMoney(0);
		},
		deposit : function(){
			var r_acc = document.querySelector('#result_account').innerText;
			console.log('계좌번호 : '+r_acc);
			switch (typeof r_acc) {
			case 'number': console.log('this is number type ');break;
			case 'string': console.log('this is string type ');break;
			case 'undefined': console.log('this is undefined type ');break;
			default : console.log('type check fail');break;
			}
			if (r_acc == '') {
				// r_acc == null
				// r_acc === undefined
				alert('먼저 통장이 개설되어야 합니다.');
			} else {
				var input_money = Number(document.querySelector('#money').value);
				var rest_money = getMoney();
				console.log('인풋 머니 타입 체크 : '+(typeof input_money === 'number'));
				console.log('잔액 차입 체크 : '+(typeof rest_money === 'number'))
				console.log("입금액 : "+input_money);
				console.log("잔액 : "+rest_money);
				setMoney(input_money + rest_money);
				document.querySelector('#rest_money').innerHTML=getMoney();
			}
		},
		withdrawal : function(){
			var input_money = Number(document.querySelector('#money').value);
			var rest_money = getMoney();
			setMoney(rest_money - input_money);
			document.querySelector('#rest_money').innerHTML=getMoney();
		}
	};
})();
var member = (function(){
	var _name,_gender;
	var _age;
	var setName = function(name){this._name=name;};
	var getName = function(){return this._name;};
	var setAge = function(age){this._age=age;};
	var getAge = function(){return this._age;};
	var setGender = function(gender){this._gender=gender;};
	var getGender = function(){return this._gender;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content_img_home').attr('src',app.img()+'/home.jpg').css('width','30px');
		$('#member_content_a_home').attr('alt','home').click(function(){controller.home();});
		$('#member_content').addClass('box').css('font-size','20px');
		$('#member_content > article').css('width','300px')
		   .addClass('center').addClass('text_left');
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
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#member_regist #bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#member_regist #rd_major > label:gt(1)').addClass('radio-inline');
		$('#member_regist #ck_subject').addClass('checkbox');
		$('#member_regist #ck_subject > label').addClass('checkbox-inline');
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function(){controller.move('member','regist');});
		$('#detail').click(function(){controller.move('member','detail');});
		$('#update').click(function(){controller.move('member','update');});
		$('#delete').click(function(){controller.move('member','delete');});
		$('#login').click(function(){controller.move('member','login');});
		$('#logout').click(function(){controller.move('member','logout');});
		$('#list').click(function(){controller.move('member','list');});
		$('#find_by').click(function(){controller.move('member','find_by');});
		$('#count').click(function(){controller.move('member','count');});
	};
	return {
		setName : setName,
		getName : getName,
		setAge : setAge,
		getAge : getAge,
		setGender : setGender,
		getGender : getGender,
		init : init,
		spec : function(){
			var name = document.querySelector('#name').value;
			var curyear = Number(new Date().getFullYear());
			
			var gendergubun = Number(document.querySelector('#ssn').value.substring(7,8));
			var year = Number(document.querySelector('#ssn').value.substring(0,2));
			
			switch (gendergubun) {
			case 1:case 5:
				setGender("남");
				year += 1900;
				break;
			case 3:case 7:
				setGender("남");
				year += 2000;
				break;		
			case 2:case 6:
				setGender("여");
				year += 1900;
				break;
			case 4:case 8:
				setGender("여");
				year += 2000;
				break;
			default:
				break;
			}
			setAge(curyear - year + 1);
			document.querySelector('#result_name').innerHTML=getName();
			document.querySelector('#result_age').innerHTML=getAge();
			document.querySelector('#result_gender').innerHTML=getGender();
		}
	};
})();
var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass = pass;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#admin_content').addClass('box').css('font-size','20px');
		$('#admin_content > article').css('width','300px')
		   .addClass('center').addClass('text_left');
		$('#admin_content a').css('font-size','15px').addClass('cursor');
		$('#admin_content > h1').text('관리자 메인화면');
		$('#admin_content_ol > li > a').addClass('remove_underline');
		$('#admin_content_ol > li:first > a').text('SIGN UP');
		$('#admin_content_ol > li:nth(1) > a').text('DETAIL');
		$('#admin_content_ol > li:nth(2) > a').text('UPDATE');
		$('#admin_content_ol > li:nth(3) > a').text('DELETE');
		$('#admin_content_ol > li:nth(4) > a').text('LIST');
		$('#admin_content_ol > li:nth(5) > a').text('SEARCH');
		$('#admin_content_ol > li:nth(6) > a').text('COUNT');
		$('#admin_content > h3').addClass('text_align_center');
	};
	var onCreate = function(){
		setContentView();
		$('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list');});
		$('#admin_nav #member_mgmt #find_by').click(function(){controller.move('member','find_by');});
		$('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
		$('#admin_nav #account_mgmt #c_list').click(function(){controller.move('account','list');});
		$('#admin_nav #account_mgmt #c_regist').click(function(){controller.move('account','regist');});
		$('#admin_nav #account_mgmt #c_delete').click(function(){controller.move('account','delete');});
		$('#admin_nav #account_mgmt #c_search').click(function(){controller.move('account','search');});
		$('#admin_nav #account_mgmt #c_count').click(function(){controller.move('account','count');});
		$('#admin_content_img_home').attr('src',app.img()+'/home.jpg').css('width','30px');
		$('#admin_content_a_home').attr('alt','home').click(function(){controller.home();});
		$('#member_management').attr('src',app.img()+'/member_management.jpg').css('width','350px').css('height','420px');
		$('#grade_management').attr('src',app.img()+'/grade_management.jpg').css('width','350px').css('height','420px');
		$('#account_management').attr('src',app.img()+'/account_management.jpg').css('width','350px').css('height','420px');
	};
	return{
		getPass : getPass,
		setPass : setPass,
		init : init,
		setContentView : setContentView,
		onCreate : onCreate,
		checkAdmin : function(){
			setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('관리자 비번을 입력바랍니다.');
				if(password == getPass()){
					controller.move('admin','main');
				} else {
					alert('관리자 비번이 틀립니다.');
				}
			}
			
		}
	};
})();
var kaup = (function(){
	var _name;
	var _height=0,_weight=0;
	var setName = function(name){this._name=name;};
	var getName = function(){return this._name;};
	var setHeight = function(height){this._height=height;};
	var getHeight = function(){return this._height;};
	var setWeight = function(weight){this._weight=weight;};
	var getWeight = function(){return this._weight;};
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		document.querySelector('#bt_kaup_calc').addEventListener('click',this.calc,false);
	};
	return{
		setName : setName,
		getName : getName,
		setHeight : setHeight,
		getHeight : getHeight,
		setWeight : setWeight,
		getWeight : getWeight,
		init : init,
		calc : function(){
			setName(document.querySelector('#name').value);
			setHeight(Number(document.querySelector('#height').value));
			setWeight(Number(document.querySelector('#weight').value));
			var result = '';
			var kaup = getWeight() / (getHeight() / 100) / (getHeight() / 100);
			if (kaup < 18.5) {
				result = "저체중";
			} else if (kaup <= 22.9 && kaup >= 18.5) {
				result = "정상";
			} else if (kaup <= 24.9 && kaup >= 23.0) {
				result = "위험체중";
			} else if (kaup <= 29.9 && kaup >= 25.0) {
				result = "비만1단계";
			} else if (kaup <= 40 && kaup >= 30.0) {
				result = "비만2단계";
			} else if (kaup > 40) {
				result = "비만3단계";
			}
			document.querySelector('#result').innerHTML=getName()+' 의 카우푸결과 '+ result;
		}
	};
})();
var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content_img_home').attr('src',app.img()+'/home.jpg').css('width','30px');
		$('#grade_content_a_home').attr('alt','home').click(function(){controller.home();});
		$('#grade_content').addClass('box').css('font-size','20px');
		$('#grade_content > article').css('width','300px')
		   .addClass('center').addClass('text_left');
		$('#grade_content a').css('font-size','15px').addClass('cursor');
		$('#grade_content > h1').text('GRADE MGMT');
		$('#grade_content_ol > li > a').addClass('remove_underline');
		$('#grade_content_ol > li:first > a').text('SIGN UP');
		$('#grade_content_ol > li:nth(1) > a').text('UPDATE');
		$('#grade_content_ol > li:nth(2) > a').text('DELETE');
		$('#grade_content_ol > li:nth(3) > a').text('LIST');
		$('#grade_content_ol > li:nth(4) > a').text('COUNT');
		$('#grade_content_ol > li:nth(5) > a').text('SEARCH');
	};
	var onCreate = function(){
		setContentView();
		$('#g_regist').click(function(){controller.move('grade','regist');});
		$('#g_update').click(function(){controller.move('grade','update');});
		$('#g_delete').click(function(){controller.move('grade','delete');});
		$('#g_list').click(function(){controller.move('grade','list');});
		$('#g_search').click(function(){controller.move('grade','search');});
		$('#g_count').click(function(){controller.move('grade','count');});
	};
	return {
		init : init
	};
})();
var session = (function(){
	var init = function(context){
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
	};
	var getContextPath = function(){return sessionStorage.getItem('context');};
	var getJavascriptPath = function(){return sessionStorage.getItem('js');};
	var getCssPath = function(){return sessionStorage.getItem('js');};
	var getImagePath = function(){return sessionStorage.getItem('img');};
	return {
		init : init,
		getContextPath : getContextPath,
		getJavascriptPath : getJavascriptPath,
		getCssPath : getCssPath,
		getImagePath : getImagePath
	};
	
})();
var controller = (function(){
	var _page,_directory;
	var setDirectory = function(directory){this._directory=directory;};
	var setPage = function(page){this._page=page;};
	var getDirectory = function(){return this._directory;};
	var getPage = function(){return this._page;};
	return{
		setDirectory : setDirectory,
		setPage : setPage,
		getDirectory : getDirectory,
		getPage : getPage,
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			
			location.href=app.context()+'/'+getDirectory()+'/'+getPage();
		},
		home : function(){
			location.href=app.context()+'/';
		}
	};
})();
var util = (function(){
	return{
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_black').css('margin','0').css('padding','0');
		$('#nav li').addClass('float_left').addClass('display_inline').css('border-right','1px').css('solid','#bbb');
		$('#nav li:last-child').css('border-right','none');
		$('#nav li a').addClass('color_white').addClass('text_align_center').css('display','block').css('padding','3px 2px').css('text-decoration','none');
		
		$('#nav li a:hover:not(.active)').addClass('bg_color_green');
		$('#nav .active').addClass('bg_color_black');
		$('#header_brand').css('font-size','15px').addClass('cursor');
		$('#header_brand').attr('src',app.img()+'/gof.JPG').css('width','70px').css('height','40px');
		$('#header_brand_a_home').attr('alt','home').click(function(){controller.home();});
	};
	var onCreate = function(){setContentView()};
	return{
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
	};
})();