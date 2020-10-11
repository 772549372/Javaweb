<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="bodyDiv">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下载</title>
<link rel="stylesheet" href="css/headandfoot.css" ">
 <link href="css/download.css" rel="stylesheet"/>
 <div id="header">
     
     <ul>
                <li><a href="main.jsp">首页</a></li>
                <li><a href="Download.jsp">下载</a></li>
                <li><a href="">文件管理</a></li>  
                <li><a href="">增加</a></li>  
                <li><a href="">查询</a></li>
                <li><a href="">论坛</a></li>
                <li><a href="">关于</a></li>
                <div id="float">
                 <li><p>欢迎您:${userName}</p></li>
                <li > <a href="login.html">[退出]</a></li>
                </div>
      </ul>
      </div>
</head>
<body>
<h1>资源下载</h1>
<div class="container">
  <c:forEach items="${downloadList}" var="download"  >
    <ul>
      <li>
        <p class="name">${download.name}</p>
        <div class="pic-txt">
          <img class="img-area" src="${download.image}" />
          <p class="txt-area">
            <span class="">${download.description}</span>
            <span class="tit-sub">
              <i class="space">时间:${download.time}</i>
              <i class="space">大小:${download.sizeStr}</i>
              <i>星级:</i>
              <i class="stars">
              <span style="width: ${download.star/5*100}%"></span>
              </i>
            </span>
          </p>
        </div>
        <a class="dl-bin" href="download.do?id=${download.id}" title="点击下载">下载</a>
      </li>
    </ul>
  </c:forEach>
  <p class="back"><a href="main.jsp">返回首页</a></p>
</div>
 
</body>
</html>