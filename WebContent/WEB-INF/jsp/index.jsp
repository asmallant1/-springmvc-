<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="model.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
    <link rel="stylesheet" type="resources/text/css" >
    <link rel="stylesheet" href="resources/css/amazeui.min.css">
    <link rel="stylesheet" href="resources/css/amazeui.cropper.css">
    <link rel="stylesheet" href="resources/css/custom_up_img.css">  
<style>
	body{
		background: url("resources/images/login-8.jpg");
		background-repeat: no-repeat;
		background-position:center;
		background-attachment: fixed;
		background-size:cover;
	}
	.personal-message{
		margin:auto;
		margin-top:20px;
		width:70%;
		hight:60%;
		padding: 1em;
		overflow: hidden;
		border-radius:20px;
		box-shadow:10px 10px 10px #666;
		background-color: #c9c6c6;
	
	}
	.personal-message::before{
		background:url("resources/images/login-10.jpg");
		background-position:center;
		background-attachment:fixed;
		background-size:cover;
    	position:absolute;
    	top: 0; right: 0; bottom: 0; left: 0;
    	margin: -30px;
    	z-index: -1;
    	-webkit-filter: blur(10px);
   		filter:blur(10px);
   		}
	h1{
	font-size:90;
	font-family: "楷书";
	color: white;
	text-align:center;
	margin-top: 20%;
	font:bold 36px Cambria, "Hoefler Text",serif;
	margin-bottom:50px;
	color:#FFFAF0;
	text-shadow:1px 1px 0 rgba(255,255,255,0.4);
	}

     		.up-img-cover {width: 100px;height: 100px;}
     		.up-img-cover img{width: 100%;}
  </style>
    </head>
    <body>
    	<div class="up-img-cover"  id="up-img-touch" style=" margin: auto ;height: 150px;width:150px" >
    		<img class="am-circle" alt="点击图片上传" src="${image}" data-am-popover="{content: '点击上传', trigger: 'hover focus'}" >
    	</div>
    	<div><a style="text-align: center; display: block;"  id="pic"></a></div>
    	
    	<!--图片上传框-->
    	<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
		  <div class="am-modal-dialog up-frame-parent up-frame-radius">
		    <div class="am-modal-hd up-frame-header">
		       <label>修改头像</label>
		      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
		    </div>
		    <div class="am-modal-bd  up-frame-body">
		      <div class="am-g am-fl">
		      	<div class="am-form-group am-form-file">
			      <div class="am-fl">
			        <button type="button" class="am-btn am-btn-default am-btn-sm">
			          <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
			      </div>
			      <input type="file" id="inputImage">
			   	</div>
		      </div>
		      <div class="am-g am-fl" >
		      	<div class="up-pre-before up-frame-radius">
		      		<img alt="" src="" id="image" >
		      	</div>
<!--这里面插入了标签保存有图片-->
		      	<div class="up-pre-after up-frame-radius">

		      	</div>
		      </div>
		      <div class="am-g am-fl">
   				<div class="up-control-btns">
    				<span class="am-icon-rotate-left"  onclick="rotateimgleft()">向左</span>
    				<span class="am-icon-rotate-right" onClick="rotateimgright()">向右</span>
    				<span class="am-icon-check" id="up-btn-ok" url="changeHeadImage">发送</span>
   				</div>
	    	  </div>
		      
		    </div>
		  </div>
		</div>
    	
    	<!--加载框-->
    	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
		  <div class="am-modal-dialog">
		    <div class="am-modal-hd">正在上传...</div>
		    <div class="am-modal-bd">
		      <span class="am-icon-spinner am-icon-spin"></span>
		    </div>
		  </div>
		</div>
		
		<!--警告框-->
		<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
		  <div class="am-modal-dialog">
		    <div class="am-modal-hd">信息</div>
		    <div class="am-modal-bd"  id="alert_content">
		              成功了
		    </div>
		    <div class="am-modal-footer">
		      <span class="am-modal-btn">确定</span>
		    </div>
		  </div>
		</div>
		<div class="personal-message">
			
			<label>姓名：</label>${tea.getTname() }<br>
			<label>年龄：</label>${tea.getAge() }<br>
			<label>邮箱：</label>${tea.getEmail() }<br>
			<label>学院：</label>${tea.getInstitution() }<br>
			<label>住址：</label>${tea.getAddress()} <br>
			<p>简介：${tea.getPersonalmessage()}</p>
		
		</div>
		
		<script src="resources/js/jquery.min.js" charset="utf-8"></script>
        <script src="resources/js/amazeui.min.js" charset="utf-8"></script>
        <script src="resources/js/cropper.min.js" charset="utf-8"></script>
        <script src="resources/js/custom_up_img.js" charset="utf-8"></script>
    </body>
</html>