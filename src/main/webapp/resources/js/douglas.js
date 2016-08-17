var util = (function(){
	var _page,_directory;
	var setPage=function(page){this._page=page;};
	var setDirectory=function(directory){this._directory=directory;};
	return {
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = 
				sessionStorage.getItem("context")+'/'+getDirectory()+'.do?page='+getPage();
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var move = function(context,page){
	location.href=context+'/douglas.do?page='+page;
}
var douglas = (function(){
	var context = sessionStorage.getItem("context");
	return {
		init : function() {
			document.querySelector('#bt_bom').addEventListener('click',function(){move(context,'bom');},false);
			document.querySelector('#bt_dom').addEventListener('click',function(){move(context,'dom');},false);
			document.querySelector('#bt_kaup').addEventListener('click',function(){move(context,'kaup');},false);
			document.querySelector('#bt_account').addEventListener('click',function(){move(context,'account');},false);
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
			document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
			document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
			document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
			document.querySelector('#bt_withdraw').addEventListener('click',this.withdraw,false);
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


