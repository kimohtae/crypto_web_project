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
    <Script src="http://code.jquery.com/jquery-3.4.1.min.js"></Script>
    <link rel="stylesheet" href="/assets/css/reset.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="/assets/js/index.js"></script>
  
        

</head>
<body>
    <div class="login_wrap">
        <div class="login_container">
            <p class="line"></p>
            <div class="login_top">
                <h1>LOGIN</h1>
            </div>
            <div class="login_mid">
                <input type="text" class="account" placeholder="User ID">
                <input type="password" class="password" placeholder="Password">
            </div>
            <div class="login_bot">
                <button id="login">Sign In</button>
            </div>
        </div>
    </div>
    <div class="backgroud"></div>
</body>
</html>