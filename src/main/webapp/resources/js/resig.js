var grade = (function(){
	return{
		init : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width','5%)')
			$('#grade_content > article')
			.css('width','300px')
			.css('text-align','left')
			.css('margin','0 auto')
		    $('#title').css('font-size','40px')
			$('#a_regist').click(function(){ 
				location.href ="${context}/grade/regist.do"
		});
			$('#a_update').click(function(){ 
				location.href ="${context}/grade/update.do"
		});
			$('#a_delete').click(function(){ 
				location.href ="${context}/grade/delete.do"
		});
			$('#a_list').click(function(){ 
				location.href = "${context}/grade/list.do"
		});
			$('#a_count').click(function(){ 
				location.href =	"${context}/grade/count.do"
		});
			$('#a_find').click(function(){ 
				location.href = "${context}/grade/search.do"
		});
		}
	};
})();

