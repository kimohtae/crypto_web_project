<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/statistics.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/statistics.js"></script>

        

</head>
<body>
    <div class="main_container">
        <div class="main_upper_wrap">
            <a href="/admin/member" id="member">Member</a>
            <a href="/admin/contact" id="contact">Contact</a>
            <a href="/admin/news" id="news">News</a>
            <a href="/admin/post" id="post">Post</a>
            <a href="/admin/statistics" id="stat">Statistics</a>
            <button><i class="fas fa-ellipsis-h"></i></button>
            
        </div>
        <div class="page_container">
            <div class="stat_page_wrap">
                <div class="button_container">
                    <div class="button_wrap">
                        <button id="delete_btn">삭제</button>
                        <button id="status_btn">상태변경</button>
                        <button id="initial_btn">초기화</button>
                    </div>
                    <div class="search_post_wrap">
                        <select id="keyword_type">
                            <option value="pi_title">제목</option>
                            <option value="pi_contents">내용</option>
                            <option value="mi_name">작성자</option>
                        </select>
                        <input type="text" class="search_post_box">
                        <button class="search_post_btn"><i class="fas fa-search"></i></button>
                    </div>
                </div>
                <table class="stat_list_table">
                    <thead>
                        <tr>
                            <th>번호<i id="seq_arrow" class="fas fa-arrows-alt-v"></i></th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>카테고리</th>
                            <th>상태/조회/추천<i id="status_arrow" class="fas fa-arrow-up"></i></th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="item">
                            <tr class="${item.si_seq}s" data-seq="${item.si_seq}s">
                                <td>${item.si_seq}</td>
                                <td>${item.mi_name}</td>
                                <td>${item.si_title}</td>
                                <td>${item.si_contents}</td>
                                <td>${item.sti_name}</td>
                                <td>${item.si_status}/${item.si_view}/${item.si_like}</td>
                                <td>
                                    <fmt:formatDate value="${item.si_reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${item.si_mod_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="popup_container" style="display: none;">
        <div class="popup_wrap">
            <div id="popup_number"></div>
            <div id="popup_author"></div>
            <div id="popup_title"></div>
            <div id="content_wrap"></div>
            <div id="popup_cat"></div>
            <div id="popup_status"></div>
            <div id="popup_reg_dt"></div>
            <div id="popup_mod_dt"></div>
            <div class="popup_btn">
                <button id="popup_delete_btn">삭제</button>
                <button id="popup_close_btn">취소</button>
            </div>
        </div>
        <div class="reply_popup_wrap" style="display: none;">
            <div class="reply_list_box">
            </div>
        </div>
    </div>
</body>
</html>



