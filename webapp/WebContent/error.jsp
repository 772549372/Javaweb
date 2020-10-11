<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出错了</title>
<link href="css/error.css" rel="stylesheet"/>
<script language="JavaScript" src="js/error.js"></script>
</head>
<body>
<div id="errorDiv">
 <div id="errorHint">
     <p id="errorInfo"> ${info}<br/></p>
     <p>还剩<span id="leaveTime">5</span>秒自动跳转</p>
     <p>不能跳转，请<a href="login.html">点击这儿</a></p>
 </div>

</div>

       
</body>
</html>