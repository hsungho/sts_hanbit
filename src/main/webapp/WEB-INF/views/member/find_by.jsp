<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box" style='padding-top:0'>
	<form id="member_find_form" class="navbar-form navbar-center" role="search">
		<div class="form-group">
			<div>
				<select name="search_option" style='width:100px;height:30px'>
					<option value="id">ID</option>
					<option value="name">NAME</option>
					<option value="gender">GENDER</option>
				</select>
    			<input type="text" name="keyword" class="form-control" placeholder="Search"/>
    			<input type="hidden"/>
	  			<input type="submit" class="btn btn-primary" value="SEARCH"/>
	  		</div>
    		</div><!-- /input-group -->
	</form>
</div>