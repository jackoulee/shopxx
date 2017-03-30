<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="/shopWeb/js/bootstrap/css/bootstrap-3.3.7.min.css">
   <link rel="stylesheet" type="text/css" href="/shopWeb/js/bootstrap-table/bootstrap-table.min.css">
    <script src="/shopWeb/js/jquery-3.1.1.min.js"></script>
	<script src="/shopWeb/js/bootstrap/js/bootstrap-3.3.7.min.js"></script>
	<script src="/shopWeb/js/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="/shopWeb/js/bootstrap-table/bootstrap-table-zh-CN.js"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath }/storeController/importStoreInfo.do" method="post" enctype="multipart/form-data">
       <input type="file" name="myFile">
       <input type="submit" value="提交">
    </form>
	<table class="table">
	</table>
	<script type="text/javascript">
		$(function() {
			$("table").bootstrapTable({
				url : '/shopWeb/storeController/queryAllPro.do',
				striped: true,
				//search:true,
				columns : [ {
					checkbox : true
				},{
					field : 'PRO_NO',
					title : '货品编号'
				}, {
					field : 'PRO_NAME',
					title : '货品名称'
				}, {
					field : 'PRO_TOTALNO',
					title : '库存'
				}, {
					field : 'PRO_DIS',
					title : '描述'
				},{
					field : 'PRO_TIME',
					title : '修改时间'
				},],
				clickToSelect: true, //是否启用点击选中行
				showToggle:true, //是否显示详细视图和列表视图的切换按钮
				//showColumns: true, //是否显示所有的列
				showRefresh: true, //是否显示刷新按钮
				uniqueId: "PRO_id",
				toolbar : '#toolbar',
				pagination : true,
				sidePagination : 'server',
				pageNumber : 1,
				pageSize : 5,
				pageList : [ 5, 10, 20 ],
				queryParams : function(params) {
					return {
						pageSize : params.limit,
						offSet : params.offset
					}
				}
			})
		})
	</script>
	</body>
</html>