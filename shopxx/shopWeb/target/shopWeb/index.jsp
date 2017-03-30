<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,
 initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<!-- <link rel="stylesheet" type="text/css" href="/shopWeb/js/bootstrap/css/bootstrap-responsive.min.css"> -->
<link rel="stylesheet" type="text/css" href="/shopWeb/js/bootstrap/css/bootstrap-3.3.7.min.css">
<link rel="stylesheet" type="text/css" href="/shopWeb/js/bootstrap-table/bootstrap-table.min.css">

<style type="text/css">
	#main{
		margin:50px 0 0 0
	}
	.navbar{
		background-color:#337ab7;
	}
	.navbar-default .navbar-nav > li > a {
    	color: #fff;
	}
</style>
</head>
<body>
	<input type="hidden" value="${user.userId}" id="user">
	<!-- 导航条组件 -->
	<div class="navbar navbar-default navbar-fixed-top" >
		<div class="container">
			<!-- 导航条头部 -->
			<div class="navbar-header">
				<a href="#" class="navbar-brand">公司logo</a>
				<button class="navbar-toggle" data-toggle="collapse" data-target="#nav-tool">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="nav-tool">
				<form action="" class="navbar-form navbar-right">
					<div class="input-group">
						<!-- /input-group -->
						<input type="text" class="form-control" placeholder="Search for..."> 
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">查询</button>
						</span>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li >
						<a href="#"><span class="glyphicon glyphicon-home"></span>首页</a>
					</li>
					<li>
						<a href="#"><span class="glyphicon glyphicon-question-sign"></span>关于</a>
					</li>
					<li>
						<a href="#">
							<span class="glyphicon glyphicon-user"></span>
								${user.userName}
							<span class="badge">5</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- 主体 -->
	<div id="main">
		<div class="container-fluid" style="margin-top: 70px">
			<div class="row">
				<div class="col-md-2">
					<div class="panel-group" id="accordion">
						<!-- <!-- 手风琴1
						<div class="panel panel-info">
							<div class="panel-heading" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne">
								<a class="accordion-toggle"> 商品 </a>
							</div>
							<div id="collapseOne" class="panel-collapse collapse">
								<div class="panel-body">
									<ul class="nav nav-pills nav-stacked">
										<li><a href="#">商品管理</a></li>
										<li><a href="#">库存管理</a></li>
									</ul>
								</div>
							</div>
						</div>

						手风琴2

						<div class="panel panel-info">
							<div class="panel-heading" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo">
								<a class="accordion-toggle"> 订单 </a>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse">
								<div class="panel-body">
									<ul class="nav nav-pills nav-stacked">
										<li><a href="#">订单管理</a></li>
										<li><a href="#">订单状态</a></li>
									</ul>
								</div>
							</div>
						</div>

						手风琴3

						<div class="panel panel-info">
							<div class="panel-heading" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree">
								<a class="accordion-toggle"> 统计 </a>
							</div>
							<div id="collapseThree" class="panel-collapse collapse">
								<div class="panel-body">
									<ul class="nav nav-pills nav-stacked">
										<li><a href="#">订单统计</a></li>
										<li><a href="#">商品排名</a></li>
									</ul>
								</div>
							</div>
						</div>
						手风琴4 -->
						 
						
					</div>
				</div>

				<div class="col-md-10">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">位置</h3>
						</div>
						<div class="panel-body" id="panel-body" >
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	
	<script src="/shopWeb/js/jquery-3.1.1.min.js"></script>
	<script src="/shopWeb/js/bootstrap/js/bootstrap-3.3.7.min.js"></script>
	<script src="/shopWeb/js/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="/shopWeb/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	
	<script type="text/javascript">
	
		$(function() {
			
			$.ajax({
				type:'post',
				url:'/shopWeb/rightController/showRight.do',
				data:{userId:$('#user').val()},
				dataType:'json',
				success:function(result){
					//console.log(result)
					var parents = [];
					for(var i = 0; i<result.length; i++){
						if(result[i].rightPid==0){
							parents.push(result[i])
							$('#accordion').append(
									'<div class="panel panel-info">'
										+'<div class="panel-heading" data-toggle="collapse"'
											+'data-parent="#accordion" href="#'+result[i].rightId+'">'
											+'<a class="accordion-toggle">'+result[i].rightName+'</a>'
										+'</div>'
										+'<div id="'+result[i].rightId+'" class="panel-collapse collapse">'
											+'<div class="panel-body" >'
												+'<ul class="nav nav-pills nav-stacked" id="'+result[i].rightId+'-son'+'">'
												+'</ul>'
											+'</div>'
										+'</div>'	
									+'</div>'	
							)
						}
					}
					console.log(parents)
					for (var i = 0; i < parents.length; i++) {
						for (var j = 0; j < result.length; j++) {
							if(result[j].rightPid==parents[i].rightId){
								$('#'+parents[i].rightId+'-son').append(
												'<li><a href="javascript:void(0)" onclick="showPage(this)" title="'+result[j].rightTitle+'">'+result[j].rightName+'</a></li>'
								)
							}
						}
					}
				}
			})
			
			$('#panel-body').load("/shopWeb/sub_page/welcome.jsp");
			
			/* $('a[title]').click(function(){
				var url = this.title;
				$('#panel-body').load("/shopWeb"+url+".jsp");
			}) */
			
		})
		
		function showPage(a){
			var url = a.title;
			$('#panel-body').load("/shopWeb"+url+".jsp");
		}
		
		
	</script>
</body>
</html>