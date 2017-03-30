<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品统计</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/Highcharts/exporting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/Highcharts/highcharts.js"></script>
</head>
<body>
<div id="container" style="min-width:400px;min-height:400px"></div>
<script type="text/javascript">
function test(nameEveryJson,sumPeopleNumberJson){
	$(document).ready(function() {
		var chart = {
            type: 'bar'
        };
        var title = {
            text: '各类型商品统计'
        };
        var xAxis = {
            categories: nameEveryJson,
            title: {
                text: null
            }
        };
        var yAxis = {
            min: 0,
            title: {
                text: '库存总量 (个)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        };
        var tooltip = {
            valueSuffix: ' 个'
        };
        var plotOptions = {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        };
        var legend = {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        };
        var credits = {
            enabled: false
        };
        var series = [{
            name: '库存数量',
            data: sumPeopleNumberJson
        }];
	   var json = {};
	   
	   json.chart = chart;
	   json.title = title;
	   json.xAxis = xAxis;
	   json.yAxis = yAxis;
	   json.tooltip = tooltip;
	   json.plotOptions = plotOptions;
	   json.legend = legend;
	   json.series = series;
	   json.credits = credits;
	   
	   $('#container').highcharts(json);
	});
	
}
$(function(){
	 $.ajax({
			type:"post",
			url:"/shopWeb/countController/queryProCount.do",
			dataType:"json",
			success:function(result){	
				var nameEveryJson=[];
				var sumPeopleNumberJson=[];
				for (var i = 0; i <result.length; i++) {
					nameEveryJson.push(result[i].PRONAME);//为数组中追加内容
					sumPeopleNumberJson.push(result[i].PROTOTALNO);
				}
               test(nameEveryJson,sumPeopleNumberJson)
      		},
      		error:function(){
				alert("获取数据异常");
			}
			
		});
	   
});
</script>
</body>
</html>