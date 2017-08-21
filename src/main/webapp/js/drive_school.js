function delete_line(packageid){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			console.log("onreadystatechange: "+xhr.readyState);
			if(xhr.readyState === 4){
 				if (xhr.status === 200) {
 					/*解析json字符串*/
 					var obj = eval('(' + xhr.responseText + ')');//json是以字符串传过来，需要对其进行转成对象。
 					if (obj.status == 1) {
 						a();
 					}else{
 						alert("删除失败!");
 					}
 				}
			}
		}
		xhr.open( "POST", "ddp.action");
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		var data="packageid="+packageid;
		xhr.send(data);// 发送HTTP请求
	}

			function a(){
				$("tbody").children().remove();
				var int_search = $("#int_search").val();
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function(){
	    			console.log("onreadystatechange: "+xhr.readyState);
					if(xhr.readyState === 4){
		 				if (xhr.status === 200) {
		 					/*解析json字符串*/
		 					var obj = eval('(' + xhr.responseText + ')');//json是以字符串传过来，需要对其进行转成对象。
		 					if (obj.status == 1) {
		 						var list = obj.dsplist;//获取dsolist数组
		 						/*获取套餐信息并加载*/
		 						for( var i = 0;i<list.length;i++){
		 							//data[i];
		 							var str = "<tr><td>"+list[i].dsname+"</td><td>"+list[i].dstype+"</td><td>"+list[i].models+"</td><td>"+list[i].traintime+"</td><td>"+list[i].price+"</td><td>"+list[i].description+"</td><td class='del'>"+list[i].packageid+"</td></tr>";
        							$("tbody").append(str);//append添加数据

		 						}
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

            					//鼠标悬浮在"删除"上改变字体颜色  使用事件委托
								var colorStatus="";//保存鼠标悬浮前的颜色
								$("tbody>tr").delegate(".del","mouseover",function(){
									colorStatus=$(this).css("color");
									$(this).css({"color":"red","cursor":"pointer"});
								}).delegate(".del","mouseout",function(){
									$(this).css("color",colorStatus);
									}).delegate(".del","click",function(){
									//点击  删除  弹出“价格”
									var packageid = $(this).html();
									delete_line(packageid);									
								})

								
		 					}else{
		 						alert("获取失败!");
		 					}
		 				}
					}
				}
				xhr.open( "POST", "sdp.action");
				xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				var data="dsname="+int_search;
				xhr.send(data);// 发送HTTP请求
			}
		
			

			/*获取套餐信息*/
        /*	for (var i = 0; i < data.length; i++) {
            	data[i];
            	var str = "<tr><td>"+data[i].dsname+"</td><td>"+data[i].dstype+"</td><td>"+data[i].models+"</td><td>"+data[i].traintime+"</td><td>"+data[i].price+"</td><td>"+data[i].description+"</td><td class='del'>"+"删除"+"</td></tr>";
            	$("tbody").append(str);//append添加数据
            }*/

            $(function(){
				a();

				/*搜索功能*/
				$(".search_school").mouseover(function(){
					$(this).css({"color":"red",
						"cursor":"pointer"
					});
				}).mouseout(function(){
            		$(this).css({"color":"blue"
					});
				}).on('click', function () {
					a();
				});

            	/*打开弹窗*/
            	$(".add_school").mouseover(function(){
            		$(this).css({"color":"red",
						"cursor":"pointer"
					});
            	}).mouseout(function(){
            		$(this).css({"color":"blue"
					});
            	}).on('click', function () {
					$("body").append("<div id='mask'></div>");
					$("#mask").addClass("mask").fadeIn("slow");
					$("#LoginBox").fadeIn("slow");
				});

				/*关闭弹窗*/
				$(".close_btn").hover(function () {
		 			$(this).css({ color: 'black' }) 
				}, function () { 
					$(this).css({ color: '#999' })
				}).on('click', function () {
					$("#LoginBox").fadeOut("2000");				
					$("#mask").css({ display: 'none' });
				});

				/*提交驾校信息*/
				$("#button").click(function(){
					/*发送线程请求*/
					var dsname = $("#dsname").val();
					var dstype = $("#dstype").val();
					var models = $("#models").val();
					var traintime = $("#traintime").val();
					var price = $("#price").val();
					var description = $("#description").val();
					if (dsname !="" && dstype !="" && models != "" && traintime != "" && price !="" && description != "") {
   			 			var xhr = new XMLHttpRequest();
						xhr.onreadystatechange = function(){
		    				console.log("onreadystatechange: "+xhr.readyState);
							if(xhr.readyState === 4){
			 					if (xhr.status === 200) {
			 						/*解析json字符串*/
			 						var obj = eval('(' + xhr.responseText + ')');//json是以字符串传过来，需要对其进行转成对象。
			 						if (obj.status == 1) {
			 							$("#LoginBox").fadeOut("2000");				
			 							$("#mask").css({ display: 'none' });
			 							a();			 							
			 						}else{
			 							alert("获取失败!");
			 						}
			 					}
							}
						}
						xhr.open( "POST", "idp.action");
						xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
						var data="dsname="+dsname+"&dstype="+dstype+"&models="+models+"&traintime="+traintime+"&price="+price+"&description="+description;
						xhr.send(data);// 发送HTTP请求
					}else{
						alert("信息不完善，请重新输入");
					}
				})


            	
            })
   
