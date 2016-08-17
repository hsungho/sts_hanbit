var util = (function(){
	var _page,_directory;
	var context = sessionStorage.getItem("context");
	var setPage = function(page){this._page=page;};
	var getPage = function(){return this._page};
	var setDirectory = function(directory){this._directory=directory;};
	var getDirectory = function(){this._directory;};
	return{
		move : function(directory,page){
			setDiretory(directory);
			setPage(page);
			location.href=sessionStorage.getItem("context")+'/'+getDirectory()+'.do?page='+getPage();
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	}
})();
var move = function(context,page){
	location.href=context+'/douglas.do?page='+page;
}
var douglas = (function(){
	var context = sessionStorage.getItem("context");	
	return{
		init : function(){
			document.querySelector('#bt_bom').addEventListener('click',function(){move(context,'bom');},false);
			document.querySelector('#bt_dom').addEventListener('click',function(){move(context,'dom');},false);
			document.querySelector('#bt_kaup').addEventListener('click',function(){move(context,'kaup');},false);
			document.querySelector('#bt_account').addEventListener('click',function(){move(context,'account');},false);
		}
	};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no){this._account_no=account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	return{
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : function(){
		document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
		document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
		document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
		document.querySelector('#bt_withdrawal').addEventListener('click',this.withdrawal,false);
		},
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
var kaup = (function(){
	var _name;
	var _height=0,_weight=0;
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setHeight = function(height){this._height=height;}
	var getHeight = function(){return this._height;}
	var setWeight = function(weight){this._weight=weight;}
	var getWeight = function(){return this._weight;}
	return{
		setName : setName,
		getName : getName,
		setHeight : setHeight,
		getHeight : getHeight,
		setWeight : setWeight,
		getWeight : getWeight,
		init : function(){
			document.querySelector('#bt_kaup_calc').addEventListener('click',this.calc,false);
		},
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
			/*return name+" 은 BMI 지수는 "+ Double.parseDouble(String.format("%.2f", bmigisu)) +" 이고 "+kaupu+" 이다";*/
		}
	};
})();
var member = (function(){
	var _name,_gender;
	var _age;
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setAge = function(age){this._age=age;}
	var getAge = function(){return this._age;}
	var setGender = function(gender){this._gender=gender;}
	var getGender = function(){return this._gender;}
	return {
		setName : setName,
		getName : getName,
		setAge : setAge,
		getAge : getAge,
		setGender : setGender,
		getGender : getGender,
		spec : function(){
			setName(document.querySelector('#name').value);			
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

