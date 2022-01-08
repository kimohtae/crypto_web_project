<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/index.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/index.js"></script>
  
        

</head>
<body>
    <div class="main_container">
        <div class="main_upper_wrap">
            <p id="news">News</p>
            <p id=stra>Strategy</p>
            <p id="com">Community</p>
            <p id="adm">Administration</p>
            <button><i class="fas fa-ellipsis-h"></i></button>
            <div id="underline"></div>
        </div>
        <div class="page_container">
            <div class="news_page_wrap">
                <a href="/practice/page">something news</a>
                <a href="#">something news</a>
                <a href="#">something news</a>
                <a href="#">something news</a>
            </div>
            <div class="stra_page_wrap">
                <a href="#">something stra</a>
                <a href="#">something stra</a>
                <a href="#">something stra</a>
                <a href="#">something stra</a>
            </div>
            <div class="com_page_wrap">
                <a href="#">something comm</a>
                <a href="#">something comm</a>
                <a href="#">something comm</a>
                <a href="#">something comm</a>
            </div>
            <div class="admin_page_wrap">
                <a href="/admin/member">something admin</a>
                <a href="#">something admin</a>
                <a href="#">something admin</a>
                <a href="#">something admin</a>
            </div>
        </div>
    </div>
</body>
</html>