<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>classroom</title>
<!-- 下拉款css -->

	<link rel="stylesheet" href="resources/css/reset.css"/>
    <script src="resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/select_gj.min.js"></script>
    <link rel="stylesheet" href="resources/css/select_gj.css">

	<link rel="stylesheet" type="text/css" href="resources/css/normalizeofclassroomtable.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/htmleaf-demoofclassroomtable.css">
	<link rel="stylesheet" href="resources/css/mainofclassroomtable.css">
	<link rel="stylesheet" href="resources/css/jquery.restable.minofclassroomtable.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	<style type="text/css">
	    .head{
       
        border-radius: 5px;
      
       
        position: relative;
    }
    .select2-selection__rendered{
        text-align: left;
    }
    </style>
</head>
<body>

 	
			        		
	<div class="htmleaf-container">
		<div class="container">
		<form action="classroom" id="form1">
			<table id=table1>
				<thead>
		        <tr>
		            <th>序号</th>
		            <th>教室号</th>
		            <th>教室名</th>
		            <th>教室类型</th>
		            <th>容纳人数</th>
		            <th>地址</th>
		            <th>所属学院</th>
		            <th>操作</th>
		        </tr>
		        </thead>
		        <tr>
		        	<td>操作</td>
		        	<td>   
		        		<select style="width:100px" name="c" class="fastbannerform__country" onchange="f3()">
		        			<c:forEach var="data" items="${listpropertity.cno }" varStatus="status">
		        				<option <c:if test="${c[0] eq data}">selected</c:if>>${data}</option>
		        			</c:forEach>
			        	</select>
			        </td>
		        	<td>
						<select style="width:100px" name="c" class="fastbannerform__country" onchange="f3()">
		        			<!-- <option>${c[1]}</option> -->
		        			<c:forEach var="data" items="${listpropertity.cname}">
		        				<option <c:if test="${c[1] eq data}">selected</c:if>>${data}</option>
		        			</c:forEach>
			        	</select>
					</td>
		        	<td>
			        	<select style="width:100px" name="c"class="fastbannerform__country" onchange="f3()">
			        	<!--	<option>${c[2]}</option>-->
		        			<c:forEach var="data" items="${listpropertity.type }">
		        				<option <c:if test="${c[2] eq data}">selected</c:if>>${data}</option>
		        			</c:forEach>
			        	</select>
		        	</td>
		        	<td>
			        	<select style="width:100px" name="c" class="fastbannerform__country" onchange="f3()">
		        			<c:forEach var="data" items="${listpropertity.size}">
		        				<option <c:if test="${c[3] eq data}">selected</c:if>>${data}</option>
		        			</c:forEach>
			        	</select>
		        	</td>
		        	
		            <td>
		            	<select style="width:120px" name="c" class="fastbannerform__country" onchange="f3()">
		        			<c:forEach var="data" items="${listpropertity.address }">
		        				<option <c:if test="${c[4] eq data}">selected</c:if> style="font-family: Microsoft YaHei;font-size: 14px;color: #fff">${data}</option>
		        			</c:forEach>
		        		</select>
		            </td>
		            
		        	<!--<td>
			        	<select style="width:100px" name="c" onchange="f3()">
		        			<c:forEach var="data" items="${listpropertity.institution}">
		        				<option <c:if test="${c[5]} eq ${data}">selected</c:if>>${data}</option>
		        			</c:forEach>
			        	</select>
		        	</td>-->
		        	<td>
			        	<select name="c"  style="width:100px;"  class="fastbannerform__country" onchange="f3()">
		        			<c:forEach var="data" items="${listpropertity.institution}">
		        				<option <c:if test="${c[5] eq data}">selected</c:if> >${data}</option>
		        			</c:forEach>
			        	</select>
		        	</td>

		        </tr>
		        <tbody>
					<c:forEach items="${list}" varStatus="status" var="data">
						<tr>
						<td>${status.index+1}</td>
						<td>${data.cno}</td>
						<td>${data.cname}</td>
						<td>${data.type}</td>
						<td>${data.size}</td>
						<td>${data.address}</td>
						<td>${data.institution}</td>
						<td><a href="reservations?cno=${data.cno}">预约</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
			   共${all}页    第
				<input type="text" id="page" name="page" style="width: 100px" class="page" value="${page}" >页
				<select name="allPage"  onchange="f3()">
					<option <c:if test="${allPage eq '4'}">selected</c:if>>4</option>
					<option <c:if test="${allPage eq '5'}">selected</c:if>>5</option>
					<option <c:if test="${allPage eq '6'}">selected</c:if>>6</option>
					<option <c:if test="${allPage eq '7'}">selected</c:if>>7</option>
					<option <c:if test="${allPage eq '8'}">selected</c:if>>8</option>
					<option <c:if test="${allPage eq '9'}">selected</c:if>>9</option>
					<option <c:if test="${allPage eq '10'}">selected</c:if>>10</option>
				</select>
				<input type="button" id="upPage" onclick="f1()" value="上一页" style="margin-left: 30px">
				<input type="button" id="downPage" onclick="f2()" value="下一页" style="margin-left: 50px">
				<input type="submit" value="GO" style="width:100px" style="margin-left: 50px">
			</form>
			</div>
		</div>
	<!--  下拉框样式	-->
	<script src="resources/js/select2_1.js"></script>

	<script>window.jQuery || document.write('<script src="resources/js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="resources/js/jquery.restable.minoftable.js"></script>
	
	<script>
		function f1(){
			
			var page=document.getElementById("page");
			//alert(page);
			var i=parseInt(page.value)-1;
			var form=document.getElementById("form1");
			//alert($('#page').val());
			//lert($('#page').val());
			//$('#page').val(i+"");
			//alert("--");
			page.value=i+"";
			//alert("--");
			form1.submit();
		}
		function f2(){
			//alert("f1()");
			var page=document.getElementById("page");
			//alert(page);
			var i=parseInt(page.value)+1;
			var form=document.getElementById("form1");
			//alert($('#page').val());
			//lert($('#page').val());
			//$('#page').val(i+"");
			//alert("--");
			page.value=i+"";
			//alert("--");
			form1.submit();
		}
		function f3(){
			form1.submit();
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