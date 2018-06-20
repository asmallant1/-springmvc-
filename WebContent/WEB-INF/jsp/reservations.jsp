<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>classroom</title>
<!-- 这是日期的js -->

	
	<link rel="stylesheet" type="text/css" href="resources/css/normalizeofclassroomtable.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/htmleaf-demoofclassroomtable.css">
	<link rel="stylesheet" href="resources/css/mainofclassroomtable.css">
	
	<script language="javascript" type="text/javascript" src="resources/js/My97DatePocker/WdatePicker.js"></script>
	<!--<link rel="stylesheet" href="resources/css/jquery.restable.minofclassroomtable.css">-->
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body onload="disptime()">
	<div class="htmleaf-container">
		<div class="container">
			
			<table id=table1>
			<thead>
		        <tr>
		            <th>教室号</th>
		            <th>教室名</th>
		            <th>教室类型</th>
		            <th>容纳人数</th>
		            <th>地址</th>
		            <th>所属学院</th>
		        </tr>
		     </thead>
		        <tr>
		        	<td>${cr.getCno()}
		        	</td>
		        	<td><input type="text" style="width: 100px" name="cname" value="${cr.getCname()}"></td>
		        	<td>${cr.getType()}</td>
		        	<td>${cr.getSize()}</td>
		            <td>${cr.getAddress()}
		            </td>
		        	<td>${cr.getInstitution()}
		        	</td>
		        </tr>
			</table>

		<!--  
			开始时间：
			<input class="Wdate"  
			style="width:200px;height:25px;margin-top:10px;border-radius: 4px;border-color: #c9c6c6" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
			onFocus="WdatePicker((lang:'zh-cn',minDate:new Date()))"
			>
			结束时间：
			<input class="Wdate"  style="width:200px;height:25px;margin-top:10px;border-radius: 4px;border-color: #c9c6c6" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			<br>
			
			
			大于今天一天以后的时间
			<input id="d422" class="Wdate" type="text" onclick="WdatePicker({minDate:'%y-%M-{%d+1}',el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
			<br>
			这个是限定了范围
				<input id="d424" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-M-d H:mm:ss',minDate:'%y-%M-%d 7:00:00',maxDate:'%y-%M-{%d+1} 21:00:00'})"/>
			-->
			不可预约时间段:<br>
			<c:forEach   var="data" items="${listTime}" varStatus="status">
				${data.startdate}  &nbsp  &nbsp-----  &nbsp &nbsp   ${data.enddate}<br>
			</c:forEach>
		<form action="saveTborrowed" id="form1">
			<input type="hidden" style="width: 100px" name="cno" value="${cr.getCno()}">
			开始时间：
			<input name="time"
			style="width:200px;height:25px;margin-top:10px;border-radius: 4px;border-color: #c9c6c6"
			id="d4311" class="Wdate" type="text" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}',minDate:'%y-%M-{%d+1}',el:this,dateFmt:'yyyy-MM-dd HH:mm'})"/>
			结束时间：
			<input name="time"
			style="width:200px;height:25px;margin-top:10px;border-radius: 4px;border-color: #c9c6c6"
			id="d4312" class="Wdate" type="text" onclick="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'%y-%M-{%d+20} 21:00:00',el:this,dateFmt:'yyyy-MM-dd HH:mm'})"/>
			
			<br>
			<div id="myclock" style="margin-top: 10px"></div>
			<div style="margin-top:10px;">
			请说明用途
				<textarea  id="texttearea" name="text"
				style="width: 350px;height:180px;border-radius: 10px;border-color: #c9c6c6">
					
				</textarea>
			</div>
			<input type="button" onclick="sub()" value="提交" style="margin-top:10px;border-radius: 4px;border-color: #c9c6c6">
			<a href="classroom"><input type="button" value="返回" style="margin-top:10px;border-radius: 4px;border-color: #c9c6c6"></a>
		</form>
		</div>
	</div>
	<script>window.jQuery || document.write('<script src="resources/js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="resources/js/jquery.restable.minoftable.js"></script>
	<script>
		function disptime(){
		 var today=new Date(); //获得当前时间
		 var year=today.getYear();
		 var month=today.getMonth()+1;
		 var date=today.getDate();
		 var hh=today.getHours();  //获得小时、分钟、秒
		 var mm=today.getMinutes();
		 var ss=today.getSeconds();
		 /*设置div的内容为当前时间*/
		 document.getElementById("myclock").innerHTML="现在时间：2018年"+f(month)+"月"+f(date)+"日"+f(hh)+"时"+f(mm)+"分"+f(ss)+"秒";
		/*
		  使用setTimeout在函数disptime()体内再次调用setTimeout
		  设置定时器每隔1秒（1000毫秒），调用函数disptime()执行，刷新时钟显示
		*/
		  setTimeout("disptime()",1000);
		}
		function f(m){
			if(m<10){
				m="0"+m;
			}
			return m;
		}
		
		function sub(){
			if(document.getElementById("d4311").value==""||document.getElementById("d4312").value==""){
				alert("时间不能为空");
			}else{
				//alert("dd");
			     $(function(){
			            $.ajax({
			                url:'saveTborrowed',
			                type:'post',
			                dataType:'json',
			                data:$("#form1").serialize(),
			                success:function(data){
			                    //回调函数
			                    if(data[0].result=='ok'){
			                    	alert("预约申请已成功提交");
			                    	window.location.href="reservations?cno="+${cr.getCno()};
			                    }else{
			                    	alert("预约失败，该时间段不可预约，请重新选择时间段");
			                    }
			                }
			            });
			        });
			}
		}
		
   
	
        $(function(){
        	$('#table1').ReStable();
            $('#table2').ReStable({rowHeaders: false});
            $('#table3').ReStable({keepHtml: true, rowHeaders: false});
        })
    </script>
</body>
</body>
</html>