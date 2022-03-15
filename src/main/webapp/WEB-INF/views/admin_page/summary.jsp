<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link rel="stylesheet" href="/assets/css/summary.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/summary.js"></script>

        

</head>
<body>
    <div class="main_container">
        <div class="main_upper_wrap">
            <a href="/admin/member" id="member">Member</a>
            <a href="/admin/contact" id="contact">Contact</a>
            <a href="/admin/category" id="category">Category</a>
            <a href="/admin/news" id="news">News</a>
            <a href="/admin/post" id="post">Post</a>
            <a href="/admin/statistics" id="stat">Statistics</a>
            <button><i class="fas fa-ellipsis-h"></i></button>
        </div>
        <div class="page_container">
            <div class="status_box member">
                <h1>Member</h1>
                <div>
                    <p>총 회원 수 : 4300명</p>
                    <p>신규 회원 수 : 323명</p>
                    <p>정상 회원 수 : 3267명</p>
                    <p>정지 회원 수 : 700명</p>
                    <p>탈퇴 회원 수 : 113명</p>
                </div>
            </div>
            <div class="status_box news">
                <h1>News</h1>
                <div>
                    <p>총 뉴스 수: 223개</p>
                    <p>인기 뉴스</p>
                    <div class="rank">
                        <a href="#">1등 뉴스</a>
                        <a href="#">2등 뉴스</a>
                        <a href="#">3등 뉴스</a>
                        <a href="#">4등 뉴스</a>
                        <a href="#">5등 뉴스</a>
                    </div>
                </div>
            </div>
            <div class="status_box">
                <h1>Category</h1>
                <div>
                    <p>뉴스 카테고리 수 : 16개</p>
                    <p>커뮤니티 카테고리 수 : 22개</p>
                    <p>통계 카테고리 수 : 4개</p>
                </div>
            </div>
            <div class="status_box">
                <h1>Community</h1>
                <div>
                    <p>전체 글 수 : 3326개</p>
                    <p>인기 글</p>
                    <div class="rank">
                        <a href="#">1등 글</a>
                        <a href="#">2등 글</a>
                        <a href="#">3등 글</a>
                        <a href="#">4등 글</a>
                        <a href="#">5등 글</a>
                    </div>
                </div>
            </div>
            <div class="status_box">
                <h1>Contact</h1>
                <div>
                    <p>전체 문의 수 : 216개</p>
                    <p>처리되지 않은 문의 수 : 185개</p>
                    <p>처리된 않은 문의 수 : 16개</p>
                    <p>보류된 않은 문의 수 : 15개</p>
                </div>
            </div>
            <div class="status_box">
                <h1>Statistics</h1>
                <div>
                    <p>전체 통계 수 : 15개</p>
                    <p>인기 통계</p>
                    <div class="rank">
                        <a href="#">1등 통계</a>
                        <a href="#">2등 통계</a>
                        <a href="#">3등 통계</a>
                        <a href="#">4등 통계</a>
                        <a href="#">5등 통계</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>



