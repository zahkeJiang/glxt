$(function(){
	search();
	function search(){
		$("tbody").children().remove();
		var requestKey = $('#select option:selected').val();
		alert("requestKey="+requestKey);
		var requestValue = $("#int_search").val();
		$.post("dsOrder/finish",{quest:requestValue},function(obj){
			if (obj.status == 0) {
			 	var list = obj.data;//获取dsolist数组
			 	/*获取套餐信息并加载*/
			 	for( var i = 0;i<list.length;i++){
			 	//data[i];
			 		var str = "<tr><td>"+list[i].dsname+"</td><td>"+list[i].dstype+"</td><td>"+list[i].models+"</td><td>"
			 		+list[i].refundtime+"</td><td class='pri'>"+list[i].orderprice+"¥</td><td>"+list[i].realname+"</td><td>"
			 		+list[i].ordernumber+"</td><td>"+list[i].phonenumber+"</td></tr>";
	        		$("tbody").append(str);//append添加数据

			 	}
			 	$(".pri").css("color","#fd0000");
			 	$("tbody>tr:odd").addClass("odd");///为tbody中基数行添加样式
	            $("tbody>tr:even").addClass("even");//为tbody中偶数行添加样式
	            $("tbody>tr").mouseover(function(){
	            	//alert($(this).children().eq(6).html());
	            	$(this).addClass("select");
	            	// $(this).find("td").eq(4).addClass("delete_on");

	        	}).mouseout(function(){           		
	            	$(this).removeClass("select");
	            	// $(this).find("td").eq(4).removeClass("delete_on");
	            })

			 	}else{
			 		alert(obj.msg);
			 	}
		},'json');
	}
	
	/*搜索功能*/
	$(".search_school").mouseover(function(){
		$(this).css({"color":"red",
			"cursor":"pointer"
		});
	}).mouseout(function(){
		$(this).css({"color":"blue"
		});
	}).on('click', function () {
		search();
	});
});