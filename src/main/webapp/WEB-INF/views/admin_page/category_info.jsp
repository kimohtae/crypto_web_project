<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/category_info.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/category_info.js"></script>

        

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
        <div class="category_container">
            <div class="category_page_wrap NewsTable">
                <div class="button_wrap">
                    <button class="add_btn">추가</button>
                    <button class="delete_btn">삭제</button>
                    <button class="initial_btn">초기화</button>
                </div>
                <h1 class="title">News Table</h1>
                <div class="category_list">
                    <select class="select_category">
                        <c:forEach items="${Table}" var="item">
                            <option value="${item.ti_seq}">${item.ti_table}</option>
                        </c:forEach>
                    </select>
                </div>
                <table class="category_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>순서</th>
                            <th>카테고리 이름</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${NewsData}" var="li">
                            <tr data-seq="${li.nti_seq}">
                                <td>${li.nti_seq}</td>
                                <td>${li.nti_order}</td>
                                <td>${li.nti_name}</td>
                                <td>
                                    <fmt:formatDate value="${li.nti_reg_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${li.nti_mod_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${NewsPage}" var="i">
                        <a id="${i}" href="/admin/category?offset=${(i-1)*20}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
            <div class="category_page_wrap CommuTable">
                <div class="button_wrap">
                    <button class="add_btn">추가</button>
                    <button class="delete_btn">삭제</button>
                    <button class="initial_btn">초기화</button>
                </div>
                <h1 class="title">Community Table</h1>
                <div class="category_list">
                    <select class="select_category">
                        <c:forEach items="${Table}" var="item">
                            <option value="${item.ti_seq}">${item.ti_table}</option>
                        </c:forEach>
                    </select>
                </div>
                <table class="category_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>순서</th>
                            <th>카테고리 이름</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ComuData}" var="li">
                            <tr data-seq="${li.cti_seq}">
                                <td>${li.cti_seq}</td>
                                <td>${li.cti_order}</td>
                                <td>${li.cti_name}</td>
                                <td>
                                    <fmt:formatDate value="${li.cti_reg_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${li.cti_mod_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${ComuPage}" var="i">
                        <a id="${i}" href="/admin/category?offset=${(i-1)*20}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
            <div class="category_page_wrap StatTable">
                <div class="button_wrap">
                    <button class="add_btn">추가</button>
                    <button class="delete_btn">삭제</button>
                    <button class="initial_btn">초기화</button>
                </div>
                <h1 class="title">Statistics Table</h1>
                <div class="category_list">
                    <select class="select_category">
                        <c:forEach items="${Table}" var="item">
                            <option value="${item.ti_seq}">${item.ti_table}</option>
                        </c:forEach>
                    </select>
                </div>
                <table class="category_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>순서</th>
                            <th>카테고리 이름</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${StatData}" var="li">
                            <tr data-seq="${li.sti_seq}">
                                <td>${li.sti_seq}</td>
                                <td>${li.sti_order}</td>
                                <td>${li.sti_name}</td>
                                <td>
                                    <fmt:formatDate value="${li.sti_reg_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${li.sti_mod_dt}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${StatPage}" var="i">
                        <a id="${i}" href="/admin/category?offset=${(i-1)*20}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="display: none;">
        <div class="popup_wrap">
            <div class="popup_contents">
                <h1 class="popup_name">카테고리 <span>추가</span></h1>
                <input type="text" id="add_popup_name" placeholder="카테고리를 입력해 주세요."></input>
                <input type="number" id="add_popup_order" value="0"> 

                <button id="popup_add_btn">추가</button>
                <button id="popup_modify_btn">수정</button>
                <button id="popup_close_btn">취소</button>
            </div>
        </div>
    </div>
</body>
</html>



