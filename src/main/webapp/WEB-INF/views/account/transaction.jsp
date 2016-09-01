<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="container" style='width:100%'>
<div class="jumbotron">
  <h1>Hello, world!</h1>
  <img src="${img}/account/hana.jpg"/>
  <p><a class="btn btn-primary btn-lg" href="https://www.kebhana.com/" role="button">하나은행</a></p>
</div>
<h3 style='margin:0 auto;width:250px'>입출금</h3>
	<section>
		금액 : <input type="text" name="money" id="money" />
		<input type="button" id="bt_deposit" value="입금"/>
		<input type="button" id="bt_withdrawal" value="출금"/>
	</section>
</div>
