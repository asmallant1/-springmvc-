<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
      <!-- The stylesheet -->
        <link rel="stylesheet" href="resources/assets/css/styles.css" />
        
        <!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script type="text/javascript">
        		function f(){
        			//alert("0");
       				var email=document.getElementById("email1").value;
       				//alert("1");
       				var p1=document.getElementById("password1").value;
       				//alert("2");
       				var p2=document.getElementById("password2").value;
       				
       				var bu=document.getElementById("bu");
       				//alert("2423");
       				if(email==""||p1==""||p2==""){
       					alert("输入不能为空");
       				}else if(p1!=p2){
       					alert("两次密码不一致");
       				}else {
       					alert("-----");
       					//bu.submit();
       					document.form.submit();
       				}
       			}
        	
        </script>
    </head>
    
    <body>

        <div id="main">
        	
        	<h1>Sign up, it's FREE!</h1>
        	
        	<form class="" name="form"  action="changeTeaPassword" method="get">
        		
        		<div class="row email1">
	    			<input type="password" id="email1" name="old" placeholder="old Password" />
        		</div>
        		
        		<div class="row pass">
        			<input type="password" id="password1" name="password1" placeholder="new Password" />
        		</div>
        		
        		<div class="row pass">
        			<input type="password" id="password2" name="password2" placeholder="Password (repeat)" disabled="true" />
        		</div>
        		
        		<!-- The rotating arrow -->
        		<div class="arrowCap"></div>
        		<div class="arrow"></div>
        		
        		<p class="meterText">Password Meter</p>
        		
        		<input type="button" value="Register" onclick="f()" id="bu"/>
        		
        	</form>
        </div>
                
        <!-- JavaScript includes - jQuery, the complexify plugin and our own script.js -->
		<script src="resources/assets/js/jquery-1.7.2.min.js"></script>
		<script src="resources/assets/js/jquery.complexify.js"></script>
		<script src="resources/assets/js/script.js"></script>
		     
    </body>
</html>