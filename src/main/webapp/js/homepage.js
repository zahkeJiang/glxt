$(function(){
	$(".container_search_order p").click(function(){
		var ordernumbertype = /^[A-Za-z0-9]+$/;
		var ordernumber = $("input[name='search_order']").val();
		if (ordernumbertype.test(ordernumber)) {
			// $.cookie="ordernumber="+ordernumber;
			window.location.href="order_information.html?ordernumber="+ordernumber;
			
		}else{
			alert("请输入正确的订单号");
		}
	});
});