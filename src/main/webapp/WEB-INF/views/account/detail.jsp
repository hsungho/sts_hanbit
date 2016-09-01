<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<div class="box" style="height: 150px">
	<ul class="list-group">
	   	<li class="list-group-item">박신혜</li>
	   	<li class="list-group-item">26</li>
		<li class="list-group-item">여</li>
		<li class="list-group-item">123-456-789</li>
		<li class="list-group-item">3,000,000,000</li>
	</ul>
<div class="panel panel-primary">
  	<div class="panel-heading">계좌 내역</div>
  	<div class="panel-body"></div>	
<table>
  <tr>
    <th>날짜</th>
    <th>입금</th>
    <th>출금</th>
    <th>잔액</th>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>500,000,000</td>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>1,000,000,000</td>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>1,500,000,000</td>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>2,000,000,000</td>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>2,500,000,000</td>
  </tr>
  <tr>
    <td>2016-08-01</td>
    <td>500,000,000</td>
    <td>0</td>
    <td>3,000,000,000</td>
  </tr>
</table>	  
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	</div>
</div>