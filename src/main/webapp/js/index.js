

$(function(){
	$("#renovation").click(function(){
		var codeimg = document.getElementById("code_pic");  
		codeimg.src = "verifi_code?date=" + new Date();
	});
	$("#submit").click(function(){
		var account = $("#account").val();
		var password = $("#password").val();
		var code = $("#code").val();
		$.post("login",{"account":account,"password":password,"code":code},function(data){
			if (data.status==0) {
				window.location.href="homepage.html";
			}else{
				alert("登陆失败");
			}
		},"json");
	});
});