<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/post_info.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/post_info.js"></script>

        

</head>
<body>
    
    <div class="main_container">
        <div class="main_upper_wrap">
            <a href="/admin/member" id="member">Member</a>
            <a href="/admin/post" id="post">Post</a>
            <button><i class="fas fa-ellipsis-h"></i></button>
            
        </div>
        <div class="page_container">
            <div class="post_page_wrap">
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
                <table class="post_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>종류/종목</th>
                            <th>조회/추천/상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.cnt==0}">
                            <tr>
                                <td id="nodata" colspan="8">회원 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="li">
                            <c:if test="${li.pi_status==1}">
                                <tr id="${li.pi_seq}p" data-seq="${li.pi_seq}p">
                            </c:if>
                            <c:if test="${li.pi_status==2}">
                                <tr id="${li.pi_seq}n" data-seq="${li.pi_seq}n">
                            </c:if>
                                <td>${li.pi_seq}<input class="check_box" type="checkbox"></td>
                                <td>${li.mi_name}</td>
                                <td>${li.pi_title}</td>
                                <td style="width: 40px; text-overflow: ellipsis;">${li.pi_contents}</td>
                                <td>${li.ti_table}/${li.iti_type}</td>
                                <td>${li.pi_views}/${li.pi_like}/
                                    <c:if test="${li.pi_status==1}">공개</c:if>
                                    <c:if test="${li.pi_status==2}">비공개</c:if>
                                </td>
                                <td>${li.pi_reg_dt}</td>
                                <td>${li.pi_mod_dt}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${data.page}" var="i">
                        <a id="${i}" href="/admin/member?offset=${(i-1)*20}&newOrder=${data.order}&adesc=${data.adesc}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
        </div>
    </div>
    <div class="popup_container" style="display: none;">
        <div class="popup_wrap">
            <div id="popup_number">:</div>
            <div id="popup_author">:</div>
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
    </div>
</body>
</html>



