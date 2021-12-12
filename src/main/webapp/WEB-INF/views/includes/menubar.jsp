<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/assets/css/menubar.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script>
        $(function(){
            let pos = $('#news').offset();
                let wid = $('#news').width();
                let hei = $('#news').innerHeight();
                console.log(pos.left)
                console.log(pos.top)
                console.log(wid)
                console.log(hei)
                $('#underline').css({
                   "width":wid+"px",
                   "top":pos.top+hei+"px",
                   "left":pos.left+"px",
                   "height":"2px",
               })
            $('#news').click(function(){
                let pos = $('#news').offset();
                let wid = $('#news').width();
                let hei = $('#news').innerHeight();
                console.log(pos.left)
                console.log(pos.top)
                console.log(wid)
                console.log(hei)
                $('#underline').css({
                   "width":wid+"px",
                   "top":pos.top+hei+"px",
                   "left":pos.left+"px",
                   "height":"2px",
               })
            })
            $('#stra').click(function(){
                let pos = $('#stra').offset();
                let wid = $('#stra').width();
                let hei = $('#stra').innerHeight();
                console.log(pos.left)
                console.log(pos.top)
                console.log(wid)
                console.log(hei)
                $('#underline').css({
                   "width":wid+"px",
                   "top":pos.top+hei+"px",
                   "left":pos.left+"px",
                   "height":"2px",
               })
            })
            $('#com').click(function(){
                let pos = $('#com').offset();
                let wid = $('#com').width();
                let hei = $('#com').innerHeight();
                console.log(pos.left)
                console.log(pos.top)
                console.log(wid)
                console.log(hei)
                $('#underline').css({
                   "width":wid+"px",
                   "top":pos.top+hei+"px",
                   "left":pos.left+"px",
                   "height":"2px",
               })
            })  
        })    
    </script>
        

</head>
<body>
    <div class="main_container">
        <div class="main_upper_wrap">
            <p id="news">News</p>
            <p id=stra>Strategy</p>
            <p id="com">Community</p>
            <button><i class="fas fa-ellipsis-h"></i></button>
            <div id="underline"></div>
        </div>

</body>
</html>