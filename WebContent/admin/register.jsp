<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="base/header.jsp" %>

<title>管理员注册-中山大学第一附属医院管理系统</title>
</head>
<body class="login-bg">
    <style type="text/css">
    	input[disabled=disabled]{
			opacity: 0.6;
			cursor: not-allowed!important;
		}
		input.error {
		    border-color: deeppink!important;
		}
		input.error:hover {
		    border-color: deeppink!important;
		}
    </style>
    <div class="login">
        <div class="message">管理员注册-中山大学第一附属医院</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" action="<%=request.getContextPath() %>/admin/register" class="layui-form" >
            <input name="username" id="username" placeholder="用户名"  type="text" class="layui-input" >
            <hr class="hr15">
            <input name="password" id="password"  placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input name="repassword" id="repassword"  placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input class="loginin" id="button" value="注册" disabled="disabled" style="width:100%;" type="submit">
            <hr class="hr20" >
            
        </form>
    </div>
	<script type="text/javascript">
		var usernameDom = document.querySelector("#username");
		var passwdDom = document.querySelector("#password");
		var repasswdDom = document.querySelector("#repassword")
		var button = document.querySelector("#button")
		
		layui.use('layer', function(){
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//username输入的内容,必须是[A-z0-9_]并且必须是大于等于5个字符以上
			usernameDom.oninput = function(){
				
				var value = usernameDom.value;
				var regex = /^[A-z0-9_]{5,20}$/i;
				if(regex.test(value)){
					$("#username").removeClass("error")
				}else{
					$("#username").addClass("error");
					console.log("用户名必须由英文字母和数字以及下划线组成,必须大于等于5个字符！")
					console.log(usernameDom)
					
					layer.msg("用户名必须由英文字母和数字以及下划线组成,必须大于等于5个字符！", {
					        time: 3000, //20s后自动关闭
					        offset: 't'
					})
					
				}
				
				
				
			}
			passwdDom.oninput = function(){
				var value = passwdDom.value;
				var regex = /.{6,}/;
				if(!regex.test(value)){
					//passwdDom.className  = passwdDom.className+" error"
					$("#username").addClass("error");
					layer.msg("密码必须5个字符以上", {
					        time: 3000, //20s后自动关闭
					        offset: 't'
					})
				}else{
					$("#username").removeClass("error")
					
				}
				
			}
			repasswdDom.oninput=function(){
				if(passwdDom.value==repasswdDom.value&&passwdDom.value.length>5&&usernameDom.value.length>=5){
					$("#username").removeClass("error")
					button.disabled = false;
					
				}else{
					$("#username").addClass("error");
					button.disabled = true;
					layer.msg("重复密码与密码不一致", {
					        time: 3000, //20s后自动关闭
					        offset: 't'
					})
				}
			}
			
			
			
		})
		
	</script>
   
</body>
</html>