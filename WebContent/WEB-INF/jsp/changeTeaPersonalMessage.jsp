<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改个人信息</title>
	<style>
			.up-img-cover {width: 100px;height: 100px;}
     		.up-img-cover img{width: 100%;}
	</style>
	<link rel="stylesheet" href="resources/common/css/sccl.css">
	<link rel="stylesheet" href="resources/css/changeTPM.css" >
	
	<link rel="stylesheet" type="resources/text/css" >
    <link rel="stylesheet" href="resources/css/amazeui.min.css">
    <link rel="stylesheet" href="resources/css/amazeui.cropper.css">
    <link rel="stylesheet" href="resources/css/custom_up_img.css"> 
    
    <script src="resources/js/jquery.min.js" charset="utf-8"></script>
    <script src="resources/js/amazeui.min.js" charset="utf-8"></script>
    <script src="resources/js/cropper.min.js" charset="utf-8"></script>
    <script src="resources/js/custom_up_img.js" charset="utf-8"></script>
    
</head>
<body style="background-color: #c9c6c6;">

    	<div class="up-img-cover"  id="up-img-touch" style=" margin: auto" >
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
    				<span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
    				<span class="am-icon-rotate-right" onClick="rotateimgright()"></span>
    				<span class="am-icon-check" id="up-btn-ok" url="changeHeadImage"></span>
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

	<div class="pc-kk-form">
		<form action="changeTeaPersonalMessage" name="form" method="get">
			<div class="pc-kk-form-list">
				<input type="text" placeholder="${tea.getTname() }" style="margin-bottom: 8px">
			<!--  </div>
				<div class="pc-kk-form-list">
				<input type=text" placeholder="address" name="address" value="${tea.getAddress()}">
			</div>
			-->
			<div class="pc-kk-form-list" name="nice-select">
					<input type="text" placeholder="age"  name="age"  value="${tea.getAge()}"  >
			</div>
			<!--  
				<div class="nice-select" name="nice-select" style="float:right">
					<input type="text" name ="sex" value="${tea.getSex()}" readonly>
					<ul>
						<li data-value="male">男</li>
						<li data-value="female">女</li>
					</ul>

				</div>
			-->
			<div class="pc-kk-form-list">
				<input type="email" name="email" placeholder="E-mail" value="${tea.getEmail()}" >
			</div>
			<div class="pc-kk-form-list pc-kk-form-list-clear">
				<div class="nice-select" name="nice-select">
					<input type="text" name="sex" value="${tea.getSex() }" readonly>
					<ul>
						<li data-value="time1">男</li>
						<li data-value="time2">女</li>
			
					</ul>
				</div>
				<div class="nice-select" name="nice-select" style="float:right">
					<input type="text" name="institution" value="${tea.getInstitution()}" readonly>
					<ul>
						<li data-value="USA">软件学院</li>
						<li data-value="Britain">材料学院</li>
						<li data-value="Britain">信工学院</li>
					</ul>

				</div>
			</div>
			<div class="pc-kk-form-list">
				<input type=text" placeholder="address" name="address" value="${tea.getAddress()}">
			</div>
		<!--	<div class="pc-kk-form-list">
				<input type="text" placeholder="Invitation Code">
			</div>
		-->
		<!-- 	<div class="pc-kk-form-list">
				<div class="nice-select" name="nice-select">
					<input type="text" value="${tea.getInstitution() }"  readonly name="institution">
					<ul>
						<li data-value="time1">软件学院</li>
						<li data-value="time2">材料学院</li>
						<li data-value="time3">信工学院</li>
					</ul>
		
				</div>
			</div>
		-->

			<div class="pc-kk-form-list" style="height:auto">
				<textarea name="personalmessage">${tea.getPersonalmessage()}</textarea>
			</div>
			<div class="pc-kk-form-btn">
				<button onclick="f()" value="Submit">Submit</button>
			</div>
		</form>
	</div>

	<script>
		function f(){
			
			$('form').submit();
			//alert("234");
		}

        $('[name="nice-select"]').click(function(e){

            $('[name="nice-select"]').find('ul').hide();

            $(this).find('ul').show();

            e.stopPropagation();

        });

        $('[name="nice-select"] li').hover(function(e){

            $(this).toggleClass('on');

            e.stopPropagation();

        });

        $('[name="nice-select"] li').click(function(e){

            var val = $(this).text();

            $(this).parents('[name="nice-select"]').find('input').val(val);

            $('[name="nice-select"] ul').hide();

            e.stopPropagation();

        });

        $(document).click(function(){

            $('[name="nice-select"] ul').hide();

        });

	</script>
</body>
</html>