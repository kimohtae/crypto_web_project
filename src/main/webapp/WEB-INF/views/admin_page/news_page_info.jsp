<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/news_page_info.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/news_page_info.js"></script>

        

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
            <div class="news_page_wrap">
                <button id="delete_bun">삭제</button>
                <table class="news_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>회사</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>링크</th>
                            <th>조회수</th>
                            <th>등록일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.cnt==0}">
                            <tr>
                                <td id="nodata" colspan="8">뉴스 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="li">
                            <tr id="${li.npi_seq}s" data-seq="${li.npi_seq}s" class="news_data">
                                <td>${li.npi_seq}<input type="checkbox" style="display: none;"></td>
                                <td>${li.npi_company}</td>
                                <td>${li.npi_title}</td>
                                <td>${li.npi_content}</td>
                                <td>${li.npi_link}</td>
                                <td>${li.npi_view}</td>
                                <td>
                                    <fmt:formatDate value="${li.npi_reg_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${data.page}" var="i">
                        <a id="${i}" href="/admin/contact?offset=${(i-1)*20}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
        </div>
    </div>
    <div id="sending" offset="${data.offset}" page="${data.page}" cnt="${data.cnt}" style="display:none"></div>
</body>
</html>



