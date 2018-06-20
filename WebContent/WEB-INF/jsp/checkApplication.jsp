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
	
	<!--<link rel="stylesheet" href="resources/css/jquery.restable.minofclassroomtable.css">-->
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="htmleaf-container">
	<div class="container">
		<table id=table1>
			<thead>
		        <tr>
		            <th>教室号</th>
		            <th>教室名</th>
		            <th>开始</th>
		            <th>结束</th>
		            <th>借用理由</th>
		            <th>申请时间</th>
		            <th>申请状态</th>
		            <th>批准时间</th>
		        </tr>
		     </thead>
		     <c:forEach items="${listtborrow }" var="data" varStatus="status">
		     	<tr>
		        	<td>${data.cno}</td>
		        	<td>${listroomname.get(status.index).getCname() }</td>
		        	<td>${data.startdate}</td>
		        	<td>${data.enddate}</td>
		        	<td>${data.text}</td>
		        	<td>${data.applicationdate}</td>
		            <td>${data.approval}</td>
		            <td>${data.approvaldate}</td>
		        	
		        </tr>
		     </c:forEach>
		</table>
	</div>
	</div>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="resources/js/jquery.restable.minoftable.js"></script>
	<script>

        $(function(){
        	$('#table1').ReStable();
            $('#table2').ReStable({rowHeaders: false});
            $('#table3').ReStable({keepHtml: true, rowHeaders: false});
        })
    </script>
</body>
</body>
</html>