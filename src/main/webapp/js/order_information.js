var ordernumber = "";
function ShowMessage() 
{ 
   var thisURL = document.URL;    
   var getval = thisURL.split('?')[1];  
   ordernumber = getval.split("=")[1];  
} 
window.onload=ShowMessage(); 

$(function(){
	$.post("dsOrder/all",{"ordernumber":ordernumber},function(data){
		if (data.status=="0") {
			var orderurl = data.data;
			if (orderyrl.orderstatus=="0") {
				$(".orderstatus").html("未付款"); 
			}else if (orderyrl.orderstatus=="1") {
				$(".orderstatus").html("已付款");
			}else if (orderyrl.orderstatus=="2") {
				$(".orderstatus").html("材料提取中");
			}else if (orderyrl.orderstatus=="3") {
				$(".orderstatus").html("材料审核中");
			}else if (orderyrl.orderstatus=="4") {
				$(".orderstatus").html("报名已完成");
			}else if (orderyrl.orderstatus=="5") {
				$(".orderstatus").html("已取消");
			}
			$(".username").html(orderurl.realname); 
			$(".tel").html(orderurl.phonenumber); 
			$(".address").html(orderurl.address); 
			$(".order_information").html(orderurl.dsname+"$nbsp;&frasl;&nbsp;"+orderurl.dstype+"$nbsp;&frasl;&nbsp;"+orderurl.models+"$nbsp;&frasl;&nbsp;"+orderurl.traintime); 
			$(".note").html(orderurl.note); 
			$(".price").html(orderurl.originalprice+".00"); 
			$(".ordernumber").html(orderurl.ordernumber); 
			$(".ordertime").html(orderurl.paytime); 
			$(".coupon").html(orderurl.originalprice-orderurl.orderprice+".00"); 
			$(".pay_price").html(orderurl.orderprice+".00"); 
			

		}else if (data.status=="-10"){
			$(".information").empty();
			$(".information").html("订单号不存在");
		}else{
			alert("系统繁忙，请稍后再试");
		}		
	},"json");
});