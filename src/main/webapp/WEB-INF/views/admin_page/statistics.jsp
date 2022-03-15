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
    <script>
        let mi_seq = "${login_info.mi_seq}"
        let type = "${type}"
        let offset = "${offset}"
        let keyword = "${keyword}"
        
    </script>
    

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
            <div class="stat_page_wrap">
                <div class="button_container">
                    <div class="button_wrap">
                        <button id="add_btn">추가</button>
                        <button id="delete_btn">삭제</button>
                        <button id="status_btn">상태변경</button>
                        <button id="initial_btn">초기화</button>
                    </div>
                    <div class="search_post_wrap">
                        <select id="keyword_type">
                            <option value="all">선택</option>
                            <option value="title">제목</option>
                            <option value="contents">내용</option>
                            <option value="name">작성자</option>
                        </select>
                        <input type="text" class="search_post_box">
                        <button class="search_post_btn"><i class="fas fa-search"></i></button>
                    </div>
                </div>
                <table class="stat_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>카테고리</th>
                            <th>상태/조회/추천</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${data}" var="item">
                            <tr class="${item.si_seq}s" data-seq="${item.si_seq}s" mi-seq="${item.si_mi_seq}s">
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
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${page}" var="i">
                        <a id="${i}" href="/admin/statistics?offset=${(i-1)*20}&keyword=${keyword}&type=${type}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
        </div>
    </div>
    <div class="add_container" style="display: none;">
        <div class="add_popup_wrap">
            <div class="add_input_contents">
                <input type="text" id="add_popup_title" placeholder="제목을 입력해 주세요."></input>
                <select id="add_popup_cat">
                    <option value="0">선택</option>
                    <c:forEach items="${category}" var="item">
                        <option value="${item.sti_seq}">${item.sti_name}</option>
                    </c:forEach>
                </select>
                <i class="fas fa-trash-alt" id="img_del"></i>
                <div id="add_si_img_wrap" class="img_file">
                    <i class="fal fa-plus-circle"></i>
                </div>
                <form class="add_form_img">
                    <input type="file" name="file" id="add_input_file">
                </form>
                <textarea id="add_content_wrap" placeholder="내용을 입력해 주세요."></textarea>
                <div class="add_popup_btn">
                    <button id="add_popup_add_btn">추가</button>
                    <button id="add_popup_close_btn">취소</button>
                </div>
                
            </div>
        </div>
    </div>
    <div class="popup_container" style="display: none;">
        <div class="popup_wrap">
            <div id="popup_number"></div>
            <div id="popup_author"></div>
            <input id="popup_title"></input>
            <i class="fas fa-trash-alt" id="mod_img_del"></i>
            <div id="si_img_wrap" class="img_file"><i class="fal fa-plus-circle"></i></div>
            <form class="form_img">
                <input type="file" name="file" id="mod_input_file">
            </form>
            <textarea id="content_wrap"></textarea>
            <select id="popup_cat" >
                <option value="0">선택</option>
                <c:forEach items="${category}" var="item">
                    <option value="${item.sti_seq}">${item.sti_name}</option>
                </c:forEach>
            </select>
            <div id="popup_status"></div>
            <div id="popup_reg_dt"></div>
            <div id="popup_mod_dt"></div>
            <div class="popup_btn">
                <button id="popup_modify_btn">저장</button>
                <button id="popup_close_btn">취소</button>
            </div>
        </div>
    </div>
</body>
</html>



