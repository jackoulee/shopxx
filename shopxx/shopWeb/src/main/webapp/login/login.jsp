<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/shopWeb/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/shopWeb/js/Highcharts/exporting.js"></script>
 <script type="text/javascript" src="/shopWeb/js/Highcharts/highcharts.js"></script>
<style type="text/css">
	body{
		background: #ebebeb;
		font-family: "Helvetica Neue","Hiragino Sans GB","Microsoft YaHei","\9ED1\4F53",Arial,sans-serif;
		color: #222;
		font-size: 12px;
	}
	*{padding: 0px;margin: 0px;}
	.top_div{
		background: #008ead;
		width: 100%;
		height: 400px;
	}
	.ipt{
		border: 1px solid #d3d3d3;
		padding: 10px 10px;
		width: 290px;
		border-radius: 4px;
		padding-left: 35px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
		box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
		-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
		-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
		transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
	}
	.ipts{
		border: 1px solid #d3d3d3;
		padding: 10px 10px;
		width: 200px;
		border-radius: 4px;
		padding-right: 35px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
		box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
		-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
		-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
		transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
	}
	.ipt:focus{
		border-color: #66afe9;
		outline: 0;
		-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
		box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
	}
	.u_logo{
		background: url("/shopWeb/login/images/username.png") no-repeat;
		padding: 10px 10px;
		position: absolute;
		top: 43px;
		left: 40px;
	
	}
	.p_logo{
		background: url("/shopWeb/login/images/password.png") no-repeat;
		padding: 10px 10px;
		position: absolute;
		top: 12px;
		left: 40px;
	}
	a{
		text-decoration: none;
	}
	.tou{
		background: url("/shopWeb/login/images/tou.png") no-repeat;
		width: 97px;
		height: 92px;
		position: absolute;
		top: -87px;
		left: 140px;
	}
	.left_hand{
		background: url("/shopWeb/login/images/left_hand.png") no-repeat;
		width: 32px;
		height: 37px;
		position: absolute;
		top: -38px;
		left: 150px;
	}
	.right_hand{
		background: url("/shopWeb/login/images/right_hand.png") no-repeat;
		width: 32px;
		height: 37px;
		position: absolute;
		top: -38px;
		right: -64px;
	}
	.initial_left_hand{
		background: url("/shopWeb/login/images/hand.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -12px;
		left: 100px;
	}
	.initial_right_hand{
		background: url("/shopWeb/login/images/hand.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -12px;
		right: -112px;
	}
	.left_handing{
		background: url("/shopWeb/login/images/left-handing.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -24px;
		left: 139px;
	}
	.right_handinging{
		background: url("/shopWeb/login/images/right_handing.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -21px;
		left: 210px;
	}
</style>
</head>
<body>
<DIV class="top_div"></DIV>
	<DIV id="container" style=" margin: -200px auto auto; margin-left: 50px; border: 1px solid rgb(231, 231, 231); 
	border-image: none; min-width: 850px; height: 400px; text-align: center; float: left">
	</DIV>
	<DIV style="background: rgb(255, 255, 255); margin: -130px auto auto; margin-right: 50px; border: 1px solid rgb(231, 231, 231);
		 border-image: none; width: 400px; height: 250px; text-align: center; float: right">
		<DIV style="width: 165px; height: 96px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<P style="padding: 30px 0px 10px; position: relative;">
			<SPAN class="u_logo"></SPAN> 
			<INPUT class="ipt" type="text" placeholder="请输入用户名或邮箱" value="" id="user">
		</P>
		<P style="padding: 1px 0px 10px;position: relative;">
			<SPAN class="p_logo"></SPAN> 
			<INPUT class="ipt" id="password" type="password" placeholder="请输入密码" value="">
		</P>
		<P style="position: relative;">
			<input class="ipts" id="validateCode" onblur="checkImg(this.value)" name="validateCode" type="text"  placeholder="输入验证码"/>
			<span class="y_yzimg"><img id="codeValidateImg"  onClick="javascript:flushValidateCode();"/></span>
			<input type="hidden" id="codes" value="0">
		</P>
		<DIV
			style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px;
			border-top-style: solid;">
			<P style="margin: 0px 35px 20px 45px;">
				<SPAN style="float: left;"> 
					<A style="color: rgb(204, 204, 204);" href="/shopWeb/login/register.jsp">忘记密码?</A>
				</SPAN> 
				<SPAN style="float: right;"> 
					<A style="color: rgb(204, 204, 204); margin-right: 10px;" href="/shopWeb/login/register.jsp">注册</A>
					<A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); 
					border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:void(0)" onclick="login()">登录</A>
				</SPAN>
			</P>
		</DIV>
	</DIV>
<script type="text/javascript">
$(function(){
	//得到焦点
	$("#password").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#password").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
});
function login(){
	var codes = $("#codes").val();
	if(codes == 1){
		var username = $("#user").val();
		var password = $("#password").val();
		$.ajax({
			type:"post",
			url:"/shopWeb/userController/login.do",
			data:{userName:username,passWord:password},
			dataType:"json",
			success:function(result){
				if(result == 3){
					location.href = "/shopWeb/index.jsp";
				}else if(result == 2){
					alert("密码错误，请重新输入。");
				}else if(result == 1){
					alert("用户不存才，请重新输入。");
				}
			},
			error:function(){
				alert("重置出错");
			}
		})
	}else if(codes == 2){
		
	}else if(codes == 0){
		alert("请输入验证码。");
	}

}
$(document).ready(function() {
    flushValidateCode();//进入页面就刷新生成验证码
  });

/* 刷新生成验证码 */
function flushValidateCode(){
	var validateImgObject = document.getElementById("codeValidateImg");
	validateImgObject.src = "${pageContext.request.contextPath }/userController/getSysManageLoginCode.do?time=" + new Date();
	$("#codes").val(0);
}
/*校验验证码输入是否正确*/
function checkImg(code){
   var url = "${pageContext.request.contextPath}/userController/checkimagecode.do";
   $.get(url,{"validateCode":code},function(data){
       if(data=="ok"){
           $("#codes").val(1);
       }else{           
    	   alert("验证码错误，请重新输入。");
    	   flushValidateCode();
           $("#codes").val(2);
       }
   })
}

function test(monthEveryJson,sumPeopleNumberJson){
	$(document).ready(function() {

	   var credits={
		    enabled: false//页面右下角授权默认是true字符 是否显示Highcharts的官网地址
		};
	   var title = {//大图标的标题
	       text: '每日访问人数统计'   
	   };
	   var subtitle = {//小标题业绩对比图
	        text: '访问量展示图'
	   };
	   //图表中横轴的值
	   var xAxis = {
	       categories: monthEveryJson,//设置X轴分类名称，数组
	       lineColor: "#800000",//横轴的颜色
	       lineWidth:4
	   };
	 //图表中竖轴的值
	   var yAxis = {
	      title: {
	         text: '访问人次（人）'
	      },
	      //对比值的 参数
	      plotLines: [{
	         value: 600,//比对数值的横线值为竖轴的刻度
	         width: 2,//线条的宽度
	         color: 'red'//线条的颜色
	      }]
	   };   

	    var tooltip = {
	      valueSuffix: '人',//数据的单位  自定义
	      backgroundColor:"",//数据点数据框背景颜色
	      borderWidth:0,//数据点的边框宽度
	   } 
	    var legend = {
	      layout: 'vertical',//设置折线图形 的样式   图例项目的布局。可以是’horizontal’或’vertical’ 
	      align: 'right',//设定图例在图表区中的水平对齐方式，合法值有left，center 和 right。默认是：center.
	      borderColor: '',//图例的边框颜色。 默认是：#999999.
	      verticalAlign: 'bottom',//图例框的垂直对齐方式
	      borderWidth: 2 //显示边框效果
	   }; 
	
	   var series =  [
	      {
	         name: '当日访问人次（人）',
	         data:sumPeopleNumberJson
	      }, 
	     
	   ];
	
	   var json = {};
	
	   json.title = title;
	   json.subtitle = subtitle;
	   json.xAxis = xAxis;
	   json.yAxis = yAxis;
	   json.tooltip = tooltip;
	   json.legend = legend;
	   json.series = series;
	   json.credits = credits;
	   
	   $('#container').highcharts(json);
	});
	
}
$(function(){
	 $.ajax({
			type:"post",
			url:"/shopWeb/userController/queryCount.do",
			dataType:"json",
			success:function(result){	
				var monthEveryJson=[];
				var sumPeopleNumberJson=[];
				for (var i = 0; i <result.length; i++) {
					monthEveryJson.push(result[i].countDay);//为数组中追加内容
					sumPeopleNumberJson.push(result[i].countNumber);
				}
                test(monthEveryJson,sumPeopleNumberJson)
       		},
       		error:function(){
				alert("获取数据异常");
			}
			
		});
	   
});
</script>
</body>
</html>