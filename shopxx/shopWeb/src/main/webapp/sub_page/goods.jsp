<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="formSearch" class="form-horizontal">
			<div class="form-group" style="margin-top: 15px">
				<label class="control-label col-sm-1" for="goodNo">商品编号</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="goodNo">
				</div>
				<label class="control-label col-sm-1" for="goodName">商品名称</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="goodName">
				</div>
				<label class="control-label col-sm-1" for="saleType">促销类型</label>
				<div class="col-sm-2">
					<select id="saleType" class="form-control saletype">
						<option value="">请选择</option>
					</select>
				</div>
				<div class="col-sm-3">
					<button type="button"  id="btn_query"
						class="btn btn-primary">查询</button>
					<button type="reset" id="btn_flush"
						class="btn btn-primary">清空</button>
				</div>
			</div>
		</form>

	</div>
	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>
		<button id="btn_edit" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		</button>
	</div>
	
	<div class="modal" id="myModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal"><span>&times;</span></button>
					<h3 id="title"></h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="add_form">
						<div class="form-group">
							<label for="goodno" class="control-label col-sm-2">商品编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="goodno" name="goodNo">
							</div>
							<label for="goodname" class="control-label col-sm-2">商品名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="goodname" name="goodName">
							</div>
							<label for="totalno" class="control-label col-sm-2">库存</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="totalno" name="totalNumber">
							</div>
							<label for="goodinfo" class="control-label col-sm-2">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="goodinfo" name="goodInfo">
							</div>
							<label for="typeid" class="control-label col-sm-2">商品类型</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="typeid" name="typeId">
							</div>
							<label for="saletypeid" class="control-label col-sm-2">促销类型</label>
							<div class="col-sm-10">
								<select id="saletypeid" class="form-control saletype" name="saleId">
									<option value=null>请选择</option>
								</select>
							</div>
							<label for="isselling" class="control-label col-sm-2">上架/下架</label>
							<div class="col-sm-10">
								<select id="isselling" class="form-control" name="isSelling">
									<option value=null>请选择</option>
									<option value="1">上架</option>
									<option value="2">下架</option>
								</select>
							</div>
							<label for="altertime" class="control-label col-sm-2">修改时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="altertime" name="creatDate">
							</div>
							<label for="goodprice" class="control-label col-sm-2">商品售价</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="goodprice" name="goodPrice">
							</div>
							<label for="note" class="control-label col-sm-2">备注</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="note" rows="3" name="note"></textarea>
							</div>
							<input type="hidden" id="goodid" name="goodId">
							<input type="hidden" name="userId" value="A2FFE9AB1F7F4613BBBEAF56817F8F5F">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" id="quit">退出</button>
					<button class="btn btn-primary" id="save"></button>
				</div>
			</div>
		</div>
	</div>
	<table class="table">
	</table>
		
		<div class="modal" id="alert1" tabindex="-1" style="margin-top:200px">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal"><span>&times;</span></button>
						<h4>提示!</h4>
					</div>
					<div class="modal-body">
						<div class="alert alert-warning" role="alert" id="message">
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" id="IKNOW">OK</button>
					</div>
				</div>
			</div>
		</div>
	
	
	<script type="text/javascript">

		$(function() {
			$.ajax({
				type:'post',
				url:'/shopWeb/goodController/querySaleType.do',
				dataType:'json',
				success:function(result){
					//console.log(result)
					for(var i = 0; i<result.length; i++){
						$(".saletype").append(
							'<option value="'+result[i].SALEID+'">'+result[i].SALENAME+
							'</option>'
						);
					}
				}
			})
			
			initTable();
			
			$('#btn_query').click(function(){
				$("table").bootstrapTable('refresh')
			})
			
			$('#btn_add').click(function(){
				$('#add_form')[0].reset();
				$('#title').html('新增')
				$('#save').html('添加')
			})
			
			$('#btn_edit').click(function(){
				$('#title').html('修改')
				$('#save').html('修改')
				$('#add_form')[0].reset();
				var row = $("table").bootstrapTable('getSelections');
				//console.log(row)
				if(row>=null&&row<=null){
					$('#message').html('请选择一条数据');
					$('#alert1').modal('show')
				}
				else{
					for ( var key in row[0]) {
						//console.log(row[0][key])
						$('#'+key.toLowerCase()).val(row[0][key])
					}
					$('#myModal').modal('show')
				}
			})
			
			$('#btn_delete').click(function(){
				var row = $("table").bootstrapTable('getSelections');
				if(row>=null&&row<=null){
					$('#message').html('请至少选择一条数据');
					$('#alert1').modal('show')
				}
				else{
					$('#message').html('确认删除吗?');
					$('#alert1').modal('show');
					var ids = [];
					//console.log(row)
					for ( var i = 0; i<row.length; i++) {
						//console.log(row[i])
						ids.push(row[i].GOODID);
					}
					console.log(ids)
					$('#IKNOW').click(function(){
						$.ajax({
							type:'post',
							url:'/shopWeb/goodController/deleteGoods.do',
							data:JSON.stringify(ids),
							contentType : 'application/json;charset=utf-8',
							dataType:'json',
							success:function(result){
								if(result.success){
									$('#IKNOW').unbind("click"); 
									$('#alert1').modal('hide')
									$('#message').html(result.tip);
									$('#alert1').modal('show')
									$('#IKNOW').click(function(){
										$('#alert1').modal('hide')
									})
									$("table").bootstrapTable('refresh')
								}
							}
						})
						//$('#alert1').modal('hide')
					})
				}
			})
			
			$('#quit').click(function(){
				$('#myModal').modal('hide')
			})
			
			$('#IKNOW').click(function(){
				$('#alert1').modal('hide')
			})
			
			$('#save').click(function(){
				var url;
				if($('#title').html()=='新增')url='/shopWeb/goodController/insertGood.do';
				if($('#title').html()=='修改')url='/shopWeb/goodController/updateGood.do';
				$.ajax({
					type:'post',
					url:url,
					data:$('#add_form').serialize(),
					dataType:'json',
					success:function(result){
						if(result.success){
							$('#myModal').modal('hide')
							$('#message').html(result.tip);
							$('#alert1').modal('show')
						}
					}
				})
			})
		})
		
		function initTable(){
			$("table").bootstrapTable({
				url : '/shopWeb/goodController/queryAllGoods.do',
				striped: true,
				//search:true,
				columns : [ {
					checkbox : true
				},{
					field : 'GOODNO',
					title : '商品编号'
				}, {
					field : 'GOODNAME',
					title : '商品名称'
				}, {
					field : 'TOTALNO',
					title : '库存'
				}, {
					field : 'GOODINFO',
					title : '描述'
				}, {
					field : 'GOODTYPE',
					title : '商品类型'
				}, {
					field : 'SALETYPE',
					title : '促销类型'
				}, {
					field : 'ISSELLING',
					title : '是否上架',
					formatter:function(value){
						if(value==1)return '<font color="green">上架</font>';
						if(value==2)return '<font color="red">下架</font>';
						}
				}, {
					field : 'USERNAME',
					title : '修改员工',
				}, {
					field : 'ALTERDATE',
					title : '修改时间'
				}, {
					field : 'GOODPRICE',
					title : '价格'
				}, {
					field : 'NOTE',
					title : '备注'
				},{
					field : 'SALETYPEID',
					visible : false
				},{
					field : 'TYPEID',
					visible : false
				} ],
				clickToSelect: true, //是否启用点击选中行
				showToggle:true, //是否显示详细视图和列表视图的切换按钮
				//showColumns: true, //是否显示所有的列
				showRefresh: true, //是否显示刷新按钮
				uniqueId: "GOODID",
				toolbar : '#toolbar',
				pagination : true,
				sidePagination : 'server',
				pageNumber : 1,
				pageSize : 5,
				pageList : [ 5, 10, 20 ],
				queryParams : function(params) {
					return {
						pageSize : params.limit,
						offSet : params.offset,
						goodNo : $('#goodNo').val(),
						goodName : $('#goodName').val(),
						goodSaleId : $('#saleType').val()
					}
				}
			})
		}
	</script>
</body>
</html>