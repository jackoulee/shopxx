<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/shopWeb/js/jquery-1.9.1.min.js"></script>
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
		top: 14px;
		left: 40px;
	}
	.p_logotwo{
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
	<DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231);
		 border-image: none; width: 400px; height: 250px; text-align: center;">
		<DIV style="width: 165px; height: 96px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<P style="padding: 30px 0px 10px; position: relative;">
			<SPAN class="u_logo"></SPAN> 
			<INPUT class="ipt" type="text" placeholder="请输入用户名" value="" id="user">
		</P>
		<P style="padding: 3px 0px 10px;position: relative;">
			<SPAN class="p_logo"></SPAN> 
			<INPUT class="ipt" id="password" type="password" placeholder="请输入密码" value="" >
		</P>
		<P style="position: relative;">
			<SPAN class="p_logotwo"></SPAN> 
			<INPUT class="ipt" id="passwordTwo" type="password" placeholder="请再次输入密码" value="" onblur="checkPwd()">
		</P>
		<DIV
			style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px;
			border-top-style: solid;">
			<P style="margin: 0px 35px 20px 45px;">
				<SPAN style="float: left;"> 
					<!-- <A style="color: rgb(204, 204, 204);" href="#">忘记密码?</A> 
					<A style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">重置密码</A> -->
				</SPAN> 
				<SPAN style="float: right;"> 
					<A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); 
					border-image: none; color: rgb(255, 255, 255); font-weight: bold;margin-right: 10px;" onclick="reset()">重置密码</A>
					<A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); 
					border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="register()">注册</A>
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
	//得到焦点
	$("#passwordTwo").focus(function(){
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
	$("#passwordTwo").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
});
//检查两次密码是否正确
function checkPwd(){ 
	var username = $("#user").val();
	var password = $("#password").val();
	var passwordTwo = $("#passwordTwo").val();
	if(password != null && passwordTwo != null && password == passwordTwo){
		return true;
	}else{
		alert("两次密码不正确或输入为空");
		return false;
	}
}
//注册
function register(){
	if(checkPwd()){
		var username = $("#user").val();
		var passwordTwo = $("#passwordTwo").val();
		$.ajax({
			type:"post",
			url:"/shopWeb/userController/register.do",
			data:{userName:username,passWord:passwordTwo},
			dataType:"json",
			success:function(result){
				if(result == 4){
					location.href = "/shopWeb/login/login.jsp";
				}else if(result == 6){
					alert("账号已经被注册，请重新输入信息");
				}
			},
			error:function(){
				alert("注册出错");
			}
		})
	}
}
//重置密码
function reset(){
	if(checkPwd()){
		var username = $("#user").val();
		var passwordTwo = $("#passwordTwo").val();
		$.ajax({
			type:"post",
			url:"/shopWeb/userController/reset.do",
			data:{userName:username,passWord:passwordTwo},
			dataType:"json",
			success:function(result){
				if(result == 7){
					location.href = "/shopWeb/login/login.jsp";
				}else if(result == 1){
					alert("用户不存才，请确认帐号。");
				}
			},
			error:function(){
				alert("重置出错");
			}
		})
	}
}
</script>
</body>
</html>