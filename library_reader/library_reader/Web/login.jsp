<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
 <link href="css/login.css" rel="stylesheet"/>
      <script src="js/login.js"></script>
   <script>
      function changeCode(){
    	     var codeImg=document.getElementById("vcodeImg");
            codeImg.src="servlet/CreateImage?t="+Math.random();
      }
   </script>
</head>
<body>

    <div id="loginForm">
    <form action="ajaxLoginCheck.do" method="post">
        <p>
            
            <input id="userName" type="text" name="userName" placeholder="用户名"/>
            <span id="checkError" name="checkError">${info}</span>
        </p>
        <p>
           
            <input id="password" type="password" name="password" placeholder="密&nbsp;码"/>
            <span id="checkError" name="checkError">${info}</span>
        </p>
         
        <p>
            
            <input id="vcode" type="text" name="userCode"  placeholder="验证码"/>
      		<img   src="servlet/CreateImage" onclick="changeCode()"   id="vcodeImg" title="看不清，换一个">
      		<span id="checkError" name="checkError">${info}</span>
      		
        </p>
        <p><input type="checkbox" name="autoLogin"  /> 一周内免登录    <a href="register.jsp" >注册</a></p>
        <p>
            <input id="btLogin" type="submit"  value="登&nbsp;&nbsp;录"/>
            
            
        </p>
    </form>
    </div>
</body>
<!-- onclick="jqAjaxCheckLogin()" -->
</html>
