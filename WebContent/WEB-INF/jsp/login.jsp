<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
    <title>首页</title>
	
	<link rel="stylesheet" href="resources/common/layui/css/layui.css">
	<link rel="stylesheet" href="resources/common/css/sccl.css">
    
  </head>
  
  <body class="login-bg">
    <div class="login-box">
        <header>
            <h1>教师借用管理系统</h1>
        </header>
        <div class="login-main">
			<form action="home" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden" value="">                
				<div class="layui-form-item">
					<label class="login-icon">
						<i class="layui-icon"></i>
					</label>
					<input type="text" name="id" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="login-icon">
						<i class="layui-icon"></i>
					</label>
					<input type="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				
				<div class="layui-form-item">
					<label class="login-icon">
						<i class="layui-icon"></i>
					</label>
					<select name="type">
						<option>学生</option>
						<option>教师</option>
						<option>管理员</option>
					</select>
				</div>
				<div class="layui-form-item">
					<div class="pull-left login-remember">
						<label>记住帐号？</label>

						<input type="checkbox" name="rememberMe" value="true" lay-skin="switch" title="记住帐号"><div class="layui-unselect layui-form-switch"><i></i></div>
					</div>
					<div class="pull-right">
						<button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="login">
							<i class="layui-icon"></i> 登录
						</button>
					</div>
					<div class="clear"></div>
				</div>
			</form>        
		</div>
     
    </div>
       <!-- <div class="login-code-box">
            <input type="text" class="layui-input" id="code" />
            <img id="valiCode" src="/manage/validatecode?v=636150612041789540" alt="验证码" />
        </div>-->
    <script type="text/html" id="code-temp">
    </script>
      <script src="resources/common/layui/layui.js"></script>
    <script>
        layui.use(['layer', 'form'], function () {
            var layer = layui.layer,
				$ = layui.jquery,
				form = layui.form();

            form.verify({
                userName: function (value) {
                    if (value === '')
                        return '请输入用户名';
                },
                password: function (value) {
                    if (value === '')
                        return '请输入密码';
                }
            });

            var errorCount = 0;

            form.on('submit(login)', function (data) {
				window.location.href = "home";
                /*if (errorCount > 5) {
                    layer.open({
                        title: '<img src="' + location.origin + '/Plugins/layui/images/face/7.gif" alt="[害羞]">输入验证码',
                        type: 1,
                        content: document.getElementById('code-temp').innerHTML,
                        btn: ['确定'],
                        yes: function (index, layero) {
                            var $code = $('#code');
                            if ($code.val() === '') {
                                layer.msg('输入验证码啦，让我知道你是人类。');
                                isCheck = false;
                            } else {
                                $('input[name=verifyCode]').val();
                                var params = data.field;
                                params.verifyCode = $code.val();
                                submit($,params);
                                layer.close(index);
                            }
                        },
                        area: ['250px', '150px']
                    });
                    $('#valiCode').off('click').on('click', function () {
                        this.src = '/manage/validatecode?v=' + new Date().getTime();
                    });
                }else{
                    submit($,data.field);
                }

                return false;*/
            });

        });
		
        /*function submit($,params){
            $.post('/manage/login',params , function (res) {
                if (!res.success) {
                    if (res.data !== undefined)
                        errorCount = res.data.errorCount
                    layer.msg(res.message,{icon:2});
                }else
                {
                    layer.msg(res.message,{icon:1},function(index){
                        layer.close(index);
                        location.href='/manage';
                    });
                }
            }, 'json');
        }*/
    </script>
  </body>
</html>
